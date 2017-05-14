<template>
<div class="pagePersonal">
<mt-header class='mint-header ' title="人才征信">
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
            <div class="userState" >
                <!--<p> &nbsp; 1233434231</p>-->
                <p> &nbsp;<span>&nbsp;{{this.$store.state.companyNo}}</span> </p>
                <p v-if="this.$store.state.status_auth"> &nbsp;<span>&nbsp;{{this.$store.state.companyNo}}</span> </p>
                <p v-if="!this.$store.state.status_auth">&nbsp;<span>&nbsp;{{this.$store.state.personNo}}</span> </p>
            </div>
  
            <div class="entrance">
               <span>设置</span>
            </div>
           </div>
<ul class="mui-table-view mui-grid-view mui-grid-9">
		            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4">
                  <a @click='gotoPage("page21")' href="javascript:;">
		                    <span class="iconfont icon-jianli f24" style="color:#FF7C00"></span>
		                    <div class="mui-media-body">企业认证</div>
                  </a>
                </li>
                 <li @click='gotoPage("page23")' class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4"><a href="javascript:;">
		                    <span class="iconfont icon-toupiaotiaocha f24" style="color:#34BDBA"></span>
		                    <div class="mui-media-body">简历辩伪</div></a>
                </li>
		            <li @click='gotoPage("page20")' class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4"><a href="javascript:;">
		                    <span class="iconfont icon-bianwei f24" style="color:#60A7DF"></span>
		                    <div class="mui-media-body">申请背调</div></a>
                </li>
		           
		            <li  @click='gotoPage("page13")'class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4"><a href="javascript:;">
		                    <span class="iconfont icon-icon3 f24" style="color:#8DA906"></span>
		                    <div class="mui-media-body">上传简历</div></a>
                </li>
                 <li  @click='gotoPage("page20")'class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4"><a href="javascript:;">
		                    <span class="iconfont icon-bianwei f24" style="color:#34BDBA"></span>
		                    <div class="mui-media-body">加证</div></a>
                </li>
		            <li  @click='gotoPage("page20")'class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-4"><a href="javascript:;">
		                    <span class="iconfont icon-icon3 f24" style="color:#8DA906"></span>
		                    <div class="mui-media-body">套餐介绍</div></a>
                </li>
		           
		     
		        </ul>

               </div>   
  </main>

<mt-tabbar v-model="selected" fixed>
  <mt-tab-item id="首页" class="navSelected">
    <img slot="icon" src="./../../../static/img/shouye.png">
    首页
  </mt-tab-item>

  <mt-tab-item id="我的" class="navSelected">
    <img slot="icon" src="./../../../static/img/shouye.png">
    我的
  </mt-tab-item>
 
</mt-tabbar>
</div>
</template>
<script>
import { Tabbar, TabItem } from 'mint-ui';


import {Header} from 'mint-ui';
export default {
  name: 'page20',
  data() {
    return {
        selected: '首页'
    }
  },
 components: {

 },
  methods: {
   gotoPage(e){
        this.$router.push(e)
      }
  },
  watch: {
    selected:function(newval,oldval){
  if(this.selected=='我的'){
    this.$router.push("page22")
  }
  //  if(this.selected=='通讯录'){
  //   this.$router.push("page8")
  // }
  //  if(this.selected=='首页'){
  //   this.$router.push("page2")
  // }
}
  },
  mounted () {
    this.selected='首页'
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
bottom: 55px;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
background-color: #fff;
.mui-grid-view.mui-grid-9 {
    background-color: transparent;
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
      width: 52%;
       float: left;
      height: 100px;
  p{
    width: 100%;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    height: 30px;
    line-height: 30px;
    margin: 0;
      font-size: 1.6rem;
      color: #FFFFFF;
     
      span{
        font-size: 1.6rem;
        color: #FFDDC6;
       
      }
    }
    p:first-child{
      margin-top: 20px;
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