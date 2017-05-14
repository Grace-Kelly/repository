<template>
<div class="educationExperience ">
   <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                     
                  <div class="personal-form  animated fadeInRightBig">
                      <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">工作经验</span> </p> 
                            <span @click="jumpNext" class="fr f15 fcGrey">若无工作经验,<a class="f15">可跳过</a> </span>  
                        </div>
                        </div>
                      <div>
<div class="list-box">
<div class="list-input" @click="open('picker4')">
  <p class=""><span class="fcRed f14">* &nbsp; </span>入职时间</p>
  <input  disabled   v-model="workExperience.entryTime"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.entryTime">
                            入学时间不能为空
                          </div>
</div>
<div class="list-box">
<div class="list-input" @click="open('picker5')">
           <p class=""><span class="fcRed f14">* &nbsp; </span>离职时间</p>
                            <input  disabled   v-model="workExperience.dimissionTime" placeholder="请选择>">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!workExperience.dimissionTime">
                            离职时间不能为空
                          </div>
</div>
                        <!--<div class="list-box">
                          <div class="list-input" @click="entryTime">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>入职时间</p>
                              <input  disabled   v-model="workExperience.entryTime"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.entryTime">
                            入学时间不能为空
                          </div>
                        </div>-->
                       
                      <!--<div class="list-box">
                         <div class="list-input" @click="dimissionTime">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>离职时间</p>
                            <input  disabled   v-model="workExperience.dimissionTime" placeholder="请选择>">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!workExperience.dimissionTime">
                            离职时间不能为空
                          </div>
                        </div>-->

                      <div class="list-box">
                         <div class="list-input">
                            <p class=" "> <span class="fcRed f14">* &nbsp; </span>公司</p>
                            <input v-model="workExperience.companyName" placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.companyName">
                           公司不能为空
                          </div>
                        </div>

                      <div class="list-box">
                        <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>职位</p>
                            <input v-model="workExperience.position"  placeholder="请填写">
                        </div>
                         <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.position">
                           职位不能为空
                          </div>
                        </div>
               
 
<div class="list-box">
<div class="list-input" @click="popupVisible3=true">
<p class="fa fa-phone"><span class="fcRed f14">* &nbsp; </span>项目描述</p>
<input disabled v-model="resultJobDescription" placeholder="请填写">
</div>
<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.workDescription">
项目描述不能为空
</div>
</div>


                      <div class="list-box">
                        <div class="list-input" @click="Position">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>行业</p>
                            <input  disabled    v-model="workExperience.trade" placeholder="请填写">
                        </div>
                           <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.trade">
                            行业不能为空
                          </div>
                        </div>
                        <div class="list-box">
                        <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>部门</p>
                            <input v-model="workExperience.department"  placeholder="请填写">
                        </div>
                         <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!workExperience.department">
                            部门不能为空
                          </div>
                        </div>
                    </div>
                         <div v-if="this.$store.state.formsState" class="mui-text-center mui-col-xs-12 wsnrp mgt20 mgb20">
                           <div @click="addList" class="bgc0 bd btn-next fc1 mui-col-xs-5 dib">保存并继续添加</div>
                           <div @click="nextList" class="bgc btn-next fc0 mui-col-xs-5 dib">下一步</div>
                        </div>

                        <div v-if="!this.$store.state.formsState" class="mui-text-center mui-col-xs-12 wsnrp mgt20 mgb20">
                           <div @click="addSubmit" class="bgc btn-next fc0 mui-col-xs-8 dib">保存提交</div>
                        </div>
                  </div>


<!--弹出填写表单-->


<mt-popup v-model="popupVisible3" closeOnClickModal="false" position="right" class="mint-popup-3" >
<div class="textareaBox">
<textarea placeholder="请填写工作描述。(限300字)" maxlength ="300" v-model="workExperience.workDescription" rows="14" class="mint-field-core"></textarea>
<span class="textareaHint">{{result}}</span>

<mt-button @click.native="popupVisible3 = false" >
保存返回
</mt-button>
</div>
</mt-popup>


 <mt-popup v-model="popupPositionVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelBackground' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineBackground' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="eduSlot" @change="onChangebackground" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<mt-popup v-model="popupdimissionTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelGraduation' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineGraduation' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangegraduation" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<mt-popup v-model="popupentryTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determine' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangeadmission" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>


<mt-datetime-picker
      ref="picker4"
      type="date"
      v-model="value4"
      :startDate="startDate"
     :endDate="endDate"
      month-format="{value} 月"
      date-format="{value} 日"
      @confirm="handleChange">
    </mt-datetime-picker>

<mt-datetime-picker
      ref="picker5"
      type="date"
      v-model="value5"
      :startDate="startDate"
     :endDate="endDate"
      month-format="{value} 月"
      date-format="{value} 日"
      @confirm="handleChange2">
    </mt-datetime-picker>
