package com.zhenergy.zmp.system.dingtalk.inneruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.entity.InnerUser;
import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.api.service.IInnerUserService;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUserByUserIdResult;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUseridByUnionidResult;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUserinfoByCodeResult;
import com.zhenergy.zmp.system.dingtalk.inneruser.service.base.InnerUserService;

@Component
public class InnerUserWrapService implements IInnerUserService{

	@Autowired
	private InnerUserService innerUserService;
	
	@Override
	public String getUserIdByCode(String code) throws DDApiException {
				
		GetUserinfoByCodeResult result = innerUserService.getUserInfoByCode(code);
		if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
			return result.getUserid();
		}
		throw new DDApiException(result);
		
	}

	@Override
	public User getUserByUserId(String userId) throws DDApiException {
		GetUserByUserIdResult result = innerUserService.getUserByUserId(userId);
		if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
			return change(result);
		}
		throw new DDApiException(result);
	}

	@Override
	public String getUserIdByUnionid(String unionid) throws DDApiException {
		
		GetUseridByUnionidResult result = innerUserService.getUseridByUnionid(unionid);
		if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
			return result.getUserid();
		}
		throw new DDApiException(result);
	}
	
	
	private User change(GetUserByUserIdResult result) {
		
		InnerUser innerUser = new InnerUser();
		innerUser.setUserId(result.getUserid());
		innerUser.setName(result.getName());
		innerUser.setMobile(result.getMobile());
		return innerUser;
	}
}
