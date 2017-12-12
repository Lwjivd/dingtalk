package com.zhenergy.zmp.system.dingtalk.sdk.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 获取jsapi_ticket
 */
public class JSAPITicketResult extends DDResult {

	private String ticket;
	private String expires_in;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	
}
