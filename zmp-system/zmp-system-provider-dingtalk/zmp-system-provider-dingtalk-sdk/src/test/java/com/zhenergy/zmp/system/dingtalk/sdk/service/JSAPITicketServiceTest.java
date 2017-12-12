package com.zhenergy.zmp.system.dingtalk.sdk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.JSAPIDDConfig;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JSAPITicketServiceTest {

	@Autowired
	private JSAPITicketService jSAPITicketService;
	
	
	@Test
	public void robotSend() {
		try {
			
			String agentId = "agentId";
			String url = "url";
			JSAPIDDConfig ddConfig = jSAPITicketService.ddConfig(agentId, url);
			
		} catch (DDApiException e) {
			e.printStackTrace();
		}

		
	}
}
