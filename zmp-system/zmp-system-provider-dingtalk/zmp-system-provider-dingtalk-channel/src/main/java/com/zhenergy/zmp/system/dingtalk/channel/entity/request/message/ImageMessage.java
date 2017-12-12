package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class ImageMessage extends Message{

	private String msgtype="image";
	private Image image;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}