package com.csmf.dto;

import java.util.Date;

public class User {
	
	private String memberId;
	private String name;
	private String identityNum;
	private String telPhone;
	private String password;
	private String memberType;
	private String memberStatus;
	private Date createTime;
	private Date updateTime;
	private String email;
	private String companyId;
	private char gender;
	private Date bornDay;
	private Date workDay;
	private String address;
	private char sendFlag;
	private String finishFlag;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityNum() {
		return identityNum;
	}
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getBornDay() {
		return bornDay;
	}
	public void setBornDay(Date bornDay) {
		this.bornDay = bornDay;
	}
	public Date getWorkDay() {
		return workDay;
	}
	public void setWorkDay(Date workDay) {
		this.workDay = workDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(char sendFlag) {
		this.sendFlag = sendFlag;
	}
	public String getFinishFlag() {
		return finishFlag;
	}
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}
	
	
}
