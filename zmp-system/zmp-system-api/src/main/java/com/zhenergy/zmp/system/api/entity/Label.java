package com.zhenergy.zmp.system.api.entity;

import com.zhenergy.zmp.common.api.DataEntity;

/**
 * 外部联系人
 */
public class Label extends DataEntity {
	
	private Long labelId;
	private Long parentLabelId;
	
	private String labelName;
	public Long getLabelId() {
		return labelId;
	}
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public Long getParentLabelId() {
		return parentLabelId;
	}
	public void setParentLabelId(Long parentLabelId) {
		this.parentLabelId = parentLabelId;
	}

}
