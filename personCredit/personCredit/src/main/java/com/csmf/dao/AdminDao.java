package com.csmf.dao;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

public interface AdminDao {
	
void updateCompanyInfo(Map param);

void updateCompanyStatus(Map param);

void insertCompanyInfo(Map<String,Object> param) throws Exception;
	
String queryCompanyAuth(Map<String,Object> param) throws Exception;

}
