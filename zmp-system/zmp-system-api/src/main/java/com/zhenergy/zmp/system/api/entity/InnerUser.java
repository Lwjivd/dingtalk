package com.zhenergy.zmp.system.api.entity;


import java.util.List;

/**
 * 内部联系人
 */
public class InnerUser extends User {

	private List<Long> department;

	public List<Long> getDepartment() {
		return department;
	}

	public void setDepartment(List<Long> department) {
		this.department = department;
	}


}
