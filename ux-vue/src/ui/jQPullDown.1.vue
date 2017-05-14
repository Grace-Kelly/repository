<template>
<form action="" method="post">
<div class="xms-divselect">
    <p @click='divselect("#divselect","#inputselect")'>选择组件</p>
      <ul>
         <li><a @click="uxInputChs" href="javascript:;" selectid="1">文本输入框</a></li>
         <li><a @click="uxInputNum" href="javascript:;" selectid="2">数字输入框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="3">中文输入框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="4">英文输入框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">单选框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">多选框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">图片上传输入框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">日期输入框</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">跳转按钮</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">下拉按钮</a></li>
         <li><a @click="selectItem" href="javascript:;" selectid="5">自适应图片</a></li>
      </ul>
  </div>
  <input name="" type="hidden" value="" id="inputselect"/>
</form>
</template>
<script>
  let vm;
  export default {
    name: 'uxPullDown',
    data() {
      return {
       
       };
     },
    computed:{

     },
      methods:{            
            divselect(divselectid,inputselectid){ 
              let el = event.currentTarget;
               let ul = $(el).next();
                  if(ul.css("display")=="none"){
                     $(el).next("ul").slideDown("fast");
                  }else{
                      // ul.slideUp("fast");
                       $(el).next("ul").slideUp("fast");
                  }  
               
          },
          uxInputNum(){
            //更改的文字
                 let inputselect = $("#inputselect");
                  let el = event.currentTarget;
                  let value = $(el).attr("selectid");
                  let txt = $(el).text();
                  $(el).parent().parent().hide();
                  $(el).parent().parent().prev().text(txt);
                  inputselect.val(value);
             //  提交的数据     
                  sessionStorage.className="uxInputNum";
                  let CP=sessionStorage.className;
                  let ID=sessionStorage.objectID;
                  console.log(`${ID}:${CP}`)
            //    获取长宽高坐标
              let inputWidth=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).width;
              let inputHeight=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).height;
              let inputLeft=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).left;
              let inputTop=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).top;
              let inputBackground=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).background;
              $("#styleHeight").val(inputHeight)
              $("#styleWidth").val(inputWidth)
              $("#styleLeft").val(inputLeft)
              $("#styleTop").val(inputTop)
            //更改iframe的状态 
              // $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input objectID=${sessionStorage.objectID} maxlength='10' style="width:${inputWidth};height:${inputHeight};left:${inputLeft};top:${inputTop};position:absolute"> `);
            //   input的附加属性修改
             this.$store.commit("inputNumStatus")
          },
          uxInputChs(){
                  let inputselect = $("#inputselect");
                  let el = event.currentTarget;
                  let value = $(el).attr("selectid");
                  let txt = $(el).text();
                  $(el).parent().parent().hide();
                  $(el).parent().parent().prev().text(txt);
                  inputselect.val(value);
             //  提交的数据     
                  sessionStorage.className="uxInputChs";
                  let CP=sessionStorage.className;
                  let ID=sessionStorage.objectID;
                  console.log(`${ID}:${CP}`)
            //    获取长宽高坐标
              let inputWidth=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).width;
              let inputHeight=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).height;
              let inputLeft=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).left;
              let inputTop=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).top;
              let inputBackground=this.getStyle($("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`)[0], null).background;
              $("#styleHeight").val(inputHeight)
              $("#styleWidth").val(inputWidth)
              $("#styleLeft").val(inputLeft)
              $("#styleTop").val(inputTop)
            //更改iframe的状态 
              // $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input objectID=${sessionStorage.objectID} maxlength='10' style="width:${inputWidth};height:${inputHeight};left:${inputLeft};top:${inputTop};position:absolute"> `);
            //   input的附加属性修改
             
              this.$store.commit("inputChsStatus")
              
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
            getStyle(ele) {
              var style = null;
              if(window.getComputedStyle) {
                  style = window.getComputedStyle(ele, null);
              }else{  
                  style = ele.currentStyle;
              }
              return style;
            },
         selectItem(){
           let inputselect = $("#inputselect");
                  let el = event.currentTarget;
                  let value = $(el).attr("selectid");
                  let txt = $(el).text();
                  $(el).parent().parent().hide();
                  $(el).parent().parent().prev().text(txt);
                  inputselect.val(value);
         }            
        
        },
     created: function () {
     },
    components: {
    },
    mounted () {
    }
  };
</script>

<style lang="scss" scoped>
.ux-none{
  display: none;

}
.ux-block{
  display:block;
}
.xms-divselect{
    p{
      width: 92px;
      height: 24px;
      line-height: 24px;
      display: block;
      cursor: pointer;
      font-size: 12px;
      margin-left: 4px;
      padding-left: 4px;
      padding-right: 30px;
      background: url(../../static/img/xjt.png) no-repeat right center;
      color: #fff;
      background-color: #595E62;
    }
    ul {
        width: 124px;
        margin-left: 4px;
        border: 1px solid #333333;
        background-color: #ffffff;
        position: absolute;
        z-index: 20000;
        display: none;
        li {
        height: 24px;
        line-height: 24px;
        // 定制
        background-color: #fff;
        a {
            display: block;
            height: 24px;
            color: #fff;
            background-color: #434649;
            cursor: pointer;
            font-size: 12px;
            text-decoration: none;
            padding-left: 10px;
            padding-right: 10px;
        }
        a:hover{
            background-color: #363A3C;
             color: #A8AAAC;
        }
        }
    }
   }

</style>