package com.zhenergy.zmp.system.dingtalk.robot.entity.request;

public class Link {

	/**
	 * 消息标题
	 */
	private String title;
	/**
	 * 消息内容。如果太长只会部分展示
	 */
	private String text;
	/**
	 * 图片URL
	 */
	private String picUrl;
	/**
	 * 点击消息跳转的URL
	 */
	private String messageUrl;

	public Link(String title,String text,String picUrl,String messageUrl){
		this.title=title;
		this.text=text;
		if(picUrl!=null){
			this.picUrl=picUrl;
		}else{
			this.picUrl="";
		}
		this.messageUrl=messageUrl;
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}

}