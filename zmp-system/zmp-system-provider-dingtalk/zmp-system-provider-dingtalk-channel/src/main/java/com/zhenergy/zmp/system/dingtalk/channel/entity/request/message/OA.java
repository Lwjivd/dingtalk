package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

import java.util.List;

public class OA {

	/**
	 * 客户端点击消息时跳转到的H5地址
	 */
	private String message_url;
	
	/**
	 * PC端点击消息时跳转到的URL地址
	 */
	private String pc_message_url;
	
	/**
	 * 消息头部内容
	 */
	private Head head;
	
	/**
	 * 消息体
	 */
	private Body body;
	
	static class Head{
		
		/**
		 * 消息头部的背景颜色。长度限制为8个英文字符，其中前2为表示透明度，后6位表示颜色值。不要添加0x
		 */
		private String bgcolor;
		/**
		 * 消息的头部标题（仅适用于发送普通场景）
		 */
		private String text;
	}
	
	static class Body{
		private String title;
		/**
		 * 消息体的表单，最多显示6个，超过会被隐藏
		 */
		private List<FormItem> form;
		private Rich rich;
		private String content;
		/**
		 * 消息体中的图片media_id
		 */
		private String image;
		private String file_count;
		private String author;
		
		
		static class FormItem{
			private String key;
			private String value;
		}
		
		static class Rich{
			private String num;
			private String unit;
		}
	}
	
}
