<template>
<div class="mui-text-center mui-col-xs-12">
  <div class="dib mui-col-xs-10 mtb15">
	<canvas id="canvas1" width="1050" height="750"></canvas>
  </div>

</div>

</div>
</template>
<script>

import {Header} from 'mint-ui';
export default {
  name: 'chart',
  data() {
return {
   num:-1,
   x:2.24,
   progress:77,
    }
  },
  computed: {

  },
 components: {

 },
  methods: {


draw() {
  var canvas = document.getElementById("canvas1");
  var ctx1 = canvas.getContext('2d');

  ctx1.lineCap="round";
  var grd=ctx1.createLinearGradient(300,0,510,0);

	grd.addColorStop(0,"#FE9C00");
	grd.addColorStop("0.2","#F5EB06");
	grd.addColorStop("0.3","#F5EB06");
	// grd.addColorStop("0.6","green");
	// grd.addColorStop("0.8","yellow");
	grd.addColorStop(1,"#7FEC6B");


//  ((this.progress/10)+2.24)/300
// this.x+=((this.progress/10))/300;

    ctx1.clearRect(0, 0, 2700, 660);
//外层蓝色圆
    ctx1.beginPath();
    ctx1.lineWidth = 6;
    ctx1.strokeStyle = '#B1E8EF';
    ctx1.arc(525, 405, 357, Math.PI/1.4, 7.2, false); // 画圆
    ctx1.stroke();
    ctx1.closePath();
//灰色圆
    ctx1.beginPath();
     ctx1.lineWidth = 36;
    ctx1.strokeStyle = '#EEEEEE';
    ctx1.arc(525, 405, 300, Math.PI/1.4, 7.2, false); // 画圆
    ctx1.stroke();
    ctx1.closePath();
//公共文字
    ctx1.beginPath();
    ctx1.font = " 48pt PingFang Regular"; 
    ctx1.fillStyle='#434343';
    ctx1.textAlign = 'center'; 
    ctx1.textBaseline = 'middle'; 
    ctx1.fillText('魅力值', 525, 270); 
    ctx1.closePath();

    ctx1.beginPath();
    ctx1.font = " 36pt PingFang Regular"; 
    ctx1.fillStyle='#FE6500';
    ctx1.textAlign = 'center'; 
    ctx1.textBaseline = 'middle'; 
    ctx1.fillText('提升魅力值>>', 525, 600); 
    ctx1.closePath();

    ctx1.beginPath();
    ctx1.font = " 30pt PingFang Regular"; 
    ctx1.fillStyle='#989898';
    ctx1.textAlign = 'center'; 
    ctx1.textBaseline = 'middle'; 
    ctx1.fillText('最近提升时间2017.04.27', 525, 720); 
    ctx1.closePath();
//彩色圆
    ctx1.beginPath();
     ctx1.lineWidth = 36;
    ctx1.strokeStyle = grd;//'#ff4444';
    if (this.x < (2.24+(0.05*this.progress))) {
    this.x += 0.05;
    this.num+=1;
    ctx1.arc(525, 405, 300, Math.PI/1.4, this.x, false); // 画圆
    ctx1.stroke();
    ctx1.closePath();
            // 写文字
    ctx1.beginPath();
    ctx1.font = " 120pt PingFang Regular"; 
    ctx1.fillStyle='#F4A522';
    ctx1.textAlign = 'center'; 
    ctx1.textBaseline = 'middle'; 
    ctx1.fillText(this.num, 525, 420); 
    ctx1.closePath();
	  }
    else {
    console.log("canvs绘制完成")
    cancelAnimationFrame(startCanvas); 
    ctx1.arc(525, 405, 300, Math.PI/1.4, this.x, false); // 画圆
    ctx1.stroke();
    ctx1.closePath();
    // 写文字
    ctx1.beginPath();
    ctx1.font = " 120pt PingFang Regular"; 
    ctx1.fillStyle='#F4A522';
    ctx1.textAlign = 'center'; 
    ctx1.textBaseline = 'middle'; 
    ctx1.fillText(this.num, 525, 420); 
    ctx1.closePath();
    return;
    }
	     


// 动画
            var startCanvas=requestAnimationFrame(()=>{this.draw()})
	}


  },
  watch: {

  },
  beforeCreate () {

  },
  mounted (){
    this.num=-1;
    this.x=2.24;
    this.draw()
// setTimeout(()=>{this.draw()},300)
  },

};
</script>

<style lang="scss" scoped>
#canvas1{
  width: 100%;
}

.mint-header{
background: #FF6600;
}
.mint-header-title {
font-size: 1.7rem!important;
}
.mint-button-text{
font-size: 1.4rem!important;
}
.mintui{
font-size: 1.4rem!important;
}

</style>