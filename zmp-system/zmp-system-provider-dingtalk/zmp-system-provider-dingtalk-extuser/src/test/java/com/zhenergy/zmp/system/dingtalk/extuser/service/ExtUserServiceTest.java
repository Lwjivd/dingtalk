package com.zhenergy.zmp.system.dingtalk.extuser.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExtUserServiceTest {

	
	@Autowired
	private ExtUserWrapService iExtUserService;

	@Test
	public void create() {
		String json = "";
		try {
			iExtUserService.create(json );
		} catch (DDApiException e) {
			e.printStackTrace();
		}

	}
}