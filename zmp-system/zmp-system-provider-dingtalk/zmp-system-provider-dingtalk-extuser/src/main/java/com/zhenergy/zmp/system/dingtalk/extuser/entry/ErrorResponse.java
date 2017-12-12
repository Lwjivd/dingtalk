package com.zhenergy.zmp.system.dingtalk.extuser.entry;

import com.zhenergy.zmp.system.dingtalk.sdk.entity.response.TOPDingTalkSDKResponse;

public class ErrorResponse extends TOPDingTalkSDKResponse {
	
	private Error error_response;
	
	public Error getError_response() {
		return error_response;
	}

	public void setError_response(Error error_response) {
		this.error_response = error_response;
	}

	public static class Error {
		private int code;
		private String msg;
		private String sub_code;
		private String sub_msg;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getSub_code() {
			return sub_code;
		}
		public void setSub_code(String sub_code) {
			this.sub_code = sub_code;
		}
		public String getSub_msg() {
			return sub_msg;
		}
		public void setSub_msg(String sub_msg) {
			this.sub_msg = sub_msg;
		}
	}
	
	
	
}
