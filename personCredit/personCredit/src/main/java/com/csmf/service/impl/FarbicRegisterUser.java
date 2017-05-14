package com.csmf.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csmf.util.Base64;
import com.csmf.util.RSA;
import com.fabric.java.core.sdk.FabricClient;

public class FarbicRegisterUser implements Callable<Map<String,Object>> {

	private Log log = LogFactory.getLog(this.getClass());
	
	private String id;
	
	
	public FarbicRegisterUser(String id){
		this.id = id;
	}
	
	public Map<String,Object> call() throws Exception {
		
		FabricClient client = new FabricClient();
		Map<String,Object> resultMap = new HashMap<String,Object>();
			String baseID = Base64.encode(id.getBytes());
			String passwd  = client.registerUser(baseID);
			resultMap.put("passwd", passwd);	
		return resultMap;
	}

}
