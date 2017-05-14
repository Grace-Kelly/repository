package com.csmf.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personAllSkillDao")
public interface PersonAllSkillDao {

	void savePersonSkills(Map<String,Object> param);
	
	void updatePersonSkillById(Map<String,Object> param);
	
	List querySkillById(String memberId);
}
