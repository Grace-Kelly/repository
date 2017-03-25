<template>
    <div class="street-detail animated bounceInRight">
        <div>
            <div id="segmentedControl" class="mui-segmented-control">
                <a class="mui-control-item" :class="isActive('one')" @tap="selects='one'">
                                追踪案情
                            </a>
                <a class="mui-control-item" :class="isActive('two')" @tap="selects='two'">
                                案件处理图片
                            </a>

            </div>
        </div>
        <div class="mui-control-content mui-active">
            <component :is="'select-'+selects" :firmenus="firmenus" :secmenus="secmenus" :selects="selects"></component>
        </div>
    </div>
</template>


<script>
    import Vue from 'vue';
    let secmenus = [{
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-2-01",
    }, {
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-2-04",
    }, {
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-2-05",
    },];
    let firmenus = [{
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-3-01",
    }, {
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-3-04",
    }, {
        pic: "assets/img/wx_logo_108.png",
        txt: "街道",
        num: "2016-3-05",
    },];
    let selectone = Vue.component('select-one', {
        template: `
    <div id="select-one">
        <div class="detail" style="padding:0 15px;">
            <ul class="mui-table-view" style="border-radius:10px;border:1px solid #c8c7cc;">
                <div class="detail-title mui-table-view-cell">
                    <div class="mui-col-xs-2 fl mui-text-center">头像</div>
                    <div class="mui-col-xs-6 fl mui-text-center">昵称</div>
                    <div class="mui-col-xs-4 fl mui-text-center">加入时间</div>
                    <div>secmenus</div>
                </div>
                <li class="mui-table-view-cell" v-for="secmenu in secmenus">
                    <a>
                        <div class="mui-col-xs-6 fl mui-text-center">
                            <p class="mui-ellipsis">{{secmenu.txt}}</p>
                        </div>
                        <div class="mui-col-xs-4 fl mui-text-center">
                            <p class="mui-ellipsis">{{secmenu.num}}</p>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    `,
        props: [
            "secmenus",
            "selects"]

    });
    let selecttwo = Vue.component('select-two', {
        template: `
    <div id="select-two">
    <div class="detail" style="padding:0 15px;">
            <ul class="mui-table-view" style="border-radius:10px;border:1px solid #c8c7cc;">
                <div class="detail-title mui-table-view-cell">
                    <div class="mui-col-xs-2 fl mui-text-center">头像</div>
                    <div class="mui-col-xs-6 fl mui-text-center">昵称</div>
                    <div class="mui-col-xs-4 fl mui-text-center">加入时间</div>
                    <div>firmenus</div>
                </div>
                <li class="mui-table-view-cell" v-for="firmenu in firmenus">

                    <a>
                        <div class="mui-col-xs-6 fl mui-text-center">
                            <p class="mui-ellipsis">{{firmenu.txt}}</p>
                        </div>
                        <div class="mui-col-xs-4 fl mui-text-center">
                            <p class="mui-ellipsis">{{firmenu.num}}</p>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
`,
        props: [
            "firmenus",
            "selects"
        ],
    });
    let muiTabBar = {
        name: 'muiTabBar',
        data() {
            return {
                selects: "one",
                secmenus: secmenus,
                firmenus: firmenus
            };
        },
        methods: {
            isActive: function (selectName) {
                if (this.selects == selectName) {
                    return "mui-active";
                } else {
                    return;
                }
            },
            back: function () {
                location.href = "#"
            }
        },
        props: [

        ],
        components: {
            selectone, selecttwo
        },
        mounted() {
            console.log("加载完成muiTabBar")
        }
    };


    export default muiTabBar;
</script>
<style lang='scss' scoped>

.mui-segmented-control .mui-control-item.mui-active {
    color           : #fff;
    background-color: #00ABF3;
}
 .mui-segmented-control .mui-control-item {
    background-color: #FFFFFF;
    color           : #00ABF3;
    border-color    : #FFFFFF;
    border-left     : 1px solid #FFFFFF;
}
 .mui-segmented-control {
    border          : 1px solid #FFFFFF;
}

</style>