package com.zhenergy.zmp.system.dingtalk.sdk.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.util.Formatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Component;

import com.zhenergy.zmp.common.utils.StringHelper;
import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.JSAPIDDConfig;
import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.JSAPITicketResult;

/**
 * 参考：https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.u44KhI&treeId=385&articleId=104966&docType=1
 *
 */
@Component
public class JSAPITicketService extends AccessBaseService {

	private Lock lock = new ReentrantLock();
	
	private final static String BASE_JSAPI_TICKET_URL = "https://oapi.dingtalk.com/get_jsapi_ticket?access_token={ACCESS_TOKE}";
	
	private static final String REDIS_PREFIX_DD_JSAPI_TICKET = "dd_jsapi_ticket";
	
	private static final String NONCE_STR = "dd_jsapi_ticket";
	
	public String getJsapiTicket() throws DDApiException {
		String token = redisRepository.get(REDIS_PREFIX_DD_JSAPI_TICKET);
		if(StringHelper.isNotBlank(token)) {
			return token;
		}
		return getJsapiTicketFromDD();
	}
	
	public JSAPIDDConfig ddConfig(String agentId, String url) throws DDApiException {
		String timeStamp = String.valueOf(Clock.systemDefaultZone().millis());
		String signature = sign(timeStamp, url);
		String corpId = dingTalkProperties.getCorpId();
		JSAPIDDConfig ddConfig = new JSAPIDDConfig();
		ddConfig.setAgentId(agentId);
		ddConfig.setCorpId(corpId);
		ddConfig.setNonceStr(NONCE_STR);
		ddConfig.setSignature(signature);
		ddConfig.setTimeStamp(timeStamp);
		return ddConfig;
	}
	
	/**
	 * 计算签名信息
	 * @param ticket
	 * @param nonceStr
	 * @param timeStamp
	 * @param url
	 * @return
	 * @throws DDApiException
	 */
	private String sign(String timeStamp,String url) throws DDApiException {
		
		String plain = "jsapi_ticket=" + getJsapiTicket() + "&noncestr=" + NONCE_STR + "&timestamp=" + timeStamp
				+ "&url=" + url;
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			sha1.reset();
			sha1.update(plain.getBytes("UTF-8"));
			return bytesToHex(sha1.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new DDApiException("500","钉钉计算签名信息失败");
		} catch (UnsupportedEncodingException e) {
			throw new DDApiException("500","钉钉计算签名信息失败");
		}
	}

	private String bytesToHex(byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
	
	private String getJsapiTicketFromDD() throws DDApiException{
		try {
			lock.lock();
			String url = BASE_JSAPI_TICKET_URL;
			JSAPITicketResult result = restTemplate.getForEntity(url, JSAPITicketResult.class, getAccessToken()).getBody();
			if(DDCofingKeys.SUCCESS.equals(result.getErrcode())) {
				String token = result.getTicket();
				String key = REDIS_PREFIX_DD_JSAPI_TICKET;
				redisRepository.setExpire(key, token, expiration);
				return token;
			}
			throw new DDApiException(result);
		} finally {
			lock.unlock();
		}
	}

	
}