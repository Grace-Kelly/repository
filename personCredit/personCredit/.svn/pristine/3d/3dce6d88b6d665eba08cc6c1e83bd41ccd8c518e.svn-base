package com.csmf.resume;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("resumePasreFactory")
public class ResumePasreFactory {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource
	ApplicationContext context;
	
	
	public ResumeBase createResumePasre(String name){
		ResumeBase resume=null;
		try {
			resume=(ResumeBase) context.getBean(name);
		} catch (Exception e) {
			log.error("can not find object name"+name, e);
		}
		
		return resume;
	}
	
	

}
