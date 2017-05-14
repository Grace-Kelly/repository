<template>
  <!-- v-nav-title="page19" -->
<div class="page19">
<mt-header class="mint-header " v-if="!userLogin" title="企业注册">
</mt-header>
<mt-header class="mint-header " v-if="userLogin" title="企业登录">
</mt-header>
<main>
    <div class="mui-content ">
      <div class="mui-col-xs-12 mui-text-center">
          <div class="avatars">
            <img src="../../../static/img/pic.png">
          </div>
          <div class="userLogin mui-col-xs-12" v-if="!userLogin">
         <div class="list-input">
              <p class="iconfont icon-iconfont"> </p>
              <input v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.companyNo"  placeholder="请输入营业执照名称">
          </div>
          <div class="list-input">
              <p class="iconfont icon-iconfont"> </p>
              <input v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.personNo"  placeholder="请输入用户名">
          </div>
          <div class="list-input">
              <p class="iconfont icon-mima"></p>
              <input type="password" v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.passwd" placeholder="请设置密码">
          </div>
          <div class="list-input">
              <p class="iconfont icon-mima"></p>
              <input type="password" v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.userRePwd" placeholder="请确认密码">
          </div>
          <div class="list-input btn-logon" @click="logon">
              <div class="div">注册</div>
          </div>
          <div >
            <p class="alreadyHave"> <span @click="changeLogin" > 已有账号？<span class="f14 fc">登录</span></span> </p> 
          </div>
          </div>

          <div class="userLogin mui-col-xs-12" v-if="userLogin">
<div class="list-input">
              <p class="iconfont icon-iconfont"> </p>
              <input v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.companyNo"  placeholder="请输入营业执照名称">
          </div>
          <div class="list-input">
              <p class="iconfont icon-iconfont"> </p>
              <input v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.personNo"  placeholder="请输入用户名">
          </div>

          <div class="list-input">
              <p class="iconfont icon-mima"></p>
              <input  id="password" type="password" v-on:focus="vnFocus" v-on:blur="vnBlur" v-model="user.passwd" placeholder="请输入密码">
              <span @click='gotoPage("page10")' class="forgetPassword">忘记密码>></span>
          </div>
          <div class="list-input btn-logon" @click="login">
              <div class="div">登录</div>
          </div>
          <div>
            <p class="alreadyHave">  <span @click="changeLogon"> 没有账号？<span  class="f14 fc">注册</span></span> </p> 
          </div>
          </div>
      </div>
    </div>

</main>
<footer v-if="footer">
    <div class="copy-right">
            <div class="cont-bot">
                <a href="javascript:;" >注册／登录即代表同意《人才征信服务平台协议》</a>
            </div>
    </div>
    <div class="switching" @click='gotoPage("page19")'>
      切换个人
    </div>
</footer>

</div>
    

