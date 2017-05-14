<template>
<div class="credential">
           <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                    
                  <div class="credential-form  animated fadeInRightBig">
             <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">证书</span> </p> 
                            <span @click="jumpNext" class="fr f15 fcGrey">若无证书,<a class="f15">保存提交</a> </span>  
                        </div>
                        </div>
                      <div>
                        <div class="list-box">
                        <div class="list-input" >
                            <p class="fa fa-phone"><span  class="fcRed f14">* &nbsp; </span>证书名称</p>
                         <input v-model="credential.name"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!credential.name">
                           证书名称不能为空
                          </div>
                      </div>
                      <div class="list-box">
<div class="list-input" @click="open('picker4')">
             <p class=""><span class="fcRed f14">* &nbsp; </span>发布日期</p>
                              <input  disabled   v-model="credential.certificateTime"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!credential.certificateTime">
                            熟练程度不能为空
                          </div>
                        </div>
                        <!--<div class="list-box">
                          <div class="list-input" @click="certificateTime">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>发布日期</p>
                              <input  disabled   v-model="credential.certificateTime"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!credential.certificateTime">
                            熟练程度不能为空
                          </div>
                        </div>-->
                           <div class="list-box">
                       <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>证书</p>
                            <input class="verification"  v-model="credential.certificateNum" placeholder="填写编号或图片">
                            <p class="verificationCode">选择证书</p>
                            <input class="verificationInput" @change='add_img' placeholder="选择照片" type="file">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!credential.certificateNum">
                            填写编号不能为空
                          </div>
                        </div>
                        <div class='finish_room'>
  	
  	   <div class='finish_room2'>
       	   <div v-for='(item ,index ) in imgs' class='room_img'>
       	   	  <img :src="item">
       	   	  <span @click='delete_img(index)'><img src="./../../static/img/delete.png"></span>
       	   </div>
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
</div>



</div>
</template>
<script>
import { Popup,Picker,DatetimePicker,Toast,Indicator,MessageBox } from 'mint-ui';

export default {
  name: 'credential',
  data() {
    return {
      value4: null,
      popupVisible2: false,
      // credentialNum:0,
resultProjectDescription:'',
resultResponsibility:'',
//控制弹出层显示
popupdateVisible:false,
popupprojectEndTimeVisible:false,
popupPositionVisible:false,
 imgs:[],
      credential:{
        certificateTime:'',
        certificateNum:'',
         saveFlag:'local',
        name:'',
      },
      yearSlot: [{
          flex: 1,
             values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
      
    };
  },
 components: {
DatetimePicker,Picker,Popup
 },
  computed:{
      
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
  methods: {
  jumpNext(){
  this.$router.push("page17")
  },

// 开关控制器
// popupdateVisible:false,
// popupprojectEndTimeVisible:false,
// popupAddressVisible:false,
  delete_img(item){
               this.imgs.splice(item,1);
		 	  },
open(picker) {
this.$refs[picker].open();
},
handleChange(value) {
this.credential.certificateTime=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
// Toast({
// message: '已选择 ' + value.toString(),
// position: 'bottom'
// });
},
 addList(){
    $(".texthint").css("display","block");

  let edu=this.credential;
  let enter=4;
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
                    this.$http.post('/personCredit/person/personCert.do',this.credential)
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

  let edu=this.credential;
  let enter=4;
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
 this.credential.saveFlag='block'
Indicator.open();
// var user = JSON.parse(JSON.stringify(this.personalExperience));  
// console.log(user)
// user.gender=this.genderMF;
// var savePersonInfo = JSON.stringify(user);
                    this.$http.post('/personCredit/person/personCert.do',this.credential)
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

  let edu=this.credential;
  let enter=4;
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
                    this.$http.post('/personCredit/person/personCert.do',this.credential)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          
                     this.$router.push('page17')
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
  add_img(event){
           if(this.imgs.length>0){
           MessageBox.confirm('最多只能上传一张图片').then(
                    action=>{
                      console.log('确认')
                    },
                    action=>{
                      console.log('取消')
                    }
                  );
           }else{
               var reader =new FileReader();
              var img1=event.target.files[0];

              reader.readAsDataURL(img1);
              var that=this;
              reader.onloadend=function(){
                that.imgs.push(reader.result)
              }
           }
            
                  
		 	  },



  },
  watch: {

  },
  mounted () {
// 添加次数
// if(this.credentialNum==0){
//   this.credentialNum= this.$store.state.educationList;
// }
console.log(this.imgs.length)
        this.credential.certificateTime='',
        this.credential.name=''
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
.top-form ,.credential-form{
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
        .verification{
          width: 40%;
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
         .verificationCode{
          width: 25%;
          border: none;
          border-left: 1px solid #999999;
          border-radius: 0;
          height: 24px;
          line-height: 24px;
          padding: 0;
          text-align: center!important;
          margin-top:13px; 
          text-align: right;
          color: #4990E2;
          vertical-align: top;
        }
        .verificationInput{
          width: 25%;
          position: absolute;
          color: transparent;
          right: 0;
          opacity: 0;
          border: none;
          background-color: transparent;
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
     .finish_room2{
   	 width: 100%;
   	 height: auto;
   	 padding-top: 15px;
   	 padding-bottom: 15px;
     margin-left: 5px;
   	 display: flex;
   	 align-items: center;

   }
    
   .finish_room2 .room_img{
   	 width: 50%;
   	 height: auto;
   	 margin:0 auto;
   	 position: relative;
   	 overflow: hidden;
   }
   .finish_room2 .room_img img{
   	 
   	 width: 100%;
   
   }
   .finish_room2>.room_img span{
   	  position: absolute;
   	  width: auto;
   	  height: auto;
   	  right: 5px;
   	  bottom:3px;
   }

</style>