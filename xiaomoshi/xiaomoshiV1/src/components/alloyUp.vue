<template>
    <div class="pull_refresh" id="pull_refresh">
        <div class="pull">
            <div id="arrow" class="arrow">
                <img src="asset/arrow.png"><br />
            </div>
        </div>
        <div id="header">AlloyTouch</div>
        <div id="wrapper">
            <div id="scroller">
                <ul id="list">
                    <li>Hello, AlloyTouch!</li>
                    <li>AlloyFinger - Super Tiny Size Gestures Library</li>
                    <li>Transformjs - Made CSS3 Super Easy</li>
                    <li>AlloyFlow - </li>
                    <li>Nuclear - Some HTML + Scoped CSS + JS </li>
                    <li>AlloyGameEngine</li>
                    <li>Rosin</li>
                    <li>LivePool</li>
                    <li>AlloyStick</li>
                    <li>CodeStar</li>
                    <li>AlloyDesigner</li>
                    <li>JXAnimate</li>
                    <li>Spirit</li>
                    <li>AlloyImage</li>
                    <li>ModJS</li>
                    <li>Pretty row 16</li>
                    <li>stepify</li>
                    <li>AlloyTimer</li>
                    <li>Alloy Desktop</li>
                    <li>JX UI</li>
                    <li>CodeTank</li>
                    <li>iSpriter</li>
                    <li>Rythem</li>
                    <li>Go!Png </li>
                    <li>JX</li>
                    <li>TEditor</li>
                    <li>row 1</li>
                    <li>row 2</li>
                    <li>row 3</li>
                    <li>row 5</li>
                    <li>row 5</li>
                    <li>row 7</li>
                    <li>row 8</li>
                    <li>row 9</li>
                    <li>row 11</li>
                    <li>row 11</li>
                    <li>row 12</li>
                    <li>row 13</li>
                    <li>row 14</li>
                    <li>row 15</li>
                    <li>row 16</li>
                    <li>row 17</li>
                    <li>row 18</li>
                    <li>row 19</li>
                    <li>row 20</li>
                    <li>row 21</li>
                    <li>row 22</li>
                    <li>row 23</li>
                    <li>row 24</li>
                    <li>row 25</li>
                </ul>
            </div>
        </div>
        <div id="footer"></div>
        <script>
        
    let alloyTouch = {
        name: 'alloyTouch',
        data() {
            return {
                // 初始化设置
                options: {
                    touch: "",//反馈触摸的dom
                    vertical: true,//不必需，默认是true代表监听竖直方向touch
                    target: '#scroller', //运动的对象
                    property: "translateY",  //被滚动的属性
                    sensitivity: 1,//不必需,触摸区域的灵敏度，默认值为1，可以为负数
                    factor: 1,//不必需,默认值是1代表touch区域的1px的对应target.y的1
                    step: 40,
                },
                // 动态设置属性
                min: window.innerHeight - 45 - 48 - 2000, //不必需,滚动属性的最小值
                max: 0, //不必需,滚动属性的最大值
            };
        },
        methods: {
            // 回调函数
            change: function (value) {
                pull_refresh.translateY = value;
            },
            touchMove: function (evt, value) {
                if (value > 70) {
                    //http://caniuse.com/#search=classList
                    arrow.classList.add("arrow_up");
                } else {
                    arrow.classList.remove("arrow_up");
                }
            },
            touchEnd: function (evt, value) {
                if (value > 70) {
                    this.to(60);
                    mockRequest(this);
                    return false;
                }
            },
            
        },
        components: {

        },
        mounted() {
            console.log("加载完成alloyUP")
             var scroller = document.querySelector("#scroller"),
            arrow = document.querySelector("#arrow"),
            pull_refresh = document.querySelector("#pull_refresh"),
            list = document.querySelector("#list"),
            index = 0;

        Transform(pull_refresh, true);
        Transform(scroller, true);
        function mockRequest(at) {
            pull_refresh.classList.add("refreshing");
            setTimeout(function () {
                var i = 0,
                    len = 3;
                for (; i < len; i++) {
                    var li = document.createElement("li");
                    li.innerHTML = "new row " + index++;
                    list.insertBefore(li, list.firstChild);
                }
                arrow.classList.remove("arrow_up");
                pull_refresh.classList.remove("refreshing");
                at.to(at.initialValue);
                at.min -= 40 * 3;
            }, 500);
        }
        }
    };



    export default alloyUp;
</script>
<style lang='scss' scoped>

 #wrapper {
            position: absolute;
            z-index: 8;
            top: 45px;
            bottom: 48px;
            left: 0;
            width: 100%;
            background: rgb(233, 230, 230);
            overflow: hidden;
        }

        #scroller {
            position: absolute;
            z-index: 8;
            -webkit-tap-highlight-color: rgba(0,0,0,0);
            width: 100%;
            -webkit-transform: translateZ(0);
            -moz-transform: translateZ(0);
            -ms-transform: translateZ(0);
            -o-transform: translateZ(0);
            transform: translateZ(0);
            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            -webkit-text-size-adjust: none;
            -moz-text-size-adjust: none;
            -ms-text-size-adjust: none;
            -o-text-size-adjust: none;
            text-size-adjust: none;
        }

            #scroller ul {
                list-style: none;
                padding: 0;
                margin: 0;
                width: 100%;
                text-align: left;
            }

            #scroller li {
                padding: 0 10px;
                height: 40px;
                line-height: 40px;
                border-bottom: 1px solid #ccc;
                border-top: 1px solid #fff;
                background-color: #fafafa;
                font-size: 14px;
            }

        .pull_refresh {
            text-align: center;
            color: #00a9f2;
            position: absolute;
            z-index: 10;
            top: -10px;
            width: 100%;
        }

        .arrow {
            margin-top: 5px;
            margin-bottom: 5px;
        }

            .arrow:after {
                content: "Pull to refresh";
            }

        .arrow_up.arrow:after {
            content: "Release to refresh";
        }

        .arrow_up img {
            transform: rotateZ(180deg);
            -webkit-transform: rotateZ(180deg);
        }

        .pull_refresh img {
            width: 20px;
            transition: transform .4s ease;
        }

        .pull_refresh.refreshing .pull {
            display: none;
        }

        .pull_refresh.refreshing .loading {
            display: block;
        }

        .wording {
            margin-bottom: 14px;
        }

        .pull_refresh .pull {
            display: block;
        }

        .pull_refresh .loading {
            display: none;
        }
</style>