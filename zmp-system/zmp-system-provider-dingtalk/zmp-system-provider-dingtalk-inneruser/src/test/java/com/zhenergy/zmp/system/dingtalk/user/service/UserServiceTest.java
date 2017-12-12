package com.zhenergy.zmp.system.dingtalk.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.api.service.IInnerUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Autowired
	private IInnerUserService iUserService;
	private String userid = "XUHJ";

	@Test
	public void getUser() throws DDApiException {

		iUserService.getUserByUserId(userid);
	}
}
