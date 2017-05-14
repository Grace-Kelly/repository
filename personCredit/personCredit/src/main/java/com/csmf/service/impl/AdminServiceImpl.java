package com.csmf.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.csmf.dao.AdminDao;
import com.csmf.dao.ISeqNoDAO;
import com.csmf.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource
	private AdminDao adminDao;
	
	/**
	 * 企业认证，修改企业资料
	 */
	public Map updateCompanyInfo(Map param) throws Exception{
		Map result = new HashMap();
		adminDao.updateCompanyInfo(param);
		result.put("status", true);
		result.put("errorMsg", "审核成功！");
		return result;
	}

	
	public Map updateCompanyStatus(Map param) throws Exception{
		Map result = new HashMap();
		adminDao.updateCompanyStatus(param);
		result.put("status", true);
		result.put("errorMsg", "审核成功！");
		return result;
	}
	
	
	
}
