package com.csmf.filter;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AuthFilter implements Filter {
	
	private Log log = LogFactory.getLog(AuthFilter.class);
	
	//过滤.do数组
	private static String[] doFunctions = {"companyLogin.do","companyRegrister.do","registerUser.do"
										,"checkCookieAndSession.do","loginUser.do","loginOut.do","generateCode.do"};
	   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// 判断是否是http请求
		if (!(servletRequest instanceof HttpServletRequest)
				|| !(servletResponse instanceof HttpServletResponse)) {
			throw new ServletException(
					"OncePerRequestFilter just supports HTTP requests");
		}
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		/**
		 * 如果处理http请求，并且需要访问诸如getheader或getcookies等在servletrequest中
		 * 无法得到的方法，就要把此request对象构造成httpservletrequest
		 */
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String currenturl = request.getRequestURI(); // 取得根目录所对应的绝对路径:
		String currentPath=request.getServletPath();
		HttpSession session = request.getSession(false); 
		String actionName = currentPath.substring(currentPath.lastIndexOf("/") + 1);

		Map result = new HashMap();
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		/*try {
			for(int i = 0 ; i < doFunctions.length ; i++){
				if(currenturl.indexOf(doFunctions[i]) <= 0){
					if ("post".equalsIgnoreCase(request.getMethod())) {
						if(session == null){
							out = response.getWriter();
							result.put("status", "notSession");
							result.put("errorMsg", "会话超时，请重新登陆！");
							JSONObject obj = JSONObject.fromObject(result);
							out.write(obj.toString());
							return;
						}
						//未登录
						String loginId = (String) session.getAttribute("loginId");
						if (loginId == null || "".equals(loginId)) {
							out = response.getWriter();
							result.put("status", "notSession");
							result.put("errorMsg", "用户未登录,请登录！");
							JSONObject obj = JSONObject.fromObject(result);
							out.write(obj.toString());
							return;
						}
					} else {
						out = response.getWriter();
						result.put("status", "NonePermission");
						result.put("msg", "没有访问权限");
						JSONObject obj = JSONObject.fromObject(result);
						out.write(obj.toString());
						return;
					}
				}
			}
			
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (out != null) {
				out.close();
			}
		}*/
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
