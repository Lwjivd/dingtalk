package com.zhenergy.zmp.system.dingtalk.channel.service.base;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.entity.request.message.Message;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.MsgSendResult;

/**
 * 参考：
 * https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.5gEJ8M&treeId=255&articleId=105566&docType=1
 */
@Component
public class ChannelMsgService extends ChannelBaseService {

	private final static String BASE_CHANNEL_MSG_URL = "https://oapi.dingtalk.com/channel/message/send?access_token={ACCESS_TOKEN}";

	public MsgSendResult messageSend(Message message) throws DDApiException{

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Message> entity = new HttpEntity<Message>(message, headers);
		return restTemplate.postForEntity(BASE_CHANNEL_MSG_URL, entity,MsgSendResult.class, getAccessToken()).getBody();
	}
}