package com.zhenergy.zmp.system.dingtalk.inneruser.entry.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 通过CODE换取用户身份
 *
 */
public class GetUserinfoByCodeResult extends DDResult {

	private String userid;
	// 手机设备号,由钉钉在安装时随机产生
	private String deviceId;
	// 是否是管理员
	private String is_sys;
	/**
	 * 级别，
	 * 0：非管理员 
	 * 1：超级管理员（主管理员） 
	 * 2：普通管理员（子管理员） 
	 * 100：老板
	 */
	private String sys_level;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getIs_sys() {
		return is_sys;
	}
	public void setIs_sys(String is_sys) {
		this.is_sys = is_sys;
	}
	public String getSys_level() {
		return sys_level;
	}
	public void setSys_level(String sys_level) {
		this.sys_level = sys_level;
	}
	
}
