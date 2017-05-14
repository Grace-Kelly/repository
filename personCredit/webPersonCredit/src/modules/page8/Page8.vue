<template>
<div class="pagePersonal">
     <mt-header class="mint-header is-fixed" title="消息">

<router-link to="/page2" slot="left">
<mt-button icon="back"></mt-button>
</router-link>

</mt-header>
<main>
         <div class="mui-content bgc0">
          <div @click="certifier"  size="large" class="certifierList" v-for="item in 6">
            <div class="certifierItem">
              <div class="certifierAvatar">
                <img src="./../../../static/img/pic.png">
              </div>
              <div class="certifierInformatization">
                <div>
                  <span class="certifierClass mui-text-left">工作经验加证</span>
                  <span class="certifierIntroduce mui-text-right">2017.04.21</span>
                </div>
                <p class="mui-text-left">简历真假凭证你说了算，快来帮忙加证下。</p>
              </div>
            </div>
          </div>
         </div>

</main>



</div>
</template>
<script>
 import { MessageBox } from 'mint-ui';
export default {
  name: 'page8',
  data() {
    return {
         selected: '通讯录'
        // certifier:[{

        // },{

        // }]
    };
  },
 components: {
MessageBox
 },
  methods: {
   certifier(){

MessageBox.confirm('请按真实情况进行加证！一旦评价后就永不可修改','认证提示')
.then(
action=>{
console.log('确认')
},
action=>{
console.log('取消')
}
);
   },

  },
 watch: {
selected:function(newval,oldval){
  if(this.selected=='首页'){
    this.selected=='首页'
    this.$router.push("page2")
  }
   if(this.selected=='通讯录'){
    //  this.selected=='通讯录'
   
    this.$router.push("page8")
  }
  //  if(this.selected=='首页'){
  //   this.$router.push("page2")
  // }
}
  },
  mounted () {
console.log("加载完成page8")
this.selected='通讯录'
  },
};
</script>

<style lang="scss" scoped>
.mint-tabbar > .mint-tab-item.is-selected{
    background-color: transparent;
    color: #FF6600;
}
 a {
    text-decoration: none;
    color: #fff;
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
.certifierList{

  .certifierItem{
      display: block;
      overflow: hidden;
      margin: 25px 15px 0;
      border-bottom: 1px solid #EEEEEE;
    .certifierAvatar{

      width: 65px;
      height: 65px;
      float: left;
      border-radius: 40px;
      background-color: #444444;
      margin-bottom: 25px;
      margin-right: 10px;
      img{
          width: 100%;
          height: auto;
      }
    }
    .certifierInformatization{
      max-width: 72%;
      overflow: hidden;
      white-space: nowrap;
      float: left;
      height: 65px;
      div{
        margin-top: 5px;
      height: 30px;
        overflow: hidden;
       .certifierClass{
      font-size: 1.6rem;
      float: left;
      line-height: 30px;
      color: #444444;
      letter-spacing: -0.39px;
      }
      .certifierIntroduce{
        float: right;
        line-height: 30px;
          font-size: 1.4rem;
          color: #999999;
          letter-spacing: -0.34px;
          text-overflow: ellipsis;
      }
      }
     
      p{

      display: block;
      margin-bottom: 0;
      line-height: 25px;
      line-height: 25px;
         overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
          font-size: 1.4rem;
          color: #999999;
          letter-spacing: -0.39px;
    }
    }
@media (min-width:375px){.certifierInformatization{ width: 75%;}}
@media (min-width:414px){.certifierInformatization{  width: 78%;}}
@media (min-width:521px){.certifierInformatization{ width: 90%;}}
// @media screen and (min-width:415px) and (max-width:639px){html{font-size:12px}}
// @media screen and (min-width:640px) and (max-width:719px){html{font-size:12px}}
// @media screen and (min-width:720px){html{font-size:16px}}
// @media screen and (min-width:750px) and (max-width:799px){html{font-size:16px!important}}

    
  }
}




.showList{ 
display: none;

}
.showList:last-child{
  display: block;

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