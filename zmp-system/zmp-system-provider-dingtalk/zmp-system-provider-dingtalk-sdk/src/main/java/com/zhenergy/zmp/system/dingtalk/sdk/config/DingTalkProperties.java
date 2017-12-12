package com.zhenergy.zmp.system.dingtalk.sdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ding.talk.corp")
public class DingTalkProperties {

	private String corpId;
	
	private String corpSecret;
	
	private String  channelSecret;
	
	private String SSOsecret;

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpSecret() {
		return corpSecret;
	}

	public void setCorpSecret(String corpSecret) {
		this.corpSecret = corpSecret;
	}

	public String getChannelSecret() {
		return channelSecret;
	}

	public void setChannelSecret(String channelSecret) {
		this.channelSecret = channelSecret;
	}

	public String getSSOsecret() {
		return SSOsecret;
	}

	public void setSSOsecret(String sSOsecret) {
		SSOsecret = sSOsecret;
	}

	
	
	
}
 