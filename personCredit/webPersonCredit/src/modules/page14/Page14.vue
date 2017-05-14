<template>
<div class="pagePersonal">
      <mt-header class='mint-header is-fixed' title="简历辨伪报告" >
        <router-link to="/page20" slot="left">
       <mt-button icon="back"></mt-button>
        </router-link>
         <!--<router-link to="page8" slot="right">
        <mt-button >打印</mt-button>
        </router-link>-->
      </mt-header>
 
    <main >
     <div class="pic-report" style="background-image:url(/dist/static/img/report.png)">
       <div>
        <p>评分估值</p>
        <p>86</p>
        <p>分</p>
       </div>
      
     </div>

         <div class="mui-content bgc0">
           <!--报告信息-->
          <div class="report">
          <div class="report-information">
            <div class="report-title">候选者的基本信息</div>
            <table class="rule-table">
                    <tbody>
                    <tr class="f15">
                        <td class="f14 td-col1">姓名</td>
                        <td class="f14 td-col2" v-text='this.list[0].baseInfo[0].info.name'></td>
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">最高学历</td>
                      <td class="f14 td-col2" v-text="this.list[1].eductionList[0].info.schoolName"></td>
                      
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">最高学位</td>
                          <td class="f14 td-col2" v-text="this.list[1].eductionList[0].info.eduction"></td>
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">工作年限</td>
                        <td class="f14 td-col2" >
                          {{this.workyear}}
                        </td>
                    </tr>
                    </tbody>
           </table>
          </div>
<!--报告详情信息-->
<div>
   <div class="report-title">报告的审核信息</div>

   <!--个人信息核实-->  
   <div class="report-details" >
           <div class="report-title"> <span>个人信息核实</span> 
           <i v-if="personalExperience" class="fr iconfont icon-down" @click='personalExperience=false'> </i>
<i v-if="!personalExperience" class="fr iconfont icon-up" @click='personalExperience=true'> </i>
           </div>
<p class="results"  v-if="personalExperience">
    <span class="interval" v-if="this.list[0].baseInfo[0].result"><i class=" mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!this.list[0].baseInfo[0].result"><i class=" mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="!(this.list[0].baseInfo[0].comAutnPass==null)"   v-text=""><i class=""></i>{{this.list[0].baseInfo[0].comAutnPass}}人加证</span>
   <span class="interval  " v-if="!(this.list[0].baseInfo[0].comAutnPass==null)"><i class=""></i>{{this.list[0].baseInfo[0].authNumPass}}人加证</span>
  
</p>



            <table class="rule-table"  v-if="personalExperience"
>
       
                    <tbody>
                    <tr class="f15">
                        <td class="f14 td-col1">姓名</td>
                        <td class="f14 td-col2">{{this.list[0].baseInfo[0].info.name}}</td>
                     
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">性别</td>
                        <td class="f14 td-col2">{{this.list[0].baseInfo[0].info.sex}}</td>
                    
                      
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">出生日期</td>
                          <td class="f14 td-col2">{{this.list[0].baseInfo[0].info.Birthday}}</td>
                      
                    </tr>
                      <tr class="f15">
                        <td class="f14 td-col1">户口国籍</td>
                          <td class="f14 td-col2">{{this.list[0].baseInfo[0].info.origin}}</td>
                      
                    </tr>
                   
                    </tbody>
           </table>
          </div>


<!--学位信息-->
  <div class="report-details" v-for="item in this.list[1].eductionList">
  <div class="report-title"> <span>学历信息核实</span> 
           <i v-if="eductionList" class="fr iconfont icon-xiangxia" @click='eductionList=false'> </i>
<i v-if="!eductionList" class="fr iconfont icon-up" @click='eductionList=true'> </i>
           </div>
 <p class="results"  v-if="eductionList">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>
            <table class="rule-table"  v-if="eductionList"
