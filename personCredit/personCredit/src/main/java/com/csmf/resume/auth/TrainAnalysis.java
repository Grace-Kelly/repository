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
import com.csmf.dto.Resume;
import com.csmf.dto.TrainExperience;
import com.csmf.dto.send.SendTrain;

@Component("trainAnalysis")
public class TrainAnalysis extends Analysis {

	@Override
	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) throws Exception{
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		if(detail.get(StatusCode.JSON_TRAIN)!=null){
		//培训经历	
		List<TrainExperience> list =  resume.getTrainExperience();
		
		List<SendTrain> dataMap = (List<SendTrain>) detail.get(StatusCode.JSON_TRAIN);
		
		
		
		if(list!=null){
			
			for (TrainExperience trainExp : list) {
				//开始时间
				Date startTime = trainExp.getStartTime();
				//结束时间
				Date endTime = trainExp.getEndTime();
				//培训课程名
				String tranName = trainExp.getTranName();
				//机构名称
				String institutions = trainExp.getInstitutions();
				//培训地址
				String address = trainExp.getAddress();
				
				
				AnalysisResult result = new AnalysisResult();
				Map<String,Object> info =new HashMap<String,Object>();
				info.put("time", timesub(startTime, endTime));
				info.put("tranName", tranName);
				info.put("institutions", institutions);
				info.put("address", address);
				result.setInfo(info);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				
				for (SendTrain tran : dataMap) {
					
					String starts= tran.getStartTime();
					String ends = tran.getEndTime();
					
					Date start = format.parse(starts);
					Date end = format.parse(ends);
					
					String tNmae = tran.getTrainingName();
					String inname = tran.getCompanName();
					
					
					if(!compreDate(startTime, start, "eq")){
						continue;
					}
					
					if(!compreDate(endTime, end, "eq")){
						continue;
					}
					
					if(!tranName.equals(tNmae)){
						continue;
					}
					
					if(!institutions.equals(inname)){
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
		resultMap.put("tranList", resultList);
		return resultMap;
	}
	
	
	

}
