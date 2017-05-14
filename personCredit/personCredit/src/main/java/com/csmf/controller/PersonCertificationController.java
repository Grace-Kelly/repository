package com.csmf.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csmf.common.StatusCode;
import com.csmf.dao.ISeqNoDAO;
import com.csmf.dto.ObjFileBean;
import com.csmf.service.FabricService;
import com.csmf.service.PersonAllSkillService;
import com.csmf.service.PersonCertService;
import com.csmf.service.PersonCertificationService;
import com.csmf.service.PersonEducationService;
import com.csmf.service.PersonInfoService;
import com.csmf.service.PersonProjectService;
import com.csmf.service.PersonTrainService;
import com.csmf.service.PersonWorkService;
import com.csmf.service.UserRegisterService;
import com.csmf.util.DateUtil;
import com.csmf.util.RequestJsonFormat;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/person")
public class PersonCertificationController {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private UserRegisterService registerService;

	@Resource
	private PersonCertificationService personCertificationService;

	@Resource
	private ISeqNoDAO seqNoDAO;

	@Resource
	private PersonInfoService personInfoService;

	@Resource
	private PersonEducationService personEducationService;

	@Resource
	private PersonWorkService personWorkService;

	@Resource
	private PersonProjectService personProjectService;

	@Resource
	private PersonTrainService personTrainService;

	@Resource
	private PersonAllSkillService personAllSkillService;

	@Resource
	private PersonCertService personCertService;

	@Resource
	private FabricService fabricService;

