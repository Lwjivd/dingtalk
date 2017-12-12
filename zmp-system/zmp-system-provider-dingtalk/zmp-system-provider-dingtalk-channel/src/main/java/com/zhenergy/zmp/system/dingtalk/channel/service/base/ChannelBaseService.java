package com.zhenergy.zmp.system.dingtalk.channel.service.base;

import com.zhenergy.zmp.common.utils.StringHelper;
import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.ChannelToken;
import com.zhenergy.zmp.system.dingtalk.sdk.service.DDBaseService;

public abstract class ChannelBaseService extends DDBaseService {

	protected final static String BASE_CHANNEL_URL = "https://oapi.dingtalk.com/channel/";

	private static final String REDIS_PREFIX_DD_CHANNELTOKEN = "dd_channel_token";
	
	public String getAccessToken() throws DDApiException {
		String token = redisRepository.get(REDIS_PREFIX_DD_CHANNELTOKEN);
		if(StringHelper.isNotBlank(token)) {
			return token;
		}
		return getChannelTokenFromDD();
	}
	
	private String getChannelTokenFromDD() throws DDApiException {
		String url = BASE_CHANNEL_URL + "get_channel_token?corpid={CORPID}&channel_secret={CHANNEL_SECRET}";
		ChannelToken result = restTemplate.getForEntity(url, ChannelToken.class, dingTalkProperties.getCorpId(),
				dingTalkProperties.getChannelSecret()).getBody();
		
		if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
			String token = result.getAccess_token();
			String key = REDIS_PREFIX_DD_CHANNELTOKEN;
		    redisRepository.setExpire(key, token, expiration);
			return token;
		}
		throw new DDApiException(result);
	}
	
}
