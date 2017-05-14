<template>
<div class="educationExperience ">
                   <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                  <div class="personal-form  animated fadeInRightBig">
                      <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15">教育经历</span>  </p> 
                        </div>
                        </div>
                       <div>
                        <!--<div class="list-box">
                          <div class="list-input" @click="admissionTime">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>入学时间</p>
                              <input  disabled   v-model="eduExperience.admissionTime" placeholder="请选择>">
        
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.admissionTime">
                            入学时间不能为空
                          </div>
                        </div>-->
<div class="list-box">
<div class="list-input" @click="open('picker4')">
<p class=""><span class="fcRed f14">* &nbsp;  </span>入学时间</p>
<input disabled v-model="eduExperience.admissionTime" placeholder="请选择 >">
</div>
 <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.admissionTime">
                            入学时间不能为空
</div>
</div>
<div class="list-box">
<div class="list-input" @click="open('picker5')">
<p class=""><span class="fcRed f14">* &nbsp; </span>毕业时间</p>
<input  disabled   v-model="eduExperience.graduationTime" placeholder="请选择>">
</div>
<div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!eduExperience.graduationTime">
毕业时间不能为空
</div>
</div>
                      <!--<div class="list-box">
                         <div class="list-input" @click="graduationTime">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>毕业时间</p>
                            <input  disabled   v-model="eduExperience.graduationTime" placeholder="请选择>">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!eduExperience.graduationTime">
                            毕业时间不能为空
                          </div>
                        </div>-->
                      <div class="list-box">
                         <div class="list-input">
                            <p class=" "> <span class="fcRed f14">* &nbsp; </span>学校</p>
                            <input v-model="eduExperience.schoolName" placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.schoolName">
                            学校不能为空
                          </div>
                        </div>

                      <div class="list-box">
                        <div class="list-input" @click="educationBackground">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>学历</p>
                            <input disabled v-model="eduExperience.educationBackground" placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.educationBackground">
                            学历不能为空
                          </div>
                        </div>
                      <div class="list-box">
                        <div class="list-input">
                            <p class="fa fa-phone"><span class="fcRed f14">* &nbsp; </span>证件编号</p>
                         <input v-model="eduExperience.credentials"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.credentials">
                            证件编号不能为空
                          </div>
                        </div>
                      <div class="list-box">
                        <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>专业</p>
                            <input v-model="eduExperience.major"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!eduExperience.major">
                            专业不能为空
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



<!--address弹出框组件-->
 <!--<mt-popup v-model="popupAddressVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='canceladdress' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineaddress' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="addressSlots" @change="onChangeaddress" :visible-item-count="5"></mt-picker>
</div>
</mt-popup>-->


 <mt-popup v-model="popupEducationBackgroundVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelBackground' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineBackground' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="eduSlot" @change="onChangebackground" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

 <mt-popup v-model="popupGraduationTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelGraduation' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineGraduation' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangegraduation" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

 <mt-popup v-model="popupAdmissionTimeVisible" position="bottom" class="mui-col-xs-12" >
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

</div>



</div>
</template>
<script>

import { Popup,Picker,DatetimePicker,Toast,Indicator,MessageBox } from 'mint-ui';
export default {
  name: 'educationExperience',
  data() {
    return {
      // educationExperienceNum:0,
value4: null,
value5: null,
//控制弹出层显示
 popupAdmissionTimeVisible:false,
 popupGraduationTimeVisible:false,
popupEducationBackgroundVisible:false,

//教育经历
      eduExperience:{
        admissionTime:'',
        graduationTime:'',
        schoolName:'',
        educationBackground:'',
        credentials:'',
        saveFlag:'local',
        major:'',
      },

      yearSlot: [{
          flex: 1,
             values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
     eduSlot: [{
          flex: 1,
          values: ['博士', '硕士', '本科', '大专'],
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
 components: {
DatetimePicker,Picker,Popup
 },
  methods: {

open(picker) {
this.$refs[picker].open();
},
handleChange(value) {
this.eduExperience.admissionTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate();
},
handleChange2(value) {
this.eduExperience.graduationTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate();
},
// 开关控制器
// popupAdmissionTimeVisible:false,
// popupGraduationTimeVisible:false,
// popupAddressVisible:false,


    //时间
determine(){
this.popupAdmissionTimeVisible=false
},
cancel(){
this.popupAdmissionTimeVisible=false;
this.eduExperience.admissionTime='';
},
admissionTime(){
this.popupAdmissionTimeVisible=true;
},
onChangeadmission(picker, values) {
this.eduExperience.admissionTime = values[0];
},

determineGraduation(){
this.popupGraduationTimeVisible=false
},
cancelGraduation(){
this.popupGraduationTimeVisible=false;
this.eduExperience.graduationTime='';
},
graduationTime(){
this.popupGraduationTimeVisible=true;
},
onChangegraduation(picker, values) {
this.eduExperience.graduationTime = values[0];
},


determineBackground(){
this.popupEducationBackgroundVisible=false
},
cancelBackground(){
this.popupEducationBackgroundVisible=false;
this.eduExperience.educationBackground='';
},
educationBackground(){
this.popupEducationBackgroundVisible=true;
},
onChangebackground(picker, values) {
this.eduExperience.educationBackground = values[0];
},
// addList(){
//   $(".texthint").css("display","block");

//   let edu=this.eduExperience;
//   let enter=6;
//           for(var key in edu){
//             if((edu[key])){
//                enter-=1;
//             }
//           }
//           if(!enter){

            
           
//           }
 
// },
   addList(){
    $(".texthint").css("display","block");

  let edu=this.eduExperience;
  let enter=7;
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
                    this.$http.post('/personCredit/person/saveEducation.do',this.eduExperience)
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

  let edu=this.eduExperience;
  let enter=7;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
            }
          }
          if(!enter){
      

// var user = JSON.parse(JSON.stringify(this.eduExperience));  
// console.log(user)
// user.id=this.$store.state.id;
// var eduExperience = JSON.stringify(user);


MessageBox.confirm('信息提交后将不可修改','温馨提示')
.then(
action=>{
console.log('确认')

 this.eduExperience.saveFlag='block'
     

Indicator.open();
                  this.$http.post('/personCredit/person/saveEducation.do',this.eduExperience)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){

                      
let instance = Toast('提交成功');
setTimeout(() => {
instance.close();
}, 1000);
setTimeout(() => {
this.$router.push('page12')
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

  let edu=this.eduExperience;
  let enter=7;
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
                    this.$http.post('/personCredit/person/saveEducation.do',this.eduExperience)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          
                     this.$router.push('page5')
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
            this.eduExperience.admissionTime='',
            this.eduExperience.graduationTime='',
            this.eduExperience.educationBackground=''
  },


};
</script>

<style lang="scss" scoped>



.fadeInRightBig {
    animation:fadeInRightBig 150ms ;
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
            width: 70%;
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
            width: 30%;
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