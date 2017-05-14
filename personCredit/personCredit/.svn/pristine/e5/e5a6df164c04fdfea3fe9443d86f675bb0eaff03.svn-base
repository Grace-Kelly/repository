package com.csmf.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personWorkDao")
public interface PersonWorkDao {

	void savePersonWorkInfo(Map map);
	
	List queryCompanyById(String memberId);
	
	List queryAllWorkById(String memberId);
	
	void updateWorkInfoById (Map<String,Object> param);
	
	void saveWorkExs(List<Map<String,Object>> works);
}
