package com.csmf.resume;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.csmf.dto.Certificate;
import com.csmf.dto.EduExperience;
import com.csmf.dto.LanguageSkill;
import com.csmf.dto.ProjectExperience;
import com.csmf.dto.Resume;
import com.csmf.dto.TrainExperience;
import com.csmf.dto.WorkExperience;
import com.csmf.util.Mht2HtmlUtil;
/**
 * 51job简历模版
 * @author pact
 *
 */
@Component("jobResume")
public class JobResume implements ResumeBase{
	
	private Log log = LogFactory.getLog(this.getClass());
	
	
	public Resume parseDoc(InputStream in) {
		
		Resume resume = new Resume();
		
		try {
			String html=Mht2HtmlUtil.mht2html(in);
			
			if(!"".equals(html)){
				
				Document doc = Jsoup.parse(new String(html.getBytes(), "utf-8"));
				
				resume = queryResumeAttr(doc);
				
			}
		} catch (Exception e) {
			log.error("解析简历异常", e);
		}
		
		return resume;
		
	}
	
	
	private Resume queryResumeAttr(Document doc){
		
		Resume resume=getBaseInfo(doc);
		
		
		
		Elements elements = doc.select("table").get(0).select("tbody").first().select("tr").first().select("td").get(0).children();
		
		for (Element element : elements) {
			
			if(!element.tagName().equals("table")){
				continue;
			}
			 Element tr = element.select("tr").get(0);
			
			 if(tr==null){
				 continue;
			 }
			 
			Element td = tr.select("td").get(0);
			 
			if(td==null){
				continue;
			}
			
			 String tname = td.text();
			 
			 if("工作经验".equals(tname)){
				 resume.setWorkEx(getWorkEx(element));
			 }else if("项目经验".equals(tname)){
				 resume.setProjectEx(getProjectEx(element));
			 }else if("教育经历".equals(tname)){
				 resume.setEduEx(getEduEx(element));
			 }else if(tname.contains("技能特长")){
//				 Elements skills = doc.select("td.tit");
				 Elements skills = element.select("table");
				 for (Element skill : skills) {
					 if(skill==element){
						 continue;
					 }
					 String skillName = skill.select("tr").get(0).select("td").get(0).text();
					  if ("技能/语言".equals(skillName)){
						  resume.setLanguageSkill(getLanguageSkill(skill));
					  }else if("证书".equals(skillName)){
						  resume.setCertificate(getCertificate(skill));
					  }else if("培训经历".equals(skillName)){
						  resume.setTrainExperience(getTrainInfo(skill));
					  }
				}
			 }else if("个人信息".equals(tname)){
				 resume.setOrigin(getDomicile(element));
			 }
			
		}
		return resume;
	}
	
	
	
	private String getDomicile(Element el){
		
		String domicile=el.select("table").get(1).select("td").get(2).text();
		
		return domicile;
	}
	
	private Resume getBaseInfo(Document doc){
		
		Resume resume = new Resume();
		
		String sex = null;
		String birthday = null;
		String credentials = null;
		String school = null;
		String highestEducation =null;
		Integer workYear = null;
		String name=doc.select("table").get(2).select("tr").get(0).select("td").get(0).text();
		System.out.println(name);
		//String name=doc.getElementsByClass("name").last().text();
		
		Element table =doc.select("table").get(1);
		
		String tel =doc.select("table").get(2).select("tr").get(1).select("td").get(1).text();
		
		String email =doc.select("table").get(3).select("tr").text();
		
		String info = doc.select("table").get(2).select("tr").get(3).select("p").get(0).text();
		
		//Elements recently = doc.select("td.plate2");
		
		Element firsttable = doc.select("table").get(1);//首个table
		
		Element tab = firsttable.nextElementSibling();
		if(tab!=null){
			if(!tab.tagName().equals("table")){
				tab = tab.nextElementSibling();
			}
			if(!tab.select("td").first().text().equals("个人信息")){			
			Elements recently = tab.select("table").get(0).select("table");
			for (Element element : recently) {
				String textName=element.select("tr").get(1).select("td").get(0).text();
				if("最高学历/学位".equals(textName)){
					credentials = element.select("tr").get(2).select("td").get(1).text();
					school = element.select("tr").get(3).select("td").get(1).text();
					highestEducation = element.select("tr").get(4).select("td").get(1).text();
					
				}
				
			}
		}
		}
//		for (Element element : recently) {
//			
//			String textName=element.text();
//			if("最高学历/学位".equals(textName)){
//				Element tr = element.parent();
//				credentials = tr.nextElementSibling().select("td").get(1).text();
//				school = tr.nextElementSibling().nextElementSibling().select("td").get(1).text();
//				highestEducation = tr.nextElementSibling().nextElementSibling().nextElementSibling().select("td").get(1).text();
//				
//			}
//			
//		}
		
		if(!"".equals(info) && info!=null){
			 birthday = info.substring(info.indexOf("(")+1,info.lastIndexOf(")"));
			 sex = info.substring(0,info.indexOf("|"));
			 String str = info.substring(info.lastIndexOf("|")+1,info.length());
			 String regEx="[^0-9]";
			 Pattern p = Pattern.compile(regEx);   
			 Matcher m = p.matcher(str);
			 String year = m.replaceAll("").trim();
			 workYear = Integer.parseInt(year);
		}
		
		resume.setWorkYear(workYear);
		resume.setEmail(email);
		resume.setTel(tel);
		resume.setName(name);
		resume.setSex(sex);
		resume.setBirthday(stringToDate(birthday,"yyyy/MM"));
		resume.setHighestSchool(school);
		resume.setHighestEducation(highestEducation);
		resume.setCredentials(credentials);
		
		return resume;
	}
	
