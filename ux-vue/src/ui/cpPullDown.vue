<template>
  <div class="cpDropdown">
    <div id="dropdownLabel" @click.stop.prevent="toggle">
      {{dropdownText}} <span class="dropdown-caret"></span>
    </div>
    <ul class="cpDropdown-menu" v-if="show">
      <li v-for="(item, index) in this.list">
        <div @click.stop.prevent="select(index)">
          {{item.text}}
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
  let vm
  export default {
    name: 'cpPullDown',
    data() {
      return {
        show: false,
        dropdownText:''
      }
    },
    props: {
      list: {
        type: Array,
        default: function () {
          return [{
            text: 'item1'
          }, {
            text: 'item2'
          }]
        },
      },
      defaultText: {
        type: String,
        default: 'Plase select one'
      },
    },
    computed: {

    },
    methods: {
      toggle() {
        this.show = !this.show
        if (this.show) {
          // this.$root.$emit('shown:dropdown', this.id)
          // e.stopPropagation()
        } else {
          // this.$root.$emit('hidden::dropdown', this.id)
        }
      },
      select(index) {
        this.dropdownText=this.list[index].text;
        this.show = false
      }
    },
    created() {

    },
    components: {},
    mounted() {
       console.log("加载完成cpPullDown")
     this.dropdownText=this.defaultText;
     document.addEventListener('click',()=>{
				if(this.show) this.toggle()
			},false)
      
    }
  }

</script>

<style lang="scss" scoped>
  .cpDropdown {
    #dropdownLabel {

      .dropdown-caret {
        display: inline-block;
        width: 0;
        height: 0;
        margin-left: 2px;
        vertical-align: middle;
        border-top: 4px dashed;
        border-top: 4px solid\9;
        border-right: 4px solid transparent;
        border-left: 4px solid transparent;
      }
    }
    .cpDropdown-menu {
      position: absolute; // top: 100%;
      left: 0;
      z-index: 1000; // display: none;
      // float: left;
      min-width: 160px;
      padding: 5px 0;
      margin: 2px 0 0;
      font-size: 14px;
      text-align: left;
      list-style: none;
      background-color: #fff;
      -webkit-background-clip: padding-box;
      background-clip: padding-box;
      border: 1px solid #ccc;
      border: 1px solid rgba(0, 0, 0, .15);
      border-radius: 4px;
      -webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
      box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
    }
  }

</style>