package com.csmf.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Resume {

	
	private String name;//姓名
	private Date birthday;//出生日期 yyyy/MM
	private String origin;
	private String tel;
	private String sex;
	private String email;
	private String highestEducation;
	private String highestSchool;
	private String credentials;
	private Integer workYear;
	private List<EduExperience> eduEx = new ArrayList<EduExperience>();
	private List<WorkExperience> workEx = new ArrayList<WorkExperience>();
	private List<ProjectExperience> projectEx = new ArrayList<ProjectExperience>();
	private List<Certificate> certificate = new ArrayList<Certificate>();
	private List<LanguageSkill> languageSkill = new ArrayList<LanguageSkill>();
	private List<TrainExperience> trainExperience = new ArrayList<TrainExperience>();
	
	
	
	public Integer getWorkYear() {
		return workYear;
	}
	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	public List<TrainExperience> getTrainExperience() {
		return trainExperience;
	}
	public void setTrainExperience(List<TrainExperience> trainExperience) {
		this.trainExperience = trainExperience;
	}
	public List<LanguageSkill> getLanguageSkill() {
		return languageSkill;
	}
	public void setLanguageSkill(List<LanguageSkill> languageSkill) {
		this.languageSkill = languageSkill;
	}
	public List<Certificate> getCertificate() {
		return certificate;
	}
	public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}
	public List<ProjectExperience> getProjectEx() {
		return projectEx;
	}
	public void setProjectEx(List<ProjectExperience> projectEx) {
		this.projectEx = projectEx;
	}
	
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getHighestSchool() {
		return highestSchool;
	}
	public void setHighestSchool(String highestSchool) {
		this.highestSchool = highestSchool;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public List<EduExperience> getEduEx() {
		return eduEx;
	}
	public void setEduEx(List<EduExperience> eduEx) {
		this.eduEx = eduEx;
	}
	public List<WorkExperience> getWorkEx() {
		return workEx;
	}
	public void setWorkEx(List<WorkExperience> workEx) {
		this.workEx = workEx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
