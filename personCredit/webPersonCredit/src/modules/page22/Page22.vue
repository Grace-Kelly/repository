<template>
<div class="pagePersonal">

<mt-header class='mint-header ' title="我的">
         <router-link to="page8" slot="right">
        <mt-button ><i style="color:#fff" class="iconfont icon-xiaoxi f24"></i></mt-button>
        </router-link>
</mt-header>
    <main >
         <div class="mui-content bgc0">
           <div class="mui-col-xs-12 userStatus">
            <div class="avatars">
              <img src="../../../static/img/pic.png">
            </div>
            <div class="userState">
                <p> &nbsp; 1233434231</p>
                <p> &nbsp;<span> &nbsp;状态：在职</span> </p>
                <p> &nbsp;<span> &nbsp;简历公开：公开</span> </p>
            </div>
            <div class="entrance">
               <span>设置</span>
            </div>
           </div>

           <div class="mui-col-xs-12">
            <div class="mineList"  >
               <div>
                 <div>
  <span class="iconfont icon-toupiaotiaocha f24">

                 </span>
                 </div>
               
               </div>
               <div>
                <p> 5</p>
                <p> 简历变伪</p>
               </div>
            </div>
            <div class="mineList">
               <div>
                 <div>
<span class="iconfont icon-bianwei f24">

                 </span>
                 </div>
                 
               </div>
               <div>
                <p> 5</p>
                <p> 背景调查</p>
               </div>
            </div>
            <div class="mineList">
               <div>
                 <div>
 <span class="iconfont icon-icon3 f24">

                 </span>
                 </div>
                
               </div>
               <div>
                <p> 5</p>
                <p> 邀请</p>
               </div>
            </div>
            <div class="mineList">
               <div>
                 <div>
<span class="iconfont icon-bianwei f24">
                 </span>
                 </div>
                 
               </div>
               <div>
                <p> 5</p>
                <p> 加证</p>
               </div>
            </div>
           </div>


      </div>   
  </main>
<nav class="mui-bar mui-bar-tab">
			<a  @click='gotoPage("page2")' href="javascript:;" class="mui-tab-item " >
				<span class="mui-icon mui-icon-home"></span>
				<span class="mui-tab-label">首页</span>
			</a>

			<a @click='gotoPage("page8")' href="javascript:;" class="mui-tab-item" >
				<span class="mui-icon mui-icon-contact"></span>
				<span class="mui-tab-label">通讯录</span>
			</a>
			<a @click='gotoPage("page22")' href="javascript:;" class="mui-tab-item mui-active" >
				<span class="mui-icon mui-icon-person"></span>
				<span class="mui-tab-label">我的</span>
			</a>
		</nav>
</div>

</template>
<script>
import { Tabbar, TabItem } from 'mint-ui';
 import chart from '../../components/chart';

import {Header} from 'mint-ui';
export default {
  name: 'page22',
  data() {
    return {
        selected: '我的'
    }
  },
 components: {
chart
 },
  methods: {
   gotoPage(e){
        this.$router.push(e)
      }
  },
  watch: {
    selected:function(newval,oldval){
  if(this.selected=='我的'){
    this.selected='我的'
   
  }
   if(this.selected=='通讯录'){
      // this.selected=='通讯录'
    this.$router.push("page8")
  }
   if(this.selected=='首页'){
     this.$router.push("page2")
      this.selected='首页'
    
  }
    }
  },
  mounted () {
 this.selected='我的'
  },

};
</script>

<style lang="scss" scoped>
.mint-tabbar > .mint-tab-item.is-selected {
    background-color: transparent;
    color: #FF6600;
}
.mint-button-text{
  color: #fff!important;
}
.mint-header-title {
font-size: 1.7rem!important;
 color: #fff!important;
}

 a {
    text-decoration: none;
    color: #000;
}

.mui-content{
  padding: 0!important;
}

