<template>
    <div class="mui-slider slider">
        <div class="mui-slider-group mui-slider-loop">
            <!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
            <div class="mui-slider-item mui-slider-item-duplicate">
                <a :href="banners[banners.length-1].link">
                    <img :src="banners[banners.length-1].cover" data-preview-src data-preview-group="1" />
                </a>
            </div>
            <div class="mui-slider-item" v-for="banner in banners">
                <a :href="banner.link">
                    <img :src="banner.cover" data-preview-src data-preview-group="1" />
                </a>
            </div>
            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
            <div class="mui-slider-item mui-slider-item-duplicate">
                <a :href="banners[0].link">
                    <img :src="banners[0].cover" data-preview-src data-preview-group="1" />
                </a>
            </div>
        </div>
        <div class="mui-slider-indicator mui-text-right">
            <div class="mui-indicator" v-for="banner in banners"></div>
        </div>
    </div>
</template>
<script>
let  banners = [{
                    link: "javascript:;",
                    cover: "../../static/img/IMG_4327.JPG",
                    title: "title 1",
                }, {
                    link: "javascript:;",
                    cover: "../../static/img/IMG_4326.JPG",
                    title: "title 2",
                }, {
                     link: "javascript:;",
                    cover: "../../static/img/IMG_4327.JPG",
                    title: "title 3",
                }, {
                     link: "javascript:;",
                    cover: "../../static/img/IMG_4326.JPG",
                    title: "title 4",
                },];
    let muiCarousel = {
        name: 'muiCarousel',
        data() {
            return {
                banners:banners
            };
        },
        methods: {

        },
        props: [

        ],
        components: {

        },
        mounted() {
            mui.init({
                swipeBack: true //启用右滑关闭功能
            });
            var slider = mui(".slider");
            slider.slider({
                interval: 1000
            });
            console.log("加载完成muiCarousel")
        }
    };



    export default muiCarousel;
</script>
<style lang='scss' scoped>
.mui-slider .mui-slider-group .mui-slider-item img {
            min-height: 17rem;
             max-height: 19rem;
}


.mui-slider-title {
            line-height: 30px;
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 30px;
            margin: 0;
            text-align: left;
            text-indent: 12px;
            opacity: .8;
            background-color: #000;
}

.mui-slider .mui-slider-group .mui-slider-item img {
    width: 100%;
   
}
</style>