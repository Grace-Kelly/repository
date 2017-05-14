<template>
<div class="specialty">
           <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                    
                  <div class="personal-form  animated fadeInRightBig">
             <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">技能特长</span> </p> 
                            <!--<span @click="jumpNext" class="fr f15 fcGrey">若无项目经验,<a class="f15">保存提交</a> </span>  -->
                        </div>
                        </div>
                      <div>
                        <div class="list-box">
                        <div class="list-input" >
                            <p class="fa fa-phone"><span  class="fcRed f14">* &nbsp; </span>技能名称</p>
                         <input v-model="specialty.skillNum"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!specialty.skillNum">
                           技能名称不能为空
                          </div>
                      </div>
                        <div class="list-box">
                          <div class="list-input" @click="level">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>熟练程度</p>
                              <input  disabled   v-model="specialty.proficiency"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!specialty.proficiency">
                            熟练程度不能为空
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







<mt-popup v-model="popuplevelVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determine' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangeadmission" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>
</div>



</div>
</template>
<script>
import { Popup,Picker,DatetimePicker,Toast,Indicator,MessageBox } from 'mint-ui';
export default {
  name: 'specialty',
  data() {
    return {
      popupVisible2: false,
      // specialtyNum:0,
resultProjectDescription:'',
resultResponsibility:'',
//控制弹出层显示
popuplevelVisible:false,
popupprojectEndTimeVisible:false,
popupPositionVisible:false,

//项目经验
      specialty:{
        proficiency:'',
        skillNum:'',
                 saveFlag:'local',
      },
  


      yearSlot: [{
          flex: 1,
          values: ['精通', '熟练', '熟悉', '了解'],
          className: 'slot1'
        }],
        lastYearSlot: [{
          flex: 1,
          values: ['精通', '熟练', '熟悉', '了解'],
          className: 'slot1'
        }],
      
    };
  },
 components: {
DatetimePicker,Picker,Popup
 },
  computed:{
      
},
  methods: {
  jumpNext(){
  this.$router.push("page7")
  },

// 开关控制器
// popuplevelVisible:false,
// popupprojectEndTimeVisible:false,
// popupAddressVisible:false,


    //时间
determine(){
this.popuplevelVisible=false
},
cancel(){
this.popuplevelVisible=false;
this.specialty.proficiency='';
},
level(){
this.popuplevelVisible=true;
},
onChangeadmission(picker, values) {
this.specialty.proficiency = values[0];
},



determineBackground(){
this.popupPositionVisible=false
},
cancelBackground(){
this.popupPositionVisible=false;
this.specialty.Position='';
},
Position(){
this.popupPositionVisible=true;
},
onChangebackground(picker, values) {
this.specialty.trade = values[0];
},

 addList(){
    $(".texthint").css("display","block");

  let edu=this.specialty;
  let enter=3;
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
                    this.$http.post('/personCredit/person/personSkill.do',this.specialty)
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

  let edu=this.specialty;
  let enter=3;
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
 this.specialty.saveFlag='block'
Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                   
    // var user = JSON.parse(JSON.stringify(this.specialty));  
    //  user.gender=this.genderMF;

                     this.$http.post('/personCredit/person/personSkill.do',this.specialty)
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

  let edu=this.specialty;
  let enter=3;
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
                    this.$http.post('/personCredit/person/personSkill.do',this.specialty)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          
                     this.$router.push('page16')
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

   this.specialty.proficiency=''
   this.specialty.skillNum=''
   

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