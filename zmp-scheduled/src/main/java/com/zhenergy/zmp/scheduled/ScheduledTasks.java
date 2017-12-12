package com.zhenergy.zmp.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhenergy.zmp.scheduled.runnable.dd.SynExtUserFromDingTalkToDbRunnable;
import com.zhenergy.zmp.scheduled.runnable.dd.SynLabelFromDingTalkToDbRunnable;
import com.zhenergy.zmp.system.dingtalk.extuser.service.ExtUserWrapService;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalExtUserService;
import com.zhenergy.zmp.system.local.extuser.service.base.LocalLabelService;

@Component
public class ScheduledTasks {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
    private ExtUserWrapService extUserService;
    
    @Autowired
    private LocalExtUserService localExtUserService;
    
    @Autowired
    private LocalLabelService localLabelService;
    
	
	@Scheduled(cron = "0 */1 *  * * * ")
    public void synExtUserFromDingTalkToDb() {
    	LOGGER.debug("Scheduled synExtUserFromDingTalkToDb begin");
		SynExtUserFromDingTalkToDbRunnable job = new SynExtUserFromDingTalkToDbRunnable(extUserService, localExtUserService);
		job.run();
    }
	
	//@Scheduled(cron = "0 */1 *  * * * ")
	public void synLabelFromDingTalkToDb() {
		LOGGER.debug("Scheduled synLabelFromDingTalkToDb begin");
		SynLabelFromDingTalkToDbRunnable job = new SynLabelFromDingTalkToDbRunnable(extUserService, localLabelService);
		job.run();
    }
	
}


