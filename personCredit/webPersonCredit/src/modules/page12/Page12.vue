<template>
<div class="pagePersonal">
      <mt-header class='mint-header is-fixed' title="我的简历" >
        <router-link to="page2" slot="left">
       <mt-button icon="back"></mt-button>
        </router-link>
         <!--<router-link to="page8" slot="right">
        <mt-button >打印</mt-button>
        </router-link>-->
      </mt-header>
    <main>
         <div class="mui-content ">
           <div class="mui-col-xs-12 userStatus">
            <div class="avatars">
              <img src="../../../static/img/pic.png">
            </div>
             <p> &nbsp;{{list.info.telPhone}}  
                    <span v-if="(list.info.status==2)">&nbsp;审批中</span>
                    <span v-if="(list.info.status==1)">&nbsp;认证成功</span>
                    <span v-if="(list.info.status==0)">&nbsp;认证失败</span>
                    <span v-if="(list.info.status==3)">&nbsp;未认证</span>     
              </p>
            <div class="entrance">
               <span>></span>
            </div>
           </div>
               <div class="userNaver">
              <div class="basicInformation">考评系统</div>

              <div class="overallMerit">综合评价</div>

              <div class="ResumePreview">简历预览</div>
            </div>
                  <div class="personal-form" style="min-height: 171px">
                     <div class="list-personal">
                       <div  class="list-title"><span class=" iconHint iconfont icon-iconfont"> </span>基本信息</div>
                     </div>
                     <div class="baseMessage">
                     <div class="list-message">
                       <p class="incomplete"> <span class="personal-name">姓名：{{list.info.name}}</span> &nbsp;{{list.info.bornDate}}</p>  
                       <!--<p class="incompleteHint">信息暂未填写完整</p>-->
                     </div>
                      <div class="list-message">
                            <p class="incomplete">地址：{{list.info.address}}  | 工作时间：{{workYear}}年</p>
                      </div>
                      <div class="list-message">

                             <p  class="incomplete">邮箱：{{list.info.email}}</p>
                             <!--<p v-if="(this.$store.state.status==1)" class="incomplete">状态：认证成功</p>
                             <p v-if="(this.$store.state.status==0)" class="incomplete">状态：认证失败</p>
                             <p v-if="(this.$store.state.status==3)" class="incomplete">状态：未认证</p>-->
                     
                      </div>
                      <div class="list-message">
                             <p class="incomplete">手机：{{list.info.telPhone}}</p>
                      </div>
                      <div class="userPortrait">

                      </div>
                      </div>
                 </div>

                 <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>教育经历
                         
                          <i v-if="education" class="fr iconfont icon-up" @click='education=false'> </i>
                          <i v-if="!education" class="fr iconfont icon-xiangxia" @click='education=true'> </i>
                          <span class='addlist' @click="addlist('page4',list.education.id)">增加教育</span>
                          <div v-if="education"  class="separator"></div>
                       </div>
                      
                     </div>
                    
                     <div v-if="education"  class="messageBox" v-for="(item,index) in list.education">
                      <div class="list-message extraMessage">
                        <p class="incomplete"> {{item.admissionTime}} - {{item.graduationTime}}

                        </p>
                        <p class="incomplete incompleteRed">教育背景：{{item.educationBackground}}</p>
                       <p class="incomplete">专业：{{item.major}}</p>
                       <p class="incomplete">学校：{{item.schoolName}}</p>
                        <p class="incomplete">证书编号：{{item.credentials}}</p>
                     </div>
                     </div>
                    
                 </div>



                <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>工作经历
                          <i v-if="showWoekDetails" class="fr iconfont icon-up" @click='showWoekDetails=false'> </i>
                          <i v-if="!showWoekDetails" class="fr iconfont icon-xiangxia" @click='showWoekDetails=true'> </i>
                             <span class='addlist' @click="addlist('page5',list.workExpe.id)">增加工作</span>
                          <div v-if="showWoekDetails"  class="separator"></div>
                       </div>
                      
                     </div>
                    
                     <div v-if="showWoekDetails"  class="messageBox" v-for="(item,index) in list.workExpe">
                      <div class="list-message extraMessage">
                        <p class="incomplete"> {{item.entryTime}} - {{item.dimissionTime}}
                        </p>
                        <p class="incomplete incompleteRed">公司名称：{{item.companyName}}</p>
                       <p class="incomplete">行业：{{item.trade}}</p>
                       <p class="incomplete">部门：{{item.department}}</p>
                        <p class="incomplete">职位：{{item.companyName}}</p>
                          <p class="incomplete lh3">工作描述：{{item.workDescription}}</p>
                     </div>
                     </div>
                    
                 </div>


 <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>项目经验
                          <i v-if="projectExpe" class="fr iconfont icon-up" @click='projectExpe=false'> </i>
                          <i v-if="!projectExpe" class="fr iconfont icon-xiangxia" @click='projectExpe=true'> </i>
                           <span class='addlist' @click="addlist('page6',list.projectExpe.id)">增加经验</span>
                          <div v-if="projectExpe"  class="separator"></div>
           
                       </div>
                      
                     </div>
                    
                     <div v-if="projectExpe"  class="messageBox" v-for="(item,index) in list.projectExpe">
                      <div class="list-message extraMessage">
                        <p class="incomplete"> {{item.projectBeginTime}} - {{item.projectEndTime}}
                        </p>
                        <p class="incomplete incompleteRed">公司名称：{{item.companyName}}</p>
                       <p class="incomplete">项目名称：{{item.projectName}}</p>
                          <p class="incomplete lh3">责任描述：{{item.responsibility}}</p>
                     </div>
                     </div>
                    
                 </div>



 <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>证书
                          <i v-if="cert" class="fr iconfont icon-up" @click='cert=false'> </i>
                          <i v-if="!cert" class="fr iconfont icon-xiangxia" @click='cert=true'> </i>
                                               <span class='addlist' @click="addlist('page16',list.cert.id)">增加证书</span>
                          <div v-if="cert"  class="separator"></div>
                       </div>
                      
                     </div>
  
                     <div v-if="cert"  class="messageBox" v-for="(item,index) in list.cert">
                      <div class="list-message extraMessage">
                        <p class="incomplete incompleteRed">证书名称：{{item.name}}</p>
                          <p class="incomplete">  颁发日期：{{item.certificateTime}} 
                          <p class="incomplete">  证书编号：{{item.certificateNum}} 
                        </p>
                     </div>
                     </div>
                    
                 </div>



        
                <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>技能
                          <i v-if="allSkill" class="fr iconfont icon-up" @click='allSkill=false'> </i>
                          <i v-if="!allSkill" class="fr iconfont icon-xiangxia" @click='allSkill=true'> </i>
                                               <span class='addlist' @click="addlist('page15',list.allSkill.id)">增加技能</span>
                          <div v-if="allSkill"  class="separator"></div>
                       </div>
              
                     </div>
                    
                     <div v-if="allSkill"  class="messageBox" v-for="(item,index) in list.allSkill">
                      <div class="list-message extraMessage">
            
                        <p class="incomplete incompleteRed">技能名称：{{item.skillNum}}</p>
                          <p class="incomplete lh3">技能熟练度：{{item.proficiency}}</p>
                     </div>
                     </div>
                    
                 </div>

                  <div class="personal-form">
                     <div class="list-personal">
                       <div  class="list-title">
                         <span class=" iconHint iconfont icon-iconfont"> </span>培训经历
                          <i v-if="train" class="fr iconfont icon-up" @click='train=false'> </i>
                          <i v-if="!train" class="fr iconfont icon-xiangxia" @click='train=true'> </i>
                                               <span class='addlist' @click="addlist('page17',list.train.id)">增加培训</span>
                          <div v-if="train"  class="separator"></div>
                       </div>
                     </div>
                    
                     <div v-if="train"  class="messageBox" v-for="(item,index) in list.train">
                      <div class="list-message extraMessage">
                        <p class="incomplete"> {{item.startTime}} - {{item.endTime}}
                        </p>
                        <p class="incomplete incompleteRed">培训名称：{{item.trainingName}}</p>
                       <p class="incomplete">机构名称：{{item.companyName}}</p>
                     </div>
                     </div>
                    
                 </div> 

           </div>   
     </main>

               
         </div>