	/**
	 * 个人认证信息保存
	 * 
	 * @param uploadFile
	 *            表单提交需要form标签包含enctype="multipart/form-data"的值
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@RequestMapping(value = "/Certification.do", method = { RequestMethod.GET, RequestMethod.POST })
	/*
	 * public void personCretification(@RequestParam(value = "uploadFile",
	 * required = true) MultipartFile[] uploadFile,
	 * 
	 * @RequestParam(value = "name") String name, @RequestParam(value =
	 * "identityNum") String identityNum, HttpServletRequest request,
	 * HttpServletResponse response) {
	 */
	public void personCretification(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<ObjFileBean> records = new ArrayList<ObjFileBean>();
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				String identityNum = (String) jsonObject.get("identityNum");
				String name = (String) jsonObject.get("name");
				/*if (!ValidationUtil.validateIdCard(identityNum)) { // 对身份证校验
					resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					resultMap.put(StatusCode.MSG, "身份证格式不对");
					JSONObject obj = JSONObject.fromObject(resultMap);
					out.write(obj.toString());
					return;
				}
				if (!ValidationUtil.validateName(name)) {
					resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					resultMap.put(StatusCode.MSG, "名字格式不对");
					JSONObject obj = JSONObject.fromObject(resultMap);
					out.write(obj.toString());
					return;
				}*/
				paramMap.put("identityNum", identityNum);
				paramMap.put("name", name);
				paramMap.put("telPhone", telPhone);
				paramMap.put("memberStatus", StatusCode.CERTIFICATION_FLAG_APPROVAL);
				registerService.updateUserInfoByTelPhone(paramMap);
				
				
				Map param  = new HashMap();
				param.put("memberStatus", StatusCode.CERTIFICATION_FLAG_SUCCESS);// 目前先默认通过
				param.put("telPhone", telPhone);
				registerService.updateStatusByTel(param);
				param.put("memberId", memberId);
				
				//paramMap.put("memberId", memberId);
				//personInfoService.updateIdentityNum(paramMap);
				
				// param.put("processTime", new Date());
				// personCertificationService.updateInfoById(param);
				Map map = registerService.queryPersonInfo(telPhone);
				//String identityNum = (String) map.get("identityNum");
				resultMap = fabricService.registerFarbric(identityNum);
				String finishFlag = (String) map.get("finishFlag");
				String sendFlag = (String) map.get("sendFlag");
				if (StatusCode.STATUS_OK.equals((String) resultMap.get(StatusCode.STATUS)) && StatusCode.PERSON_RESUME_FLAG.equals(finishFlag)) {
					if (StatusCode.SEND_FABRIC_FALSE.equals(sendFlag)) {
						Map blockMap = fabricService.packageInfo(telPhone, memberId);
						Map send = new HashMap();
						send.put("id", (String) map.get("identityNum"));
						send.put("login", (String) map.get("identityNum"));
						send.put("json", JSONObject.fromObject(blockMap).toString());
						resultMap = fabricService.saveResume(send);
						param.put("sendFlag", StatusCode.SEND_FABRIC_TRUE);
						registerService.updateSendFlag(param);
						resultMap.put(StatusCode.MSG, "认证成功");
					}
				}
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			/**
			 * // 保存文件并对文件名重新命名 FileManage fileMng = new FileManage();
			 * Map<String, Object> fileResult = fileMng.uploadFile(uploadFile,
			 * identityNum);
			 * 
			 * if (!(Boolean) fileResult.get("status")) {
			 * resultMap.put("status", false); resultMap.put("errorMsg",
			 * fileResult.get("errorMsg")); JSONObject obj =
			 * JSONObject.fromObject(resultMap); out.write(obj.toString());
			 * return; } Date createTime = new Date(); if (memberId == null ||
			 * "".equals(memberId)) { resultMap.put("status", false);
			 * resultMap.put("errorMsg", "会员ID为空"); JSONObject obj =
			 * JSONObject.fromObject(resultMap); out.write(obj.toString());
			 * return; } List list = (List) fileResult.get("filePath"); Iterator
			 * iterator = list.iterator(); while (iterator.hasNext()) {
			 * ObjFileBean objFile = new ObjFileBean();
			 * objFile.setId(seqNoDAO.getFlwNo("PS", "F"));
			 * objFile.setObjId(memberId);
			 * objFile.setType(StatusCode.CERTIFICATION_TYPE_ONE);// 身份证
			 * objFile.setFilePath((String) iterator.next());
			 * objFile.setCreateTime(createTime); objFile.setRemark("");
			 * records.add(objFile); } resultMap =
			 * personCertificationService.saveCertificationInfo(records);
			 */
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "实名认证保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 个人基本信息保存
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/savePersonInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public void personInfo(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String name = (String) jsonObject.get("name");
				String email = (String) jsonObject.get("email");
				String gender = (String) jsonObject.get("gender");
				String bornDate = (String) jsonObject.get("bornDate");
				String workYear = (String) jsonObject.get("workYear");
				String address = (String) jsonObject.get("address");
				String income = (String) jsonObject.get("income");
				String saveFlag = (String) jsonObject.get("saveFlag");
				// 做request传进来的数据校验
				/**
				 * 校验信息
				 */
				result.put("name", name);
				result.put("gender", "F".equals(gender)?"女":"男");
				result.put("bornDate", bornDate);
				result.put("workYear", workYear);
				result.put("address", address);
				result.put("email", email);
				result.put("income", income);
				result.put("remark", "remark");
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("updateTime", createTime);
				result.put("saveFlag", saveFlag);
				result.put("telPhone", telPhone);
				resultMap = personInfoService.savePersonInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "添加基本信息保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历中教育信息添加
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveEducation.do", method = { RequestMethod.GET, RequestMethod.POST })
	/*
	 * public void personEducation(@RequestParam(value = "uploadFile", required
	 * = true) MultipartFile[] uploadFile, HttpServletRequest request,
	 * HttpServletResponse response) {
	 */
	public void personEducation(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PrintWriter out = null;
		// List<ObjFileBean> records = new ArrayList<ObjFileBean>();
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String admissionTime = (String) jsonObject.get("admissionTime");
				String graduationTime = (String) jsonObject.get("graduationTime");
				String schoolName = (String) jsonObject.get("schoolName");
				String educationBackground = (String) jsonObject.get("educationBackground");
				String credentials = (String) jsonObject.get("credentials");
				String major = (String) jsonObject.get("major");
				String saveFlag = (String) jsonObject.get("saveFlag");
				result.put("admissionTime", DateUtil.stringToDate(admissionTime));
				result.put("graduationTime", DateUtil.stringToDate(graduationTime));
				result.put("schoolName", schoolName);
				result.put("educationBackground", educationBackground);
				result.put("credentials", credentials);
				result.put("major", major);
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("remark", "remark");
				// result.put("status", "0");
				result.put("updateTime", createTime);
				// result.put("file_id", "file_id");
				result.put("saveFlag", saveFlag);// 保存本地数据库
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personEducationService.savePersonEducationInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
			/*
			 * String id = (String) param.get("id"); // 保存文件并对文件名重新命名
			 * if(uploadFile.length>0){//有文件 FileManage fileMng = new
			 * FileManage(); Map<String, Object> fileResult =
			 * fileMng.uploadFile(uploadFile, id); if (!(Boolean)
			 * fileResult.get("status")) { resultMap.put(StatusCode.STATUS,
			 * StatusCode.STATUS_FAIL); resultMap.put(StatusCode.MSG,
			 * fileResult.get(StatusCode.MSG)); JSONObject obj =
			 * JSONObject.fromObject(resultMap); out.write(obj.toString());
			 * return; } Date createTime =
			 * DateUtil.stringToDate(DateUtil.dateToString(new Date())); List
			 * list = (List) fileResult.get("filePath"); Iterator iterator =
			 * list.iterator(); while (iterator.hasNext()) { ObjFileBean objFile
			 * = new ObjFileBean(); objFile.setId(seqNoDAO.getFlwNo("CSMF",
			 * "F")); objFile.setObjId(memberId); objFile.setTypeId(id);
			 * objFile.setType(StatusCode.CERTIFICATION_TYPE_TWO);// 教育
			 * objFile.setFilePath((String) iterator.next());
			 * objFile.setCreateTime(createTime); objFile.setRemark("");
			 * records.add(objFile); }
			 * personCertificationService.saveCertificationInfo(records); }
			 */
		} catch (Exception e) {
			catchException(resultMap, out, e, "添加失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历中工作经验信息保存
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveWork.do")
	public void personWork(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String entryTime = (String) jsonObject.get("entryTime");
				String dimissionTime = (String) jsonObject.get("dimissionTime");
				String companyName = (String) jsonObject.get("companyName");
				String position = (String) jsonObject.get("position");
				String workDescription = (String) jsonObject.get("workDescription");
				String trade = (String) jsonObject.get("trade");
				String department = (String) jsonObject.get("department");
				String saveFlag = (String) jsonObject.get("saveFlag");
				/*
				 * 校验数据正确性
				 */
				result.put("entryTime", DateUtil.stringToDate(entryTime));
				result.put("dimissionTime", DateUtil.stringToDate(dimissionTime));
				result.put("companyName", companyName);
				result.put("position", position);
				result.put("workDescription", workDescription);
				result.put("trade", trade);
				result.put("department", department);
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("updateTime", createTime);
				result.put("saveFlag", saveFlag);// 保存本地数据库
				result.put("remark", "remark");
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personWorkService.savePersonWorkInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历工作参与项目信息添加
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveWorkProject.do")
	public void personWorkProject(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String projectBeginTime = (String) jsonObject.get("projectBeginTime");
				String projectEndTime = (String) jsonObject.get("projectEndTime");
				String companyName = (String) jsonObject.get("companyName");
				String projectName = (String) jsonObject.get("projectName");
				String projectDescription = (String) jsonObject.get("projectDescription");
				String responsibility = (String) jsonObject.get("responsibility");
				String saveFlag = (String) jsonObject.get("saveFlag");
				// String skillId = (String) jsonObject.get("skillId");
				// String workId = (String) jsonObject.get("workId");
				/*
				 * 校验数据正确性
				 */
				result.put("projectBeginTime", DateUtil.stringToDate(projectBeginTime));
				result.put("projectEndTime", DateUtil.stringToDate(projectEndTime));
				result.put("companyName", companyName);
				result.put("projectName", projectName);
				result.put("projectDescription", projectDescription);
				result.put("responsibility", responsibility);
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("updateTime", createTime);
				// result.put("skillId", skillId);
				// result.put("workId", workId);
				result.put("saveFlag", saveFlag);// 保存本地数据库
				result.put("remark", "remark");
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personProjectService.savePersonProjectInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "项目信息保存出错");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历培训添加
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/personTrain.do")
	public void personTrain(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String startTime = (String) jsonObject.get("startTime");
				String endTime = (String) jsonObject.get("endTime");
				String companyName = (String) jsonObject.get("companyName");
				String trainingLevel = (String) jsonObject.get("trainingLevel");
				String trainingName = (String) jsonObject.get("trainingName");
				String saveFlag = (String) jsonObject.get("saveFlag");
				String trainingType = (String) jsonObject.get("trainingType");
				/*
				 * 校验数据正确性
				 */
				result.put("startTime", DateUtil.stringToDate(startTime));
				result.put("endTime", DateUtil.stringToDate(endTime));
				result.put("companyName", companyName);
				result.put("trainingLevel", trainingLevel);
				result.put("trainingType", trainingType);
				result.put("trainingName", trainingName);
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("updateTime", createTime);
				result.put("saveFlag", saveFlag);// 保存本地数据库
				result.put("remark", "remark");
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personTrainService.saveTrainInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历证书添加
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/personCert.do")
	/*
	 * public void personCert(@RequestParam(value = "uploadFile", required =
	 * true) MultipartFile[] uploadFile, HttpServletRequest request,
	 * HttpServletResponse response) {
	 */
	public void personCert(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		List<ObjFileBean> records = new ArrayList<ObjFileBean>();
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				Map<String, Object> result = new HashMap<String, Object>();
				String certificateTime = (String) jsonObject.get("certificateTime");
				String name = (String) jsonObject.get("name");
				String certificateNum = (String) jsonObject.get("certificateNum");
				String saveFlag = (String) jsonObject.get("saveFlag");
				result.put("certificateTime", DateUtil.stringToDate(certificateTime));
				result.put("name", name);
				Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
				result.put("createTime", createTime);
				result.put("updateTime", createTime);
				result.put("saveFlag", saveFlag);// 保存本地数据库
				result.put("certificateNum", certificateNum);
				result.put("remark", "remark");
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personCertService.saveCertInfo(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			/*
			 * String filePath = (String) jsonObject.get("filePath"); if
			 * (!ValidationUtil.validateImage(filePath)) {
			 * resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
			 * resultMap.put(StatusCode.MSG, "上传图片格式不对"); JSONObject obj =
			 * JSONObject.fromObject(resultMap); out.write(obj.toString());
			 * return; } // 保存文件并对文件名重新命名 FileManage fileMng = new FileManage();
			 * String id = seqNoDAO.getFlwNo("PS", "C"); Map<String, Object>
			 * fileResult = fileMng.uploadFile(uploadFile, id);
			 * 
			 * if (!(Boolean) fileResult.get("status")) {
			 * resultMap.put("status", false); resultMap.put("errorMsg",
			 * fileResult.get("errorMsg")); JSONObject obj =
			 * JSONObject.fromObject(resultMap); out.write(obj.toString());
			 * return; }
			 */
			/*
			 * 校验数据正确性
			 */

			// 用map保存便于发送有用数据json给区块链
			/*
			 * List list = (List) fileResult.get("filePath"); Iterator iterator
			 * = list.iterator(); while (iterator.hasNext()) { ObjFileBean
			 * objFile = new ObjFileBean();
			 * objFile.setId(seqNoDAO.getFlwNo("CSMF", "F"));
			 * objFile.setObjId(memberId); objFile.setType("0");// 身份证的类型为0
			 * objFile.setFilePath((String) iterator.next());
			 * objFile.setCreateTime(new Date()); objFile.setRemark("");
			 * records.add(objFile); } resultMap =
			 * personCertificationService.saveCertificationInfo(records);
			 */
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "证书保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 简历自身技能添加
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/personSkill.do")
	public void personSkill(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
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
				result.put("telPhone", telPhone);
				result.put("memberId", memberId);
				resultMap = personAllSkillService.savePersonSkills(result);
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "请求异常");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "保存失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 查询用户所录入的工作经验中的所有公司
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/queryAllCompany.do")
	public void personCompany(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			List list = personWorkService.queryCompanyById(memberId);
			resultMap.put(StatusCode.STATUS, StatusCode.STATUS_OK);
			resultMap.put(StatusCode.MSG, "查询成功");
			resultMap.put(StatusCode.STATUS_RESULT, list);
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "项目信息保存出错");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 查询个人简历
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/personInfo.do")
	public void queryPersonInfo(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			// 查询个人信息
			Map infoMap = personInfoService.queryInfoById(telPhone);
			// 查询工作经验
			List workList = personWorkService.queryAllWorkById(memberId);
			// 查询项目
			List projectList = personProjectService.queryAllProjectById(memberId);
			// 查询教育
			List educationList = personEducationService.queryAllEducationById(memberId);
			// 查询培训
			List trains = personTrainService.queryTrainById(memberId);
			// 查询证书
			List certs = personCertService.queryCertInfoById(memberId);
			// 查询技能
			List skills = personAllSkillService.querySkillById(memberId);
			Map map = new HashMap();
			map.put(StatusCode.JSON_INFO, infoMap);
			map.put(StatusCode.JSON_EDUCATION, educationList);
			map.put(StatusCode.JSON_WORK_EXPE, workList);
			map.put(StatusCode.JSON_PROJECT_EXPE, projectList);
			map.put(StatusCode.JSON_CERT, certs);
			map.put(StatusCode.JSON_TRAIN, trains);
			map.put(StatusCode.JSON_ALL_SKILL, skills);
			resultMap.put(StatusCode.STATUS, StatusCode.STATUS_OK);
			resultMap.put(StatusCode.MSG, "查询成功");
			resultMap.put(StatusCode.STATUS_RESULT, map);
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "查询失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 在保存简历时判断是否实名认证，如果是，就将信息发送给区块链，如果不是不做处理。
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/sendInfo.do")
	private void SendToBlockChain(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			// 查询个人信息
			Map infoMap = registerService.queryPersonInfo(telPhone);
			String status = (String) infoMap.get("status");
			String finishFlag = (String) infoMap.get("finishFlag");
			String sendFlag = (String) infoMap.get("sendFlag");
			if (StatusCode.SEND_FABRIC_FALSE.equals(sendFlag)) {
				if (StatusCode.CERTIFICATION_FLAG_SUCCESS.equals(status)) {
					if (StatusCode.PERSON_RESUME_FLAG.equals(finishFlag)) {
						Map map = fabricService.packageInfo(telPhone, memberId);
						Map send = new HashMap();
						send.put("id", (String) infoMap.get("identityNum"));
						send.put("login", (String) infoMap.get("identityNum"));
						send.put("json", JSONObject.fromObject(map).toString());
						resultMap = fabricService.saveResume(send);
						Map param = new HashMap();
						param.put("sendFlag", StatusCode.SEND_FABRIC_TRUE);
						param.put("telPhone", telPhone);
						registerService.updateSendFlag(param);
						resultMap.put(StatusCode.MSG, "提交成功 ");

					} else {
						resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
						resultMap.put(StatusCode.MSG, "提交失败，简历不全");
					}
				} else {
					resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					resultMap.put(StatusCode.MSG, "提交失败，还未实名认证");
				}
			} else {
				resultMap.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				resultMap.put(StatusCode.MSG, "已提交过，不能重复提交");
			}
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(resultMap, out, e, "项目信息保存出错");
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 实名认证
	 * 
	 * @param request
	 *            请求服务器信息HttpServletRequest
	 * @param response
	 *            服务器返回响应信息HttpServletResponse
	 * @return void 返回类型
	 */
	@RequestMapping("/updateStatus.do")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) {
		Map resultMap = new HashMap();
		PrintWriter out = null;
		Map param = new HashMap();
		try {
			out = response.getWriter();
			String telPhone = (String) request.getSession().getAttribute("telPhone");
			String memberId = (String) request.getSession().getAttribute("memberId");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null) {
				// String status = (String) jsonObject.get("status");
				param.put(StatusCode.STATUS, StatusCode.CERTIFICATION_FLAG_SUCCESS);// 目前先默认通过
				param.put("telPhone", telPhone);
				registerService.updateStatusByTel(param);
				param.put("memberId", memberId);
				// param.put("processTime", new Date());
				// personCertificationService.updateInfoById(param);
				Map map = registerService.queryPersonInfo(telPhone);
				String identityNum = (String) map.get("identityNum");
				resultMap = fabricService.registerFarbric(identityNum);
				String finishFlag = (String) map.get("finishFlag");
				String sendFlag = (String) map.get("sendFlag");
				if (StatusCode.CERTIFICATION_FLAG_SUCCESS.equals((String) resultMap.get("status")) && StatusCode.PERSON_RESUME_FLAG.equals(finishFlag)) {
					if (StatusCode.SEND_FABRIC_FALSE.equals(sendFlag)) {
						Map blockMap = fabricService.packageInfo(telPhone, memberId);
						Map send = new HashMap();
						send.put("id", (String) map.get("identityNum"));
						send.put("login", (String) map.get("identityNum"));
						send.put("json", JSONObject.fromObject(blockMap).toString());
						fabricService.saveResume(map);
					}
				}
				JSONObject obj = JSONObject.fromObject(resultMap);
				out.write(obj.toString());
			}
		} catch (Exception e) {
			catchException(resultMap, out, e, "实名认证失败");
		} finally {
			if (out != null)
				out.close();
		}
	}

	private void catchException(Map result, PrintWriter out, Exception e, String message) {
		log.error(message + " : " + e);
		e.printStackTrace();
		result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
		result.put(StatusCode.MSG, message);
		JSONObject obj = JSONObject.fromObject(result);
		out.write(obj.toString());
	}

}