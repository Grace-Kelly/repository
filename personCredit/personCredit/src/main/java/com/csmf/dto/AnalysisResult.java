package com.csmf.dto;

import java.util.List;
import java.util.Map;

public class AnalysisResult extends Result{
	
	private Integer authNumPass;//个人认证数通过数
	
	private Integer comAutnPass;//企业认证数通过数
	
	private Integer comAuthFail;//企业认证数通未过数
	
	private Integer authNumFail;//个人认证未通过数
	
	private Map<String,Object> info;//附加信息
	
	

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public Integer getAuthNumPass() {
		return authNumPass;
	}

	public void setAuthNumPass(Integer authNumPass) {
		this.authNumPass = authNumPass;
	}

	public Integer getComAutnPass() {
		return comAutnPass;
	}

	public void setComAutnPass(Integer comAutnPass) {
		this.comAutnPass = comAutnPass;
	}

	public Integer getComAuthFail() {
		return comAuthFail;
	}

	public void setComAuthFail(Integer comAuthFail) {
		this.comAuthFail = comAuthFail;
	}

	public Integer getAuthNumFail() {
		return authNumFail;
	}

	public void setAuthNumFail(Integer authNumFail) {
		this.authNumFail = authNumFail;
	}
	

}
