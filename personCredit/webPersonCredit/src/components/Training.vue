<template>
<div class="educationExperience">
           <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                    
                  <div class="personal-form  animated fadeInRightBig">
             <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">培训</span> </p> 
                            <span  class="fr f15 fcGrey">若无项目培训,<a class="f15" @click="addSubmit">保存提交</a> </span>  
                        </div>
                        </div>
                      <div>

                         <div class="list-box">
                        <div class="list-input" >
                            <p class="fa fa-phone"><span  class="fcRed f14">* &nbsp; </span>培训学校</p>
                         <input v-model="training.companyName"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!training.companyName">
                            培训学校不能为空
                          </div>
                      </div>

<div class="list-box">
<div class="list-input" @click="open('picker4')">
<p class=""><span class="fcRed f14">* &nbsp; </span>培训开始时间</p>
<input disabled v-model="training.startTime" placeholder="请选择 >">
</div>
<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!training.startTime">
培训开始时间不能为空
</div>
</div>

<div class="list-box">
<div class="list-input" @click="open('picker5')">
<p class=""><span class="fcRed f14">* &nbsp; </span>培训结束时间</p>
<input disabled v-model="training.endTime" placeholder="请选择 >">
</div>
<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!training.endTime">
培训结束时间不能为空
</div>
</div>

                      <div class="list-box">
                        <div class="list-input" >
                            <p class="fa fa-phone"><span  class="fcRed f14">* &nbsp; </span>培训名称</p>
                         <input v-model="training.trainingName"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!training.trainingName">
                            培训名称不能为空
                          </div>
                      </div>

                     <div class="list-box">
                         <div class="list-input" @click="projectLevel">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>培训方式</p>
                            <input  disabled   v-model="training.trainingType" placeholder="请选择>">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!training.trainingType">
                            培训方式不能为空
                          </div>
                      </div>

                       <div class="list-box">
                          <div class="list-input" @click="projectModality">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>培训层次</p>
                              <input  disabled   v-model="training.trainingLevel"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!training.trainingLevel">
                            培训层次不能为空
                          </div>
                        </div>
                       
                    </div>
                        <div v-if="this.$store.state.formsState" class="mui-text-center mui-col-xs-12 wsnrp mgt20 mgb20">
                           <div @click="addList" class="bgc0 bd btn-next fc1 mui-col-xs-5 dib">保存并继续添加</div>
                           <div @click="nextList" class="bgc btn-next fc0 mui-col-xs-5 dib">保存提交</div>
                        </div>

                        <div v-if="!this.$store.state.formsState" class="mui-text-center mui-col-xs-12 wsnrp mgt20 mgb20">
                           <div @click="addSubmit" class="bgc btn-next fc0 mui-col-xs-8 dib">保存提交</div>
                        </div>
                   </div>
<mt-popup v-model="popuptrainingEndTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelGraduation' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineGraduation' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="lastYearSlot" @change="onChangegraduation" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<mt-popup v-model="popuptrainingBeginTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determine' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangeadmission" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>


