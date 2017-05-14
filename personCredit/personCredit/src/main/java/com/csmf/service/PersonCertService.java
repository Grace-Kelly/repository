package com.csmf.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public interface PersonCertService {
	
	Map<String,Object> saveCertInfo(Map<String,Object> param) throws Exception;
	
	Map<String,Object> updateCertInfoById(Map<String,Object> param) throws Exception;
	
	List queryCertInfoById(String memberId) throws Exception;
}
