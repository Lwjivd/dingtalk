package com.zhenergy.zmp.system.api.entity;

import org.hibernate.validator.constraints.Length;
import com.zhenergy.zmp.common.api.DataEntity;

public class User extends DataEntity {

    private String userId;
	private String name;
	private Boolean active;
	private String mobile;

	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
        super();
    }

    public User(String id) {
        super(id);
    }

    @Override
    public void preInsert() {
        super.preInsert();
    }

    @Length(min = 1, max = 64)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Length(min = 0, max = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
