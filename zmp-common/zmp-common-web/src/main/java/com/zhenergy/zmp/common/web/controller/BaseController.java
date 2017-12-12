package com.zhenergy.zmp.common.web.controller;

import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aliyun.oss.ServiceException;
import com.zhenergy.zmp.common.utils.BeanValidators;
import com.zhenergy.zmp.common.utils.Collections3;
import com.zhenergy.zmp.common.web.editor.DateEditor;
import com.zhenergy.zmp.common.web.editor.StringEditor;
import com.zhenergy.zmp.common.web.entry.Result;
import com.zhenergy.zmp.common.web.entry.ReturnCode;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;

/**
 * 控制器支持类
 */
public abstract class BaseController {

    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     *
     * @param binder the binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new StringEditor());
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @ExceptionHandler(DDApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleBusinessException(DDApiException ex) {
    	
        return new Result<>(ex.getCode(), ex.getMessage());
    }

    
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> list = BeanValidators.extractMessage(ex);
        
        return new Result<>(HttpStatus.BAD_REQUEST.value(), Collections3.convertToString(list, ";"));
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleDingTalkMuchException(ServiceException ex) {
    	return new Result<>(Integer.parseInt(ex.getErrorCode()), ex.getErrorMessage());
    }
    
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBusinessException(BadCredentialsException ex) {
        //用户名或密码错误
    	return new Result<>(ReturnCode.AUTH_FAILED.getResultCode(),ReturnCode.AUTH_FAILED.getMessage());
    }

    @ExceptionHandler(DisabledException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleBusinessException(DisabledException ex) {
        //用户被停用
    	return new Result<>(ReturnCode.DISABLED_USER.getResultCode(),ReturnCode.DISABLED_USER.getMessage());
    }

}
