package com.csmf.resume.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.csmf.dto.Resume;

public class Analysis implements ResumeAnalysis{

	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail)throws Exception {
		
		return null;
	}
	
	
	
	public String timesub(Date start,Date end){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		
		String startTime = format.format(start);
		
		String endTime = format.format(end);
		
		
		return startTime+"-"+endTime;
	}
	
	public boolean compreDate(Date date,Date targaet,String reg){
		
		boolean flag = false;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
		
		String trdate = format.format(targaet);
		
		try {
			targaet = format.parse(trdate);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		if ("eq".equals(reg)){
			if(date.equals(targaet)){
				
				flag= true;
			}
		}else if("lt".equals(reg)){
			if(date.before(targaet)){
				
				flag= true;
			}
		}else if("gt".equals(reg)){
			if(date.after(targaet)){
				
				flag= true;
			}
		}
		return flag;
	}
	
	
	

}
