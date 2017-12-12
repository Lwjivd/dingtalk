package com.zhenergy.zmp.system.dingtalk.channel.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 
 */
public class MsgSendResult extends DDResult {

	/**
	 * 无效的用户的openid
	 */
	private String invaliduser;
	
	/**
	 * 发送消息的任务id
	 */
	private String taskid;

	public String getInvaliduser() {
		return invaliduser;
	}

	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	
	
}
