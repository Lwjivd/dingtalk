package com.zhenergy.zmp.system.dingtalk.robot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.dingtalk.robot.config.DingTalkRobotProperties;
import com.zhenergy.zmp.system.dingtalk.robot.entity.request.Message;
import com.zhenergy.zmp.system.dingtalk.robot.entity.request.TextMessage;
import com.zhenergy.zmp.system.dingtalk.robot.service.base.RobotSendService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RobotSendServiceTest {

	@Autowired
	private RobotSendService robotSendService;
	@Autowired
	private DingTalkRobotProperties dingTalkRobotProperties;

	@Test
	public void robotSend() {
		String webhook = dingTalkRobotProperties.getWebHook();

		String[] mobile = { "110", "120" };
		Message message = new TextMessage("text ...", mobile);

		robotSendService.robotSend(webhook, message);
	}

}