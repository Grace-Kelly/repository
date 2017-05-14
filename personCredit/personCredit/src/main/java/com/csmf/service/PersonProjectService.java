package com.csmf.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public interface PersonProjectService {

	Map<String, Object> savePersonProjectInfo(Map map) throws Exception;
	
	List queryAllProjectById(String memberId) throws Exception;
	
	Map<String, Object> updatePersonProjectById(Map<String,Object> param) throws Exception;
	
	List querySkillByProId(String id) throws Exception;
	
}