>
                   <tbody>
                    <tr class="f15">
                        <td class="f14 td-col1">最高学历：</td>
                        <td class="f14 td-col2">{{item.info.eduction}}</td>
                    
                      
                    </tr>
                     <tr class="f15">
                        <td class="f14 td-col1">所学专业：</td>
                        <td class="f14 td-col2">{{item.info.mojor}}</td>
                    
                      
                    </tr>
                      <tr class="f15">
                        <td class="f14 td-col1">学校名称：</td>
                        <td class="f14 td-col2">{{item.info.schoolName}}</td>
                     
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">在校时间</td>
                          <td class="f14 td-col2">{{item.info.time}}</td>
                      
                    </tr>
                    </tbody>
           </table>
          </div>

  
 <!--工作经验信息核实-->  
  <div class="report-details" v-for="item in this.list[2].workList">
  <div class="report-title"> <span>工作经验信息核实</span> 
           <i v-if="workList" class="fr iconfont icon-xiangxia" @click='workList=false'> </i>
<i v-if="!workList" class="fr iconfont icon-up" @click='workList=true'> </i>
           </div>
 <p class="results"  v-if="workList">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>


            <table class="rule-table"  v-if="workList">
       
                    <tbody>
                      <tr class="f15">
                        <td class="f14 td-col1">公司名称：</td>
                        <td class="f14 td-col2">{{item.info.companyName}}</td>
                    
                      
                    </tr>
                     <tr class="f15">
                        <td class="f14 td-col1">公司部门：</td>
                        <td class="f14 td-col2">{{item.info.depName}}</td>
                    
                      
                    </tr>
                      <tr class="f15">
                        <td class="f14 td-col1">所在职位：</td>
                        <td class="f14 td-col2">{{item.info.position}}</td>
                     
                    </tr>
                    <tr class="f15">
                        <td class="f14 td-col1">工作时间</td>
                          <td class="f14 td-col2">{{item.info.workTime}}</td>
                      
                    </tr>
                   <tr class="f15">
                        <td class="f14 td-col1">负责工作</td>
                          <td class="f14 td-col2">{{item.info.workdesp}}</td>
                      
                    </tr>
                   
                   
                    </tbody>
           </table>
          </div>
 <!--项目经验信息核实-->  
  <div class="report-details" v-for="item in this.list[2].projectList">
  <div class="report-title"> <span>项目经验信息核实</span> 
           <i v-if="projectList" class="fr iconfont icon-xiangxia" @click='projectList=false'> </i>
<i v-if="!projectList" class="fr iconfont icon-up" @click='projectList=true'> </i>
           </div>
 <p class="results"  v-if="projectList">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>


            <table class="rule-table"  v-if="projectList">
       
                    <tbody>
                    
                    <tr class="f15">
                        <td class="f14 td-col1">项目描述：</td>
                        <td class="f14 td-col2">{{item.info.projectDes}}</td>
                    
                      
                    </tr>
                     <tr class="f15">
                        <td class="f14 td-col1">项目名称：</td>
                        <td class="f14 td-col2">{{item.info.projectName}}</td>
                    
                      
                    </tr>
                    
                    <tr class="f15">
                        <td class="f14 td-col1">项目时间：</td>
                          <td class="f14 td-col2">{{item.info.time}}</td>
                      
                    </tr>
                   <tr class="f15">
                        <td class="f14 td-col1">项目职责：</td>
                        <td class="f14 td-col2">{{item.info.workdes}}</td>        
                    </tr>
                   
                   
                    </tbody>
           </table>
          </div>

  
 <!--技能信息核实-->  
  <div class="report-details" v-for="item in this.list[4].skills">
  <div class="report-title"> <span>技能信息核实</span> 
           <i v-if="skills" class="fr iconfont icon-xiangxia" @click='skills=false'> </i>
