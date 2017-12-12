package com.zhenergy.zmp.system.dingtalk.channel.service.base;

import org.springframework.stereotype.Component;

import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.GetByCodeResult;
import com.zhenergy.zmp.system.dingtalk.channel.entity.response.GetByOpenidResult;

/**
 * 参考：
 * https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.rKLBSo&treeId=255&articleId=105660&docType=1
 */
@Component
public class ChannelService extends ChannelBaseService {

	/**
	 * 关注者免登接口
	 * 
	 * @param code
	 * @return
	 * @throws DDApiException 
	 * @throws  
	 */
	public GetByCodeResult getByCode(String code) throws DDApiException {

		String url = BASE_CHANNEL_URL + "user/get_by_code?access_token={CHANNEL_TOKEN}&code={CODE}";
		return restTemplate.getForEntity(url, GetByCodeResult.class, getAccessToken(), code).getBody();
	}

	/**
	 * 获取关注者详情
	 * 
	 * @param openid
	 * @return
	 */
	public GetByOpenidResult getByOpenid(String openid) throws DDApiException {

		String url = BASE_CHANNEL_URL + "user/get_by_openid?access_token={CHANNEL_TOKEN}&openid={OPENID}";
		return restTemplate.getForEntity(url, GetByOpenidResult.class, getAccessToken(), openid).getBody();
	}

	/**
	 * 获取服务窗关注者列表
	 * 
	 * @param offset
	 * @param size
	 * @return
	 */
	public String userList(String offset, String size) throws DDApiException {

		String url = BASE_CHANNEL_URL + "user/list?access_token={CHANNEL_TOKEN}&offset={0}&size={20}";
		return restTemplate.getForObject(url, String.class, getAccessToken(), offset, size);
	}
}