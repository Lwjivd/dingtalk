package com.zhenergy.zmp.system.dingtalk.robot.entity.request;

public class TextMessage extends Message {

	private String msgtype="text";
	private Text text;
	private At at;

	public TextMessage(String content,String[] atMobiles){
		this.text=new Text(content);
		this.at=new At(atMobiles);
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

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

}