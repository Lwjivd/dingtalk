package com.zhenergy.zmp.system.api.entity;


/**
 * 外部联系人
 */
public class ExtUser extends User {
	
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 企业名
	 */
	private String companyName;
	/**
	 * 负责人userId
	 */
	private String followerUserid;
	/**
	 * 标签列表
	 */
	private String labelIds;
	
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 共享给的部门ID
	 */
	private String shareDeptids;
	/**
	 * 共享给的员工userId列表
	 */
	private String shareUserids;
	/**
	 * 手机号国家码
	 */
	private String stateCode = "86";
	/**
	 * 职位
	 */
	private String title;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFollowerUserid() {
		return followerUserid;
	}
	public void setFollowerUserid(String followerUserid) {
		this.followerUserid = followerUserid;
	}
	public String getLabelIds() {
		return labelIds;
	}
	public void setLabelIds(String labelIds) {
		this.labelIds = labelIds;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShareDeptids() {
		return shareDeptids;
	}
	public void setShareDeptids(String shareDeptids) {
		this.shareDeptids = shareDeptids;
	}
	

	public String getShareUserids() {
		return shareUserids;
	}
	public void setShareUserids(String shareUserids) {
		this.shareUserids = shareUserids;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
