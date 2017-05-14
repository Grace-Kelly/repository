package com.csmf.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusCode {
	
	public static String LOGIN_STAUTS = "LOGIN";
	
	public static String LOGIN_FAIL = "0";//登陆失败
	
	public static String LOGIN_SUCCESS = "1";//登陆成功
	
	public static String LOGIN_ERROR = "-1";//登陆异常
	
	public static String MSG = "msg";//返回消息
	public static String STATUS = "status";
	public static String STATUS_OK = "ok";
	public static String STATUS_FAIL = "fail";
	public static String STATUS_RESULT = "result";
	
	public static String JSON_INFO = "info"; //个人基本信息
	
	public static String JSON_EDUCATION="education";//个人教育
	
	public static String JSON_WORK_EXPE="workExpe";//工作经历
	
	public static String JSON_PROJECT_EXPE="projectExpe";//项目经验
	
	public static String JSON_ALL_SKILL="allSkill";//全部技能
	
	public static String JSON_TRAIN="train";//培训
	
	public static String JSON_CERT="cert";//证书
	
	public static String SEND_FABRIC_TRUE="1";//简历已发送给区块链
	
	public static String SEND_FABRIC_FALSE="0";//简历未发送给区块链
	
	public static String CERTIFICATION_FLAG_SUCCESS="1";//认证成功
	
	public static String CERTIFICATION_FLAG_APPROVAL="2";//审批中
	
	public static String CERTIFICATION_FLAG_FAIL="0";//认证失败
	
	public static String CERTIFICATION_FLAG_NO_APPROVAL="3";//未认证
	
	public static String PERSON_RESUME_FLAG="11";//简历完成度，1为基本信息，1为教育，只要有基本信息和教育就可以直接发送区块链

	public static String PERSON_RESUME_FLAG_FALSE="00";//简历完成度，1为基本信息，1为教育

	public static String CERTIFICATION_TYPE_ONE = "1";//身份证
	
	public static String CERTIFICATION_TYPE_TWO = "2";//教育
	
	public static String CERTIFICATION_TYPE_THREE = "0";//其他证书
	
	public static Map<String,String> RESUMETYPE = new HashMap<String, String>();
	
	public static String JOBRESUME="51job";
	public static List<String> RESUMEANALYSIS=new ArrayList<String>();//需要判断的选项
	public static String WORK = "workExAnalysis";
	public static String BASE = "baseAnalysis";
	public static String PROJECT = "projectExAnalysis";
	public static String TRAIN = "trainAnalysis";
	public static String CERT = "certificateAnalysis";
	public static String SKILL = "skillAnalysis";
	public static String EDU = "eduAnalysis";
	
	static{//顺序不能改变，与前端保存这个顺序
		RESUMETYPE.put(JOBRESUME, "jobResume");
		RESUMEANALYSIS.add(BASE);//个人
		RESUMEANALYSIS.add(EDU);//教育
		RESUMEANALYSIS.add(WORK);//工作		
		RESUMEANALYSIS.add(PROJECT);//项目
		RESUMEANALYSIS.add(SKILL);//技能
		RESUMEANALYSIS.add(CERT);//证书
		RESUMEANALYSIS.add(TRAIN);//培训
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
