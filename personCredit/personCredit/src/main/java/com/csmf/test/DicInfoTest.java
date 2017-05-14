package com.csmf.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.csmf.dao.ISeqNoDAO;
import com.csmf.dao.PersonInfoDao;
import com.csmf.dao.SecretKeyDAO;
import com.csmf.service.DictionaryService;
import com.csmf.service.PersonInfoService;
import com.csmf.util.DateUtil;

public class DicInfoTest extends BaseTest{
	@Resource
	DictionaryService service;
	@Resource
	SecretKeyDAO secretKeyDAO;
	@Resource
	PersonInfoService personInfoService;
	@Resource
	private ISeqNoDAO seqNoDAO;
	@Resource
	private PersonInfoDao personInfoDao;
	@Test
	public void queryTest(){
		Map param = new HashMap();
		param.put("id", "123456789");
		param.put("passwd", "123456789");
		param.put("memberId", "123456789");
		secretKeyDAO.updateSecretKey(param);
	}
	/*public static void main(String[] args) {
		String c ="中国c";
		
		System.out.println(c.toUpperCase()); 
		
	}*/
	
	@Test
	public void test100() throws Exception{
		Map result = new HashMap();
		result.put("id", "213");
		result.put("name", "name");
		result.put("gender","F".equals("F")?"女":"男");
		result.put("bornDate", "2017/01/01");
		result.put("workYear", "2016");
		result.put("address", "youhome");
		result.put("email", "hajf@1.com");
		result.put("income", "12");
		result.put("remark", "remark");
		Date createTime = DateUtil.stringToDate(DateUtil.dateToString(new Date()));
		result.put("createTime", createTime);
		result.put("updateTime", createTime);
		result.put("saveFlag", "local");
		result.put("memberId", "memberId");
		result.put("telPhone", "17722848815");
		try{
			personInfoDao.savePersonInfo(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
