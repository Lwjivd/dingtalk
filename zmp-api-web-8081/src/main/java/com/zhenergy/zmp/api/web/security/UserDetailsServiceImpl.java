package com.zhenergy.zmp.api.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zhenergy.zmp.api.web.security.model.AuthUserFactory;
import com.zhenergy.zmp.api.web.security.utils.TokenUtil;
import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.api.service.IInnerUserService;
import com.zhenergy.zmp.system.dingtalk.channel.service.ChannelWrapService;

/**
 * Security User Detail Service
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * 内部用户服务
	 */
	@Autowired
	private IInnerUserService innerUserService;

	/**
	 * 服务窗服务
	 */
	@Autowired
	private ChannelWrapService channelWrapService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private TokenUtil jwtTokenUtil;
	

	public String getUserIdByTypeAndCode(String type, String code) throws DDApiException {
		if (DDCofingKeys.F_TYPE.equals(type)) {
			String unionid = channelWrapService.getUnionidByCode(code);
			return innerUserService.getUserIdByUnionid(unionid);
		}
		return innerUserService.getUserIdByCode(code);
	}

	@Override
	public UserDetails loadUserByUsername(String loginName) {
		try {
			User user = innerUserService.getUserByUserId(loginName);
			if (user == null) {
				throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
			} else {
				user.setPassword(passwordEncoder.encode(jwtTokenUtil.getSecret()));
				return AuthUserFactory.create(user);
			}
		} catch (DDApiException e) {
			throw new UsernameNotFoundException(String.format("DDApiException code: '%s', message: '%s'.", e.getCode(), e.getMessage()));
		}
	}
}
