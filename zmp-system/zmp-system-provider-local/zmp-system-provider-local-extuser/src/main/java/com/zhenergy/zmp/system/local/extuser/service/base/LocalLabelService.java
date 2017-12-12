package com.zhenergy.zmp.system.local.extuser.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhenergy.zmp.common.redis.RedisRepository;
import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.entity.Label;
import com.zhenergy.zmp.system.local.extuser.mapper.LabelMapper;

@Service
@Transactional(readOnly = true)
public class LocalLabelService {

    @Autowired
    private LabelMapper labelMapper;
    
    @Autowired
    private RedisRepository redisRepository;
    
    private static final String REDIS_PREFIX_EXTUSER = "extuser:";

    @Transactional(readOnly = false)
    public void save(Label label) {
    	labelMapper.insert(label);
    }
    
    public void setCache(Label label) {
    	
    	String key = REDIS_PREFIX_EXTUSER + label.getId();
    	String value = JsonMapperHelper.defaultMapper().toJson(label);
    	redisRepository.set(key, value);
    }
    
}
