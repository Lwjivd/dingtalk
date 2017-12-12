package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class FileMessage extends Message{

	private String msgtype="file";
	private File file;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}