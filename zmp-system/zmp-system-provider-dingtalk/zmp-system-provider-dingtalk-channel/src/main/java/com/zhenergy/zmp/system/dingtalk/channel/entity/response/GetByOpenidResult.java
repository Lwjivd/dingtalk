package com.zhenergy.zmp.system.dingtalk.channel.entity.response;

import com.zhenergy.zmp.system.api.entity.DDResult;
/**
 *  获取关注者详情返回
 */
public class GetByOpenidResult extends DDResult {

	// 关注者在钉钉上的昵称
	private String nickname;
	
	// 关注者在钉钉上的头像链接
	private String avatar;
	
	// 在 本服务窗运营服务商 范围内,唯一标识关注者身份的id
	private String openid;
	
	// 该用户是否关注了本服务窗,当关注时值为1,当用户取消关注后,值为0且其余字段都没有值
	private String subscribe;
	
	// 在本 服务窗技术开发商 范围内,唯一标识关注者身份的id
	private String unionid;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
}
