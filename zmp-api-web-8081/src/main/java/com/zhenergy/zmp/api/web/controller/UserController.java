package com.zhenergy.zmp.api.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenergy.zmp.common.web.controller.BaseController;
import com.zhenergy.zmp.common.web.entry.Result;
import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.api.service.IInnerUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/{version}/user")
//@Api(tags = "人员管理")
public class UserController extends BaseController {
	
    /**
     * 用户服务
     */
    @Autowired
    private IInnerUserService innerUserService;
    
    @GetMapping(value = "get/{userid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取成员详情",notes = "获取成员详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "userid", value = "员工唯一标识", required = true, dataType = "String", paramType = "path"),
    })
    public Result getUser(
    		@PathVariable("version") String version,
    		@PathVariable("userid") String userId
    ) throws DDApiException {

        User user = innerUserService.getUserByUserId(userId);

        return new Result<>(user);
    }

    @DeleteMapping(value = "delete/{userid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除人员",notes = "删除人员", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "userid", value = "员工唯一标识", required = true, dataType = "String", paramType = "path"),
    })
    public Result deleteUser(
		@PathVariable("version") String version,
		@PathVariable("userid") String userId
    ) throws DDApiException {

    	User user = innerUserService.getUserByUserId(userId);
        return new Result<>(user);
    }


}
