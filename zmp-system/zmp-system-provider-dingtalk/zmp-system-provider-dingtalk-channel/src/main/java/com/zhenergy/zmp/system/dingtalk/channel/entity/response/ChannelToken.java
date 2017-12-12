package com.zhenergy.zmp.system.dingtalk.channel.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;
/**
 * 服务窗ChannelToken
 */
public class ChannelToken extends DDResult {

	private String access_token;
	private String expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

}