<mt-popup v-model="popupprojectModalityVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelModality' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineModality' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="modalitySlot" @change="onChangeModality" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<mt-popup v-model="popupprojectLevelVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancellevel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determinelevel' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="levelSlot" @change="onChangelevel" :visible-item-count="3"></mt-picker>
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
import { Popup,Picker,DatetimePicker,Indicator,MessageBox,Toast} from 'mint-ui';
export default {
  name: 'educationExperience',
  data() {
    return {
      value4: null,
      value5: null,
      popupVisible3: false,
      popupVisible2: false,
      // educationExperienceNum:0,
resultProjectDescription:'',
resultResponsibility:'',
//控制弹出层显示
popuptrainingBeginTimeVisible:false,
popuptrainingEndTimeVisible:false,
popupprojectModalityVisible:false,
popupprojectLevelVisible:false,
popupAdmissionTimeVisible:false,

//培训经验
      training:{
        // trainingNum:0,
        startTime:'',
        
        endTime:'',

        trainingName:'',
        trainingLevel:'',
         saveFlag:'local',
        trainingType:'',
        saveFlag:"local"
      },
  
 levelSlot: [{
          flex: 1,
          values: ['全日制', '非全日制'],
          className: 'slot1'
        }],
      modalitySlot: [{
          flex: 1,
          values: ['高级', '中级', '初级'],
          className: 'slot1'
        }],

      yearSlot: [{
          flex: 1,
          values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
        lastYearSlot: [{
          flex: 1,
            values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
      
    };
  },
 components: {
DatetimePicker,Picker,Popup
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
              l = (this.training.projectDescription).toString().replace(/\s/g,"").length;
              num= `${l}／300`;
              if(this.training.projectDescription){
                 this.resultProjectDescription=`已填写${l}个字`
              }
         
        return num;
      },
        responsibilityResult:function(){
          var l = 0;
          var num=0;
          var arr = [];
          var reg = /^[\s]$/g;
              l = (this.training.responsibility).toString().replace(/\s/g,"").length;
              num= `${l}／300`;
              if(this.training.responsibility){
                 this.resultResponsibility=`已填写${l}个字`
              }
         
        return num;
      }
},
  methods: {
  jumpNext(){
  this.$router.push("page7")
  },

// 开关控制器
// popuptrainingBeginTimeVisible:false,
// popuptrainingEndTimeVisible:false,
// popupAddressVisible:false,

// popupprojectModalityVisible:false,
// popupprojectLevelVisible:false,
  // modality:'',
  //       level:''
determineModality(){
this.popupprojectModalityVisible=false
},
cancelModality(){
this.popupprojectModalityVisible=false;
this.admissionTime='';
},
projectModality(){
this.popupprojectModalityVisible=true;
},
onChangeModality(picker, values) {
this.training.trainingLevel = values[0];
},


determinelevel(){
this.popupprojectLevelVisible=false
},
cancellevel(){
this.popupprojectLevelVisible=false;
this.admissionTime='';
},
projectLevel(){
this.popupprojectLevelVisible=true;
},
onChangelevel(picker, values) {
this.training.trainingType = values[0];
},


    //时间
determine(){
this.popuptrainingBeginTimeVisible=false
},
cancel(){
this.popuptrainingBeginTimeVisible=false;
this.training.startTime='';
},
trainingBeginTime(){
this.popuptrainingBeginTimeVisible=true;
},
onChangeadmission(picker, values) {
this.training.startTime = values[0];
},

determineGraduation(){
this.popuptrainingEndTimeVisible=false
},
cancelGraduation(){
this.popuptrainingEndTimeVisible=false;
this.training.endTime='';
},
trainingEndTime(){
this.popuptrainingEndTimeVisible=true;
},
onChangegraduation(picker, values) {
this.training.endTime = values[0];
},


determineBackground(){
this.popupPositionVisible=false
},
cancelBackground(){
this.popupPositionVisible=false;
this.training.Position='';
},
Position(){
this.popupPositionVisible=true;
},
onChangebackground(picker, values) {
this.training.trade = values[0];
},
open(picker) {
this.$refs[picker].open();
},
handleChange(value) {
this.training.startTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
// Toast({
// message: '已选择 ' + value.toString(),
// position: 'bottom'
// });
},
handleChange2(value) {
this.training.endTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
// console.log(value.toString())
// console.log(value.getDate())
// Toast({
// message: '已选择 ' + value.toString(),
// position: 'bottom'
// });
},
addSubmit(){
   $(".texthint").css("display","block");

  let edu=this.training;
  let enter=7;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
               console.log(enter)
            }
          }
          if(!enter){
      
MessageBox.confirm('信息提交后将不可修改','温馨提示')
.then(
action=>{
console.log('确认')
Indicator.open();
 this.training.saveFlag='block'
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/personTrain.do',this.training)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
                   
let instance = Toast('提交成功');
setTimeout(() => {
instance.close();
}, 1000);
setTimeout(() => {
 this.$router.push('page12')
}, 1500);
                   
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
addList(){
    $(".texthint").css("display","block");

  let edu=this.training;
  let enter=7;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
               console.log(enter)
            }
          }
          if(!enter){
      

Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/personTrain.do',this.training)
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


    nextList(){
    $(".texthint").css("display","block");

  let edu=this.training;
  let enter=7;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
            }
          }
          if(!enter){
      


// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/personTrain.do',this.training)
                    .then((res)=>{
                
                    if(res.body.status=='ok'){
          
                    
                         MessageBox.confirm('信息提交后将不可修改','温馨提示')
                          .then(
                          action=>{
                          console.log('确认')
                          Indicator.open();
                              this.$http.post('/personCredit/person/sendInfo.do')
                              .then((res)=>{
                                    Indicator.close()
                              let instance = Toast('已保存区块');
                              setTimeout(() => {
                              instance.close();
                              }, 800);
                              setTimeout(() => {
                              this.$router.push('page12')
                              }, 1500);

                              },(err)=>{
                              let instance = Toast('未保存成功');
                              setTimeout(() => {
                              instance.close();
                              }, 1000);
                              })

                             
                          },
                          action=>{
                              let instance = Toast('已保存草稿');
                              setTimeout(() => {
                              instance.close();
                              }, 1000);
                              setTimeout(() => {
                              this.$router.push('page12')
                              }, 1300);
                          }
                          );
                          

                   
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

  
        this.training.startTime='',
        this.training.endTime='',
        this.training.trainingLevel='',
         this.training.trainingName=''
        this.training.trainingType=''


      // trainingBeginTime:'',
      //   trainingEndTime:'',
      //   trainingName:'',
      //   modality:'',
      //   level:''

  // '{"startTime":"2017/01/01","endTime":"2017/01/01","companyName":"companyName","trainingDescription":"trainingDescription","trainingName":"trainingName"}'
// this.$http.post('/personCredit/person/personTrain.do',haha)
// .then((res)=>{
// console.log(res.body.status)
// console.log("=================")

// // commit(‘updateOrderList’,res.data.list)
// },(err)=>{
// console.log("--------------")
// console.log(err)
// })

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
.top-form ,.personal-form{
  .topHint{
    background: rgba(255,229,105,0.51);
  font-size: 1.4rem;
  height: 34px;
  line-height: 34px;
  padding-left: 10px;
  color: #F19F17;
  margin-bottom: 0px;
  }
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