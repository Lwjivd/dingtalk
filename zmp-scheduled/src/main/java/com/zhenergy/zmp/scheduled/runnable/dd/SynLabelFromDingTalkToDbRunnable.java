package com.zhenergy.zmp.scheduled.runnable.dd;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.entity.Label;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.dingtalk.extuser.service.ExtUserWrapService;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalLabelService;

/**
 * 同步钉钉标签列表到本地数据库
 */
public class SynLabelFromDingTalkToDbRunnable implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(SynLabelFromDingTalkToDbRunnable.class);
	
	private static final long SIZE = 2l;
	
    private ExtUserWrapService extUserService;
    
    private LocalLabelService localLabelService;
    
    public SynLabelFromDingTalkToDbRunnable(ExtUserWrapService extUserService, LocalLabelService localLabelService) {
    	this.extUserService = extUserService;
    	this.localLabelService = localLabelService;
    }
    
	@Override
	public void run() {
		
		LOGGER.debug("Scheduled SynLabelFromDingTalkToDbRunnable begin");
		getLabelFromDingTalk(0);

	}

	private boolean getLabelFromDingTalk(long offset) {

		try {
			String json = extUserService.listLabelGroups(SIZE, offset);
			Result result = JsonMapperHelper.defaultMapper().fromJson(json, Result.class);
			
			List<Label> results = change(result);
			saveLabelToDb(results);
			if (null != results && results.size() == SIZE) {
				offset = offset + SIZE;
				return getLabelFromDingTalk(offset);
			}
			return true;
		} catch (DDApiException e) {
			LOGGER.error("Scheduled synExtUserFromDingTalkToDb exe error " + e.getMessage());
			return false;
		}

	}

	private void saveLabelToDb(List<Label> results) {
		for (Label label : results) {
			localLabelService.save(label);
		}
	}
	
	
	
	
	private static List<Label> change(Result result) {
		Label label = null;
		List<Label> labels = new ArrayList<>();
		List<Result.Color> colors = result.getResult();
		for (Result.Color color : colors) {
			label = new Label();
			label.setLabelId(color.getColor());
			label.setLabelName(color.getName());
			labels.add(label);
			for (Result.Color.Label ddLabel : color.getLabels()) {
				label = new Label();
				label.setLabelId(ddLabel.getId());
				label.setParentLabelId(color.getColor());
				label.setLabelName(ddLabel.getName());
				
				labels.add(label);
			}
		}
		return labels;
	}
	
	private static class Result{
		private List<Color> result = new ArrayList<>();
		
		public List<Color> getResult() {
			return result;
		}

		public void setResult(List<Color> result) {
			this.result = result;
		}

		static class Color {
			private Long color;
			private String name;
			private List<Label> labels = new ArrayList<>();
			
			public Long getColor() {
				return color;
			}

			public void setColor(Long color) {
				this.color = color;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public List<Label> getLabels() {
				return labels;
			}

			public void setLabels(List<Label> labels) {
				this.labels = labels;
			}

			static class Label{
				private Long id;
				private String name;
				public Long getId() {
					return id;
				}
				public void setId(Long id) {
					this.id = id;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
			}
		}
	}
	
}
