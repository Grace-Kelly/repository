<template>
<div class="pagePersonal">
     <mt-header class="mint-header is-fixed" title="简历上传">

<router-link to="/page20" slot="left">

<mt-button icon="back"></mt-button>

</router-link>

</mt-header>
<main>
<div class="mui-content bgc0">
<p class="topHint">目前只能上传zip格式的压缩包</p>

<div class="upLoad-box">
<div>
<span  v-if="upLoad" >
    +
</span>

<p  v-if="upLoad">上传简历</p>
<span v-if='!upLoad' class="mui-icon mui-icon-compose" >
    
</span>
<p  v-if='!upLoad' class="textUploadName">{{uploadName}}</p>
 <form id="selectBtnForm" enctype="multipart/form-data" >
    <input type="file" placeholder="" class="upload" name="fileInput" @change="fileChanged1" id="fileInput">
</form>

<!--<div>
<form enctype="multipart/form-data">
<input type="file" id="haha" onchange="haha(event)" >
</form>
</div>-->




</div>
</div>

<div class="mui-xs-col-12 mui-text-center">
      <div @click='uploadFile' class="list-input btn-logon mui-text-center" >
              <div class="div">上传</div>
          </div>
</div>

<div style="position:relative">
   <div class="page-progress-wrapper">
      <mt-progress :value="value" v-if="progressVisible" transition="progress-fade">
        <div slot="end">{{ value }}%</div>
      </mt-progress>
    </div>
</div>

</div>
</main>
   




</div>
</template>
<script>

