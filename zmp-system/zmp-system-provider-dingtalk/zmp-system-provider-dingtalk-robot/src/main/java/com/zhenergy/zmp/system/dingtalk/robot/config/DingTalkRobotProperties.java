package com.zhenergy.zmp.system.dingtalk.robot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ding.talk.robot")
public class DingTalkRobotProperties {

	public String webHook;

	public String getWebHook() {
		return webHook;
	}

	public void setWebHook(String webHook) {
		this.webHook = webHook;
	}
	
}
 