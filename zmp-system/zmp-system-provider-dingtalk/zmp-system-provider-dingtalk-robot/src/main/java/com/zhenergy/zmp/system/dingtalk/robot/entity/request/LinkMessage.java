package com.zhenergy.zmp.system.dingtalk.robot.entity.request;

public class LinkMessage extends Message {

	private String msgtype = "link";
	private Link link;

	public LinkMessage(String title, String text, String picUrl, String messageUrl) {
		this.link = new Link(title, text, picUrl, messageUrl);
	}

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