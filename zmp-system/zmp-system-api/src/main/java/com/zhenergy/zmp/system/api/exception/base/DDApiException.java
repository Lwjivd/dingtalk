package com.zhenergy.zmp.system.api.exception.base;

import com.zhenergy.zmp.system.api.entity.DDResult;

/**
 * 钉钉API.
 */
public class DDApiException extends Exception {

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public DDApiException(DDResult result) {
		this.code = Integer.parseInt(result.getErrcode());
		this.message = result.getErrmsg();
	}
	
	public DDApiException(String code, String message) {
		this.code = Integer.parseInt(code);
		this.message = message;
	}
	
	public DDApiException(int code, String message) {
		this.code = code;
		this.message = message;
	}

}