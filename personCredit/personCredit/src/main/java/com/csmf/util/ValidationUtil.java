package com.csmf.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 项目名称：personCredit 包名：com.csmf.util 文件名称： ValidationUtil.java 类的描述：对表单数据的正确性校验
 * 创建人：czj 创建时间：2017年4月24日/下午4:59:33
 */
public class ValidationUtil {

	/**
	 * @Title:ValidationUtil
	 * @Description:校验用户注册信息
	 * @param map
	 * @return Map
	 *         :属性status为false则校验不通过，错误信息放在errorMsg属性里面，属性status为true则校验通过，errorMsg为null；
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map validateUser(Map map) {
		Map validateMap = new HashMap();
		Map validateMsg = new HashMap();
		String userPwd = (String) map.get("userPwd");
		String userRePwd = (String) map.get("userRePwd");
		String telPhone = (String) map.get("telPhone");
		boolean validateFlag = true;
		if (userPwd != null && !userPwd.equals("")) {
			if (userPwd.length() < 6 && userPwd.length() > 16) {
				validateMsg.put("userPwd", "密码长度介于6~16");
				validateFlag = false;
			}
		} else {
			validateMsg.put("userRePwd", "密码不能为空");
			validateFlag = false;
		}
		if (userRePwd != null && !userRePwd.equals("")) {
			if (!userRePwd.equals(userPwd)) {
				validateMsg.put("userRePwd", "重复密码与密码不一至");
				validateFlag = false;
			}
		} else {
			validateMsg.put("userRePwd", "重复密码不能为空");
			validateFlag = false;
		}
		if (telPhone != null && !telPhone.equals("")) {
			if (!validateTelPhone(telPhone)) {
				validateMsg.put("telPhone", "手机号不正确");
				validateFlag = false;
			}
		} else {
			validateMsg.put("telPhone", "手机号不能为空");
			validateFlag = false;
		}
		validateMap.put("status", validateFlag);
		validateMap.put("errorMsg", validateMsg);
		return validateMap;

	}

	/*
	 * 校验邮箱
	 */
	public static boolean validateEmail(String email) {
		return Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$").matcher(email).matches();
	}

	/*
	 * 校验手机
	 */
	public static boolean validateTelPhone(String telPhone) {
		return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[^1^4,\\D]))\\d{8}").matcher(telPhone).matches();
	}

	/*
	 * 校验身份证
	 */
	public static boolean validateIdCard(String idCard) {
		return IdCardValidation.isIDCard(idCard);
	}

	/**
	 * @Title: validateImage
	 * @Description: 校验图片的格式，只支持jpg、png、jpeg格式
	 * @param imageName
	 *            图片的全名
	 * @return boolean 返回类型
	 */
	public static boolean validateImage(String imageName) {
		int lastIndex = imageName.lastIndexOf(".");
		String imageFormat = imageName.substring(lastIndex + 1);
		if ("jpg".equals(imageFormat) || "png".equals(imageFormat) || "jpeg".equals(imageFormat)) {
			return true;
		}
		return false;
	}

	/**   
	 * @Title: validateName  
	 * @Description: 校验中文名字，长度为2~4 
	 * @param name  待校验的名字 
	 * @return boolean    返回类型  
	 */ 
	public static boolean validateName(String name) {
		if (name != null && !name.equals("")) {
			if (Pattern.compile("[\u4e00-\u9fa5]{2,4}").matcher(name)
					.matches()) {
				return true;
			}
			return false;
		}
		return false;
	}
}
