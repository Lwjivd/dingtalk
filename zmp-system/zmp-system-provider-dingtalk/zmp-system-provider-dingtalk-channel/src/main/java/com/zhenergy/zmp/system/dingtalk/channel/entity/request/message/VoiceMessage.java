package com.zhenergy.zmp.system.dingtalk.channel.entity.request.message;

public class VoiceMessage extends Message{

	private String msgtype="voice";
	private Voice voice;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
}