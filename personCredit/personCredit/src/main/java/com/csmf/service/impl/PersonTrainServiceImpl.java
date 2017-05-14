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
import com.csmf.dao.PersonTrainDao;
import com.csmf.dao.UserRegisterDao;
import com.csmf.dto.send.SendProject;
import com.csmf.dto.send.SendTrain;
import com.csmf.dto.send.SendWork;
import com.csmf.service.FabricService;
import com.csmf.service.PersonTrainService;
import com.csmf.util.DateUtil;

import net.sf.json.JSONObject;

@Service("personTrainService")
public class PersonTrainServiceImpl implements PersonTrainService {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private PersonTrainDao personTrainDao;

	@Resource
	private ISeqNoDAO seqNoDAO;

	@Resource
	private UserRegisterDao userRegisterDao;

	@Resource
	private FabricService fabricService;

	public Map<String, Object> saveTrainInfo(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if (param != null) {
			String telPhone = (String) param.get("telPhone");
			String saveFlag = (String) param.get("saveFlag");
			param.put("id", seqNoDAO.getFlwNo("PS", "T"));
			if (!StringUtils.isEmpty(telPhone)) {
				Map personMap = userRegisterDao.queryPersonInfo(telPhone);
				String identityNum = (String) personMap.get("identityNum");
				String sendFlag = (String) personMap.get("sendFlag");
				if (!StringUtils.isEmpty(saveFlag)) {
					if ("local".equals(saveFlag)) {
						personTrainDao.saveTrainInfo(param);
						result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
						result.put(StatusCode.MSG, "保存成功");
					}
					if ("block".equals(saveFlag)) {
						String json = beanToJson(param);
						result = fabricService.sendToBlock(sendFlag, identityNum, json);
						if (StatusCode.STATUS_FAIL.equals((String) result.get(StatusCode.STATUS))) {
							return result;
						}
						personTrainDao.saveTrainInfo(param);
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

	public Map<String, Object> updateTrainById(Map<String, Object> param) throws Exception {
		String saveFlag = (String) param.get("saveFlag");
		String telPhone = (String) param.get("telPhone");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(saveFlag)) {
			if ("local".equals(saveFlag)) {
				personTrainDao.updateTrainById(param);// 更新
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
				personTrainDao.updateTrainById(param);
			}
		} else {
			resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
			resultMap.put(StatusCode.MSG, "保存失败,参数出错");
		}
		return resultMap;
	}

	public List queryTrainById(String memberId) throws Exception {
		return personTrainDao.queryTrainById(memberId);
	}

	public String beanToJson(Map<String, Object> param) throws Exception {
		SendTrain Sendtrain = new SendTrain();
		if (param != null) {
			Sendtrain.setCompanName((String) param.get("companName"));
			Sendtrain.setEndTime(DateUtil.dateToString((Date) param.get("endTime")));
			Sendtrain.setStartTime(DateUtil.dateToString((Date) param.get("startTime")));
			Sendtrain.setTrainingDescription("");
			Sendtrain.setTrainingName((String) param.get("trainingName"));
			Sendtrain.setTrainingType((String) param.get("trainingType"));
			Sendtrain.setTrainingLevel((String) param.get("trainingLevel"));
			JSONObject obj = JSONObject.fromObject(Sendtrain);
			return obj.toString();
		} else {
			throw new Exception("请求失败，参数为空");
		}
	}
}
