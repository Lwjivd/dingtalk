package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class Link {

	private String title;
	private String text;
	
	/**
	 * 图片媒体文件id，可以调用上传媒体文件接口获取
	 */
	private String pic_url;
	
	/**
	 * 消息点击链接地址
	 */
	private String message_url;
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
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getMessage_url() {
		return message_url;
	}
	public void setMessage_url(String message_url) {
		this.message_url = message_url;
	}
}