</template>
<script>

import {Header,Toast,MessageBox,Indicator} from 'mint-ui';
export default {
  name: 'page2',
  data() {
   
    return {
      workTime:'',
education:true,
cert:true,
train:true,
allSkill:true,
projectExpe:true,
      showWoekDetails:true,
      showEduDetails:true,
       list:{},
    }
  },
  computed: {
  },
 components: {

 },
  methods: {
    addlist(e,f){
      this.$store.commit("formsStateChange")
      this.$store.commit("changeId",f)
console.log(this.$store.state.id)
        this.$router.push(e)
      }
  },
  watch: {

  },
   created: function () {
    


   },
  mounted () {









// console.log(this.list.info.name)
// console.log(this.list.info.name)

// this.list={
//         "allSkill":[
//             {
//                 "skillNum":"001",
//                 "saveFlag":"local",
//                 "id":"S000000001007",
//                 "proficiency":"01"
//             }
//         ],
//         "education":[
//             {
//                 "educationBackground":"??",
//                 "graduationTime":"2015/06/24",
//                 "major":"???????",
//                 "credentials":"12468923547",
//                 "saveFlag":"local",
//                 "admissionTime":"2011/09/01",
//                 "id":"E000000000983",
//                 "schoolName":"ANPU"
//             },
//             {
//                 "educationBackground":"??",
//                 "graduationTime":"2015/06/24",
//                 "major":"???????",
//                 "credentials":"12468923547",
//                 "saveFlag":"local",
//                 "admissionTime":"2011/09/01",
//                 "id":"E000000000984",
//                 "schoolName":"ANPU"
//             },
//             {
//                 "educationBackground":"??",
//                 "graduationTime":"2015/06/24",
//                 "major":"???????",
//                 "credentials":"12468923547",
//                 "saveFlag":"local",
//                 "admissionTime":"2011/09/01",
//                 "id":"E000000001008",
//                 "schoolName":"ANPU"
//             },
//             {
//                 "educationBackground":"??",
//                 "graduationTime":"2015/06/24",
//                 "major":"???????",
//                 "credentials":"12468923547",
//                 "saveFlag":"local",
//                 "admissionTime":"2011/09/01",
//                 "id":"E000000001009",
//                 "schoolName":"ANPU"
//             },
//             {
//                 "educationBackground":"??",
//                 "graduationTime":"2015/06/24",
//                 "major":"???????",
//                 "credentials":"12468923547",
//                 "saveFlag":"local",
//                 "admissionTime":"2011/09/01",
//                 "id":"E000000001011",
//                 "schoolName":"ANPU"
//             },
//             {
//                 "educationBackground":"硕士",
//                 "graduationTime":"2008/12/04",
//                 "major":"123",
//                 "credentials":"1213",
//                 "saveFlag":"local",
//                 "admissionTime":"2007/02/28",
//                 "id":"E000000001062",
//                 "schoolName":"ewr"
//             }
//         ],
//         "workExpe":[
//             {
//                 "entryTime":"2017/05/08",
//                 "trade":"IT",
//                 "companyName":"??",
//                 "saveFlag":"local",
//                 "dimissionTime":"2017/05/08",
//                 "workDescription":"?????",
//                 "id":"W000000000988",
//                 "position":"java??",
//                 "department":"???"
//             }
//         ],
//         "projectExpe":[
//             {
//                 "projectEndTime":"2017/05/08",
//                 "responsibility":"??",
//                 "companyName":"????",
//                 "projectDescription":"??",
//                 "saveFlag":"local",
//                 "id":"W000000000989",
//                 "projectName":"????",
//                 "projectBeginTime":"2017/05/08"
//             }
//         ],
//         "cert":[
//             {
//                 "name":"IBm",
//                 "saveFlag":"local",
//                 "certificateTime":"2017/05/08",
//                 "id":"C000000000997",
//                 "certificateNum":"3478587394785"
//             },
//             {
//                 "name":"IBm",
//                 "saveFlag":"local",
//                 "certificateTime":"2017/05/08",
//                 "id":"C000000001010",
//                 "certificateNum":"3478587394785"
//             }
//         ],
//         "info":{
//             "income":"100",
//             "address":"haha",
//             "gender":"M",
//             "name":"czj",
//             "saveFlag":"local",
//             "bornDate":"1993/01",
//             "id":"I000000001018",
//             "workYear":"2015",
//             "email":"526421627@qq.com",
//             "memberId":"M000000000975"
//         },
//         "train":[
//             {
//                 "trainingType":"01",
//                 "trainingName":"javWeb??",
//                 "companyName":"????",
//                 "saveFlag":"local",
//                 "startTime":"2017/05/08",
//                 "id":"T000000000993",
//                 "endTime":"2017/05/08",
//                 "trainingLevel":"05"
//             },
//             {
//                 "trainingType":"01",
//                 "trainingName":"javWeb??",
//                 "companyName":"????",
//                 "saveFlag":"local",
//                 "startTime":"2017/05/08",
//                 "id":"T000000000994",
//                 "endTime":"2017/05/08",
//                 "trainingLevel":"05"
//             }
//         ]
//     }


// MessageBox.confirm('您还未上传简历','温馨提示')
// .then(
// action=>{
//   this.$router.push("page20")
// console.log('确认')
// },
// action=>{
// console.log('取消')
// this.$router.push("page20")
// }
// );


this.$http.get('/personCredit/person/personInfo.do')
.then((res)=>{

if(res.body.status=='ok'){

    if((res.body.result.info.name==undefined)){
    MessageBox.confirm('您还未录入个人信息','温馨提示')
    .then(
    action=>{
    console.log('确认')
    this.$router.push("page3")
    },
    action=>{
    console.log('取消')
    this.$router.push("page2")
    }
    );
    }else{
    this.list=res.body.result;
    var haha = new Date();
    this.workYear=haha.getFullYear()-Number(this.list.info.workYear)

    }

 
}else{
      Indicator.close()
      console.log(res.body.status)
      console.log(res.body.msg)
      MessageBox.confirm(res.body.msg,'错误提示').then(
      action=>{
      console.log('确认')
      },
      action=>{
      console.log('取消')
      }
      );
}

},(err)=>{
Indicator.close()
console.log("错误")
MessageBox('提示', '服务器繁忙');
})









  },

};
</script>

