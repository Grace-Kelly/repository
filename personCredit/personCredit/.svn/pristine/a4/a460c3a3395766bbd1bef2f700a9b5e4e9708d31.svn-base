package com.csmf.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


public interface CompanyAdminService {
	

	Map<String,Object> loginCompany(Map<String,Object> param);

	Map<String,Object> registerCompanyAdmin(Map<String,Object> param);
	
	List<Map<String,Object>> resumeAnalysis(InputStream in,String type,String id,String login);
	
	void saveCompanyInfo(Map<String,Object> param) throws Exception;
	
}
