package com.csmf.service;

import java.util.List;
import java.util.Map;

import com.csmf.dto.ObjFileBean;

public interface PersonCertificationService {

	/**   
	 * @Title: saveCertificationInfo  
	 * @Description: TODO 
	 * @param list 批量添加文件保存
	 * @throws Exception    设定文件   
	 * @return Map<String,Object>    是否保存成功，根据属性status  
	 */ 
	Map<String, Object> saveCertificationInfo(List<ObjFileBean> list) throws Exception;
	
	void updateInfoById(Map param) throws Exception;
}
