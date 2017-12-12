package com.zhenergy.zmp.system.dingtalk.inneruser.service.base;

import org.springframework.stereotype.Component;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUserByUserIdResult;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUseridByUnionidResult;
import com.zhenergy.zmp.system.dingtalk.inneruser.entry.response.GetUserinfoByCodeResult;
import com.zhenergy.zmp.system.dingtalk.sdk.service.AccessBaseService;

@Component
public class InnerUserService extends AccessBaseService {

	private final static String BASE_URL = "https://oapi.dingtalk.com/user/";

	public GetUseridByUnionidResult getUseridByUnionid(String unionid) throws DDApiException {
		
		String url = BASE_URL + "getUseridByUnionid?access_token={ACCESS_TOKEN}&unionid={xxxxxx}";
		
		return restTemplate.getForEntity(url, GetUseridByUnionidResult.class, getAccessToken(), unionid).getBody();
	}
	
	public GetUserinfoByCodeResult getUserInfoByCode(String code) throws DDApiException {
		
		String url = BASE_URL + "getuserinfo?access_token={ACCESS_TOKEN}&code={CODE}";
		return restTemplate.getForEntity(url, GetUserinfoByCodeResult.class, getAccessToken(), code).getBody();
	}
	
	public GetUserByUserIdResult getUserByUserId(String userId) throws DDApiException {
		
		String url = BASE_URL + "get?access_token={ACCESS_TOKEN}&userid={zhangsan}";
		return restTemplate.getForEntity(url, GetUserByUserIdResult.class, getAccessToken(), userId).getBody();
	}

	/*@Override
	public String getUserIdByCode(String code) throws BusinessException {
		return getUserByCode(code).getUserId();
	}
	
	
	
	
	public User getUserByCode(String code) throws BusinessException {
		try {
			CorpUserDetail corpUserDetail = corpUserService.getUserinfo(dingAuthService.getAccessToken(), code);
			return change(corpUserDetail);
		} catch (ServiceException ex) {
			throw new BusinessException(ex.getCode(),ex.getMessage());
		}
	}
	
	private User change(CorpUserDetail corpUserDetail) {
		
		InnerUser innerUser = new InnerUser();
		innerUser.setUserId(corpUserDetail.getUserid());
		innerUser.setName(corpUserDetail.getName());
		innerUser.setMobile(corpUserDetail.getMobile());
		return innerUser;
	}
*/
	
	
}