	private Date stringToDate(String date,String format){
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date d = null;
		
		try {
			if("至今".equals(date)){
				date = f.format(new Date());
			}
			d =f.parse(date);
		} catch (ParseException e) {
			
			log.error("日期格式转换异常",e);
		}
		return d;
	}
	
	private List<TrainExperience> getTrainInfo(Element el){
		
		List<TrainExperience> list = new ArrayList<TrainExperience>();
		
//		Element parent = el.parent();
//		Element tbody = parent.parent();
		Element tbody = el.select("tbody").first();
		Elements trans = tbody.children();
		
		for (Element tran : trans) {
			

			if(!tran.select("table").isEmpty()){
				TrainExperience experience = new TrainExperience();
				//String tranInfo = tran.select("table").get(0).select("strong").text();
				Elements st =  tran.select("table").get(0).select("strong");
				String tranInfo = null;
				if(st.size()==0){
					tranInfo = tran.select("table").get(0).select("b").get(0).text();
				}else{
					tranInfo = tran.select("table").get(0).select("strong").get(0).text();
				}
				String address = tran.select("table").get(1).select("table").get(2).select("td").get(1).text();
				String time = tran.select("table").get(0).select("td").get(0).text();
				String institutions = tran.select("table").get(1).select("table").get(1).select("td").get(1).text();
				
				List<String> times = timeString(time, "--");
				
				experience.setStartTime(stringToDate(times.get(0),"yyyy/MM"));
				experience.setEndTime(stringToDate(times.get(1),"yyyy/MM"));
				experience.setTranName(tranInfo);
				experience.setInstitutions(institutions);
				experience.setAddress(address);
				list.add(experience);
			}
		}
		
		return list;
	}
	
	private List<Certificate> getCertificate(Element el){
		
		List<Certificate> list =new ArrayList<Certificate>();
		
//		Element parent = el.parent();
//		Element tbody = parent.parent();
		Element tbody = el.select("tbody").first();
		Elements cers = tbody.children();
		for (Element skill : cers) {
			
//			Certificate certificate =new Certificate();
//			String time = skill.select("td").get(0).text();
//			Elements st =  skill.select("strong");
//			String names = null;
//			if(st.size()==0){
//				 names = skill.select("b").get(0).text();
//			}else{
//				 names = skill.select("strong").get(0).text();
//			}
//    		System.out.println(time+","+names);
//    		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");	    		
//    		certificate.setName(names);
//    		try {
//				certificate.setTime(format.parse(time));
//			} catch (ParseException e) {
//				log.error("解析日期格式异常"+time,e);
//			}
//    		list.add(certificate);
			
			
	    	if(!skill.select("table").isEmpty()){
	    		Certificate certificate =new Certificate();
	    		
	    		String time = skill.select("table").get(0).select("td").get(0).text();	    		
				Elements st =  skill.select("table").get(0).select("strong");
				String names = null;
				if(st.size()==0){
					 names = skill.select("table").get(0).select("b").get(0).text();
				}else{
					 names = skill.select("table").get(0).select("strong").get(0).text();
				}
	    		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");	    		
	    		certificate.setName(names);
	    		try {
					certificate.setTime(format.parse(time));
				} catch (ParseException e) {
					log.error("解析日期格式异常"+time,e);
				}
	    		list.add(certificate);
	    		System.out.println(time+","+names);
	    	}
		}
		return list;
	}
	
