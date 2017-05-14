<template>
<div class="ux-left-sidebar" style="display:none">
  <div class="ux-tabSwitchTarget" style="display: block" id='uxTabSwitch1'>
          <p class="ux-leftTabtitle">全部页面 <span>(3)</span> </p>
        <ul class="ux-tabbox">
              <li @click="goToPage">
                <div class="ux-pageimg"></div>
                <div class="ux-pageinformation">
                    <p>page1</p>
                   <p>第一页</p>
                </div>
              </li>
              <li @click="goToPage">
                <div class="ux-pageimg"></div>
                <div class="ux-pageinformation">
                   <p>page2</p>
                   <p>第二页</p>
                </div>
              </li>
              <li @click="goToPage">
                <div class="ux-pageimg"></div>
                <div class="ux-pageinformation">
                   <p>登录</p>
                   <p>第三页</p>
                </div>
              </li>
          </ul>
  </div>
        <!--内容-->
  <div class="ux-tabSwitchTarget"  id='uxTabSwitch2'>
           <p class="ux-leftTabtitle">模块选择<span>(3)</span> </p>
     
           <ul class="ux-tabbox">
            <li >
                <a  @click="xmsOutIn('plane')">accordion(折叠面板模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">chart(图表模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">dateTime(日期模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">dialog(消息框)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
             <li >
                <a  @click="xmsOutIn('plane')">navbar(导航栏模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">pagination(分页模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
             <li >
                <a  @click="xmsOutIn('plane')">picker(选择器模块)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
          </ul>
  </div>
 <!--                        组件内容                    -->
  <div class="ux-tabSwitchTarget"  id='uxTabSwitch3'>
          <p class="ux-leftTabtitle">组件选择<span>(3)</span> </p>
           <ul class="ux-tabbox">
            <li >
                <a  @click="xmsOutIn('plane')">input(表单组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">button(按钮组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">基本按钮</p>
                    <p @click="changeRadio">圆形按钮</p>
                    <p @click="changeCheck">开关按钮</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">icon(图标组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">方向图标</p>
                    <p @click="changeRadio">文件图标</p>
                    <p @click="changeCheck">工具图标</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">range(滑块组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
             <li >
                <a  @click="xmsOutIn('plane')">switch(开关组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
            <li >
                <a  @click="xmsOutIn('plane')">typography(文字组件)</a>
                <div class="xms-close plane">
                    <p @click="changeInput">普通表单</p>
                    <p @click="changeRadio">单选框</p>
                    <p @click="changeCheck">复选框</p>
                </div>
            </li>
          </ul>

  </div>
</div>
</template>
<script>
    let uxLeftsidebar = {
        name: 'uxLeftsidebar',
        data() {
            return {
            };
        },
        methods  : {
           changeInput(){
            //    获取长宽高坐标
              let inputWidth=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).width;
              let inputHeight=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).height;
              let inputLeft=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).left;
              let inputTop=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).top;
              $("#styleHeight").val(inputHeight)
              $("#styleWidth").val(inputWidth)
              $("#styleLeft").val(inputLeft)
              $("#styleTop").val(inputTop)
              $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input objectID=${sessionStorage.objectID} maxlength='10' style="width:${inputWidth};height:${inputHeight};left:${inputLeft};top:${inputTop};position:absolute"> `);
            //   input的附加属性修改
              this.$store.commit("inputStatus")
            },
            changeRadio(){
            // //    获取长宽高坐标
              let inputLeft=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).left;
              let inputTop=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).top;
              $("#styleLeft").val(inputLeft)
              $("#styleTop").val(inputTop)
              $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input type="radio" name="sex" value="male" objectID=${sessionStorage.objectID} style="left:${inputLeft};top:${inputTop};position:absolute"> `);
            //   input的附加属性修改
              this.$store.commit("radioStatus")
            },
            changeCheck(){
            //    获取长宽高坐标
            //   let inputWidth=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).width;
            //   let inputHeight=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).height;
              let inputLeft=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).left;
              let inputTop=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).top;
            //   $("#styleHeight").val(inputHeight)
            //   $("#styleWidth").val(inputWidth)
              $("#styleLeft").val(inputLeft)
              $("#styleTop").val(inputTop)
              $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input objectID=${sessionStorage.objectID} style="width:${inputWidth};height:${inputHeight};left:${inputLeft};top:${inputTop};position:absolute"> `);
            //   input的附加属性修改
              this.$store.commit("checkStatus")
            },
            goToPage(){
                var el = event.currentTarget;
                var page = $(el).find('p:nth-of-type(1)').text();
                document.getElementById("iframe").src=`./../../../static/html/${page}.html`; 
            },    
            getStyle(ele) {
            var style = null;
            if(window.getComputedStyle) {
                style = window.getComputedStyle(ele, null);
            }else{  
                style = ele.currentStyle;
            }
            return style;
            },
            xmsOutIn(e){
                 var el = event.currentTarget;
                if($(el).next().hasClass("xms-close")){

                    $(el).next().removeClass("xms-close").addClass("xms-open").addClass("fadeTopIn");
                }
                else{

                    $(el).next().removeClass("xms-open").addClass("xms-close");
              
                }
            }
        },
        components: {
            
        },
        mounted() {
            console.log("加载完成uxLeftsidebar")
        }
    };
    export default uxLeftsidebar;
</script>
<style lang='scss' scoped>

/*                     --start-ux-left-sidebar 3--               */
#uxTabSwitch3,#uxTabSwitch2{
    .ux-leftTabtitle{
                font-size: 12px;
                width: 100%;
                color: #fff;
                height: 65px;
                text-align: center;
                line-height: 65px;
                    span{
                    font-size: 12px;
                    color: #989A9C;
                    margin-left: 5px;
                    height: 65px;
                    line-height: 65px;
                    }
    }
 .ux-tabbox{
      padding: 0 10px;
        li{
            overflow: hidden;
            cursor: pointer;
            width: 100%;
            height: auto;
      
             a{
                display: block;
                text-align: left;
                font-size: 12px;
                line-height: 55px;
                white-space: nowrap;
                text-overflow: ellipsis;
                text-decoration: none;
                color: #fff;
            }
            a:after {
                right: 15px;
                content: '\e583';
                font-family: Muiicons;
                font-size: 12px;
                line-height: 55px;
                top: 50%;
                float: right;
                display: inline-block;
                text-decoration: none;
                color: #bbb;
                -webkit-font-smoothing: antialiased;
            }
            .plane{
                position: relative;
                overflow: hidden;
                height: 0px;
                transition: all 0.3s cubic-bezier(0,1,.4,1);
                p{
                    width: 100%;
                    text-align: center;
                    font-size: 12px;
                    line-height: 40px;
                    white-space: nowrap;
                    text-overflow: ellipsis;
                    text-decoration: none;
                    background-color: #56595A;
                    color: #fff;
                    border-bottom: 1px solid #363A3C;
                }
            }
            .xms-open{
                height: auto;
                // display: block;
                -webkit-transform: translate(0, 0);
                transform        : translate(0, 0);
            }
            .xms-close{
                // display: none;
                -webkit-transform: translate(-100%, 0);
                transform        : translate(-100%, 0);
            }
    }
   
}
}

/*                     --start-ux-left-sidebar1--               */

.ux-left-sidebar{
    height: 100%;
    width: 240px;
    background-color: #292C2E;
    position: fixed;
    left: 0;
    top: 60px;
        #uxTabSwitch1 .on{
            background-color: #292C2E;
            color: #fff;
        }
    
        #uxTabSwitch1{
        left: 0;
        top: 0px;
        z-index: 1;
        width: 100%;
        height: 100%;
        color: #56595A;
            .ux-leftTabtitle{
                font-size: 12px;
                width: 100%;
                color: #fff;
                height: 65px;
                text-align: center;
                line-height: 65px;
                    span{
                    font-size: 12px;
                    color: #989A9C;
                    margin-left: 5px;
                    height: 65px;
                    line-height: 65px;
                    }
            }
        .ux-tabbox{
        width: 100%;
        height: 100%;
        overflow: auto;
        li{
            height: 55px;
            text-align: left;
            cursor: pointer;
            padding-top: 10px;
            padding-left: 10px;
                .ux-pageimg{
                    display: inline-block;
                    width: 44px;
                    height: 44px;
                }
                .ux-pageinformation{
                    display: inline-block;
                    height: 44px;
                    margin-left: 10px;
                    vertical-align: top;
                        p{
                        height: 22px;
                        line-height: 22px;
                        text-align: left;
                        color: #fff;
                        font-size: 12px;
                        vertical-align: top;
                    }
                }
            }
        }

   }
}










/*                     --end-ux-left-sidebar--               */

</style>