<template>

    <div class="uxDialog-wrap">
      <div class="uxDialog-cover" @click="closeMyself"></div>
      <transition name="drop">
        <div class="uxDialog-content" >
          <p class="uxDialog-close" @click="closeMyself">x</p>
           <slot>empty</slot>
        </div>
      </transition>
    </div>

</template>

<script>
let uxDialog={
  name:"uxDialog",
  // props: {
    // isShow: {
    //   type: Boolean,
    //   default: true
    // }
  // },
  data () {
    return {
      
    }
  },
  methods: {
    closeMyself () {
      // this.$emit('on-close')
    }
  }
}
 export default uxDialog;
</script>

<style scoped>
.drop-enter-active {
  transition: all .5s ease;
}
.drop-leave-active {
  transition: all .3s ease;
}
.drop-enter {
  transform: translateY(-500px);
}
.drop-leave-active {
  transform: translateY(-500px);
}

.uxDialog-wrap {
  position: fixed;
  width: 100%;
  height: 100%;
}
.uxDialog-cover {
  background: #000;
  opacity: .3;
  position: fixed;
  z-index: 5;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.uxDialog-content {
  width: 50%;
  position: fixed;
  max-height: 50%;
  overflow: auto;
  background: #fff;
  top: 20%;
  left: 50%;
  margin-left: -25%;
  z-index: 10;
  border: 2px solid #3484F5;
  padding: 2%;
  line-height: 1.6;
}
.uxDialog-close {
  position: absolute;
  right: 5px;
  top: 5px;
  width: 20px;
  height: 20px;
  text-align: center;
  cursor: pointer;
}
.uxDialog-close:hover {
  color: #3484F5;
}
</style>
