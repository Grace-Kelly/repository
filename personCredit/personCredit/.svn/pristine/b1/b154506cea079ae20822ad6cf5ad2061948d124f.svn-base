
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csmf.common.StatusCode;
import com.csmf.dto.send.SendAllSkills;
import com.csmf.dto.send.SendCertificate;
import com.csmf.dto.send.SendEducation;
import com.csmf.dto.send.SendKill;
import com.csmf.dto.send.SendPersonInfo;
import com.csmf.dto.send.SendProject;
import com.csmf.dto.send.SendTrain;
import com.csmf.dto.send.SendWork;
import com.csmf.service.impl.FabricServiceImpl;
import com.csmf.util.Base64;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class Test {
	public static void main(String[] args) {
		SendPersonInfo personInfo = new SendPersonInfo();
		personInfo.setName("czj");
		personInfo.setIdentityNum("350322199301161154");
		personInfo.setBornDate("1993/01/16");
		personInfo.setOrigin("001");
		personInfo.setGender("M");
		personInfo.setHighestEducation("9863");
		personInfo.setPolitical("5001");
		personInfo.setNation("00");
		personInfo.setMarry("F");
		
		
		List<SendWork> works = new ArrayList<SendWork>();
		SendWork work = new SendWork();
		work.setDimissionTime("2017/02/02");
		work.setEntryTime("2017/02/02");
		work.setCompanName("companyName");
		work.setPosition("position");
		work.setTrade("trade");
		work.setWorkDescription(("workDescription"));
		work.setDepartment("department");
		works.add(work);
		
		work.setDimissionTime("2017/02/02");
		work.setEntryTime("2017/02/02");
		work.setCompanName("company");
		work.setPosition("posit");
		work.setTrade("trade");
		work.setWorkDescription(("Description"));
		work.setDepartment("");
		works.add(work);
		
		List<SendProject> projects = new ArrayList<SendProject>();
		SendProject project = new SendProject();
		project.setProjectName("Test");
		project.setProjectBeginTime("2017/02/02");
		project.setProjectEndTime("2017/02/02");
		project.setProjectDescription("projectDescription");
		project.setCompanyName("companyName");
		project.setResponsibility("responsibility");
		List<SendKill> skillList = new ArrayList<SendKill>();
		for(int i=199;i<204;i++){
			SendKill skill = new SendKill();
			skill.setSkillDataNum("skill"+i);
			skill.setSkillDataType("type"+i);
			skillList.add(skill);
		}
		project.setSkillId(skillList);
		project.setWorkId("workId");
		projects.add(project);
		projects.add(project);
		
		// 查询教育并封装成bean
		List<SendEducation> educations = new ArrayList<SendEducation>();
		SendEducation education = new SendEducation();
		education.setAdmissionTime("2017/02/02");
		education.setCredentials("credentials");
		education.setEducationBackground("educationBackground");
		education.setGraduationTime("2017/02/02");
		education.setMajor("major");
		education.setSchoolName("schoolName");
		education.setStatus("T");
		educations.add(education);
		
		List<SendTrain> trains = new ArrayList<SendTrain>();
		SendTrain train = new SendTrain();
		train.setCompanName("companName");
		train.setStartTime("2017/02/02");
		train.setEndTime("2017/02/02");
		train.setTrainingDescription("trainingDescription");
		train.setTrainingName("trainingName");
		trains.add(train);
		
		
		List<SendCertificate> certs = new ArrayList<SendCertificate>();
		SendCertificate cert = new SendCertificate();
		cert.setCertificateTime("2017/02/02");
		cert.setCertificateType("certificateType");
		cert.setName("name");
		certs.add(cert);
		
		List<SendAllSkills> skills = new ArrayList<SendAllSkills>();
		SendAllSkills skill = new SendAllSkills();
		skill.setProficiency("proficiency");
		skill.setSkillNum("skillNum");
		skill.setSkillType("skillType");
		skills.add(skill);
		
		Map map = new HashMap();
		map.put(StatusCode.JSON_INFO, personInfo);
		map.put(StatusCode.JSON_EDUCATION, educations);
		map.put(StatusCode.JSON_WORK_EXPE, works);
		map.put(StatusCode.JSON_PROJECT_EXPE, projects);
		map.put(StatusCode.JSON_ALL_SKILL, skills);
		map.put(StatusCode.JSON_TRAIN, trains);
		map.put(StatusCode.JSON_CERT, certs);
		
		JSONObject obj = JSONObject.fromObject(map);
		System.out.println(obj.toString());
		
		FabricServiceImpl impl = new FabricServiceImpl();
		Map resultMap = impl.BlockChainToMap(obj.toString());
		JSONObject obj1 = JSONObject.fromObject(resultMap);
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("memberId", "00001");
		Base64.encode(obj1.toString().getBytes());
		param.put("json", obj1.toString());
		System.out.println(obj1.toString());
		
		
	}
}
