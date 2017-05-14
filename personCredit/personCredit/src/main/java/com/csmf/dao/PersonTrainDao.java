package com.csmf.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component("personTrainDao")
public interface PersonTrainDao {
	void saveTrainInfo(Map<String,Object> param);
	
	void updateTrainById(Map<String,Object> param);
	
	List queryTrainById(String memberId);
}
