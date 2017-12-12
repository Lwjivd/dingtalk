package com.zhenergy.zmp.system.api.service;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;

public interface IDDUserService {

	String getUserIdByCode(String code) throws DDApiException;
	
	
}
