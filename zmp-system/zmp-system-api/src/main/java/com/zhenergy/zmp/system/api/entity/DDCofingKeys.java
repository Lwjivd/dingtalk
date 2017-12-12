package com.zhenergy.zmp.system.api.entity;

/**
 * 钉钉 常量
 *
 */
public final class DDCofingKeys {

    /**
     * 成功
     */
    public static final String SUCCESS = "0";

    /**
     * 钉钉jsapi类型 
     * 0:微应用
     * 1:服务号
     */
    public static final String W_TYPE = "0";
	public static final String F_TYPE = "1";
	
    private DDCofingKeys() {
        throw new IllegalAccessError("Utility class");
    }
}
