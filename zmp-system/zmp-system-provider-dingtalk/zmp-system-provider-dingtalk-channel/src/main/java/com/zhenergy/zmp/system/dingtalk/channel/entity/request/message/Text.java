package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class Text {

	/**
	 * 消息内容
	 */
	private String content;

	public Text(String content){
		this.content=content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}