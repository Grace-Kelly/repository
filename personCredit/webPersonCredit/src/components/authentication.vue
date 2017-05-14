<template>
<div class="authentication">
<mt-header title="实名认证">
  <router-link to="/page2" slot="left">
<mt-button icon="back"></mt-button>

  </router-link>
  <!--<mt-button @click='save' slot="right">保存</mt-button>-->
</mt-header>

<main>
         <div class="mui-content bgc0">
    <div class="personal-form">
                         <div class="list-box">
                        <div class="list-input">
                            <p class=" ">真实姓名</p>
                            <input    placeholder="请填写" v-model="personal.name">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.name">
                            真实姓名不能为空
                          </div>
                        </div>
                        <div class="list-box">
                        <div class="list-input">
                            <p class=" ">身份证</p>
                            <input  v-model="personal.identityNum"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.identityNum">
                            身份证不能为空
                          </div>
                        </div>
                             <div class="list-box">
                        <div class="list-input">
                            <p class=" ">手机号码</p>

                            <input class="verification"  v-model="personal.phoneNumber"  disabled >
                            <button   class="verificationCode f14">修改</button>
                       
                        </div>
                          
                        </div>
                          <div class="list-box">
                       <div class="list-input">
                            <p class=" ">验证码</p>
                            <input class="verification"  v-model="seccode"  placeholder="请填写">
                            <button  @click="verificationCode" :disabled="time > 0"  class="verificationCode f14"> {{this.printnr}}</button>
                        </div>
                          <!--<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.seccode">
                            验证码不能为空
                          </div>-->
                        </div>
                       <div class="list-box">
                       <div class="list-input">
                            <p class=" ">上传身份证正反面</p>
                            <input class="verification"  disabled placeholder="">
                            <p class="verificationCode" style="border-left:transparent">选择照片</p>
                            <input class="verificationInput"   @change='add_img' placeholder="" type="file">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.imgs">
                            身份证照片不能为空
                          </div>
                        </div>
<div class='finish_room'>
  	
  	   <div class='finish_room2'>
       	   <div v-for='(item ,index ) in personal.imgs' class='room_img'>
       	   	  <img :src="item">
       	   	  <span @click='delete_img(index)'><img src="./../../static/img/delete.png"></span>
       	   </div>
       </div>
  </div>
  </div>           
          <div class="btn-box">
              <div class="btn-logon" @click='save'>立即认证</div>
          </div>      
   </div>


      </main>           

 </div>          
                    