<i v-if="!skills" class="fr iconfont icon-up" @click='skills=true'> </i>
           </div>
 <p class="results"  v-if="skills">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>

            <table class="rule-table"  v-if="skills">
       
                    <tbody>
                      <tr class="f15">
                        <td class="f14 td-col1">技能名称：</td>
                        <td class="f14 td-col2">{{item.info.skillName}}</td>
                    
                      
                    </tr>
                    
                    <tr class="f15">
                        <td class="f14 td-col1">技能水平：</td>
                          <td class="f14 td-col2">{{item.info.level}}</td>
                      
                    </tr>
                   
                   
                    </tbody>
           </table>
          </div>
          <!--证书信息核实-->  
  <div class="report-details" v-for="item in this.list[5].certificate">
  <div class="report-title"> <span>证书信息核实</span> 
           <i v-if="certificate" class="fr iconfont icon-xiangxia" @click='certificate=false'> </i>
<i v-if="!certificate" class="fr iconfont icon-up" @click='certificate=true'> </i>
           </div>
 <p class="results"  v-if="certificate">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>


            <table class="rule-table"  v-if="certificate">
       
                    <tbody>
                    
                     <tr class="f15">
                        <td class="f14 td-col1">证书名称：</td>
                        <td class="f14 td-col2">{{item.info.name}}</td>
                    
                      
                    </tr>
                    
                    <tr class="f15">
                        <td class="f14 td-col1">证书时间：</td>
                          <td class="f14 td-col2">{{item.info.time}}</td>
                      
                    </tr>
                  
                   
                   
                    </tbody>
           </table>
          </div>
              <!--培训信息核实-->  
  <div class="report-details" v-for="item in this.list[6].tranList">
  <div class="report-title"> <span>培训信息核实</span> 
           <i v-if="tranList" class="fr iconfont icon-xiangxia" @click='tranList=false'> </i>
<i v-if="!tranList" class="fr iconfont icon-up" @click='tranList=true'> </i>
           </div>
 <p class="results"  v-if="tranList">
    <span class="interval" v-if="item.result"><i class="mintui mintui-field-success"></i>完全一致</span>
  <span class="interval" v-if="!item.result"><i class="mintui mintui-field-error"></i>存在差异</span>
 
   <span class="interval " v-if="item.comAutnPass"><i class="iconfont icon-yonghuzu"></i>{{item.comAutnPass}}人加证</span>
   <span class="interval  " v-if="item.authNumPass"><i class="iconfont icon-icon"></i>{{item.authNumPass}}人加证</span>
  
</p>


            <table class="rule-table"  v-if="tranList">
       
                    <tbody>
                    
                   <tr class="f15">
                        <td class="f14 td-col1">培训地址：</td>
                        <td class="f14 td-col2">{{item.info.address}}</td>
                    
                    </tr>
                    
                    <tr class="f15">
                        <td class="f14 td-col1">培训机构名称：</td>
                          <td class="f14 td-col2">{{item.info.institutions}}</td>
                      
                    </tr>
                     <tr class="f15">
                        <td class="f14 td-col1">培训时间：</td>
                          <td class="f14 td-col2">{{item.info.time}}</td>
                      
                    </tr>
                      <tr class="f15">
                        <td class="f14 td-col1">培训课程名称：</td>
                          <td class="f14 td-col2">{{item.info.tranName}}</td>
                      
                    </tr>
                    </tbody>
           </table>
          </div>
</div>
   
    
       



          </div>
        </div>   
    </main>             
</div>


