package com.zhenergy.zmp.scheduled.runnable.dd;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.entity.ExtUser;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.extuser.service.ExtUserWrapService;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalExtUserService;

/**
 * 同步钉钉外部联系人到本地数据库
 */
public class SynExtUserFromDingTalkToDbRunnable implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(SynExtUserFromDingTalkToDbRunnable.class);
	
	private static final long SIZE = 2l;
	private static final String RESULT_JSON_FORMET = "result:{0}";
	
    private ExtUserWrapService extUserService;
    
    private LocalExtUserService localExtUserService;
    
    public SynExtUserFromDingTalkToDbRunnable(ExtUserWrapService extUserService,LocalExtUserService localExtUserService) {
    	this.extUserService = extUserService;
    	this.localExtUserService = localExtUserService;
    }
    
	@Override
	public void run() {
		
		LOGGER.debug("SynExtUserFromDingTalkToDbRunnable begin");
		getExtUserFromDingTalk(0);

	}

	private boolean getExtUserFromDingTalk(long offset) {

		try {
			String str = extUserService.extList(SIZE, offset);
			String json = "{" + MessageFormat.format(RESULT_JSON_FORMET, str) + "}";
			Result result = JsonMapperHelper.defaultMapper().fromJson(json, Result.class);
			List<ExtUser> results = change(result);
			
			saveExtUserToDb(results);
			if (null != results && results.size() == SIZE) {
				offset = offset + SIZE;
				return getExtUserFromDingTalk(offset);
			}
			return true;
		} catch (DDApiException e) {
			LOGGER.error("Scheduled synExtUserFromDingTalkToDb exe error " + e.getMessage());
			return false;
		}

	}

	private void saveExtUserToDb(List<ExtUser> results) {
		for (ExtUser extUser : results) {
			localExtUserService.save(extUser);
		}
	}
	
	
	private static List<ExtUser> change(Result result) {
		ExtUser extUser = null;
		List<ExtUser> extUsers = new ArrayList<>();
		List<Result.DingTalkExtUser> dingTalkExtUsers = result.getResult();
		for (Result.DingTalkExtUser dingTalkExtUser : dingTalkExtUsers) {
			extUser = new ExtUser();
			extUser.setUserId(dingTalkExtUser.getUserId());
			extUser.setAddress(dingTalkExtUser.getAddress());
			extUser.setCompanyName(dingTalkExtUser.getCompanyName());
			extUser.setFollowerUserid(dingTalkExtUser.getFollowerUserid());
			extUser.setLabelIds(Arrays.toString(dingTalkExtUser.getLabelIds().toArray()));
			extUser.setMobile(dingTalkExtUser.getMobile());
			extUser.setName(dingTalkExtUser.getName());
			extUser.setRemark(dingTalkExtUser.getRemark());
			extUser.setShareDeptids(Arrays.toString(dingTalkExtUser.getShareDeptids().toArray()));
			extUser.setShareUserids(Arrays.toString(dingTalkExtUser.getShareUserids().toArray()));
			extUser.setStateCode(dingTalkExtUser.getStateCode());
			extUser.setTitle(dingTalkExtUser.getTitle());
			
			extUsers.add(extUser);
		}
		return extUsers;
	}
	
	
	
	private static class Result {
		private List<DingTalkExtUser> result = new ArrayList<>();
		
		public List<DingTalkExtUser> getResult() {
			return result;
		}
		public void setResult(List<DingTalkExtUser> result) {
			this.result = result;
		}
		
		
		static class DingTalkExtUser {
			
			private String userId;
			
			/**
			 * 地址
			 */
			private String address;
			/**
			 * 企业名
			 */
			private String companyName;
			/**
			 * 负责人userId
			 */
			private String followerUserid;
			/**
			 * 标签列表
			 */
			private List<Long> labelIds = new ArrayList<>();
			/**
			 * 手机号
			 */
			private String mobile;
			/**
			 * 名称
			 */
			private String name;
			/**
			 * 备注
			 */
			private String remark;
			/**
			 * 共享给的部门ID
			 */
			private List<Long> shareDeptids = new ArrayList<>();
			/**
			 * 共享给的员工userId列表
			 */
			private List<String> shareUserids = new ArrayList<>();
			/**
			 * 手机号国家码
			 */
			private String stateCode = "86";
			/**
			 * 职位
			 */
			private String title;
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getCompanyName() {
				return companyName;
			}
			public void setCompanyName(String companyName) {
				this.companyName = companyName;
			}
			public String getFollowerUserid() {
				return followerUserid;
			}
			public void setFollowerUserid(String followerUserid) {
				this.followerUserid = followerUserid;
			}
			public List<Long> getLabelIds() {
				return labelIds;
			}
			public void setLabelIds(List<Long> labelIds) {
				this.labelIds = labelIds;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getRemark() {
				return remark;
			}
			public void setRemark(String remark) {
				this.remark = remark;
			}
			public List<Long> getShareDeptids() {
				return shareDeptids;
			}
			public void setShareDeptids(List<Long> shareDeptids) {
				this.shareDeptids = shareDeptids;
			}
			public List<String> getShareUserids() {
				return shareUserids;
			}
			public void setShareUserids(List<String> shareUserids) {
				this.shareUserids = shareUserids;
			}
			public String getStateCode() {
				return stateCode;
			}
			public void setStateCode(String stateCode) {
				this.stateCode = stateCode;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getUserId() {
				return userId;
			}
			public void setUserId(String userId) {
				this.userId = userId;
			}
		}
	}
}