</div>


</template>
<script>
import { Popup,Picker,DatetimePicker,Toast,Indicator,MessageBox } from 'mint-ui';

export default {
  name: 'educationExperience',
  data() {
    return {
      value4: null,
      value5: null,

      resultJobDescription:'',
      popupVisible3: false,
      // educationExperienceNum:0,

//控制弹出层显示
popupentryTimeVisible:false,
popupdimissionTimeVisible:false,
popupPositionVisible:false,

//教育经历
      // workExperience:{
      //   // workExperienceNum:0,
      //   entryTime:'',
      //   dimissionTime:'',
      //   companyName:'',
      //   Position:'',
      //   jobDescription:'',
      //   department:'',
      // },
//工作经验
      workExperience:{
        // workExperienceNum:0,
        entryTime:'',
        dimissionTime:'',
        saveFlag:'local',
        companyName:'',
        position:'',//小写
        workDescription:'',
        trade:'',
        department:'',
      },
//项目经验
      // projectExperience:{
      //   // workExperienceNum:0,
      //   projectBeginTime:'',
      //   projectEndTime:'',
      //   projectDescription:'',
      //   responsibility:'',
      // },
  


      yearSlot: [{
          flex: 1,
             values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
     eduSlot: [{
          flex: 1,
          values: ['IT', '教育', '医疗', '金融'],
          className: 'slot1'
        }],
      
    };
  },
    props: {
    startDate: {
        type: Date,
        default() {
          return new Date(new Date().getFullYear() -30, 0, 1);
        }
      },
      endDate: {
        type: Date,
        default() {
          return new Date(new Date().getFullYear() +1, 11, 31);
        }
      }
  },
  computed:{
result:function(){
var l = 0;
var num=0;
var arr = [];
var reg = /^[\s]$/g;
l = (this.workExperience.workDescription).toString().replace(/\s/g,"").length;
num= `${l}／300`;
if(this.workExperience.workDescription){
this.resultJobDescription=`已填写${l}个字`
}
return num;
},
},
 components: {
DatetimePicker,Picker,Popup
 },
  methods: {
    open(picker) {
this.$refs[picker].open();
},
 
handleChange(value) {
this.workExperience.entryTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
},
handleChange2(value) {
this.workExperience.dimissionTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
},
jumpNext(){
 this.$router.push("page6")
},

// 开关控制器
// popupentryTimeVisible:false,
// popupdimissionTimeVisible:false,
// popupAddressVisible:false,


    //时间
determine(){
this.popupentryTimeVisible=false
},
cancel(){
this.popupentryTimeVisible=false;
this.workExperience.entryTime='';
},
entryTime(){
this.popupentryTimeVisible=true;
},
onChangeadmission(picker, values) {
this.workExperience.entryTime = values[0];
},

determineGraduation(){
this.popupdimissionTimeVisible=false
},
cancelGraduation(){
this.popupdimissionTimeVisible=false;
this.workExperience.dimissionTime='';
},
dimissionTime(){
this.popupdimissionTimeVisible=true;
},
onChangegraduation(picker, values) {
this.workExperience.dimissionTime = values[0];
},


determineBackground(){
this.popupPositionVisible=false
},
cancelBackground(){
this.popupPositionVisible=false;
this.workExperience.position='';
},
Position(){
this.popupPositionVisible=true;
},
onChangebackground(picker, values) {
this.workExperience.trade = values[0];
},
  addList(){
    $(".texthint").css("display","block");

  let edu=this.workExperience;
  let enter=8;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
            }
          }
          if(!enter){
      

Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/saveWork.do',this.workExperience)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          this.$store.commit("addEducation")
                   
                    console.log("=================")
                    }else{
                    Indicator.close()
                    console.log(res.body.status)
                    console.log(res.body.msg)
                    MessageBox('提示', res.body.msg);
         
                    }
                    },(err)=>{
                    Indicator.close()
                    console.log("错误")
                    MessageBox('提示', '服务器繁忙');
                    })
                    // MessageBox.confirm('前往添加认证','认证提示').then(
                    // action=>{
                    // console.log('确认')
                    // this.$router.push('page9')
                    // },
                    // action=>{
                    // console.log('取消')
                    // this.$router.push('page2')
                    // }
                    // );

                    
           
}
},

