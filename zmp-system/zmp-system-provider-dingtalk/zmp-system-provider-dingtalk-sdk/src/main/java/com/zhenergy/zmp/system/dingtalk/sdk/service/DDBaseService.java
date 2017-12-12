package com.zhenergy.zmp.system.dingtalk.sdk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.zhenergy.zmp.common.redis.RedisRepository;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.sdk.config.DingTalkProperties;

public abstract class DDBaseService {

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected DingTalkProperties dingTalkProperties;

	@Autowired
	protected RedisRepository redisRepository;
	
	protected static final long expiration = 2 * 60 * 60;
	
	public abstract String getAccessToken() throws DDApiException;

}
