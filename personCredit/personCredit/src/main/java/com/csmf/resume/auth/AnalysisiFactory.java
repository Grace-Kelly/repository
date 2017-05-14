package com.csmf.resume.auth;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("analysisiFactory")
public class AnalysisiFactory {
	
private Log log = LogFactory.getLog(this.getClass());
	
	@Resource
	ApplicationContext context;
	
	
	public ResumeAnalysis newInstince(String name){
		
		ResumeAnalysis resume=null;
		try {
			resume=(ResumeAnalysis) context.getBean(name);
		} catch (Exception e) {
			log.error("can not find object name"+name, e);
		}
		
		return resume;
		
	}

}
