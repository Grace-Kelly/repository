package com.csmf.service;

import com.csmf.dto.User;

import java.util.Map;

public interface UserRegisterService {
	
	@SuppressWarnings("rawtypes")
	Boolean isExistUserByPhone(Map map);
	
	Boolean isExistUserByPhone(String telPhone);
	
	User getUserByPhone(String telPhone);
	
	void saveUser(Map person)  throws Exception;

	void updateUserInfoByTelPhone(Map<String,Object> param) throws Exception;

	String getMemberIdByTelPhone(String telPhone) throws Exception;
	
	Map queryPersonInfo(String telPhone) throws Exception;
	
	Boolean checkPwd(String telPhone,String pwd,Map param) throws Exception;
	
	String setFinishFlagValue(String type,String finishFlag) throws Exception;
	
	void updateFinishFlagValue(String telPhone,String finishFlag) throws Exception;
	
	void updatePwdByTelPhone(Map map) throws Exception;
	
	void updateTelPhoneByTelPhone(Map<String,Object> param) throws Exception;
	
	void updateStatusByTel(Map<String,Object> param) throws Exception;
	
	void updateSendFlag(Map<String,Object> param) throws Exception;
}
