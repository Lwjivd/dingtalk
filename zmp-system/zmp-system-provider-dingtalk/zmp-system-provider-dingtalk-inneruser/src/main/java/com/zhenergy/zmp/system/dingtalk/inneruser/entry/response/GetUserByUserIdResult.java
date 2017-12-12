package com.zhenergy.zmp.system.dingtalk.inneruser.entry.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 获取成员详情
 */
public class GetUserByUserIdResult extends DDResult {

	private String userid;
	private String name;
	private String tel;
	private String workPlace;
	private String remark;
	private String mobile;
	private String email;
	private String active;
	private String orderInDepts;
	private String isAdmin;
	private String isBoss;
	private String dingId;
	private String unionid;
	private String isLeaderInDepts;
	private String isHide;
	private String[] department;
	private String position;
	private String avatar;
	private String jobnumber;
	//private String[] roles;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getOrderInDepts() {
		return orderInDepts;
	}

	public void setOrderInDepts(String orderInDepts) {
		this.orderInDepts = orderInDepts;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsBoss() {
		return isBoss;
	}

	public void setIsBoss(String isBoss) {
		this.isBoss = isBoss;
	}

	public String getDingId() {
		return dingId;
	}

	public void setDingId(String dingId) {
		this.dingId = dingId;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getIsLeaderInDepts() {
		return isLeaderInDepts;
	}

	public void setIsLeaderInDepts(String isLeaderInDepts) {
		this.isLeaderInDepts = isLeaderInDepts;
	}

	public String getIsHide() {
		return isHide;
	}

	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}

	public String[] getDepartment() {
		return department;
	}

	public void setDepartment(String[] department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	/*public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	static class Role {
		private String id;
		private String name;
		private String groupName;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGroupName() {
			return groupName;
		}
		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		
    }*/
}
