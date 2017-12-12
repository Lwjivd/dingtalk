package com.zhenergy.zmp.system.api.service;

import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;

/**
 * 内部用户接口
 */
public interface IInnerUserService {

	String getUserIdByCode(String code) throws DDApiException;
	
	User getUserByUserId(String userId) throws DDApiException;
	
	String getUserIdByUnionid(String unionid) throws DDApiException;
}