<style lang="scss" scoped>
.addlist{
  color: #417505;
  font-size: 1.4rem!important;
  float: right;
  padding-right: 2%;
}

.separator{
  height: 10px;
  width: 100%;
 
  border-top: 1px solid #EEEEEE;
}
.mui-content{
  padding-bottom: 0;
}
main {
display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 0;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
}
.baseMessage{
  position: relative;
}
    .mui-bar{
        background-color: #FF6600;
         box-shadow: none;
         button{
           background-color: transparent;
           color: #fff;
           border: none;
         }
    }
    .mui-bar-nav a , .mui-bar-nav h1{
        color:#fff;
        font-weight: 300;
    }
    .pagePersonal{
      background-color: #efeff4;
    }
.userStatus{
  padding: 4% 20px;
  background-color: #FF6600;
  overflow: hidden;
  white-space: nowrap;
  .avatars{
      white-space: nowrap;
      float: left;
      width: 100px;
      height: 100px;
      border-radius: 50px;
      // background-color: #444;
      margin-bottom: 10px;
      padding-bottom: 10px;
      img{
        width: 100%;
      }
    }
    p{
      margin-top: 39px;
      float: left;
      font-size: 1.8rem;
      color: #FFFFFF;
      letter-spacing: -0.43px;  
      span{
     
         font-size: 1.4rem;
color: #FFDDC6;
letter-spacing: -0.43px;
      }
    }
    .entrance{
      margin-top: 39px;
      float: right;
      span{
        color: #FFFFFF;
        margin-right: 5px;
         font-size: 1.5rem;
      }
    }

}
.userNaver{
  white-space: normal;
  font-size: 0;
  height: 50px;
  background-color: #fff;
  div{
    display: inline-block;
    vertical-align: middle;
    width: 33%;
    height: 24px;
    margin-top: 13px;
    line-height: 24px;
    font-size: 1.4rem;
    text-align: center
  }
  .basicInformation{
    border-right: 1px solid #C7C7CC;
  }
  .overallMerit{
    border-right: 1px solid #C7C7CC;
  }
  .ResumePreview{
    
  }
}
.messageBox{
  position: relative;
}




