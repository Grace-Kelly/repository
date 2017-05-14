package com.csmf.resume.auth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.csmf.common.StatusCode;
import com.csmf.dto.AnalysisResult;
import com.csmf.dto.EduExperience;
import com.csmf.dto.Resume;
import com.csmf.dto.send.SendEducation;

@Component("eduAnalysis")
public class EduAnalysis extends Analysis {

	@Override
	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) throws Exception{
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		//获取教育经历
		if(detail.get(StatusCode.JSON_EDUCATION)!=null){
		List<EduExperience> eduExs = resume.getEduEx();
		
		List<SendEducation> dataMap = (List<SendEducation>) detail.get(StatusCode.JSON_EDUCATION);

		if(eduExs!=null){
			for (EduExperience eduExp : eduExs) {
				 //开始时间
				Date startTime =  eduExp.getStartTime();
				//结束时间
				Date endTime = eduExp.getEndTime();	
				//学校名称
				String schoolName = eduExp.getSchoolName();
				//学位
				String eduction = eduExp.getEducation();
				//专业
				String mojor = eduExp.getMajor();
				
				AnalysisResult result = new AnalysisResult();
				
				Map<String,Object> info = new HashMap<String,Object>();
				
				info.put("time", timesub(startTime, endTime));
				info.put("schoolName", schoolName);
				info.put("eduction", eduction);
				info.put("mojor", mojor);
				result.setInfo(info);
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				for (SendEducation education : dataMap) {
					
					String starts = education.getAdmissionTime();
					String ends = education.getGraduationTime();
					Date start =  format.parse(starts);
					Date end =  format.parse(ends);
					String school = education.getSchoolName();
					String educt = education.getEducationBackground();
					String moj = education.getCredentials();
					//判断入学时间
					if(!compreDate(startTime, start, "eq")){
						continue;
					}
					//毕业时间
					if(!compreDate(endTime, end, "eq")){
						continue;
					}
					//学校名称
					if(!school.equals(schoolName)){
						continue;
					}
					//学历
					if(!eduction.equals(educt)){
						continue;
					}
					//专业
					if(!moj.equals(mojor)){
						continue;
					}
					result.setResult(true);
					result.setAuthNumPass(0);
		  			result.setAuthNumFail(0);
		  			result.setComAuthFail(0);
		  			result.setAuthNumPass(0);
					
				}
				
				resultList.add(result);	
			}
		}
		}
		resultMap.put("eductionList", resultList);
		return resultMap;
	}

	
	
	
}
