<template>
<div class="authentication">
<mt-header class="mint-header is-fixed" title="修改手机号码">
  <router-link to="/page2" slot="left">
  <!--<mt-button icon="back">返回</mt-button>-->
  <mt-button >取消</mt-button>
  </router-link>
  <mt-button @click='save' slot="right">保存</mt-button>
</mt-header>
<main>
    <div class="mui-content bgc0">
    
    <div class="personal-form">                  
        <p class="changeHint">修改成功后需使用新手机号码登录</p>
                       <div class="list-box">
                        <div class="list-input">
                            <p class=" ">手机号码</p>
                            <input  v-model="personal.phoneNumber"  placeholder="注册时填写的手机号码">
                        </div>
                        <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.phoneNumber">
                            手机号码不能为空
                        </div>
                        </div>
                          <div class="list-box">
                       <div class="list-input">
                            <p class=" ">验证码</p>
                            <input class="verification"  v-model="personal.seccode"  placeholder="请填写密码">
                            <button  @click="verificationCode" :disabled="time > 0"  class="verificationCode f14"> {{this.printnr}}</button>
                        </div>
                          <!--<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.seccode">
                            验证码不能为空
                          </div>-->
                        </div>
                       

       </div>
                   
 </div>

</main>
                 

 </div>          
                    











</template>
<script>
import { Toast,Popup,Picker,DatetimePicker,MessageBox } from 'mint-ui';
export default {
  name: 'changePhoneNumber',
  data() {
    return {

time:0,      
      personal:{
        uname:'',
        password:'',
        confirmpassword:'',
        idCard:'',
        phoneNumber:'',
        seccode:'',
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
        
        
        nextList(){
            $(".texthint").css("display","block");

          let edu=this.personal;
          let enter=5;
                  for(var key in edu){
                    if((edu[key])){
                      enter-=1;
                    }
                  }
                  if(!enter){

                    
                  }
        },

save(){
    $(".texthint").css("display","block");

          let edu=this.personal;
          let enter=5;
                  for(var key in edu){
                    if((edu[key])){
                      enter-=1;
                    }
                  }
                  if(!enter){

                    
                  }
     let phoneNumber = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/;
     let isIDCard1=/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/;
     let isIDCard2=/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
     let isPassword= /^[A-Za-z0-9]{6,10}$/;
        // if (!this.userName) {
        //      let instance = Toast('用户名不能为空');
        //       setTimeout(() => {
        //         instance.close();
        //       }, 1500);
        //        return false;
        //    }
       
        // if (((isIDCard1.test(this.personal.idCard)||isIDCard2.test(this.personal.idCard))===false)) {
        //            let instance = Toast('身份证格式错误');
        //             setTimeout(() => {
        //               instance.close();
        //             }, 1500);
        //             return false;
        //   }
            if (!phoneNumber.test(this.personal.phoneNumber)) {
                  let instance = Toast('手机号格式错误');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;
          }
      
          else{
            console.log("成功")
            this.$router.push('page8')
          }
      },

  },
  watch: {

  },
  mounted () {

  },


};
</script>

<style lang="scss" scoped>
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

.changeHint{
  font-size: 12px;
color: #999999;
letter-spacing: -0.29px;
padding: 5px 15px;
margin-bottom: 0;
background: #FBFBFB;
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
   	 height: 100px;
   	 margin-right: 10px;
   	 position: relative;
   	 overflow: hidden;
   }
   .finish_room2 .room_img img{
   	 
   	 width: 100%;
   	 height: 100%;
   }
   .finish_room2>.room_img span{
   	  position: absolute;
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