</template>
<script>
import { Toast,MessageBox,Header,Indicator} from 'mint-ui';
  let vm;
  export default {
   
    data() {
      return {
        footer:true,
        userLogin:true,
        user:{
            companyNo:'',
            personNo:'',
            passwd:'',
            userRePwd:"",
        },
       
 
        msg: 'ajax接口测试',
        list: []
      };
    },
    computed: {

   
    
    },
    created: function () {
      vm = this;
    },
    components: {
      Toast
    },  
    props:[
      "text",
    ],
    methods: {
       vnFocus(){
        this.footer=false;
      },
      gotoPage(e){
        this.$router.push(e)
      },
      vnBlur(){
        this.footer=true;
      },
      changeLogin(){
        this.userLogin=true;
      },
      changeLogon(){
        this.userLogin=false;
      },

      //登录
      login(){
        var el=event.currentTarget;
        $(el).addClass("btnActive")
        setTimeout(()=>{ $(el).removeClass("btnActive")},200)
        let phoneNumber = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/;
     let isIDCard1=/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/;
     let isIDCard2=/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
     let isPassword= /^[A-Za-z0-9]{6,16}$/;

        if (!this.user.personNo) {
             let instance = Toast('用户名不能为空');
              setTimeout(() => {
                instance.close();
              }, 1500);
               return false;
           }
          if (!this.user.passwd) {
                   let instance = Toast('密码不能为空');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;
          }
         if (!isPassword.test(this.user.passwd)) {
                   let instance = Toast('密码6-16位数字或字符串');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;
          }else{
            console.log("成功")
            Indicator.open();
            let user =new Object;
            user.companyNo=this.user.companyNo;
            user.personNo=this.user.personNo;
            user.passwd=this.user.passwd;
            user = JSON.stringify(this.user);
            console.log(user);
            this.$http.options.xhr = { withCredentials: true }
            this.$http.post('/personCredit/companyAdmin/companyLogin.do',user)
                  .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
                      
this.$store.commit("updateCompanyNo",this.user.companyNo)
console.log(this.$store.state.companyNo)
this.$store.commit("updatePersonNo",this.user.personNo)
console.log(res.body.status_auth)
if((res.body.status_auth=='1')){
this.$router.push('page20')
}else{
    MessageBox.confirm('前往添加认证','认证提').then(
                          action=>{
                          console.log('确认')
                          this.$router.push('page21')
                          },
                          action=>{
                          console.log('取消')
                          this.$router.push('page20')
                          }
                          );
}

                        console.log("=================")
                    }else{
                      Indicator.close()
                      console.log(res.body.status)
                      console.log(res.body.msg)
                        MessageBox.confirm(res.body.msg,'错误提示').then(
                            action=>{
                            console.log('确认')
                            // this.$router.push('page21')
                            },
                            action=>{
                            console.log('取消')
                            //  this.$router.push('page20')
                            }
                            );
                    }
                  // commit(‘updateOrderList’,res.data.list)
                },(err)=>{
                  Indicator.close()
                     console.log("错误")
                      MessageBox('提示', '服务器繁忙');
                 })
            // MessageBox.confirm('前往添加认证','认证提示').then(
            // action=>{
            // console.log('确认')
            // this.$router.push('page21')
            // },
            // action=>{
            // console.log('取消')
            //  this.$router.push('page20')
            // }
            // );



          }
      },

      logon(){
         var el=event.currentTarget;
        $(el).addClass("btnActive")
        setTimeout(()=>{ $(el).removeClass("btnActive")},200)
        //测试  
        
     let phoneNumber = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/;
     let isIDCard1=/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/;
     let isIDCard2=/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
     let isPassword= /^[A-Za-z0-9]{6,16}$/;
           if (!this.user.companyNo) {
             let instance = Toast('营业执照名称不能为空');
              setTimeout(() => {
                instance.close();
              }, 1500);
               return false;
           }
        if (!this.user.personNo) {
             let instance = Toast('用户名不能为空');
              setTimeout(() => {
                instance.close();
              }, 1500);
               return false;
           }
          if(!this.user.passwd){
                   let instance = Toast('密码不能为空');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false; 
          }
         if (!isPassword.test(this.user.passwd)) {
                   let instance = Toast('密码6-16位数字或字符串');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;    
          }
         if (this.user.userRePwd!==this.user.passwd) {
                   let instance = Toast('密码输入不一致');
                    setTimeout(() => {
                      instance.close();
                    }, 1500);
                    return false;    
          }else{
Indicator.open();
 // 注册
 
   let user =new Object;
   user.companyNo=this.user.companyNo;
   user.personNo=this.user.personNo;
   user.passwd=this.user.passwd;
   let companyRegrister = JSON.stringify(user);
              this.$http.post('/personCredit/companyAdmin/companyRegrister.do',companyRegrister)
                  .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
// sessionStorage.state=this.user.personNo;
                        MessageBox.confirm('注册成功,前往登录','提示').then(
                          action=>{
                          console.log('确认')
                    //  sessionStorage.company=this.user.companyNo;     
this.$store.commit("updateCompanyNo",this.user.companyNo)
                          this.user.companyNo='',
                          this.user.personNo='',
                          this.user.passwd='',
                          this.changeLogin();

                          // this.$router.push('page21')
                          },
                          action=>{
                          console.log('取消')
                          this.$router.push('page20')
                          }
                          );
                        console.log(res.body.status)
                    }else{
                      Indicator.close()
                      console.log(res.body.status)
                      console.log(res.body.msg)
                        MessageBox.confirm(res.body.msg,'错误提示').then(
                            action=>{
                            console.log('确认')
                            // this.$router.push('page21')
                            },
                            action=>{
                            console.log('取消')
                            //  this.$router.push('page20')
                            console.log(this.user.passwd)
                            console.log(this.user.userRePwd)

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
},
      startHacking() {
        // this.$bus.$emit('change-abc', 1);
        //
        // this.$bus.$on('change-abc', function() {
        // });
        this.$store.dispatch('getProvince');
        console.log(this.$store)
        console.log(this.$store.dispatch)
        console.log(this.$store.getters.xx)
        console.log(this.$store.commit('yy'))
        this.$http.get('https://rec.its.sustc.edu.cn/Api/province?token=b9ffKpohkOff0JX615LHCMBba3e8T8tGclQ8nNGR6HcRTxShf9').then((response) => {
          // success callback
          console.log(response);
          console.log(this);
          vm.List = response.body.data;
          console.log(vm.list);
        }, (response) => {
          // error callback
          // console.log(response);
        });
      },
      setList(content) {
        this.list = content;
      }
    },
    mounted () {
//  if(!sessionStorage.state){
      //    this.$router.push("page20")
      //  }
      //  Indicator.open();
      //   setTimeout(() => Indicator.close(), 2000);thi
   
// user[2].pop();
// var haha=user.splice(0,1);
    
  
  // console.log(user)
    }
  };
</script>

<style lang="scss" scoped>
.switching{
  height: 40px;
  line-height: 40px;
  background: #F8F8F8; 
  color: #444444;
  text-align: center;
}

footer {
    width: 100%;
display: block;
position: fixed;
height: auto;
left: 0;
right: 0;
bottom: 0;
}
.btnActive{
  background-color: #FF7F3C!important;
  color: #fff!important;
  border: #E46F31;
}

.mui-content{
  background: transparent;
  div{
    background: transparent;
  
    
  }
}

main {
display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 75px;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
background-image: url(../../../static/img/bgimg.png);
  // background-size: 100% 100%;
  background-position: center center;
}


.page19{
  height   : 100%;
    .mui-bar{
        background-color: #FF6600;
    }
    .mui-bar-nav a , .mui-bar-nav h1{
        color:#fff;
        font-weight: 300;
        font-size: 1.7rem;
    }
input::-webkit-input-placeholder,
textarea::-webkit-input-placeholder {
  font-weight: 0;
  font-size: 1.4rem;
  font-weight: 300;
  color: #AFAFAF;
}
    .avatars{
      display: inline-block;
      width: 100px;
      height: 100px;
      margin: 40px auto;
      border-radius: 50px;
      background-color: #444;
      img{
        width: 100%;
      }
    }
    .list-input{
      display: inline-block;
      line-height: 42 px;
      white-space: nowrap;
      overflow: hidden;
      width: 80%;
      height: 42px;
      margin-bottom: 5px;
      padding: 0 15px;
      -webkit-user-select: text;
      border: 1px solid #EEEEEE;
      border-radius: 25px;
      outline: 0;
      background-color: #fff;
      -webkit-appearance: none;
    
        input{
          font-size: 14px;
          line-height: 1;
          padding: 13px 5px!important;
            vertical-align: top;
            -webkit-user-select: text;
            border:transparent;
            border-radius: 3px;
            outline: 0;
            width: 85%;
            overflow: hidden;
            background-color: #fff;
            -webkit-appearance: none;
          
            text-align: left;
        }
        p{
            display: inline-block;
            line-height: 42px;
            height: 42px;
            color: #dddddd;
            margin-bottom: 0;
            width: 15%;
            overflow: hidden;
            font-size: 2.6rem;
        }
        #password{
          width: 55%;
        }
        .forgetPassword{
            display: inline-block;
            font-family:'PingFang Regular';
            font-size: 1.4rem;
            text-align: left;
            font-weight: 100;
            line-height: 40px;
            vertical-align: top;
            color: #C9C9C9;
          width: 30%;
        }
        
    }
      .btn-logon{
        margin-top: 20px;
        background: #F6F6F6;
        border: 1px solid #DDDDDD;
        line-height: 40px;
        font-size: 14px;
        color: #AFAFAF;
        letter-spacing: -0.34px; 
      }
    .alreadyHave{
      width: 90%;
      margin: 0;
          text-align: right;
          line-height: 30px;
          height: 30px;
          span{
            display: inline-block;  
            font-size: 14px;
            height: 30px;
            letter-spacing: -0.34px;
            line-height: 30px;
          }
    }
}





.copy-right{

width: 100%;
.cont-bot{
    border-bottom: 1px solid #DDDDDD;
            display:block;
            line-height: 25px;
            text-align: center;
            font-size: 12px;
            color: #C9C9C9;
            a {
              color: #C9C9C9;
          }
        }
}

       
</style>