import { Toast,Popup,Picker,DatetimePicker,MessageBox,Progress,Indicator } from 'mint-ui';
export default {
  name: 'page13',
  data() {
  
    return {
      uploadName:'',
      file:{},
code:{
  id:''
},
        upLoad:true,
        progressVisible: false,
        value: 0,
        uploading: false,
        timer: null,
        personal:{
            imgs:[]
        }

      
    };
  },
 components: {
     MessageBox
 },
  methods: {


fileChanged1(event) {
  console.log(1)
     var fileName, imgSrc;
    var files = event.target.files;
    console.log(files);
    
         var fileName = files[0].name;
         this.uploadName=fileName;
    if (files[0]) {
      var extStart = files[0].name.lastIndexOf(".");
      var ext = files[0].name.substring(extStart, files[0].name.length).toUpperCase();
      if (ext != ".ZIP" ) {
        // alert("仅限上传文件(zip , doc)格式！");
        MessageBox('提示', "仅限上传文件( zip)格式！");
        return false;
      }
      if (files[0].size > 5 * 1024 * 1024) {
        // alert("上传文件大小不能超过5M！");
         MessageBox('提示', "上传文件大小不能超过5M！");
        return false;
      }
      
      else{
   

         var fileName = files[0].name;
          this.file=files[0]
         this.upLoad=false;
//  this.file=file
 console.log(this.file)
        //  const formData = new FormData()
        //  formData.append('file', file)
        //  formData.append('id', this.code.id)
        


        
      // this.$http.post('/personCredit/companyAdmin/resumeAnalysis.do',formData).then((res)=>{
      //   console.log(res.body.json.parse())
      
      // }).then((res)=>{})
      //  console.log("_________________")

      }

    }
  },
// 
   
gotoPage(e){
this.$router.push(e)
},

uploadFile() {
        if (!this.upLoad) {
          // console.log(this.upLoad)
          // this.value = 0;
          // this.progressVisible = true;
          // this.uploading = true;
          // this.timer = setInterval(() => this.value++, 10);
          
console.log(this.file)

  const formData = new FormData()
  formData.append('file', this.file)

Indicator.open()
     
this.$http.post('/personCredit/companyAdmin/resumeupload.do',formData)
.then((res)=>{
Indicator.close()
if(res.body.status=='ok'){
// console.log(res.body.data)
let instance = Toast('上传成功');

this.uploadName='';
this.upLoad=true;
setTimeout(() => {
instance.close();
}, 1000);

setTimeout(() => {
this.$router.push("page20");
}, 1200);
// var list=JSON.parse(JSON.stringify(res.body.data));


// $store.commit("updateFactList",list)

// console.log(this.$store.state.factList)

        // res.body.data
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
console.log("=================")
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
// 
   

}else{
          MessageBox('提示', '请选择文件');
        }
      },
},

  watch: {
value(val) {
        if (val >= 100) {
          this.uploading = false;
          this.progressVisible = false;
          setTimeout(() => Toast({ message: '上传成功', position: 'bottom', duration: 1000 }), 200);
          clearTimeout(this.timer);

          setTimeout(() => this.submit(), 800);
          setTimeout(() => this.$router.push('page2'), 1200);
         
        }
  }
  },
  mounted () {
console.log("加载完成page13")

 this.uploadName='';

this.upLoad=true;


// var hahaha=JSON.parse(JSON.stringify(haha));
// console.log(hahaha);
  },

};
</script>

<style lang="scss" scoped>
.textUploadName{
   width: 100%;
    text-align: center;
    overflow: hidden;
    -webkit-line-clamp: 2;
    text-overflow: ellipsis;
   
   
}
.extra-input{
  border:none!important;
  border-bottom:1px solid #EEEEEE!important;
  border-radius: 0!important;
 
}
 .mt-progress {
        width: 80%;
        position: absolute;
        left: 50%;
        transform: translateX(-50%);
        top: 5px;
        // #FF7C00
      }
       .mt-progress{
         .mt-progress-progress {
    background-color: #FF7C00!important;
}
       }


.topHint{
    background: #FFE56A;
    font-size: 1.2rem;
    height: 34px;
    line-height: 34px;
    padding-left: 20px;
    color:#F19F17;
    margin-bottom: 0px;
}
.upLoad-box{
      padding-left: 10px;
      display: block;
    width: 100%;
  

      div{
          text-align: center;
            position: relative;
          #selectBtnForm{
            position:absolute;
            z-index: 10;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            input{
              width: 100%;
              height: 148px;
              color: transparent;
              opacity: 0;
            }
          }
          span{
              margin-top: 40px;
            display: inline-block;
            width: 30px;
            line-height: 25px;
            height: 30px;
            border-radius: 15px;
            margin-bottom: 10px;
            color: #F6A623;
            border: 1px solid  #F6A623;
          }
          p{
            color:  #4A4A4A;
            font-size: 1.4rem;
          }
display: inline-block;
background-color: #F9F9F9;
width: 40%;
height: 150px;
margin-left: 10px;
margin-bottom: 20px;
margin-top: 20px;
border: 1px solid #eee;
border-radius: 10px;
      }
}
  .btn-logon{
        margin-top: 20px;
        background: #FF7C00!important;
        color: #fff!important;
        border: 1px solid #DDDDDD;
        line-height: 40px;
        font-size: 14px;
        color: #AFAFAF;
        letter-spacing: -0.34px; 
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
            line-height: 40px;
            height: 40px;
            vertical-align: top;
            padding: 0 5px;
            -webkit-user-select: text;
            border:transparent;
            border-radius: 3px;
            outline: 0;
            width: 85%;
            overflow: hidden;
            background-color: #fff;
            -webkit-appearance: none;
            font-size: 1.7rem;
          
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
.showList{ 
display: none;

}
.showList:last-child{
  display: block;

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
.personal-form  {
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
.child-view {
 transition                                : all 0.3s cubic-bezier(0,1,.4,1);
    height                                 : 100%;
}
 
.slide-left-enter,
.slide-right-leave-active {
    opacity                                : 0.25;
    -webkit-transform                      : translate(100%, 0);
    transform                              : translate(100%, 0);
}
.slide-left-leave-active,
.slide-right-enter {
    opacity                                : 0.25;
    -webkit-transform                      : translate(-100%, 0);
    transform                              : translate(-100%, 0);
}
</style>