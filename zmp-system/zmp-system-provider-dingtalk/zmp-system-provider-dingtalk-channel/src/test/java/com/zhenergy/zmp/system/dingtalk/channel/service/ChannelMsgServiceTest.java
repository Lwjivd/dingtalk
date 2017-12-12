package com.zhenergy.zmp.system.dingtalk.channel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.entity.request.message.Message;
import com.zhenergy.zmp.system.dingtalk.channel.entity.request.message.Text;
import com.zhenergy.zmp.system.dingtalk.channel.entity.request.message.TextMessage;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.MsgSendResult;
import com.zhenergy.zmp.system.dingtalk.channel.service.base.ChannelMsgService;
import com.zhenergy.zmp.system.dingtalk.channel.service.base.ChannelService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChannelMsgServiceTest {

	@Autowired
	private ChannelMsgService channelMsgService;

	@Autowired
	private ChannelService channelService;

	@Test
	public void messageSend() {

		try {
			Text text = new Text("text ...");
			Message message = new TextMessage(text);
			MsgSendResult msgSendResult = channelMsgService.messageSend(message);
			System.out.println(msgSendResult);
		} catch (DDApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}