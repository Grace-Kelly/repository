package com.csmf.dto.send;

import java.util.Date;
import java.util.List;


/** 
 * 项目名称：personCredit
 * 包名：com.csmf.dto.send 
 * 文件名称： SendProject.java
 * 类的描述：简历的项目模块发送给区块链的POJO      
 * 创建时间：2017年5月2日/下午2:07:24
 */  
public class SendProject {

	/**
	 * 开始时间
	 */
	private String projectBeginTime;
	/**
	 * 结束时间
	 */
	private String projectEndTime;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 项目描述
	 */
	private String projectDescription;
	/**
	 * 负责项目模块信息
	 */
	private String responsibility;
	/**
	 * 技能id
	 */
	private List<SendKill> skillId;
	/**
	 * 工作经验id
	 */
	private String workId;
	
	/**
	 * 项目名称
	 */
	private String projectName;
	
	/**
	 * 唯一标识
	 */
	private String id;
	
	public String getProjectBeginTime() {
		return projectBeginTime;
	}
	public void setProjectBeginTime(String projectBeginTime) {
		this.projectBeginTime = projectBeginTime;
	}
	public String getProjectEndTime() {
		return projectEndTime;
	}
	public void setProjectEndTime(String projectEndTime) {
		this.projectEndTime = projectEndTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public List<SendKill> getSkillId() {
		return skillId;
	}
	public void setSkillId(List<SendKill> skillId) {
		this.skillId = skillId;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
