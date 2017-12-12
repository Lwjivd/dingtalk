package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class Image {

	/**
	 * 图片媒体文件id，可以调用上传媒体文件接口获取。建议宽600像素 x 400像素，宽高比3：2
	 */
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}