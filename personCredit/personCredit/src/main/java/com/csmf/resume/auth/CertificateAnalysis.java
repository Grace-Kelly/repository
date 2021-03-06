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
import com.csmf.dto.Certificate;
import com.csmf.dto.Resume;
import com.csmf.dto.send.SendCertificate;

@Component("certificateAnalysis")
public class CertificateAnalysis extends Analysis {

	@Override
	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		if(detail.get(StatusCode.JSON_CERT)!=null){
		
		List<Certificate> list = resume.getCertificate();
		
		List<SendCertificate> dataMap = (List<SendCertificate>) detail.get(StatusCode.JSON_CERT);
		
		
		
		if(list!=null){
			
			for (Certificate cert : list) {
				//获证时间
				Date time = cert.getTime();
				//证书名称
				String name = cert.getName();
				
				AnalysisResult  result = new AnalysisResult();
				Map<String,Object> info = new HashMap<String,Object>();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				info.put("time", format.format(time));
				info.put("name", name);
				result.setInfo(info);
				 
				for (SendCertificate certs : dataMap) {
					
					String ts = certs.getCertificateTime();
					
					Date t =format.parse(ts);
					
					String na = certs.getName();
					
					if(!compreDate(time, t, "eq")){
						continue;
					}

					if(!name.equals(na)){
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
		resultMap.put("certificate", resultList);
		return resultMap;
	}

	
	
	
	
}
