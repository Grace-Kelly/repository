package com.csmf.dto;

import java.util.Date;

/** 
 * 项目名称：personCredit
 * 包名：com.csmf.dto 
 * 文件名称： RegistrationApproval.java
 * 类的描述：个人信息实名认证POJO       
 * 创建人：czj    
 * 创建时间：2017年4月24日/下午6:42:42
 */  
public class RegistrationApprovalBean {
	/**
	 * 审核id：唯一标识
	 */
	private String id;
	
	/**
	 * 会员Id，个人用户信息唯一标识
	 */
	private String memberId;
	
	/**
	 * 审批状态：00表示未审批，01表示审批通过，02表示审批中。
	 */
	private String status;
	
	/**
	 *数据保存到数据库时间 
	 */
	private Date createTime;
	
	/**
	 *审批时间 
	 */
	private Date processTime;
	
	/**
	 * 实名认证上传图片的保存路径
	 */
	private String filePath;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getProcessTime() {
		return processTime;
	}
	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