</template>
<script>
// 140106198912130619
import { Toast,Popup,Picker,DatetimePicker,MessageBox,Indicator } from 'mint-ui';
export default {
  name: 'educationExperience',
  data() {
    return {
   seccode:'',
time:0,      
      personal:{
        name:'',
        identityNum:'',
        phoneNumber:'18588270177',
     
        imgs:[]
      }
    };
  },
 components: {
    MessageBox,Toast
 },
 computed: {
            printnr() {
                return this.time > 0 ? this.time + 's' : '发送验证码'
            }
},
  methods: {
 
        doTimer:function(){
          if (this.time > 0) {
                  this.time = this.time - 1
                  setTimeout(this.doTimer, 1000)
              }
              // else{

              // }
        },

        verificationCode(){
                this.time = 60;
                        this.doTimer()
        },
        
        delete_img(item){
               this.personal.imgs.splice(item,1);
		 	  },
		 	  add_img(event){
           if(this.personal.imgs.length>1){
           MessageBox.confirm('最多只能上传两张图片').then(
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
                that.personal.imgs.push(reader.result)
              }
           }
            
                  
		 	  },

        nextList(){
            $(".texthint").css("display","block");

          let edu=this.personal;
          let enter=4;
                  for(var key in edu){
                    if((edu[key])){
                      enter-=1;
                    }
                  }
                  if(!enter){

                    
                  }
        },

save(){
       var el=event.currentTarget;
$(el).addClass("btnActive")
setTimeout(()=>{ $(el).removeClass("btnActive")},200)
    $(".texthint").css("display","block");

          let edu=this.personal;
          let enter=4;
                  for(var key in edu){
                    if((edu[key])){
                      enter-=1;
                    }
                  }
                  if(!enter){

                    
                
     let phoneNumber = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/;
    //  let isIDCard1=/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/;
     let isIDCard2=/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
     let isPassword= /^[A-Za-z0-9]{6,10}$/;
        if (!this.personal.name) {
             let instance = Toast('用户名不能为空');
              setTimeout(() => {
                instance.close();
              }, 1500);
               return false;
           }

        if (!isIDCard2.test(this.personal.identityNum)) {
                   let instance = Toast('身份证格式错误');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;
          }
          else{
console.log("成功")
Indicator.open();

var user=new Object;
user.name=this.personal.name;
user.identityNum=this.personal.identityNum;
this.$http.post('/personCredit/person/Certification.do',user)
.then((res)=>{
Indicator.close()
if(res.body.status=='ok'){
this.$store.state.formsState=true;
let instance = Toast('认证成功');
setTimeout(() => {
instance.close();
}, 1000);
setTimeout(() => {
 this.$router.push('page3')
}, 1300);
                   
                    // console.log("成功")
                    // MessageBox.confirm('是否前往录入简历','录入提示')
                    // .then(
                    // action=>{
                    // console.log('确认')
                
                    // },
                    // action=>{
                    // console.log('取消')
                    // this.$router.push('page2')
                    // }
                    // );
           
}else{
Indicator.close()
console.log(res.body.status)
console.log(res.body.msg)
MessageBox.confirm(res.body.msg,'错误提示').then(
action=>{
console.log('确认')
// this.$router.push('page9')
},
action=>{
console.log('取消')
// this.$router.push('page2')
}
);
}
// commit(‘updateOrderList’,res.data.list)
},(err)=>{
Indicator.close()
console.log("错误")
MessageBox('提示', '服务器繁忙');
})






          }


  }


      },

  },
  watch: {

  },
  mounted () {



this.$http.get('/personCredit/personCenter/showTel.do')
.then((res)=>{
  this.personal.phoneNumber=res.body.result
console.log(res.body)
console.log("=================")

// commit(‘updateOrderList’,res.data.list)
},(err)=>{
console.log("--------------")
console.log(err)
MessageBox('提示', '服务器繁忙');
})

  },


};
</script>

<style lang="scss" scoped>
.btn-box{
  margin-bottom: 20px;
  width: 100%;
  text-align: center;

}
.btn-logon{
  width: 80%;
  display: inline-block;
        margin-top: 20px;
        background: #EE702E;
        border: 1px solid #CB6028;
        border-radius: 20px;
        line-height: 40px;
        font-size: 14px;
        color: #fff;
        letter-spacing: -0.34px; 
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

.authentication{
  width: 100%;
  height: 100%;
}
 .finish_room{
		  width: 100%;
		  height: auto;
	}
.dspn{
  display: none;
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
   	 margin-right: 10px;
   	 position: relative;
   	 overflow: hidden;
   }
   .finish_room2 .room_img img{
   	 
   	 width: 100%;
   	 height: auto;
   }
   .finish_room2>.room_img span{
   	  position: absolute;
      white-space: normal; 
   	  width: auto;
   	  height: auto;
   	  right: 5px;
   	  bottom:3px;
   }
 







.btn-next{
  width: 65%;
  border-radius: 30px;
  color: #fff;
  font-size: 1.4rem;
  display: inline-block;
  line-height: 40px;
  height: 40px;
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
 input[type='file']::-webkit-input-placeholder{
          color: #4990E2;
          text-align: left;

}
.top-form ,.personal-form  {
  overflow-x: hidden;
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
        position: relative;
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


</style>