package com.csmf.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csmf.service.AdminService;
import com.csmf.util.RequestJsonFormat;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private AdminService adminService;
	
	/**
	 * 修改企业资料（企业审核用）
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/updateCompanyInfo.do")
	public void updateCompanyInfo(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "companyFiles", required = true) MultipartFile[] companyFiles) {
		
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			if(companyFiles.length != 3){
				result.put("status", false);
				result.put("errorMsg", "必须上传三份文件");
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
			//文件上传操作 TODO
			out = response.getWriter();
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if(jsonObject != null){
				Map param = new HashMap();
				param.put("companyId", jsonObject.getString("companyId"));
				param.put("socialCreditCode", jsonObject.getString("companyId"));
				param.put("legalRepresentative", jsonObject.getString("legalRepresentative"));
				param.put("identityNum", jsonObject.getString("identityNum"));
				param.put("name", jsonObject.getString("name"));
				param.put("companyType", jsonObject.getString("companyType"));
				param.put("status", jsonObject.getString("2"));
				param.put("scale", jsonObject.getString("scale"));
				param.put("capital", jsonObject.getString("capital"));
				param.put("industry", jsonObject.getString("industry"));
				param.put("address", jsonObject.getString("address"));
				param.put("remark", jsonObject.getString("remark"));
				result = adminService.updateCompanyInfo(param);
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}
	
	
	/**
	 * 企业审核
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/updateCompanyStatus.do")
	public void updateCompanyInfo(HttpServletRequest request, HttpServletResponse response) {
		
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if(jsonObject != null){
				
				Map param = new HashMap();
				param.put("companyId", jsonObject.getString("companyId"));
				param.put("status", jsonObject.getString("3"));
				result = adminService.updateCompanyStatus(param);
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}
	
	private void catchException(Map result, PrintWriter out, Exception e, String message) {
		log.error("异常错误信息：" + e);
		e.printStackTrace();
		result.put("status", false);
		result.put("errorMsg", message);
		JSONObject obj = JSONObject.fromObject(result);
		out.write(obj.toString());
	}
	
}
