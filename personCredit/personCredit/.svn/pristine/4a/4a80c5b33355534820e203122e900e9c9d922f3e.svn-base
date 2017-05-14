package com.csmf.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@MapperScan
@Component("personCertDao")
public interface PersonCertDao {

	void saveCertInfo(Map<String,Object> param);
	
	void updateCertInfoById(Map<String,Object> param);
	
	List queryCertInfoById(String memberId);

}