</template>
<script>
var list={
  "list": [
    {
      "baseInfo": [
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "sex": "男",
            "origin": "户口/国籍：",
            "name": "何福暖",
            "Birthday": "1993/06"
          }
        }
      ]
    },
    {
      "eductionList": [
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "eduction": "本科",
            "time": "2011/07-2013/07",
            "schoolName": "华南师范大学",
            "mojor": "电子政务"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "eduction": "大专",
            "time": "2008/09-2013/07",
            "schoolName": "汕尾职业技术学院",
            "mojor": "教育技术学"
          }
        }
      ]
    },
    {
      "workList": [
        {
          "check": false,
          "result": true,
          "authNumPass": 6,
          "comAutnPass": 8,
          "comAuthFail": 0,
          "authNumFail": 7,
          "info": {
            "workdesp": "负责web项目的后端开发与设计",
            "companyName": "惠州风云软件科技有限公司",
            "position": "软件工程师",
            "workTime": "2014/05-2015/04",
            "depName": "开发部"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": 0,
          "comAutnPass": null,
          "comAuthFail": 0,
          "authNumFail": 0,
          "info": {
            "workdesp": "负责前后台开发与设计",
            "companyName": "文思海辉系统有限公司",
            "position": "软件工程师",
            "workTime": "1990/12-2017/05",
            "depName": "金融事业部"
          }
        }
      ]
    },
    {
      "projectList": [
        {
          "check": false,
          "result": true,
          "authNumPass": 0,
          "comAutnPass": null,
          "comAuthFail": 0,
          "authNumFail": 0,
          "info": {
            "workdes": "本人担任项目中的组长职位，负责人员安排以及项目进度的把控并负责部分模块的开发。",
            "time": "2016/01-2017/05",
            "projectName": "平安信用险融资在线管理平台",
            "projectDes": "eclipse(开发工具) windows(软件环境)目前，企业想找银行贷款，会提供货物的物流信息，以此作为证明，从银行获得贷款。但是，这种方式下，很容易伪造物流信息，从而造成银行的损失，所以需要一个统一的平台进行管理，系统自动分配物流公司，由平安产险承保，最终向银行申请贷款，以此来控制伪造物流信息的风险，减少银行损失，该平台分为四个子系统：企业端、物流端、保险端、银行端。"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": 0,
          "comAutnPass": null,
          "comAuthFail": 0,
          "authNumFail": 0,
          "info": {
            "workdes": "本人主要负责项目中用户的OTC开户，产品的上架以及展现等功能模块的开发。",
            "time": "2015/11-2015/12",
            "projectName": "前交所",
            "projectDes": "eclipse(开发工具) windows(软件环境)前交所对接平安证券OTC完成开户、交易、清算等功能，并从B系统获取产品数据，实现在前交所B2B平台上销售中证机构间报价系统中的产品，从而为前交所B2B交易平台接入OTC资产。"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": 0,
          "comAutnPass": null,
          "comAuthFail": 0,
          "authNumFail": 0,
          "info": {
            "workdes": "本人主要负责项目里的用户登录和权限验证、保证金管理、报表查询等模块以及定时任务的开发与设计。",
            "time": "2015/09-2015/10",
            "projectName": "招拍挂系统",
            "projectDes": "eclipse(开发工具) windows(软件环境)由于来款难区分，退款繁琐且可能因保证金退款不及时导致公司业务部门与财务部门出现纠纷，占用资金也会导致投标企业意愿降低，所以在此背景下，针对这类问题的有效解决从而衍生出了此系统，该系统主要有以下几块功能模块：标的子账户管理、保证金管理、来账核查、报表查询等。"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": 0,
          "comAutnPass": null,
          "comAuthFail": 0,
          "authNumFail": 0,
          "info": {
            "workdes": "参与项目的前后端开发与设计，主要负责学籍管理、计费管理、收费管理、系统管理等模块的开发。",
            "time": "2015/05-2015/08",
            "projectName": "温州教育管理系统",
            "projectDes": "eclipse(开发工具) windows(软件环境)由于现在各个教育系统为分散的C/S体系，每次发布系统和更新系统需要到客户现场去完成，不利于维护和推广。所以将原有的C/S体系转化为B/S体系，项目主要有以下几个模块：系统管理、学校信息、学生资料管理、计费管理、收费管理、学籍管理、消息中心等。"
          }
        }
      ]
    },
    {
      "skills": [
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "英语",
            "level": "良好"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "HTML",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "Java",
            "level": "精通"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "Director",
            "level": "一般"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "XML/XSLT",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "JSP",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "J2EE",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "Oracle",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "JavaScript",
            "level": "熟练"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "skillName": "CSS",
            "level": "熟练"
          }
        }
      ]
    },
    {
      "certificate": [
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "name": "全国计算机等级二级",
            "time": "2012/03"
          }
        }
      ]
    },
    {
      "tranList": [
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "institutions": "文娱歌唱",
            "tranName": "唱歌",
            "address": "深圳",
            "time": "2011/01-2012/01"
          }
        },
        {
          "check": false,
          "result": true,
          "authNumPass": null,
          "comAutnPass": null,
          "comAuthFail": null,
          "authNumFail": null,
          "info": {
            "institutions": "腾讯",
            "tranName": "英雄联盟",
            "address": "华宝一号",
            "time": "2006/01-2007/01"
          }
        }
      ]
    }
  ],
  "status": "ok"
}
import {Header,MessageBox} from 'mint-ui';
export default {
  name: 'page2',
  data() {
    return {
workyear:0,

      personalExperience:true,
      educationExperience:true,
      workExperience:true,
      projectExperience:true,
      training:true,
      specialty:true,
      credential:true,
      

      eductionList:true,
      workList:true,
      projectList:true,
      skills:true,
      certificate:true,
      tranList:true,
       list:[1,2]
    }
  },
  computed: {
  },
 components: {

 },
  methods: {
  
  },
  watch: {

  },
   created: function () {

if((this.$store.state.factList[0]==undefined)){
MessageBox.confirm('您还未上传简历','温馨提示')
.then(
action=>{
  this.$router.push("page20")
console.log('确认')
},
action=>{
console.log('取消')
this.$router.push("page20")
}
);

}else{
this.workyear='';
this.list='';
this.list=JSON.parse(JSON.stringify(list)).list;  
//this.list=this.$store.state.factList     //上线使用
var str=this.list[2].workList[this.list[2].workList.length-1].info.workTime;
var n=str.split('/',1);
var haha = new Date();
this.workyear=haha.getFullYear()-Number(n)
console.log(this.workyear)

}



    },
  mounted () {


     



   
  },

};
</script>

