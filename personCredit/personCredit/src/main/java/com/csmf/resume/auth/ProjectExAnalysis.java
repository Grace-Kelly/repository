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
import com.csmf.dto.ProjectExperience;
import com.csmf.dto.Resume;
import com.csmf.dto.send.SendProject;

@Component("projectExAnalysis")
public class ProjectExAnalysis extends Analysis {

	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		if(detail.get(StatusCode.JSON_PROJECT_EXPE)!=null){
		//获取项目经验
		List<ProjectExperience> list = resume.getProjectEx();
		
		List<SendProject> projectExpes = (List<SendProject>) (detail.get(StatusCode.JSON_PROJECT_EXPE)!=null?detail.get(StatusCode.JSON_PROJECT_EXPE):new ArrayList<SendProject>());
		
		
		
		if(list !=null){
			
			for (ProjectExperience project : list) {
				
				//项目开始时间
				Date startTime = project.getStartTime();
				
				//项目结束时间
				Date endTime = project.getEndTime();
				
				//项目名称
				String projectName = project.getProjectName();
				
				String workdes = project.getWorkDes();
				
				String projectDes = project.getProjectDes(); 
				
				AnalysisResult result = new AnalysisResult();
				Map<String,Object> info = new HashMap<String,Object>();
				info.put("projectName", projectName);
				info.put("time", timesub(startTime,endTime));
				info.put("workdes", workdes);
				info.put("projectDes", projectDes);
				result.setInfo(info);
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				for (SendProject pro : projectExpes) {
					String starts = pro.getProjectBeginTime();
					String ends = pro.getProjectEndTime();
					Date start = format.parse(starts);
					Date end = format.parse(ends);
					String name = pro.getProjectName();
					//对比开始时间
					if(!compreDate(startTime,start,"eq")){
						continue;
					}
					//对比结束时间
					if(compreDate(endTime, new Date(), "eq") && !compreDate(end, new Date(), "eq")){
						if(!compreDate(endTime, end, "lt")){
							continue;
						}
					}else{
						if(!compreDate(endTime, end, "eq")){
							continue;
						}
					}
					//对比项目名称
					if(!projectName.equals(name)){
						continue;
					}
					
					
					result.setResult(true);
		  			//是否已经背调
		  			result.setAuthNumPass(0);
		  			result.setAuthNumFail(0);
		  			result.setComAuthFail(0);
		  			result.setAuthNumPass(0);
					
				}
				resultList.add(result);
			}

		}
		}
		resultMap.put("projectList", resultList);
		return resultMap;
	}
	
	
	

}
