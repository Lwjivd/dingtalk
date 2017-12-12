package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class Message {
	
	// 服务窗应用的代理id
	private String channelAgentId;
	
	// 由接收人的openid组成的字符串，多个使用"|"符号进行分割
	private String touser;

	public String getChannelAgentId() {
		return channelAgentId;
	}

	public void setChannelAgentId(String channelAgentId) {
		this.channelAgentId = channelAgentId;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}
	
}
