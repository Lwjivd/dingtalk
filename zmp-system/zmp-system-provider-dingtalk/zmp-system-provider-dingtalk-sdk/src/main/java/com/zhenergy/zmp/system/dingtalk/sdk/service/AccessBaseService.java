package com.zhenergy.zmp.system.dingtalk.sdk.service;

import com.zhenergy.zmp.common.utils.StringHelper;
import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.AccessTokenResult;

public abstract class AccessBaseService extends DDBaseService {

	private final static String BASE_URL = "https://oapi.dingtalk.com/gettoken?corpid={id}&corpsecret={secrect}";

	private static final String REDIS_PREFIX_DD_ACCESSTOKEN = "dd_access_token";
	
	@Override
	public String getAccessToken() throws DDApiException {
		String token = redisRepository.get(REDIS_PREFIX_DD_ACCESSTOKEN);
		if(StringHelper.isNotBlank(token)) {
			return token;
		}
		return getAccessTokenFromDD();
	}
	
	private String getAccessTokenFromDD() throws DDApiException {
		String url = BASE_URL;
		AccessTokenResult result = restTemplate.getForEntity(url, AccessTokenResult.class, dingTalkProperties.getCorpId(),
				dingTalkProperties.getCorpSecret()).getBody();
		if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
			String token = result.getAccess_token();
			String key = REDIS_PREFIX_DD_ACCESSTOKEN;
		    redisRepository.setExpire(key, token, expiration);
			return token;
		}
		throw new DDApiException(result);
	}
	
}
