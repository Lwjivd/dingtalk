package com.zhenergy.zmp.system.local.extuser.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhenergy.zmp.common.service.dao.CrudDao;
import com.zhenergy.zmp.system.api.entity.ExtUser;

@Mapper
public interface ExtUserMapper extends CrudDao<ExtUser> {

	ExtUser getByUserId(String userId);
	
	ExtUser getByCode(String code);
	

}
