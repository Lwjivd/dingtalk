package com.zhenergy.zmp.system.dingtalk.extuser.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.CorpExtAddRequest;
import com.dingtalk.api.request.CorpExtAddRequest.OpenExtContact;
import com.dingtalk.api.request.CorpExtListRequest;
import com.dingtalk.api.request.CorpExtListlabelgroupsRequest;
import com.dingtalk.api.response.CorpExtAddResponse;
import com.dingtalk.api.response.CorpExtListResponse;
import com.dingtalk.api.response.CorpExtListlabelgroupsResponse;
import com.taobao.api.ApiException;
import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.sdk.service.AccessBaseService;

@Component
public class ExtUserService extends AccessBaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExtUserService.class);
	
	@Autowired
	private DingTalkClient dingTalkClient;
	
	public CorpExtAddResponse create(String json) throws DDApiException {
		
		try {
			LOGGER.debug(json.toString());
			OpenExtContact contact = JsonMapperHelper.defaultMapper().fromJson(json, OpenExtContact.class);
			CorpExtAddRequest req = new CorpExtAddRequest();
			req.setContact(contact);
			CorpExtAddResponse rsp = dingTalkClient.execute(req, getAccessToken());
			return rsp;
		} catch (ApiException e) {
			LOGGER.error("ErrorCode: {0}, ErrMsg: {1}, Message: {2}, StackTrace: {3} ", e.getErrCode(), e.getErrMsg(), e.getMessage(), e.getStackTrace());
			throw new DDApiException(e.getErrCode(), e.getErrMsg());
		} 
	}

	public CorpExtListResponse extList(long size, long offset) throws DDApiException {
		LOGGER.debug("size: {0}, offset: {1}", size, offset);
		try {
			
			CorpExtListRequest req = new CorpExtListRequest();
			req.setSize(size);
			req.setOffset(offset);
			CorpExtListResponse rsp = dingTalkClient.execute(req, getAccessToken());
			return rsp;
			
		} catch (ApiException e) {
			LOGGER.error("ErrorCode: {0}, ErrMsg: {1}, Message: {2}, StackTrace: {3} ", e.getErrCode(), e.getErrMsg(), e.getMessage(), e.getStackTrace());
			throw new DDApiException(e.getErrCode(), e.getErrMsg());
		} 
	}
	
	
	public CorpExtListlabelgroupsResponse listLabelGroups(long size, long offset) throws DDApiException {
		LOGGER.debug("size: {0}, offset: {1}", size, offset);
		try {
			CorpExtListlabelgroupsRequest req = new CorpExtListlabelgroupsRequest();
			req.setSize(size);
			req.setOffset(offset);
			CorpExtListlabelgroupsResponse rsp = dingTalkClient.execute(req, getAccessToken());
			return rsp;
		} catch (ApiException e) {
			LOGGER.error("ErrorCode: {0}, ErrMsg: {1}, Message: {2}, StackTrace: {3} ", e.getErrCode(), e.getErrMsg(), e.getMessage(), e.getStackTrace());
			throw new DDApiException(e.getErrCode(), e.getErrMsg());
		} 
	}
	
	
}