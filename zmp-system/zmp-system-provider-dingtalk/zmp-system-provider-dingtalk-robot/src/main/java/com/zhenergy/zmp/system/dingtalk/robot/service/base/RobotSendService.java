package com.zhenergy.zmp.system.dingtalk.robot.service.base;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.zhenergy.zmp.system.dingtalk.robot.entity.request.Message;
import com.zhenergy.zmp.system.dingtalk.robot.entity.response.RobotSendResult;
import com.zhenergy.zmp.system.dingtalk.sdk.service.AccessBaseService;

/**
 * 参考：https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.eNJ6EJ&treeId=257&articleId=105735&docType=1
 *
 */
@Component
public class RobotSendService extends AccessBaseService {

	public RobotSendResult robotSend(String webhook,Message message){

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Message> entity = new HttpEntity<Message>(message, headers);
		ResponseEntity<RobotSendResult> entryResult = restTemplate.postForEntity(webhook, entity, RobotSendResult.class);
		
		return entryResult.getBody();
	}

	
}