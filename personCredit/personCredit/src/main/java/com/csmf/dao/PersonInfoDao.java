package com.csmf.dao;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personInfoDao")
public interface PersonInfoDao {

	void savePersonInfo(Map<String,Object> param);
	
	void updatePersonInfoById(Map<String,Object> param);
	
	Map<String, Object> queryInfoById(String telPhone);
	
	void updateIdentityNum(Map map);
}
