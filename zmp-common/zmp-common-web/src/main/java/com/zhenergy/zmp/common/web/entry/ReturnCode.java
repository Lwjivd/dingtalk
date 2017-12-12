package com.zhenergy.zmp.common.web.entry;

/**
 * 返回码
 */
public enum ReturnCode {

	/**
     * success
     */
    SUCCESS(200, "成功"),
    NOT_FOUNT(404, "找不到"),
    INTERNAL_SERVER_ERROR(500,"服务器遇到错误"),
    
    REPEAT(992, "数据重复"),
    NULL_DATA(995, "没有数据"),
    TIME_PASSED(996, "时间己过期"),
    DISABLED_USER(998, "用户被停用"),
    AUTH_FAILED(999, "用户名或密码错误");

    private int resultCode;
    private String message;

    ReturnCode(int resultCode) {
        this.resultCode = resultCode;
    }

    ReturnCode(String message) {
        this.message = message;
    }

    ReturnCode(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
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
}
