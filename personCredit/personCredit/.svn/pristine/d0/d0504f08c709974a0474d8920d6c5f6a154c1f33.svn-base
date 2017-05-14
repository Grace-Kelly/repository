package com.csmf.resume.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.csmf.common.StatusCode;
import com.csmf.dto.AnalysisResult;
import com.csmf.dto.Result;
import com.csmf.dto.Resume;
import com.csmf.dto.WorkExperience;
import com.csmf.dto.send.SendWork;

@Component("workExAnalysis")
public class WorkExAnalysis extends Analysis{

	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) throws Exception {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		if(detail.get(StatusCode.JSON_WORK_EXPE)!=null){
			
			List<SendWork> workExpes =  (List<SendWork>) (detail.get(StatusCode.JSON_WORK_EXPE)!=null?detail.get(StatusCode.JSON_WORK_EXPE):new ArrayList<SendWork>());
			
			List<WorkExperience> list = resume.getWorkEx();
			
			if(list!=null){
				
				for (WorkExperience workExperience : list) {
					//入职时间
				   Date startTime = workExperience.getStartTime();
				   //离职时间
				   Date endTime = workExperience.getEndTime();
				   //公司名称
				   String companyName = workExperience.getCompanyName();
				   //职位
				   String position = workExperience.getPosition();
				   //部门
				   String depName = workExperience.getDepName();
				   //工作描述
				   String workdesp = workExperience.getWorkdesp();
				   AnalysisResult result = new AnalysisResult();
				   Map<String,Object> dataMap =  new HashMap<String,Object>();
		  			dataMap.put("workTime", timesub(startTime,endTime));
		  			dataMap.put("companyName", companyName);
		  			dataMap.put("position", position);
		  			dataMap.put("depName", depName);
		  			dataMap.put("workdesp", workdesp);	  			
		  			result.setInfo(dataMap);
		  			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				  for (SendWork work : workExpes) {
					  		
//					  		boolean workTime = true;
//					  		boolean company = true;
//					  		boolean pos = true;
					  		if (work.getEntryTime()!=null){					  			
					  			String entryTimes = work.getEntryTime();
					  			Date entryTime = format.parse(entryTimes);
					  			if(!compreDate(startTime,entryTime,"eq")){//开始时间未匹配
					  				continue;
					  			}
					  			String dimissionTimes = work.getDimissionTime();
					  			
					  			Date dimissionTime = format.parse(dimissionTimes);
					  			
					  			if(compreDate(endTime,new Date(),"eq") && !compreDate(dimissionTime,new Date(),"eq")){//离职时间
					  				
					  				if(!compreDate(endTime, dimissionTime, "gt")){
					  					continue;
					  				}
					  			}else{
					  				if(!compreDate(endTime, dimissionTime, "eq")){
					  					continue;
					  				}
					  			}
					  			//公司名称
					  			String wcompanyName = work.getCompanName();
					  			if(!companyName.equals(wcompanyName)){
					  				continue;
					  			}
					  			
					  			//职位
					  			String wposition = work.getPosition();
					  			
					  			if(!position.equals(wposition)){
					  				continue;
					  			}
					  			result.setResult(true);
					  			//是否已经背调
					  			result.setAuthNumPass(0);
					  			result.setAuthNumFail(0);
					  			result.setComAuthFail(0);
					  			result.setAuthNumPass(0);
					  			
					  			
					  		}
					  
					  		
				  		}
				  resultList.add(result);
				  
				}	
			}
		}
		resultMap.put("workList", resultList);
		return resultMap;
	}
	
	
	

}