addSubmit(){
   $(".texthint").css("display","block");

  let edu=this.workExperience;
  let enter=8;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
            }
          }
          if(!enter){
 
MessageBox.confirm('信息提交后将不可修改','温馨提示')
.then(
action=>{
console.log('确认')
 this.workExperience.saveFlag='block'

Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/saveWork.do',this.workExperience)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          let instance = Toast('提交成功');
setTimeout(() => {
instance.close();
}, 1000);
setTimeout(() => {
this.$router.push('page2')
}, 1300);
                    console.log("=================")
                    }else{
                    Indicator.close()
                    console.log(res.body.status)
                    console.log(res.body.msg)
                    MessageBox('提示', res.body.msg);
         
                    }
                    },(err)=>{
                    Indicator.close()
                    console.log("错误")
                    MessageBox('提示', '服务器繁忙');
                    })
                    // MessageBox.confirm('前往添加认证','认证提示').then(
                    // action=>{
                    // console.log('确认')
                    // this.$router.push('page9')
                    // },
                    // action=>{
                    // console.log('取消')
                    // this.$router.push('page2')
                    // }
                    // );




},
action=>{
console.log('取消')
}
); 







                    
           
}
},
    nextList(){
    $(".texthint").css("display","block");

  let edu=this.workExperience;
  let enter=8;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
            }
          }
          if(!enter){
      

Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/saveWork.do',this.workExperience)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){          
                     this.$router.push('page6')
                    console.log("=================")
                    }else{
                    Indicator.close()
                    console.log(res.body.status)
                    console.log(res.body.msg)
                    MessageBox('提示', res.body.msg);
         
                    }
                    },(err)=>{
                    Indicator.close()
                    console.log("错误")
                    MessageBox('提示', '服务器繁忙');
                    })
                    // MessageBox.confirm('前往添加认证','认证提示').then(
                    // action=>{
                    // console.log('确认')
                    // this.$router.push('page9')
                    // },
                    // action=>{
                    // console.log('取消')
                    // this.$router.push('page2')
                    // }
                    // );

                    
           
}
}



  },
  watch: {

  },
  mounted () {
// 添加次数
// if(this.educationExperienceNum==0){
//   this.educationExperienceNum= this.$store.state.educationList;
// }
        this.workExperience.entryTime='',
        this.workExperience.dimissionTime='',
        this.workExperience.companyName='',
        this.workExperience.position='',
        this.workExperience.workDescription='',
        this.workExperience.trade='',
        this.workExperience.department=''
  },


};
</script>

<style lang="scss" scoped>

.mint-popup-3 {
width: 100%;
height: 100%;
background-color: #fff;
}
.mint-popup-3 .mint-button {
position: absolute;
width: 90%;
top: 50%;
left: 5%;
transform: translateY(-50%);
}
.mint-popup-3 .mint-button{
top:80%!important;
}

.textareaBox{
width: 100%;
padding: 20px 15px;
textarea::-webkit-input-placeholder {
font-weight: 0;
font-size: 1.4rem;
font-weight: 300;
}
textarea{
font-size: 1.4rem;
color: #4A4A4A;
letter-spacing: -0.1px;
}
.textareaHint{
font-size: 1.4rem;
color: #4A4A4A;
letter-spacing: -0.1px;
float: right;
margin-right: 15px;
}
}
.list-box{
  height: auto;
     border-bottom: 1px solid #EEEEEE;
     margin-bottom: 5px;
}
.iconHint{
  color: #979797;
  font-size: 2.1rem;
}
.texthint{
  padding: 0 15px 2px;
  font-size: 1.4rem;
  color: #FF0000;
  display: none;
}
input::-webkit-input-placeholder,
textarea::-webkit-input-placeholder {
  font-weight: 0;
  font-size: 1.4rem;
  font-weight: 300;
}
 .topHint{
    background: rgba(255,229,105,0.51);
  font-size: 1.4rem;
  height: 34px;
  line-height: 34px;
  padding-left: 10px;
  color: #F19F17;
  margin-bottom: 0px;
  }
.top-form ,.personal-form  {
  .btn-next{
    border-radius: 30px;
    font-size: 1.4rem;
    display: inline-block;
    line-height: 40px;
    height: 40px;
   
  }
    border-radius: 7px;
    background-color: #fff;
      .list-input{
      line-height: 50px;
      white-space: nowrap;
      overflow: hidden;
      width: 100%;
      height: 50px;
      padding: 0 15px;
      -webkit-user-select: text;
   
      outline: 0;
      background-color: #fff;
      -webkit-appearance: none;
        input{
            line-height: 48px;
            height: 48px;
            vertical-align: top;
            padding: 0 5px;
            -webkit-user-select: text;
            border:transparent;
            border-radius: 3px;
            outline: 0;
            width: 65%;
            overflow: hidden;
            background-color: #fff;
            -webkit-appearance: none;
            font-size: 1.4rem;
            text-align: right;
        }
        p{
            display: inline-block;
            line-height: 50px;
            height: 50px;
            color: #444444;
            margin-bottom: 0;
            width: 35%;
            overflow: hidden;
            font-size: 1.4rem;
        }
    }

}
.wsnrp{
  div{
    height: 40px;
    line-height: 40px;
    border-bottom: 1px solid #EEEEEE;
    font-size: 1.6rem;
    
  }
}


</style>