	private List<EduExperience> getEduEx(Element el){
		
		List<EduExperience> edulist = new ArrayList<EduExperience>();
		
		
//		Element parent = el.parent();
//		Element tr = parent.nextElementSibling();
		
		Element eduEl = el.select("table").get(1).select("tbody").first();
		
		Elements edus = eduEl.children();
		
		for (Element element : edus) {
			
			EduExperience experience = new EduExperience();
			String schoolName =element.select("table").get(0).select("td").get(1).text();
			String edtime =element.select("table").get(0).select("td").get(0).text();
			String education = element.select("table").get(0).select("tr").get(1).text();//学历
			
			List<String> str = codeString(education,"|");
			
			List<String> times = timeString(edtime,"-");
			experience.setStartTime(stringToDate(times.get(0),"yyyy/MM"));
			experience.setEndTime(stringToDate(times.get(1),"yyyy/MM"));
			experience.setSchoolName(schoolName);
			experience.setEducation(str.get(0));
			experience.setMajor(str.get(1));
			edulist.add(experience);
			
		}
		return edulist;
	}
	
	private List<ProjectExperience> getProjectEx(Element el){
		
		List<ProjectExperience> projectList = new ArrayList<ProjectExperience>();
		
		
//		Element parent = el.parent();
//		Element tr = parent.nextElementSibling();
		Element projectEl = el.select("table").get(1).select("tbody").first();
		
		Elements projects = projectEl.children();
		
		for (Element element : projects) {
			
			ProjectExperience experience = new ProjectExperience();
			
			String pName =element.select("table").get(0).select("td").get(1).text();
			String pTime =element.select("table").get(0).select("td").get(0).text();
			String pdes =element.select("table").get(1).select("td").get(1).text();
			String zrdes =element.select("table").get(2).select("td").get(1).text();
			
			
			List<String> times = timeString(pTime,"-");
			
			experience.setStartTime(stringToDate(times.get(0),"yyyy/MM"));
			experience.setEndTime(stringToDate(times.get(1),"yyyy/MM"));
			experience.setProjectName(pName);
			experience.setProjectDes(pdes);
			experience.setWorkDes(zrdes);
			projectList.add(experience);
			
		}
		return projectList;
	}
	
	
	private List<LanguageSkill> getLanguageSkill(Element el){
		
		List<LanguageSkill> list = new ArrayList<LanguageSkill>();
		
//		Element tr = el.parent().nextElementSibling();
		
		Element skillEl=el.select("table").get(1).select("tbody").first();
		
		Elements skills = skillEl.children();
		
		for (Element skill : skills) {
			
			Elements tbs=skill.children();

			for (Element tb : tbs) {
				
				LanguageSkill languageSkill = new LanguageSkill();
				String langue = null;
				Elements els = tb.select("table").get(0).select("strong");
				if(els.size()==0){
					langue = tb.select("table").get(0).select("b").text();
				}else{
					langue = tb.select("table").get(0).select("strong").text();
				}
				 
				String level = tb.select("table").get(0).select("span").get(1).text();
				System.out.println(langue+","+level);
				languageSkill.setLevel(level);
				languageSkill.setSkillName(langue);
				
				list.add(languageSkill);
			
			}
		}
		return list;
	}
	
	
	public List<String> codeString(String str,String reg) {
		
		List<String> list = new ArrayList<String>();
		
		String st = str.substring(0, str.indexOf(reg));
		String st1 = str.substring(str.indexOf(reg)+1,str.length());
		list.add(st);
		list.add(st1);
		return list;
	}
	
	
	public List<String> timeString(String str,String reg) {
		
		String[] times = str.split(reg);
		
		
		List<String> arr = Arrays.asList(times);
				
		for (String string : arr) {
			if(string.equals("至今")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
				string = format.format(new Date());
			}
		}
		
		return arr;
	}
	
	private List<WorkExperience> getWorkEx(Element el){
		
		List<WorkExperience> workList = new ArrayList<WorkExperience>();
		
//		Element parent = el.parent();
//		
//		Element tr = parent.nextElementSibling();
		
		Element workEl = el.select("table").get(1).select("tbody").first();
		
		Elements works = workEl.children();
		
		for (Element element : works) {
			
			String workTime = element.select("table").get(0).select("td").get(0).text();
			Elements els = element.select("table").get(0).select("strong");
			String position = null;
			if(els.size()==0){
				 position = element.select("table").get(0).select("b").get(0).text();
			}else{
				 position = element.select("table").get(0).select("strong").get(0).text();
			}		
			String companyName = element.select("table").get(0).select("span").get(2).text();
			String depName = element.select("table").get(0).select("td").get(1).select("span").get(1).text();//部门名称
			String workdes = element.select("table").get(0).select("tr").get(3).select("table").get(0).select("td").get(1).text();//工作描述
			WorkExperience workExperience = new WorkExperience();
			
			List<String> times = timeString(workTime,"-");
			workExperience.setStartTime(stringToDate(times.get(0),"yyyy/MM"));
			workExperience.setEndTime(stringToDate(times.get(1),"yyyy/MM"));
			workExperience.setPosition(position);
			workExperience.setCompanyName(companyName);
			workExperience.setDepName(depName);
			workExperience.setWorkdesp(workdes);
			workList.add(workExperience);
		}
		return workList;
	}
	
	
	

}
