package com.zhenergy.zmp.system.dingtalk.channel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.service.base.ChannelService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChannelServiceTest {

	@Autowired
	private ChannelService channelService;
	
	@Test
	public void getChannelToken(){
		try {
			channelService.getAccessToken();
		} catch (DDApiException e) {
			e.printStackTrace();
		}
	}

	
}