package com.csmf.service.impl;

import java.util.concurrent.Callable;

import com.csmf.util.RSA;
import com.fabric.java.core.sdk.FabricClient;

public class FabricQueryResume implements Callable<String>{

	private String id;
	private String passwd;
	private String priKey;
	private String login;
	
	
	public FabricQueryResume(String login,String id,String passwd,String priKey){
		this.id = id;
		this.passwd = passwd;
		this.priKey = priKey;
		this.login = login;
	}
	
	
	
	
	public String call() throws Exception {
			
		FabricClient client = new FabricClient();
		
		String[] args = {"queryResumeInfo",id};
		
		String json = client.queryRequest(login, passwd, args);
		
		RSA rsa = RSA.create();
		
		
		
		json = rsa.decodeByPrivateKey(json, priKey);
		
		
		
		
		return json;
	}

}
