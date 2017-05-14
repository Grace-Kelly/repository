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
import com.csmf.service.DictionaryService;
import com.csmf.util.RequestJsonFormat;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	
	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 查询字典
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/selectDictionaryInfo.do")
	public void selectDictionaryInfo(HttpServletRequest request, HttpServletResponse response) {
		
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if(jsonObject != null){
				Map param = new HashMap();
				String dataType = jsonObject.getString("dataType");
				param.put("dataType", dataType);
				//行业、证书
				if(("certificate").equals(dataType) || ("industry").equals(dataType)){
					
					result = dictionaryService.selectDictionaryInfoTo2(param);
					
				}else if(("skillLanguage").equals(dataType)){//技能
					
					result = dictionaryService.selectSkillInfo(param);
					
				}else{//其他数据字典
					
					result = dictionaryService.selectDictionaryInfo(param);
					
				}
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
			result.put("status", true);
			result.put("errorMsg", "传入参数不正确！");
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}
	
	
	/**
	 * 查询省份市区
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/selectProvinceAndCityInfo.do")
	public void selectProvinceAndCityInfo(HttpServletRequest request, HttpServletResponse response) {
		
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			result = dictionaryService.selectProvinceAndCityInfo();
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
			return;
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
