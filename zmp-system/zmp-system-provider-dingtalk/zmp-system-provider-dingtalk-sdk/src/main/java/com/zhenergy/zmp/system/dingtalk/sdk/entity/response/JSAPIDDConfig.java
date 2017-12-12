package com.zhenergy.zmp.system.dingtalk.sdk.entity.response;

public class JSAPIDDConfig {

	// 必填，微应用ID
	private String agentId;
	// 必填，企业ID
	private String corpId;
    // 必填，生成签名的时间戳
	private String timeStamp;
	// 必填，生成签名的随机串
	private String nonceStr;
	// 必填，签名
	private String signature;
	// 选填。0表示微应用的jsapi,1表示服务窗的jsapi。不填默认为0。该参数从dingtalk.js的0.8.3版本开始支持
	//private String type;
	// 必填，需要使用的jsapi列表，注意：不要带dd。
	//private String [] jsApiList;
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/*public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}*/
	/*public String[] getJsApiList() {
		return jsApiList;
	}
	public void setJsApiList(String[] jsApiList) {
		this.jsApiList = jsApiList;
	}*/
	
	
}
