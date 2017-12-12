package com.zhenergy.zmp.system.dingtalk.extuser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dingtalk.api.request.CorpExtListRequest;
import com.dingtalk.api.request.CorpExtListlabelgroupsRequest;
import com.dingtalk.api.response.CorpExtAddResponse;
import com.dingtalk.api.response.CorpExtListResponse;
import com.dingtalk.api.response.CorpExtListlabelgroupsResponse;
import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.extuser.entry.DingtalkCorpExtAddResponse;
import com.zhenergy.zmp.system.dingtalk.extuser.entry.ErrorResponse;
import com.zhenergy.zmp.system.dingtalk.extuser.service.base.ExtUserService;

@Component
public class ExtUserWrapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExtUserWrapService.class);
	
	@Autowired
	private ExtUserService extUserService;
	
	public DingtalkCorpExtAddResponse create(String json) throws DDApiException {
		LOGGER.debug(json.toString());
		CorpExtAddResponse rsp = extUserService.create(json);
		String body = rsp.getBody();
		if(null != rsp.getUserid()) {
			return JsonMapperHelper.defaultMapper().fromJson(body, DingtalkCorpExtAddResponse.class);
		}
		ErrorResponse error = JsonMapperHelper.defaultMapper().fromJson(body, ErrorResponse.class);
		throw new DDApiException(error.getError_response().getSub_code(),error.getError_response().getSub_msg());
	}

	public String extList(long size, long offset) throws DDApiException {
		LOGGER.debug("size: {0}, offset: {1}", size, offset);
		CorpExtListRequest req = new CorpExtListRequest();
		req.setSize(size);
		req.setOffset(offset);
		CorpExtListResponse rsp = extUserService.extList(size, offset);
		String result = rsp.getResult();
		LOGGER.debug(result);
		return result;
			
	}
	
	public String listLabelGroups(long size, long offset) throws DDApiException {
		LOGGER.debug("size: {0}, offset: {1}", size, offset);
		CorpExtListlabelgroupsRequest req = new CorpExtListlabelgroupsRequest();
		req.setSize(size);
		req.setOffset(offset);
		CorpExtListlabelgroupsResponse rsp = extUserService.listLabelGroups(size, offset);
		String result = rsp.getResult();
		LOGGER.debug(result);
		return result;
	}
	
}