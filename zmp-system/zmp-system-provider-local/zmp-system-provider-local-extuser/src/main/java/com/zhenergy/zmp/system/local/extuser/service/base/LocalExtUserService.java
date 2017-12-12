package com.zhenergy.zmp.system.local.extuser.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhenergy.zmp.common.redis.RedisRepository;
import com.zhenergy.zmp.common.utils.JsonMapperHelper;
import com.zhenergy.zmp.system.api.entity.ExtUser;
import com.zhenergy.zmp.system.api.entity.User;
import com.zhenergy.zmp.system.api.exception.base.DDApiException;
import com.zhenergy.zmp.system.api.service.IDDUserService;
import com.zhenergy.zmp.system.local.extuser.mapper.ExtUserMapper;

@Service
@Transactional(readOnly = true)
public class LocalExtUserService {

    @Autowired
    private ExtUserMapper extUserMapper;
    
    @Autowired
    private RedisRepository redisRepository;
    
    private static final String REDIS_PREFIX_EXTUSER = "extuser:";

    @Transactional(readOnly = false)
    public void save(ExtUser extUser) {
    	extUserMapper.insert(extUser);
    }
    
    public void setCache(ExtUser extUser) {
    	
    	String key = REDIS_PREFIX_EXTUSER + extUser.getUserId();
    	String value = JsonMapperHelper.defaultMapper().toJson(extUser);
    	redisRepository.set(key, value);
    }

	public User getUserByUserId(String userId) {
		ExtUser extuser = extUserMapper.getByUserId(userId);
    	return extuser;
	}

	
}
