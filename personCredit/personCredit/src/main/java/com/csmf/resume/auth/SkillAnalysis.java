package com.csmf.resume.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.csmf.common.StatusCode;
import com.csmf.dto.AnalysisResult;
import com.csmf.dto.LanguageSkill;
import com.csmf.dto.Resume;
import com.csmf.dto.send.SendAllSkills;
import com.csmf.service.DictionaryService;

@Component("skillAnalysis")
public class SkillAnalysis extends Analysis {

	@Resource
	DictionaryService dictionaryService;
	
	@Override
	public Map<String, Object> analysis(Resume resume, Map<String, Object> detail) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<AnalysisResult> resultList = new ArrayList<AnalysisResult>();
		if(detail.get(StatusCode.JSON_ALL_SKILL)!=null){
		//技能
		List<LanguageSkill> list = resume.getLanguageSkill();
		
		List<SendAllSkills> dataMap = (List<SendAllSkills>) detail.get(StatusCode.JSON_ALL_SKILL);
		
		if(list!=null){
			
			for (LanguageSkill languageSkill : list) {
				 
				//技能名称
				String skillName = languageSkill.getSkillName();
				//熟练度
				String level = languageSkill.getLevel();
				AnalysisResult result = new AnalysisResult();
				Map<String,Object> info = new HashMap<String,Object>();
				info.put("skillName", skillName);
				info.put("level", level);
				result.setInfo(info);
				
				for (SendAllSkills skill : dataMap) {
					
					Map<String,Object> param = new HashMap<String, Object>();
					
					param.put("id", skill.getSkillNum());
					
					Map<String, Object> skillMap=new HashMap<String,Object>();
					try {
						skillMap = dictionaryService.selectSkillInfoByNameOrId(param);
					} catch (Exception e) {
						e.printStackTrace();
					}
					String name = skill.getSkillNum();
					if(skillMap!=null){
						name = (String) skillMap.get("skillName");
					}
					String lev = skill.getProficiency();
					
					if(!skillName.toUpperCase().equals(name)){
						continue;
					}
					
					if(!level.equals(lev)){
						continue;
					}
					
					result.setResult(true);
					
					
				}
				resultList.add(result);
				result.setAuthNumPass(0);
	  			result.setAuthNumFail(0);
	  			result.setComAuthFail(0);
	  			result.setAuthNumPass(0);
			}
			
			
		}
		}
		resultMap.put("skills", resultList);	
		return resultMap;
	}

	
	
	
	
}
