package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class TextMessage extends Message{

	private String msgtype="text";
	private Text text;
	
	public TextMessage(Text text) {
		this.text = text;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}

}