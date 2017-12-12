package com.zhenergy.zmp.system.local.extuser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalExtUserService;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalExtUserServiceTest {

	@Autowired
	private LocalExtUserService localExtUserService;

	/*@Autowired
	private RedisRepository redisRepository;*/

	@Test
	public void getUserByUserId() {
		String userId = "13272118461093354673";
		localExtUserService.getUserByUserId(userId);
	}

}
