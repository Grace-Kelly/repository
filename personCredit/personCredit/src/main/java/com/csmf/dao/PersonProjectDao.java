 package com.csmf.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personProjectDao")
public interface PersonProjectDao {

	void savePersonProjectInfo(Map map);
	
	List queryAllProjectById(String memberId);
	
	void updatePersonProjectById(Map<String,Object> param);
	
	//List querySkillByProId(String id);

}
