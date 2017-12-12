package com.zhenergy.zmp.system.dingtalk.inneruser.entry.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 根据unionid获取成员的userid 返回
 *
 */
public class GetUseridByUnionidResult extends DDResult {

	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
