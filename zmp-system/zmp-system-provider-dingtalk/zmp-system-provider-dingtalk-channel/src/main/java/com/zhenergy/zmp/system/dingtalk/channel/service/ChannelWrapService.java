package com.zhenergy.zmp.system.dingtalk.channel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.GetByCodeResult;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.GetByOpenidResult;
import com.zhenergy.zmp.system.dingtalk.channel.service.base.ChannelService;

@Component
public class ChannelWrapService {

	@Autowired
	private ChannelService channelService;
	
	
	public String getUnionidByCode(String code) throws DDApiException {
		
		GetByCodeResult getByCodeResult = channelService.getByCode(code);
		if(DDCofingKeys.SUCCESS.equals(getByCodeResult.getErrcode())) {
			String openid = getByCodeResult.getOpenid();
			GetByOpenidResult getByOpenidResult = channelService.getByOpenid(openid);
			if(DDCofingKeys.SUCCESS.equals(getByOpenidResult.getErrcode())) {
				String unionid = getByOpenidResult.getUnionid();
				return unionid;
			}
			throw new DDApiException(getByOpenidResult);
		}
		throw new DDApiException(getByCodeResult);
		
	}

	
}