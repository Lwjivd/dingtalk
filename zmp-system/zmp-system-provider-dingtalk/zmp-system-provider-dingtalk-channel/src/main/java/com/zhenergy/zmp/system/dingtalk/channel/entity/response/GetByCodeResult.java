package com.zhenergy.zmp.system.dingtalk.channel.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;
/**
 * 关注者免登接口返回
 */
public class GetByCodeResult extends DDResult {

	private String openid; 
	private String unionid;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}
