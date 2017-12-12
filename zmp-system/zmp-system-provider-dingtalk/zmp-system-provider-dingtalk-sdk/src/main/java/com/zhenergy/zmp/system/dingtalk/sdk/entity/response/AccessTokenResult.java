package com.zhenergy.zmp.system.dingtalk.sdk.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 获取AccessToken返回
 */
public class AccessTokenResult extends DDResult{

	private String access_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
