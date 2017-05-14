package com.csmf.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csmf.common.StatusCode;
import com.csmf.dao.ISeqNoDAO;
import com.csmf.dao.PersonAllSkillDao;
import com.csmf.dao.UserRegisterDao;
import com.csmf.dto.send.SendAllSkills;
import com.csmf.service.FabricService;
import com.csmf.service.PersonAllSkillService;
import com.csmf.util.DateUtil;

import net.sf.json.JSONObject;

@Service("personAllSkillService")
public class PersonAllSkillServiceImpl implements PersonAllSkillService {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private PersonAllSkillDao personAllSkillDao;

	@Resource
	private ISeqNoDAO seqNoDAO;
	@Resource
	private UserRegisterDao userRegisterDao;

	@Resource
	private FabricService fabricService;

	public Map<String,Object> savePersonSkills(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if (param != null) {
			String telPhone = (String) param.get("telPhone");
			String saveFlag = (String) param.get("saveFlag");
			param.put("id", seqNoDAO.getFlwNo("PS", "S"));
			if (!StringUtils.isEmpty(telPhone)) {
				Map personMap = userRegisterDao.queryPersonInfo(telPhone);
				String identityNum = (String) personMap.get("identityNum");
				String sendFlag = (String) personMap.get("sendFlag");
				if (!StringUtils.isEmpty(saveFlag)) {
					if ("local".equals(saveFlag)) {
						personAllSkillDao.savePersonSkills(param);
						result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
						result.put(StatusCode.MSG, "保存成功");
					}
					if ("block".equals(saveFlag)) {
						String json = beanToJson(param);
						result = fabricService.sendToBlock(sendFlag, identityNum, json);
						if (StatusCode.STATUS_FAIL.equals((String) result.get(StatusCode.STATUS))) {
							return result;
						}
						personAllSkillDao.savePersonSkills(param);
					}
				} else {
					result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					result.put(StatusCode.MSG, "保存失败,参数出错");
				}
			} else {
				result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				result.put(StatusCode.MSG, "信息丢失");
			}
		} else {
			result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
			result.put(StatusCode.MSG, "参数为空");
		}
		return result;
	}

	public Map<String,Object> updatePersonSkillById(Map<String, Object> param)  throws Exception {
		String saveFlag = (String) param.get("saveFlag");
		String telPhone = (String) param.get("telPhone");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(saveFlag)) {
			if ("local".equals(saveFlag)) {
				personAllSkillDao.updatePersonSkillById(param);// 更新
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "保存成功");
			}
			if ("block".equals(saveFlag)) {
				Map<String, Object> personMap = userRegisterDao.queryPersonInfo(telPhone);
				String sendFlag = (String) personMap.get("sendFlag");
				String identityNum = (String) personMap.get("identityNum");
				resultMap = fabricService.sendToBlock(sendFlag, identityNum, beanToJson(param));
				if (StatusCode.STATUS_FAIL.equals((String) resultMap.get(StatusCode.STATUS))) {
					return resultMap;
				}
				personAllSkillDao.updatePersonSkillById(param);
			}
		} else {
			resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
			resultMap.put(StatusCode.MSG, "保存失败,参数出错");
		}
		return resultMap;
	}

	public List querySkillById(String memberId) {
		return personAllSkillDao.querySkillById(memberId);
	}

	public Map<String, Object> validateInfo(JSONObject jsonObject) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String skillNum = (String) jsonObject.get("skillNum");
		String proficiency = (String) jsonObject.get("proficiency");// 熟练度
		String saveFlag = (String) jsonObject.get("saveFlag");
		/*
		 * 校验数据正确性
		 */
		result.put("id", seqNoDAO.getFlwNo("PS", "S"));
		result.put("skillNum", skillNum);
		result.put("proficiency", proficiency);
		Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
		result.put("createTime", createTime);
		result.put("updateTime", createTime);
		result.put("saveFlag", saveFlag);// 保存本地数据库
		result.put("remark", "remark");

		return result;
	}

	public String beanToJson(Map<String, Object> param) throws Exception {
		SendAllSkills skill = new SendAllSkills();
		if (param != null) {
			skill.setProficiency((String) param.get("proficiency"));
			skill.setSkillType((String) param.get("skillType"));
			skill.setSkillNum((String) param.get("skillNum"));
			JSONObject obj = JSONObject.fromObject(skill);
			return obj.toString();
		} else {
			throw new Exception("请求失败，参数为空");
		}
	}
}
