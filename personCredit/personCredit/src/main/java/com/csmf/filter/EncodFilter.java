package com.csmf.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csmf.common.StatusCode;

import net.sf.json.JSONObject;

public class EncodFilter implements Filter {

	private Log log = LogFactory.getLog(this.getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest)arg0;
			HttpServletResponse res = (HttpServletResponse)arg1;
			String telPhone = (String) req.getSession().getAttribute("telPhone");
			String memberId = (String) req.getSession().getAttribute("memberId");
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/json");
			/*if(StringUtils.isEmpty(telPhone)&&StringUtils.isEmpty(memberId)){
				try {
					PrintWriter out = res.getWriter();
					Map map = new HashMap();
					map.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					map.put(StatusCode.MSG, "还未登录请先登录");
					out.write(JSONObject.fromObject(map).toString());
					return;
				} catch (Exception e) {
					log.error("用户未登录:",e);
				}
			}*/
			
			chain.doFilter(req, res);  
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
