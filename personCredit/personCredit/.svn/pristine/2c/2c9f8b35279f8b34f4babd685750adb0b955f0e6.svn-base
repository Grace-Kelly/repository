package com.csmf.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personEducationDao")
public interface PersonEducationDao {

	void savePersonEducationInfo(Map map);
	
	List queryAllEducationById(String memberId);
	
	void updateEducationInfoById(Map<String,Object> param);
}
