package com.csmf.dao;

import java.util.List;
import java.util.Map;


public interface CompanyAdminDao {
	
	Map<String,Object> queryCompanyAdmin(Map<String,Object> param);
	
	void saveCompanyAdmin(Map<String,Object> param);
	
	Map<String,Object> queryMermberIDBy(Map<String,Object> param);
	
	String queryIsSendResumeByID(String id);
	
	void updateCompanylogin(Map<String,Object> param) throws Exception;

	void savePersonInfo(Map<String,Object> dataMap) throws Exception;
}
