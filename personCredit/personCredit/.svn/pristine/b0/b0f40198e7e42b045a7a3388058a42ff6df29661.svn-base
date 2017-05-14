package com.csmf.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csmf.common.Encryption;
import com.csmf.common.StatusCode;
import com.csmf.dao.ISeqNoDAO;
import com.csmf.service.UserRegisterService;
import com.csmf.util.DateUtil;
import com.csmf.util.RequestJsonFormat;
import com.csmf.util.ValidationUtil;

import net.sf.json.JSONObject;

@Controller
public class RegisterController {

	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private UserRegisterService registerService;

	@Resource
	private ISeqNoDAO seqNoDAO;
	/**
	 * @Title:用户注册
	 * @Description:用户注册账号控制器
	 * @param request
	 *            请求信息
	 * @param response
	 *            返回信息
	 * @return void ：无返回类型
	 */
	@RequestMapping("/registerUser.do")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void registerUser(HttpServletRequest request, HttpServletResponse response) {
		Map result = new HashMap();
		Map param = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String codeValue = (String) request.getSession().getAttribute("codeValue");
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject != null ){//&& codeValue != null) {
				/*if (jsonObject.has("codeValue")) {
					if (!codeValue.equals(jsonObject.getString("codeValue"))) {
						result.put("status", false);
						result.put("errorMsg", "验证码错误，请重新输入！");
						JSONObject obj = JSONObject.fromObject(result);
						out.write(obj.toString());
						return;
					}
				}*/
				if (jsonObject.has("telPhone") && jsonObject.has("userPwd") && jsonObject.has("userRePwd")
						&& jsonObject.has("telPhone")) {
					param.put("telPhone", jsonObject.getString("telPhone"));
					param.put("userPwd", jsonObject.getString("userPwd"));
					param.put("userRePwd", jsonObject.getString("userRePwd"));
				} else {
					result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					result.put(StatusCode.MSG, "请完善资料后进行注册！");
					JSONObject obj = JSONObject.fromObject(result);
					out.write(obj.toString());
					return;
				}
				// 校验各字段规则
				Map validateMap = ValidationUtil.validateUser(param);
				if (!(Boolean)validateMap.get("status")) {
					result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
					result.put(StatusCode.MSG, (Map) validateMap.get("errorMsg"));
					JSONObject obj = JSONObject.fromObject(result);
					out.write(obj.toString());
					return;
				}
			}
			Map userMap = new HashMap();
			userMap.put("telPhone", jsonObject.getString("telPhone"));
			boolean flag = registerService.isExistUserByPhone(userMap);
			if (flag) {
				result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				result.put(StatusCode.MSG, "用户已存在，请重新输入！");
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
			//MD5加密
			String encrypPwd =  Encryption.MD5Encrypt(jsonObject.getString("userPwd"));
			param.put("password", encrypPwd);
			//获取序列号
			param.put("memberId", seqNoDAO.getFlwNo("PS","M"));
			//注册默认为未认证
			param.put("memberStatus",StatusCode.CERTIFICATION_FLAG_NO_APPROVAL);//未认证
			param.put("memberType","0");//个人
			param.put("telPhone",jsonObject.getString("telPhone"));
			Date createTime=DateUtil.stringToDate(DateUtil.dateToString(new Date()));
			param.put("createTime", createTime);
			param.put("updateTime",createTime);
			param.put("sendFlag", StatusCode.SEND_FABRIC_FALSE);
			param.put("finishFlag",StatusCode.PERSON_RESUME_FLAG_FALSE);
			param.put("remark", "remark");
			registerService.saveUser(param);
			result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
			result.put(StatusCode.MSG,"注册成功");
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(result, out, e, "注册失败，请重新再试！");
		}
	}

	/**
	 * 自动登录
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/checkCookieAndSession.do")
	public void checkCookieAndSession(HttpServletRequest request, HttpServletResponse response) {
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Cookie[] cookies = request.getCookies();
			HttpSession session = request.getSession();

			if (cookies != null) {
				// 检测客户端cookie是否有登录数据
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("telPhone")) {
						// 匹配cookie的数据和session中的数据是否一致
						if (cookie.getValue().equals(session.getAttribute("telPhone"))) {
							result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
							result.put("telPhone", cookie.getValue());
							session.setAttribute("telPhone", cookie.getValue());
							JSONObject obj = JSONObject.fromObject(result);
							out.write(obj.toString());
							return;

						}

					}
				}
			}
			result.put("status", false);
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}

	/**
	 * @Title:RegisterController
	 * @Description:登录
	 * @param request
	 * @param response
	 * @return void
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/loginUser.do")
	public void loginUser(HttpServletRequest request, HttpServletResponse response) {
		Map result = new HashMap();
		Map param = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String telPhone = null;
			String userPwd = null;
			JSONObject jsonObject = RequestJsonFormat.toJsonObject(request);
			if (jsonObject.has("telPhone") && jsonObject.has("userPwd")) {
				telPhone=jsonObject.getString("telPhone");
				userPwd=jsonObject.getString("userPwd");
				param.put("telPhone", telPhone);
				param.put("userPwd", userPwd);
			} else {
				result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				result.put(StatusCode.MSG, "账号和密码不能为空！");
				JSONObject obj = JSONObject.fromObject(result);
				out.write(obj.toString());
				return;
			}
			
			// result = fabricService.loginUser(param);
			result = new HashMap();
			if (registerService.checkPwd(telPhone, userPwd , param)) {
				String autoLoginFlag ="N"; //jsonObject.getString("autoLoginFlag");
				// String autoLoginFlag = "Y";
				HttpSession session = request.getSession();
				if ("Y".equals(autoLoginFlag)) {
					// 设置cookie
					Cookie cookie = new Cookie("telPhone", jsonObject.getString("telPhone"));// 存入会员telPhone到cookie
					cookie.setMaxAge(60 * 24 * 3600); // 设置cookie失效时间 单位秒
					cookie.setPath("/");
					response.addCookie(cookie);
					// 将sessionid存入cookie
					Cookie cookie2 = new Cookie("JSESSIONID", session.getId());
					cookie2.setMaxAge(60 * 24 * 3600); // 设置cookie失效时间 单位秒
					cookie2.setPath("/");
					response.addCookie(cookie2);
					// 设置session
					session.setAttribute("telPhone", jsonObject.getString("telPhone"));
					session.setAttribute("memberId", (String)param.get("memberId"));
					session.setMaxInactiveInterval(60 * 24 * 3600);
				} else {
					Cookie cookie = new Cookie("telPhone", jsonObject.getString("telPhone"));// 存入会员telPhone到cookie
					cookie.setMaxAge(3600); // 设置cookie失效时间 单位秒
					cookie.setPath("/");
					response.addCookie(cookie);
					session.setAttribute("telPhone", jsonObject.getString("telPhone"));
					session.setAttribute("memberId", (String)param.get("memberId"));
					session.setMaxInactiveInterval(3600);
				}
				result.put(StatusCode.STATUS, StatusCode.STATUS_OK);
				result.put(StatusCode.STATUS_RESULT, (String)param.get("memberStatus"));
				result.put(StatusCode.MSG, "登录成功");
				log.info("登录成功："+session.getAttribute("telPhone")+","+session.getAttribute("memberId"));
			} else {
				result.put(StatusCode.STATUS, StatusCode.STATUS_FAIL);
				result.put(StatusCode.MSG, "账号或密码错误！");
			}
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/loginOut.do")
	public void loginOut(HttpServletRequest request, HttpServletResponse response) {
		Map result = new HashMap();
		PrintWriter out = null;
		try {
			out = response.getWriter();

			HttpSession session = request.getSession();
			// 清除cookies
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getValue().equals(session.getAttribute("userId"))) {
						cookie.setValue(null);
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
					/*
					 * if(cookie.getValue().equals(session.getAttribute(
					 * "JSESSIONID"))){ cookie.setValue(null);
					 * cookie.setMaxAge(0); cookie.setPath("/");
					 * response.addCookie(cookie); }
					 */
				}
			}
			// 清除session
			session.invalidate();
			/*
			 * Enumeration em = session.getAttributeNames(); while
			 * (em.hasMoreElements()) {
			 * request.getSession().removeAttribute(em.nextElement().toString())
			 * ; }
			 */

			result.put("status", true);
			JSONObject obj = JSONObject.fromObject(result);
			out.write(obj.toString());
		} catch (Exception e) {
			catchException(result, out, e, "操作失败，请重新再试！");
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/generateCode.do")
	public void generateCodeImage(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		Map resultMap = new HashMap();
		// 在内存中创建一副图片
		int w = 120;
		int h = 50;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			// 在图片上画一个矩形当背景
			Graphics g = img.getGraphics();
			g.setColor(new Color(r(50, 250), r(50, 250), r(50, 250)));
			g.fillRect(0, 0, w, h);

			String str = "aqzxswedcimnofrvgtbhyujklp1234567890";
			String codeValue = "";
			for (int i = 0; i < 4; i++) {
				g.setColor(new Color(r(50, 180), r(50, 180), r(50, 180)));
				g.setFont(new Font("黑体", Font.PLAIN, 40));
				char c = str.charAt(r(0, str.length()));
				codeValue += String.valueOf(c);
				g.drawString(String.valueOf(c), 10 + i * 30, r(h - 30, h));
			}

			// 画随机线
			for (int i = 0; i < 2; i++) {
				g.setColor(new Color(r(50, 180), r(50, 180), r(50, 180)));
				g.drawLine(r(0, w), r(0, h), r(0, w), r(0, h));
			}
			// 把内存中创建的图像输出到文件中
			String realPath = request.getSession().getServletContext().getRealPath("codeImage");
			String childPath = realPath.substring(realPath.lastIndexOf("\\")+1);
			String filePath = "/"+ (new Date()).getTime() + ".png";
			File file = new File(realPath+filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			ImageIO.write(img, "png", file);

			HttpSession session = request.getSession();
			session.removeAttribute("codeValue");
			session.setAttribute("codeValue", codeValue);
			String resutlPath = childPath+filePath;
			resultMap.put("status",true);
			resultMap.put("filePath",resutlPath);
			JSONObject obj = JSONObject.fromObject(resultMap);
			out.write(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int r(int min, int max) {
		Random random = new Random();
		int num = 0;
		num = random.nextInt(max - min) + min;
		return num;
	}

	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	private void catchException(Map result, PrintWriter out, Exception e, String message) {
		log.error("异常错误信息：" + e);
		e.printStackTrace();
		result.put(StatusCode.STATUS,StatusCode.STATUS_FAIL);
		result.put(StatusCode.MSG, message);
		JSONObject obj = JSONObject.fromObject(result);
		out.write(obj.toString());
	}
}
