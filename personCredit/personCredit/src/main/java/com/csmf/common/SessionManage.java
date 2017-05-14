package com.csmf.common;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.csmf.dto.User;
import com.csmf.service.UserRegisterService;

import net.sf.json.JSONObject;

public class SessionManage {
	
	@Resource
	private UserRegisterService registerService;
	
	public SessionManage(){
		
	}
	
	public boolean isExistSession(HttpServletRequest request){
		if(request !=null){
			HttpSession session  = request.getSession();
			if(session !=null){
				String telPhone = (String) session.getAttribute("telPhone");
				if(telPhone !=null && !telPhone.equals(""))
					return true;
				else
					return false;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map sessionUser(HttpServletRequest request){
		Map resultMap = new HashMap();
		User sessionUser = null;
		if(isExistSession(request)){
			String telPhone = (String)request.getSession().getAttribute("telPhone");
			sessionUser = (User)request.getSession().getAttribute("user");
			if(sessionUser==null){
				sessionUser = registerService.getUserByPhone(telPhone);
				request.getSession().setAttribute("user", sessionUser);
			}
			resultMap.put("status", true);
			resultMap.put("user", sessionUser);
			return resultMap;
		}else{
			resultMap.put("status", false);
			resultMap.put("errorMsg", "会话超时！");
			return resultMap;
		}
	}
}
