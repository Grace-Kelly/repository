package com.csmf.dao;

import java.util.Map;

public interface SecretKeyDAO {

	
	public void insertSecretKey(Map<String,Object> params);
	
	public void updateSecretKey(Map<String,Object> params);
	
	public Map<String,Object> querySecretKeyById(String mereId);
	
	public Map<String,Object> queryMemberIdById(String id);
	
	public String queryidBymemberId(Map<String,Object> param);
	
	public String queryCompanyReg(Map<String,Object> param);
	
	Map<String,Object> querySecretKeyByMId(String memberId);
	
	void updatePriKeyandPubKey(Map parma) throws Exception;
}
