package com.zhenergy.zmp.api.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dingtalk.api.request.CorpExtAddRequest.OpenExtContact;
import com.zhenergy.zmp.api.web.security.UserDetailsServiceImpl;
import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.common.web.controller.BaseController;
import com.zhenergy.zmp.common.web.entry.Result;
import com.zhenergy.zmp.system.api.entity.DDCofingKeys;
import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.extuser.entry.DingtalkCorpExtAddResponse.DingtalkCorpExtAdd;
import com.zhenergy.zmp.system.dingtalk.extuser.service.ExtUserWrapService;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalExtUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/{version}/extuser")
@Api(tags = "外部联系人管理")
public class ExtUserController extends BaseController {
    
    @Autowired
    private ExtUserWrapService iExtUserService;
    
    @Autowired
    private LocalExtUserService localExtUserService;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @GetMapping(value = "listlabelgroups/{size}/{offset}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取标签列表",notes = "获取标签列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "size", value = "分页大小, 最大100", required = true, dataType = "Long", paramType = "path", defaultValue = "20"),
    	@ApiImplicitParam(name = "offset", value = "偏移位置", required = true, dataType = "Long", paramType = "path"),
    })
    public Result listLabelGroups(
    		@PathVariable("version") String version,
    		@PathVariable("size") Long size,
    		@PathVariable("offset") Long offset
    ) throws DDApiException {
    	
    	String json =  iExtUserService.listLabelGroups(size, offset);

    	 return new Result<>(json);
    }
    
    @GetMapping(value = "extlist/{size}/{offset}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "外部联系人列表",notes = "外部联系人列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "size", value = "分页大小, 最大100", required = true, dataType = "Long", paramType = "path", defaultValue = "20"),
    	@ApiImplicitParam(name = "offset", value = "偏移位置", required = true, dataType = "Long", paramType = "path"),
    })
    public Result extList(
        @PathVariable("version") String version,
        @PathVariable("size") Long size,
		@PathVariable("offset") Long offset
    ) throws DDApiException {
    	
        String json = iExtUserService.extList(size, offset);

        return new Result<>(json);
    }
    
    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "创建外部联系人",notes = "创建外部联系人", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    })
    public Result create(
        @PathVariable("version") String version,
        @RequestBody OpenExtContact openExtContact
    ) throws DDApiException {
    	
    	String extUserJson = JsonMapperHelper.defaultMapper().toJson(openExtContact);
    	DingtalkCorpExtAdd response = iExtUserService.create(extUserJson).getDingtalk_corp_ext_add_response();
    	return new Result<>(response);
    }
    
    
    @GetMapping(value = "get/{code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据免登码取外部人员详情",notes = "根据免登码取外部人员详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "code", value = "免登码", required = true, dataType = "String", paramType = "path"),
    })
    public Result getByCode(
    		@PathVariable("version") String version,
    		@PathVariable("code") String code
    ) throws DDApiException {
    	
    	String userId = userDetailsService.getUserIdByTypeAndCode(DDCofingKeys.F_TYPE, code);
    	
    	User user =  localExtUserService.getUserByUserId(userId);

        return new Result<>(user);
    }
    
    
}
