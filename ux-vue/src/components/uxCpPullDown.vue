<template>
<form action="" method="post">
<div class="xms-divselect">
    <p @click.stop.prevent="toggle">{{dropdownText}}</p>
      <ul class="cpDropdown-menu" v-if="show">
         <li v-for="(item,index) in this.listTitle"><a @click.stop.prevent="select(item.select,index)" href="javascript:;"  >{{item.text}}</a></li>
      </ul>
  </div>
  <input name="" type="hidden" value="" id="inputselect"/>
</form>
</template>
<script>
  let vm;
  export default {
    name: 'uxCpPullDown',
    data() {
      return {
          show: false,
          dropdownText:'选择组件',
          listTitle:  [
            {
            text: '输入框',
            select:'inputChs'
          },
          {
            text: '单选框',
            select:'radio'
          },
          {
            text: '多选框',
            select:'check'
          },
          {
            text: '上传文件',
            select:'upload'
          },
          {
            text: '日期输入框',
            select:'inputData'
          },{
            text: '跳转按钮',
            select:'buttonJump'
          }, 
          {
            text: '自适应图片',
            select:'image'
          },{
            text: '下拉按钮',
            select:'pullDown'
          }]
       };
     },
    computed:{

     },
      methods:{            
           toggle() {
              this.show = !this.show
              if (this.show) {
                // this.$root.$emit('shown:dropdown', this.id)
                // e.stopPropagation()
              } else {
                // this.$root.$emit('hidden::dropdown', this.id)
              }
            },
            select(e,index) {
              e = e||window.event;
              this.dropdownText=this.listTitle[index].text;
              this.show = false
              sessionStorage.className=arguments[0];
              let CP=sessionStorage.className;
              let ID=sessionStorage.objectID;
              console.log(`${ID}:${CP}`)
              this.$store.commit(`${e}Status`)
          }     
        },
     created: function () {
     },
    components: {
    },
    mounted () {
       document.addEventListener('click',()=>{
				if(this.show) this.toggle()
			},false)
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