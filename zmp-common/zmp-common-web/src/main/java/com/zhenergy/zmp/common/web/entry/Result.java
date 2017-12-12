package com.zhenergy.zmp.common.web.entry;

public class Result<T> {

    private int resultCode = 200;

    private String message = "SUCCESS";

    private T data;
    
    /**
     * 返回错误码
     * @param resultCode
     */
    public Result(int resultCode) {
        this.resultCode = resultCode;
    }
    
    /**
     * 返回数据
     * @param data
     */
    public Result(T data) {
        this.data = data;
    }
    
    
	public Result(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
	}

	public Result(int resultCode, String message, T data) {
		this.resultCode = resultCode;
		this.message = message;
		this.data = data;
	}
	

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    

}
