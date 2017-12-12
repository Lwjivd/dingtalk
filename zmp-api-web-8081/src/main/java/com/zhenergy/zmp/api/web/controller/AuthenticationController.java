package com.zhenergy.zmp.api.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhenergy.zmp.api.web.security.UserDetailsServiceImpl;
import com.zhenergy.zmp.api.web.security.utils.TokenUtil;
import com.zhenergy.zmp.common.web.controller.BaseController;
import com.zhenergy.zmp.common.web.entry.AccessToken;
import com.zhenergy.zmp.common.web.entry.Result;
import com.zhenergy.zmp.common.web.entry.ReturnCode;
import com.zhenergy.zmp.common.web.security.AuthenticationTokenFilter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * API调用权限管理
 */
@RestController
@RequestMapping("/{version}/auth")
@Api(tags = "API权限管理-token")
public class AuthenticationController extends BaseController {

    /**
     * 权限管理
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * 用户信息服务
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    /**
     * Token工具类
     */
    @Autowired
    private TokenUtil jwtTokenUtil;

    @PostMapping(value = "token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取token",notes = "获取token", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
    	@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
    })
    public Result createAuthenticationToken(
    		@PathVariable("version") String version,
    		@RequestParam("username") String username,
    		@RequestParam("password") String password) {

        //完成授权
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 生成Token
        final String token = jwtTokenUtil.generateToken(userDetails);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(token);
        accessToken.setExpires_in(jwtTokenUtil.getExpiration());
        accessToken.setToken_type(TokenUtil.TOKEN_TYPE_BEARER);

        return new Result<>(accessToken);
    }
    
    /*@PostMapping(value = "token/{type}/{code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据钉钉免登码,获取token",notes = "根据钉钉免登码,获取token", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    	@ApiImplicitParam(name = "type", value = "jsapi类型;0表示微应用,1表示服务窗", required = true, dataType = "String", paramType = "path", defaultValue = "0"),
    	@ApiImplicitParam(name = "code", value = "钉钉免登码", required = true, dataType = "String", paramType = "path"),
    })
    public Result createAuthenticationTokenByCode(
    		@PathVariable("version") String version,
    		@PathVariable("type") String type,
    		@PathVariable("code") String code) throws DDApiException {
    	
    	String userId = userDetailsService.getUserIdByTypeAndCode(type, code);
    	
        //完成授权
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userId, userId)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 生成Token
        final String token = jwtTokenUtil.generateToken(userDetails);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(token);
        accessToken.setExpires_in(jwtTokenUtil.getExpiration());
        accessToken.setToken_type(TokenUtil.TOKEN_TYPE_BEARER);

        return new Result<>(accessToken);
    }*/
    

    @GetMapping(value = "refresh", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "刷新token",notes = "刷新token", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    })
    public Result refreshAndGetAuthenticationToken(@PathVariable("version") String version,
        HttpServletRequest request) {

        String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
        String token = tokenHeader.split(" ")[1];

        //重新生成Token
        String username = jwtTokenUtil.getUsernameFromToken(token);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String refreshedToken = jwtTokenUtil.generateToken(userDetails);

        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(refreshedToken);
        accessToken.setExpires_in(jwtTokenUtil.getExpiration());
        accessToken.setToken_type(TokenUtil.TOKEN_TYPE_BEARER);

        return new Result<>(accessToken);
    }

    @DeleteMapping(value = "token", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "清空token",notes = "清空token", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "String", paramType = "header", defaultValue = "Bearer "),
    	@ApiImplicitParam(name = "version", value = "版本", required = true, dataType = "String", paramType = "path", defaultValue = "v1"),
    })
    public Result deleteAuthenticationToken(
    		@PathVariable("version") String version,HttpServletRequest request) {

        String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
        String token = tokenHeader.split(" ")[1];
        //移除token
        jwtTokenUtil.removeToken(token);

        return new Result<>(ReturnCode.SUCCESS.getResultCode(),ReturnCode.SUCCESS.getMessage());
    }

}
