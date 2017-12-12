package com.zhenergy.zmp.system.dingtalk.extuser.entry;

import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.TOPDingTalkSDKResponse;

public class DingtalkCorpExtAddResponse extends TOPDingTalkSDKResponse {

	private DingtalkCorpExtAdd dingtalk_corp_ext_add_response;
	
	public DingtalkCorpExtAdd getDingtalk_corp_ext_add_response() {
		return dingtalk_corp_ext_add_response;
	}

	public void setDingtalk_corp_ext_add_response(DingtalkCorpExtAdd dingtalk_corp_ext_add_response) {
		this.dingtalk_corp_ext_add_response = dingtalk_corp_ext_add_response;
	}


	public static class DingtalkCorpExtAdd {
		private String userid;

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}
	}
}
