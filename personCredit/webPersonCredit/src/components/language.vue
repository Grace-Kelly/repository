<template>
<div class="language">
           <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                    
                  <div class="language-form  animated fadeInRightBig">
             <div class="list-box"> 
                        <div class="list-input">
                            <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">所学语言</span> </p> 
                            <span @click="jumpNext" class="fr f15 fcGrey">若无所学语言,<a class="f15">保存提交</a> </span>  
                        </div>
                        </div>
                      <div>

                        <div class="list-box">
                          <div class="list-input" @click="date">
                              <p class=""><span class="fcRed f14">* &nbsp; </span>语言名称</p>
                              <input  disabled   v-model="language.date"  placeholder="请选择>">
                          </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!language.date">
                            语言名称不能为空
                          </div>
                        </div>
                           <div class="list-box">
                       <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>语言证书</p>
                            <input class="verification"  v-model="language.languageNumber" placeholder="填写编号或图片">
                            <p class="verificationCode">选择证书</p>
                            <input class="verificationInput" @change='add_img' placeholder="选择照片" type="file">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!language.imgs">
                            语言证书不能为空
                          </div>
                        </div>
                        <div class='finish_room'>
  	
  	   <div class='finish_room2'>
       	   <div v-for='(item ,index ) in language.imgs' class='room_img'>
       	   	  <img :src="item">
       	   	  <span @click='delete_img(index)'><img src="./../../static/img/delete.png"></span>
       	   </div>
       </div>
  </div>
                    </div>
                        <div class="mui-text-center mui-col-xs-12 wsnrp mgt20">
                           <div @click="addList" class="bgc0 bd btn-next fc1 mui-col-xs-5 dib">增加语言</div>
                           <div @click="nextList" class="bgc btn-next fc0 mui-col-xs-5 dib">提交</div>
                        </div>
                   </div>





<mt-popup v-model="popupprojectEndTimeVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelGraduation' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineGraduation' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangegraduation" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<mt-popup v-model="popupdateVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determine' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangeadmission" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>
</div>



</div>
</template>
<script>
import { Popup,Picker,DatetimePicker,Toast,MessageBox } from 'mint-ui';

export default {
  name: 'language',
  data() {
    return {
      popupVisible2: false,
      // languageNum:0,
resultProjectDescription:'',
resultResponsibility:'',
//控制弹出层显示
popupdateVisible:false,
popupprojectEndTimeVisible:false,
popupPositionVisible:false,

//项目经验
      language:{

        imgs:[],
        languageNumber:'',
        languageName:'',
      },
      yearSlot: [{
          flex: 1,
          values: ['英语','德语','日语', '法语'],
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
  MessageBox.confirm('简历录入完成，确认提交后将不可修改！','')
.then(
action=>{
console.log('取消')
   this.$router.push('page2')
},
action=>{
console.log('确认')
this.$router.push('page2')
}
);
  },

// 开关控制器
// popupdateVisible:false,
// popupprojectEndTimeVisible:false,
// popupAddressVisible:false,
  delete_img(item){
               this.language.imgs.splice(item,1);
		 	  },

    //时间
determine(){
this.popupdateVisible=false
},
cancel(){
this.popupdateVisible=false;
this.language.date='';
},
date(){
this.popupdateVisible=true;
},
onChangeadmission(picker, values) {
this.language.date = values[0];
},

determineGraduation(){
this.popupprojectEndTimeVisible=false
},
cancelGraduation(){
this.popupprojectEndTimeVisible=false;
this.language.projectEndTime='';
},
projectEndTime(){
this.popupprojectEndTimeVisible=true;
},
onChangegraduation(picker, values) {
this.language.projectEndTime = values[0];
},


determineBackground(){
this.popupPositionVisible=false
},
cancelBackground(){
this.popupPositionVisible=false;
this.language.Position='';
},
Position(){
this.popupPositionVisible=true;
},
onChangebackground(picker, values) {
this.language.trade = values[0];
},
addList(){
  $(".texthint").css("display","block");

  let edu=this.language;
  let enter=4;
          for(var key in edu){
            if((edu[key])){
               enter-=1; 
               
                
            }
          }
          if(!enter){
         
       
                 
            this.$store.commit("addEducation")
      
          }
          if(enter==1){
            if(this.language.imgs.length){
                 console.log(1)
            this.$store.commit("addEducation")
          }
         
          }
         
 
},
nextList(){
    $(".texthint").css("display","block");

  let edu=this.language;
  let enter=4;
          for(var key in edu){
            if((edu[key])){
               enter-=1; 
               
                
            }
          }
          if(!enter){
         
       
                 
MessageBox.confirm('简历录入提交后不可再修改，只可新增加某些功能！','')
.then(
action=>{
console.log('确认')
   this.$router.push('page2')
},
action=>{
console.log('取消')
}
);
          
      
          }
          if(enter==1){
            if(this.language.imgs.length){
                 console.log(1)
            MessageBox.confirm('简历录入提交后不可再修改，只可新增加某些功能！','')
.then(
action=>{
console.log('确认')
   this.$router.push('page2')
},
action=>{
console.log('取消')
}
);
          }
         
          }    
        
},
  add_img(event){
           if(this.language.imgs.length>0){
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
                that.language.imgs.push(reader.result)
              }
           }
            
                  
		 	  },



  },
  watch: {

  },
  mounted () {
// 添加次数
// if(this.languageNum==0){
//   this.languageNum= this.$store.state.educationList;
// }
console.log(this.language.imgs.length)
        this.language.date='',
        this.language.languageName=''
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
.top-form ,.language-form{
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