package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class OAMessage extends Message{

	private String msgtype="oa";
	private OA oa;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public OA getOa() {
		return oa;
	}
	public void setOa(OA oa) {
		this.oa = oa;
	}
}