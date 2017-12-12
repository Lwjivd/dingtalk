package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class LinkMessage extends Message{

	private String msgtype="link";
	private Link link;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	
}