<style lang="scss" scoped>
.mintui-field-error{
  color: #FAC200;
}
.mintui-field-success{
  color: #4DE249;
}
.vt{
  vertical-align: top;
}
.pic-report{ 
  position: absolute;
  z-index: 100;
  right: 10px;
  top:10px;
  width: 140px;
  height: 160px;
  background-image: url(../../../static/img/report.png);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  text-align: center;
  div{
    margin-top:50%;
     transform: translateY(-50%);
p{
    text-align: center;
    margin: 0;
    color: #BB8E00;
  }
  p:nth-child(1){
font-size: 1.4rem;

  }
  p:nth-child(2){
    margin-top:10px;
   font-size: 4rem;
  }
}
p:nth-child(3){
  margin-top: 5px;
 font-size: 1.4rem;
  }
  }
  
@media (min-width:320px) {.pic-report{width: 112px;
  height: 128px;}}
@media (min-width:375px){.pic-report{width: 126px;
  height: 144px;}}
@media (min-width:414px) {.pic-report{width: 140px;
  height: 160px;
  }
   
  }
main {
   position: relative;
.report{
  text-align: center;
  margin: 30px 7px 10px;
  .headline{
  display: inline-block;
  font-size: 1.7rem;
  padding: 0 10px;
  line-height: 48px;
  background:  #FF6600;
  color: #fff;
  position: absolute;
  top: 36px;
  left: 50%;
  transform: translate(-50%)
}
.report-title{
    text-align: left;
    margin:25px auto 0;
    width: 95%;
    font-size: 1.4rem;
    color: #888888;
    letter-spacing: -0.41px;
  }
// 报告信息
.report-information{
  
  .report-title{
    text-align: left;
    margin:20px auto 5px;
    width: 95%;
    font-size: 1.4rem;
    color: #888888;
    letter-spacing: -0.41px;
  }
  table{
  margin: auto;
  width: 95%;
    tbody{
      width: 100%;
      tr{
        width: 100%;
        height: 40px;
        // line-height: 40px;
        border-bottom: 1px solid #D9D9D9;
        .td-col1{
          width: 33%;
          color: #888888;
          text-align: left;
        }
        .td-col2{
          width: 66%;
          text-align: left;
        }
      }
      
    }
  }
}
// 报告项目
.report-project{
  margin-top: 20px;
  background: #F6F6F6; 
  .report-title{
    text-align: left;
    margin:0 auto 0;
    width: 95%;
    font-size: 1.4rem;
    color: #888888;
    letter-spacing: -0.41px;
  }
 
  .rule-table{
     margin: auto;
  width: 90%;
    thead{
    tr{
        width: 100%;
        height: 40px;
        // line-height: 40px;
        border-bottom: 1px solid #D9D9D9;
        .td-col1{
          width: 33%;
          color: #888888;
          text-align: left;
        }
        .td-col2{
          width: 66%;
          text-align: left;
        }
      }

    }

    tbody{
   width: 100%;
      tr{
        width: 100%;
        height: 40px;
        // line-height: 40px;
        border-bottom: 1px solid #D9D9D9;
        .td-col1{
          width: 33%;
          color: #888888;
          text-align: left;
        }
        .td-col2{
          width: 66%;
          text-align: left;
        }
      
      }
      
    }
  
  }
}
// 报告详情信息
.report-details{
  border: 1px solid #E9E9E9;
 margin-top: 15px;
 margin-left: 10px;
    margin-right: 10px;
  background: #fff;
  border-radius:0 0 5px  5px;
  p{
    width: 90%;
    height: 50px;
    margin: 0 auto;
    font-size: 1.4rem;
    color: #888888;
    border-bottom: 1px solid #eee;
     line-height: 50px;
      height: 50px;
      text-align: left;
      white-space: nowrap;
    span{
      font-size: 1.8rem!important;
      margin-left: 0px;
      line-height: 50px;
      height: 50px;
    }
    .interval{
      display: inline-block;
      width: 33%;
      text-align: left;
      font-size: 1.4rem!important;
      line-height: 50px;
      i{
        font-size: 1.8rem!important;
        margin-right: 5px;
        line-height: 50px;
      }
    }
  }
  .report-title{
  width: 100%;
    background-color: #F5F5F5; 
    text-align: left;
    margin:0 auto 0;
    height: 30px;
    line-height: 30px;
    font-size: 1.4rem;
    color: #888888;
    span{
      margin-left: 10px;
    }
    i{
      margin-right: 10px;
      width: 50%;
      text-align: right;
    }
  }
  .rule-table{
     margin: auto;
  width: 90%;
   thead{
    tr{
        width: 100%;
        height: 40px;
        // line-height: 40px;
       
         .td-col1{
          width: 33%;
          color: #888888;
          text-align: left;
        }
        .td-col2{
          width: 66%;
          text-align: left;
        }
      
      }

    }
    tbody{
   width: 100%;
      tr{
        width: 100%;
        height: 40px;
        // line-height: 40px;
       
        .td-col1{
          width: 33%;
          color: #888888;
          text-align: left;
        }
        .td-col2{
          width: 66%;
          text-align: left;
        }
      
      }
      
    }
  
  }
}
.comprehensive{
   margin-top: 20px;
   margin-bottom: 20px;
  .report-title {
    background-color: #fff; 
    text-align: left;
    margin:0 auto 0;
    width: 95%;
    height: 30px;
    color: #000;
    line-height: 30px;
    font-size: 1.4rem;
  }
  .report-body {
    height: 60px;
    p{
        background-color: #fff; 
    text-align: left;
    margin:0 auto 0;
    width: 95%;
    height: 30px;
    color: #888888;
    line-height: 30px;
    font-size: 1.6rem;
    }
  }
  .report-footer {
    background-color: #fff; 
    text-align: left;
    margin:0 auto 0;
    width: 95%;
    height: 30px;
    color: #888888;
    line-height: 30px;
    font-size: 1.4rem;
    text-align: center;
color: #C3C3C3;
  }

}

}


display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 0;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
}
.mint-header{
background: #FF6600;
}
.mint-header-title {
font-size: 1.7rem!important;
}
.mint-button-text{
font-size: 1.4rem!important;
}
.mintui{
font-size: 1.4rem!important;
}

</style>