.top-form ,.personal-form  {
  .userPortrait{
    width: 90px;
    height: 100px;
        position: absolute;
    right: 15px;
    top: 15px;
    background: #F2F2F2;
border: 1px solid #D8D8D8;
  }
    border-bottom:  1px solid #DDDDDD;
    margin-top: 10px;
    position: relative;
    background-color: #fff;
      .list-personal{
        .list-title{
          margin-left: 10px;
          i{
            color: #979797;
            width: 15%;
            text-align: right;
            display: inline-block;
           padding-right: 10px;
          }
          height: auto;
          font-size: 1.6rem;
          line-height: 50px;
       
          span{
            font-size: 1.9rem;
            line-height: 50px;
            margin-right: 5px;
          }
        }
      line-height: 50px;
      white-space: nowrap;
      overflow: hidden;
      width: 100%;
      height: auto;
      padding-left: 15px;
      -webkit-user-select: text;
      outline: 0;
      background-color: #fff;
               
      -webkit-appearance: none;
    }

    .list-message{
      margin-left: 25px;
      overflow: hidden;
      height: auto;
      .personal-name{
        font-size: 1.6rem;
        color: #444444;

        line-height: 24px;
      }
      .incomplete{
        text-align: left;
        margin-top: 10px;
        font-size: 1.4rem;
        line-height: 1.1;
        margin: 7px 0;
        color: #999999;

        padding-right: 20px;
      }
      .lh3{
        line-height: 1.3;
      }
      .incompleteRed{
       
        color: #762727;
     
      }
      .incompleteHint{
        text-align: left;
        height: 20px;
        line-height: 20px;
        font-size: 1.4rem;
        color: #D1D1D1;
       
      }
    }

    .extraMessage{
      padding-left: 20px;
       border-left: 1px solid #eee;
       margin-left: 34px;
       .incomplete{
         margin-top: 0;
         margin-bottom: 8px;
       }
       .incomplete:last-child{
        margin-bottom: 12px;
        
      }
    }
    .extraMessage:before{
    content: "";
    position: absolute;
    left: 25px;;
    top: 0px;
    border-radius: 10px;
    background-color: #A5ACAC;
    border: 4px solid rgba(236, 236, 236, 0.44);
    width: 10px;
    height: 10px;

    }
  
 .extraMessage:after{
    content: '';
    display: block;
    width: 100%;
    height: 1px;
    border-bottom: 1px solid #eee;
    margin-bottom: 10px;
    }

}
.messageBox:nth-child(2) .extraMessage:before{
  
   background-color: #FF6600;
    border: 4px solid rgba(236, 236, 236, 0.44)
}


</style>