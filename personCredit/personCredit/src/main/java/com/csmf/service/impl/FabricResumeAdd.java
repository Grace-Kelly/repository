package com.csmf.service.impl;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fabric.java.core.sdk.FabricClient;

public class FabricResumeAdd implements Callable<Boolean>{

	private Log log = LogFactory.getLog(this.getClass());
	
	private String id;
	
	private String jsonStr;
	
	private String passwd;
	
	private String login;
	
	
	public FabricResumeAdd(String id,String passwd,String login,String jsonStr){
		this.id= id;
		this.jsonStr =jsonStr;
		this.passwd = passwd;
		this.login = login;
	}
	
	
	
	
	public Boolean call() throws Exception {
		
		Boolean flag = false;
		
		FabricClient client = new FabricClient();
		
		String[] arg = {"updateResumeInfo",id,jsonStr};
		
		
		flag = client.invokeRequest(login, passwd, arg);
			
		
		return flag;
	}
}
