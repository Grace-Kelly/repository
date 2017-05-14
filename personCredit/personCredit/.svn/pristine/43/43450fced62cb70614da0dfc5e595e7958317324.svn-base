package com.csmf.dao;

import com.csmf.dto.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Map;

@MapperScan
public interface UserRegisterDao {
	int isExistUserByPhone(String telPhone);//写了
	
	User getUserbyPhone(String telPhone);
	
	void saveUserForMap(Map param);//写了

	void updateUserInfoByTelPhone(Map<String,Object> param);//写了

	String getMemberIdByTelPhone(String telPhone);
	
	Map queryPersonInfo(String telPhone);
	
	Map queryStatus(String telPhone);
	
	void updateFinishFlagValue(Map param) throws Exception;
	
	void updatePwdByTelPhone(Map param) throws Exception;
	
	void updateTelPhoneByTelPhone(Map param) throws Exception;
	
	void updateStatusByTel(Map param) throws Exception;
	
	void updateSendFlag(Map param) throws Exception;
	
}