main {
display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 50px;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
background-color: #fff;
.mui-grid-view.mui-grid-9 {
    background-color: transparent;
}
 .mineList:nth-child(even){
    border-left: 1px solid #E9E9E9;
  }
.mineList{
  padding: 25px 0;
  width: 50%;
  float: left;
  white-space: nowrap;
  font-size: 0;
  border-bottom: 1px solid #E9E9E9;
  
  div:first-child{
    display: inline-block;
    width: 50%;
    text-align: right;
    div{
      width: 68px;
      height: 68px;
      background-color: #F9F9F9;
      border-radius: 40px;
      text-align: center;
      border: 1px solid #ddd;
    span{
      font-size: 2.4rem;
      width: 68px;
      line-height: 68px;
     
    }
    }
    
  }
  div:last-child{
    vertical-align: top;
     height: 68px;
    display: inline-block;
    width: 50%;
    text-align: left;
    p{
        margin: 0;
        padding-left: 10px;
    }
    p:first-child{
      margin-top: 8px;
      line-height: 30px;
      font-size: 2.4rem;
    }
    p:last-child{
      line-height: 30px;
    
      font-size: 1.4rem;
    }
  }
 
}


}
    
    .pagePersonal{
      background-color: #efeff4;
    }
.userStatus{
  padding: 4% 20px;
  background-color: #FF6600;
  overflow: hidden;
  white-space: nowrap;
  .avatars{
      white-space: nowrap;
      float: left;
      width: 100px;
      height: 100px;
      border-radius: 50px;
      // background-color: #444;
      margin-bottom: 10px;
      padding-bottom: 10px;
      img{
        width: 100%;
      }
    }
    .userState{
       float: left;
      height: 100px;
  p{
    height: 24px;
    line-height: 24px;
    margin: 0;
      font-size: 1.4rem;
      color: #FFFFFF;
     
      span{
        font-size: 1.4rem;
        color: #FFDDC6;
       
      }
    }
    p:first-child{
      margin-top: 10px;
         height: 30px;
         font-size: 1.8rem;
    line-height: 30px;
     color: #FFFFFF;
    }
    }
  
    .entrance{
      margin-top: 39px;
      float: right;
      span{
        color: #FFFFFF;
        margin-right: 5px;
         font-size: 1.5rem;
      }
    }

}
.userNaver{
  white-space: normal;
  font-size: 0;
  height: 50px;
  background-color: #fff;
  div{
    display: inline-block;
    vertical-align: middle;
    width: 33%;
    height: 24px;
    margin-top: 13px;
    line-height: 24px;
    font-size: 1.4rem;
    text-align: center
  }
  .basicInformation{
    border-right: 1px solid #C7C7CC;
  }
  .overallMerit{
    border-right: 1px solid #C7C7CC;
  }
  .ResumePreview{
  }

}

.top-form ,.personal-form  {
    border-bottom:  1px solid #DDDDDD;
    margin-top: 10px;
    background-color: #fff;
      .list-personal{
        .list-title{
          margin-left: 10px;
          height: 50px;
          font-size: 1.6rem;
          line-height: 50px;
          border-bottom: 1px solid #EEEEEE;
          span{
            font-size: 1.9rem;
            line-height: 50px;
            margin-right: 5px;
          }
        }
      line-height: 50px;
      white-space: nowrap;
      overflow: hidden;
      width: 100%;
      height: 50px;
      padding-left: 15px;
      -webkit-user-select: text;
      outline: 0;
      background-color: #fff;
      -webkit-appearance: none;
       
    }
    .list-message{
      margin-left: 25px;

      height: 60px;
      .incomplete{
        text-align: left;
        margin-top: 10px;
        font-size: 1.4rem;
        line-height: 24px;
        height: 24px;
        color: #999999;
        letter-spacing: -0.34px;
      }
      .incompleteHint{
        text-align: left;
        height: 20px;
        line-height: 20px;
        font-size: 1.4rem;
        color: #D1D1D1;
        letter-spacing: -0.34px;
      }
    }

}



</style>