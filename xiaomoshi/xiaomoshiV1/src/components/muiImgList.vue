<template>
 <ul class="animated bounceInUp list-parent" >
        <li v-for="(list, index) in lists"  class="list-cell">
            <a>
                <div :style="{ backgroundImage: 'url(' + list.cover + ')'}" class="list-pic" >
                    <p class="mui-ellipsis bgc3 rankcode">第{{index+1}}名</p>
                    <span class="numcode frc5">编号：{{list.numcode}}</span>
                </div>
                <div class="list-inform frc1 bgc3 frc5">
                    <img :src="list.photo" class="fl photo"/>
                    <div class="vote-right mui-text-left">
                        <span class="mui-ellipsis fl f15 max3" style="display:block">{{list.nickname}}</span>
                      <span class="fr f15" style="display:block" >
                        <span class="iconfont icon-xihuan frc"></span><span class="votenum">{{list.votenum}}</span></span>
                    </div>
                </div>
            </a>
        </li>
    </ul>
</template>


<script>
   let lists = [{
    "id":1,
    cover: "../../static/img/IMG_4327.JPG",
    numcode:"155",
    photo:"../../static/img/IMG_4327.JPG",
    nickname:"leo",
    votenum:"20"
}, {
    "id":2,
    cover: "../../static/img/IMG_4327.JPG",
    numcode:"155",
    photo:"../../static/img/IMG_4327.JPG",
    nickname:"leo",
    votenum:"20"
}, {
    "id":3,
    cover: "../../static/img/IMG_4327.JPG",
    numcode:"155",
    photo:"../../static/img/IMG_4327.JPG",
    nickname:"leo",
    votenum:"20"
}, {
    "id":4,
    cover: "../../static/img/IMG_4327.JPG",
    numcode:"155",
    photo:"../../static/img/IMG_4327.JPG",
    nickname:"leo",
    votenum:"20"
},];
    let muiImgList = {
       
        data() {
            return {
                lists: lists,
            };
        },
        methods: {
            // @tap="tooltips('vui-tooltips-detail')"

            
            // vote:function(){
            // var el=event.currentTarget;
            // var heart=$(el).children(".iconfont");
            // var votenum=parseInt($(el).children(".votenum").html());
            // console.log($(el));
            // console.log($(heart));
            // event.stopPropagation();
            // if(heart.hasClass("frc")){
            //     heart.addClass("frc6").removeClass("frc");
            //     votenum++;
    
            //     mui.toast('<i class="fa fa-check"></i><br>'+"投票成功");
            // }else{
            //     heart.addClass("frc").removeClass("frc6");
            //     votenum--;
            // }
            // $(el).children(".votenum").html(votenum)
            // }
        },
        props: [

        ],
        components: {
         
        },
        mounted() {
            console.log("加载完成muiImgList")

        var preImg = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC";//预设图片
        // 加载图片
        var needLoadImgs = (function(loads){
            /*
             * 1,待加载元素的集合
             * 2,待加载的元素，必须采用替换或其它方法停止图片加载
             * 3,加载图片的触发条件，容器在可视区域内
             * 4,,加载图片的影响因素，窗体滚动、大小改变的时候
             * 5，重复以上动作，直到所有图片加载完毕为止
             * */

            var needLoadImgs = function(){
                var that = this;
                this._imgs = [];
                this.initImgs = function(){
                    var l = document.images.length,
                            i = 0,
                            imgs = document.images,
                            _i = null;

                    if(l > 0){//是否启用事件
                        for(;i < l ; i++){
                            _i = imgs[i];
                            this._imgs[i] = _i;//待载入图的数组
                            if (_i.src === undefined || _i.src === false) {//检测是否存在损坏图片
                                _i.src = preImg;
                            }
                        }
                        that.updateImg();
                        that.initEvent();
                    }

                }
            }

            needLoadImgs.prototype.initEvent = function(){//绑定事件检测
                var that = this;
                //滚轴事件
                window.onscroll = function(){
                    that.updateImg();
                }
            }

            needLoadImgs.prototype.updateImg = function(){
                var i = 0,
                        l = this._imgs.length,
                        imgs = this._imgs,
                        cimg = "",
                        _i = null,
                        windowHeight=document.all ? document.getElementsByTagName("html")[0].offsetHeight : window.innerHeight,
                        scrollY = document.documentElement.scrollTop || document.body.scrollTop; //滚动条距离顶部高度
                for(;i < l ; i++){
                    _i = imgs[i];
                    cimg = _i.getAttribute("data-source");

                    if (cimg){//判断图片是否在可视区域,如果在可视区域加载

                        if(getAbsoluteTop(_i)+_i.offsetHeight/4 < windowHeight + scrollY){
                            _i.src = cimg;//设置源图片地址
                            imgs.splice(i, 1); //删除已经设置过图片的对象
                            l = this._imgs.length;
                        }
                    }
                }
            }
            return new needLoadImgs(loads);
        })();

        function getAbsoluteTop(_e){//获取元素的绝对top
            var _top = _e.offsetTop,
                    _current = _e.offsetParent;
            while (_current !== null){
                _top += _current.offsetTop;
                _current = _current.offsetParent;
            }
            return _top;
        }

        /*============图片分批加载========*/
        needLoadImgs.initImgs();
        }
    };


    export default muiImgList;
</script>
<style lang='scss' scoped>
.netizen-bottom {
    width: 100%;
    padding: 10px 0;
    min-height: 86%;
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-position: center top;
} .list-parent{
      overflow: hidden;
  }
.list-cell{
    position: relative;
     
    width: 50%;
    float: left;
    text-align: center;
    margin-bottom: 10px;
}
.list-cell:nth-child(2n+1) {
    padding: 0 1% 0 2%;
}
.list-cell:nth-child(2n) {
    padding: 0 2% 0 1%;
}
.list-pic{
    position: relative;
    width: 100%;
    padding-top: 75%;
    border-radius: 7px 7px 0 0;
    background-repeat:no-repeat;
    position: relative;
    display: block;
    background-size: cover;
    background-position: 50% 50%;
}
.list-cell .rankcode{
    position: absolute;
    left: 0;
    top:0;
    padding: 3px 6px;
    color: #fff;
    font-size: 14px;
    line-height: 20px;
    border-radius:7px 0 7px 0;
}
.list-cell .numcode{
    width: 100%;
    position: absolute;
    left: 0;
    bottom: 0;
    text-align: left;
    margin: 0;
    font-size: 14px;
    line-height: 28px;
    text-align: center;
    background-color:rgba(255,227,204,.9);
}

.list-inform {
    overflow: hidden;
    padding: 5px;
    border-radius: 0 0 7px 7px;
}
.vote-right {
    overflow: hidden;
    padding-top: 10px;
}
.photo {
    width: 40px;
    height: 40px;
    border-radius: 20px;
    margin-right: 5px;
}



</style>