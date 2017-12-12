package com.zhenergy.zmp.system.dingtalk.sdk.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;

@Configuration
@EnableConfigurationProperties(DingTalkProperties.class)
public class DingTalkConfig {

	@Bean
	@ConditionalOnMissingBean
	public DingTalkClient dingTalkClient() {
		return  new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
	}
	
}
