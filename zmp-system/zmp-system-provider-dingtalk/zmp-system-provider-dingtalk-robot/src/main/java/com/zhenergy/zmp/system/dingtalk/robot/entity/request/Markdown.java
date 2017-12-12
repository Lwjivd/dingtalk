package com.zhenergy.zmp.system.dingtalk.robot.entity.request;

public class Markdown {

	/**
	 * 首屏会话透出的展示内容
	 */
	private String title;
	/**
	 * markdown格式的消息
	 */
	private String text;

	public Markdown(String title,String text){
		this.title=title;
		this.text=text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}