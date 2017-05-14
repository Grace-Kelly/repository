package com.csmf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.csmf.common.StatusCode;
import com.csmf.dao.PersonCertificationDao;
import com.csmf.dao.PersonEducationDao;
import com.csmf.dao.PersonProjectDao;
import com.csmf.dao.PersonWorkDao;
import com.csmf.dao.UserRegisterDao;
import com.csmf.dto.ObjFileBean;
import com.csmf.service.PersonCertificationService;

@Service("personCertificationService")
public class PersonCertificationServiceImpl implements PersonCertificationService {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private UserRegisterDao userRegisterDao;

	@Resource
	private PersonEducationDao personEducationDao;

	@Resource
	private PersonProjectDao personProjectDao;

	@Resource
	private PersonWorkDao personWorkDao;

	@Resource
	private PersonCertificationDao personCertificationDao;

	public Map<String, Object> saveCertificationInfo(List<ObjFileBean> list) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		personCertificationDao.saveMoreFile(list);
		result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
		result.put(StatusCode.MSG, "保存成功");
		return result;
	}

	public void updateInfoById(Map param) throws Exception {
		personCertificationDao.updateInfoById(param);
	}

}
