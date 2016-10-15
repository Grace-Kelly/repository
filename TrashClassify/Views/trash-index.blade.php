<?php
/**
 * Created by PhpStorm.
 * User: poon
 * Date: 16/10/05
 * Time: 22:13
 */

?>
@extends("layouts::mui/frontend")

@section("css-required")
@endsection
@section("js-required")
@endsection
@section("css-addon")

    <link rel="stylesheet" href="/plugins/mui/css/mui.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/weui.css"/>
    <link rel="stylesheet" href="/assets/css/example.css"/>
    <link rel="stylesheet" href="/assets/activity/trash-classify/css/animate.min.css">
    <link rel="stylesheet" href="/assets/activity/trash-classify/css/magic.min.css">
    <link rel="stylesheet" href="/assets/activity/trash-classify/css/main.css">
@endsection

@section("js-addon")

    <script src="/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <script src="/plugins/mui/js/mui.js" type="text/javascript"></script>
    <script src="/plugins/vuejs/vue.js" type="text/javascript"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" type="text/javascript"></script>
    {{--<script src="/plugins/vuejs/vue-router.min.js" type="text/javascript"></script>--}}
    {{--<script src="/plugins/vuejs/vue-resource.min.js" type="text/javascript"></script>--}}    
@endsection

@section("head-addon")
    <style>
        body {
            background-image: url("/assets/activity/trash-classify/img/bg.png");
        }
        .mui-backdrop {
            background-color: rgba(0, 0, 0, 0.6);
        }
        .share {
            text-align: center;
        }
        .share img {
            width: 80%;
        }
        .share p {
            color: #01A1E4 !important;
            font-size: 0.9rem;
        }
        .rule-content {
            padding: 20% 7px;
        }
        .rule-content p {
            font-size: 1rem;
            padding: 0 5%;
            text-align: left;
            line-height: 21px;
            color: #ffffff;
        }
        .rule-content p:first-child {
             font-size: 20px;
         }
        .rule-table {
            text-align: center;
            width: 90%;
            margin-left: 5%;
            line-height: 30px;
            color: #ffffff;
        }
        .content-text {
            font-size: 1.1rem;
            font-weight: 600;
            margin-top: 8px;
        }
        .rubbish-pickout {
            position: absolute;
            height: 80px;
            width: 80px;
            bottom: 10px;
            right: 10px;
        }
        .rank .mui-segmented-control {
            height: 75px;
        }

        .play{-webkit-animation:playmusic 2s linear infinite ;
            animation:playmusic 2s linear infinite ;}
        @-webkit-keyframes playmusic{
            0%{-webkit-transform:rotate(0deg);
            }
            50%{-webkit-transform:rotate(180deg);}
            100%{-webkit-transform:rotate(360deg);}
        }
        @keyframes playmusic{
            0%{-webkit-transform:rotate(0deg);
            }
            50%{-webkit-transform:rotate(180deg);}
            100%{-webkit-transform:rotate(360deg);}
        }

        .col-1{
            width:12%;
        }

        .mui-toast-container{
            border-radius:0;
            bottom: 50%;
        }
        .mui-toast-container div{
            background-image: url("/assets/activity/trash-classify/img/msgbg.png");
            background-size: 100% 100%;
            border-radius: 0;
            background-color: transparent;
        }

    </style>
@endsection

@section("title")
    {{ $activity->title }}
@endsection

@section("body-attr")
@endsection

@section("body-content")

    <div class="mui-backdrop mui-hidden" id="vui-tooltips" @tap="hide">
        <component :is="tooltips"
                   :activity="activity"
                   :rule="activity.rule"
                   :user="user"
                   :max="max? max: 0"
                   :current="current? current: 0"
                ></component>
    </div>
    <section class="main" id="app">

            <img src="/assets/activity/trash-classify/img/music.png" class="col-1 music play" alt=""/>
            <audio src="/assets/activity/trash-classify/music/music.mp3" class="music-vedio" id="music" controls="" loop style="display:none;"></audio>
        
        <component :is="currentView"
                   :activity="activity"
                   :attendee="attendee"
                   :inviter="inviter"
                   :ranks="ranks? ranks: 'popular'"
                   :boddy="boddy? boddy: 'supporter'"
                   :user="user"></component>
    </section>
@endsection

@section("script-addon")

    <script type="x/template" id="vui-page-home">
        <div class="mui-content">
            <div class="page1">
                <div class="mui-col-xs-12 mui-text-center bg-header">
                    <div class="mui-col-xs-9 dib animated pulse">
                        <img src="/assets/activity/trash-classify/img/bg-header.png" class="mui-col-xs-12" alt="垃圾分类找茬头部标题">
                    </div>
                </div>
                <div class=" mui-col-xs-3 logo">
                    <div class="dib mui-col-xs-8">
                        <img src="/assets/activity/trash-classify/img/logo.png" class="mui-col-xs-12 animated rotateIn">
                    </div>
                </div>
                <div class="foot_box mui-col-xs-12">
                    <div class="btn-box">
                        <div class="dib mui-col-xs-12 mui-text-center mui-text-center">
                            <div class="dib mui-col-xs-6 animated pulse" @tap="attend">
                                <img src="/assets/activity/trash-classify/img/btn-open.png" class="mui-col-xs-11">
                            </div>
                        </div>
                        <div class="dib mui-col-xs-12 mui-text-center">
                            <div class="dib mui-col-xs-6 animated pulse" @tap="tooltips('vui-tooltips-share')">
                                <img src="/assets/activity/trash-classify/img/open-help.png" class="mui-col-xs-11">
                            </div>
                        </div>
                    </div>
                    <!--好友助力-->
                    <div class="dt mui-col-xs-12">
                        <div class="dts mui-col-xs-4 mui-text-center">
                            <a class="dib mui-col-xs-7" href="#vui-page-rank">
                                <img src="/assets/activity/trash-classify/img/btn2.png" class="mui-col-xs-12 animated rotateIn">
                            </a>
                        </div>
                        <div class="dts mui-col-xs-4 mui-text-center">
                            <a class="dib mui-col-xs-7" href="#vui-page-boddy">
                                <img src="/assets/activity/trash-classify/img/btn1.png" class="mui-col-xs-12 animated rotateIn">
                            </a>
                        </div>
                        <div class="dts mui-col-xs-4 mui-text-center">
                            <div class="dib mui-col-xs-7" @tap="tooltips('vui-tooltips-rule')">
                                <img src="/assets/activity/trash-classify/img/btn3.png" class="mui-col-xs-12 animated rotateIn">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-page-rank">
        <div class="mui-content">
            <div class="rank mb8 animated flipInX page4-box" style="padding-top:10%;">
                <div id="segmentedControl" class="mui-segmented-control">
                    <div class="mui-control-item" :class="isActive('popular')" href="#vui-page-rank" @tap="ranks='popular'">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-01.png" v-if="isActive('popular')">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-01-non.png" v-else="isActive('popular')">
                    </div>
                    <div class="mui-control-item" :class="isActive('talent')" href="#vui-page-rank" @tap="ranks='talent'">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-02.png" v-if="isActive('talent')">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-02-non.png" v-else="isActive('talent')">
                    </div>
                    <div class="mui-control-item" :class="isActive('mvp')" href="#vui-page-rank" @tap="ranks='mvp'">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-03.png" v-if="isActive('mvp')">
                        <img class="mui-col-xs-11" src="/assets/activity/trash-classify/img/rank-icon-03-non.png" v-else="isActive('mvp')">
                    </div>
                </div>
                <div class="mui-control-content mui-active">
                    <div class="playdata" v-if="user && user.status == 1">
                        <div class="fl">
                            <img :src="user.avatar" class="photo">
                        </div>
                        <div class="txt">
                            <p class="frc3 mui-ellipsis" v-text="user.nickname">小罗号</p>
                            <p class="frc3 mui-ellipsis" v-if="attendee">
                                <span class="mui-ellipsis myrank">
                                    排名：
                                    <span class="pd5" v-text="rank">0</span>
                                </span>
                                <span class="mui-ellipsis myrank">
                                    战绩：
                                    <span v-text="score">0</span>
                                </span>
                            </p>
                        </div>
                    </div>
                    <div class="playdata" v-else="! user || user.status != 1">
                        <div class="fl">
                            <img src="/assets/activity/trash-classify/img/touxinag.png" class="photo">
                        </div>
                        <div class="txt">
                            <p class="frc3 mui-ellipsis">小罗号</p>
                            <p class="frc3 mui-ellipsis">
                                <span class="mui-ellipsis myrank">
                                    排名：
                                    <span class="pd5">0</span>
                                </span>
                                <span class="mui-ellipsis myrank">
                                    战绩：
                                    <span>0</span>
                                </span>
                            </p>
                        </div>
                    </div>
                    <component :is="'vui-rank-' + ranks"
                               :activity="activity"
                               :user="user"
                               :attendee="attendee"
                               :mvps="mvps"
                               :talents="talents"
                               :populars="populars"
                               :score="score? score: 0"
                               :rank="rank? rank: 0"
                               :ranks="ranks? ranks: 'popular'"></component>
                </div>
            </div>
            <div class="mui-col-xs-12 mui-text-center foot_box">
                <a class="mui-col-xs-5 dib" href="#vui-page-home">
                    <img src="/assets/activity/trash-classify/img/reback.png" class="mui-col-xs-12">
                </a>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-page-boddy">
        <div class="mui-content">
            <div class="page4 ">
                <div class="mui-col-xs-12 mui-text-center">
                    <div class="dib mui-col-xs-10 ">
                        <div id="segmentedControl" class="mui-segmented-control">
                            <div class="mui-control-item" :class="isActive('supporter')" href="#vui-page-boddy" @tap="boddy='supporter'">
                                <span>好友助力</span>
                            </div>
                            <div class="mui-control-item" :class="isActive('supported')" href="#vui-page-boddy" @tap="boddy='supported'">
                                <span>我的接力名单</span>
                            </div>
                        </div>
                    </div>
                </div>
                <component :is="'vui-boddy-'+boddy"
                           :boddy="boddy? boddy: 'supporter'"
                           :page="page? page: 0"
                           :activity="activity"
                        :user="user"></component>
            <div class="mui-col-xs-12 mui-text-center foot_box">
                <a class="mui-col-xs-5 dib" href="#vui-page-home">
                    <img src="/assets/activity/trash-classify/img/reback.png" class="mui-col-xs-12">
                </a>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-boddy-supported">
        <div class="mui-control-content mui-active">
            <div class=" animated flipInX" v-if="supporteds">
                <p class="gift-count" v-if="supporteds">
                    你帮助了
                    <span v-text="supporteds.length">0</span>
                    位好友
                </p>
                <ul class="lsn helplist" v-if="supporteds">
                    <li class="present" v-for="supporter in supporteds">
                        <div class="list-bg  mui-text-center">
                            <div class="dt">
                                <div class="dts  mui-col-xs-3 mui-text-center">
                                    <img class="touxiang" :src="supporter.inviter.user.avatar">
                                </div>
                                <div class="dts mui-col-xs-8 mui-text-left ">
                                    <p class="mui-ellipsis" v-text="supporter.inviter.user.nickname">小罗号</p>
                                    <p class="mui-ellipsis" v-text="supporter.create_at">2016/01/01 13:00</p>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="playdata animated flipInX" v-else="supporteds">
                <div class="helpimg-non">
                    <img src="/assets/activity/trash-classify/img/nothing.png" class="mui-col-xs-9">
                </div>
                <div class="mui-text-center">
                    <h4 class="red">快召唤洪荒之力的好友来助力吧</h4>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-boddy-supporter">
        <div class="mui-control-content mui-active">
            <div class=" animated flipInX" v-if="supporters">
                <p class="gift-count" v-if="supporters">
                    有
                    <span v-text="supporters.length">0</span>
                    位好友为你加油
                </p>
                <ul class="lsn helplist" v-if="supporters">
                    <li class="present" v-for="supporter in supporters">
                        <div class="list-bg  mui-text-center">
                            <div class="dt">
                                <div class="dts  mui-col-xs-3 mui-text-center">
                                    <img class="touxiang" :src="supporter.user.avatar">
                                </div>
                                <div class="dts mui-col-xs-8 mui-text-left ">
                                    <p class="mui-ellipsis" v-text="supporter.user.nickname">小罗号</p>
                                    <p class="mui-ellipsis" v-text="supporter.create_at">2016/01/01 13:00</p>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="playdata animated flipInX" v-else="supporters">
                <div class="helpimg-non">
                    <img src="/assets/activity/trash-classify/img/nothing.png" class="mui-col-xs-9">
                </div>
                <div class="mui-text-center">
                    <h4 class="red">快召唤洪荒之力的好友来助力吧</h4>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-page-game">
        <div class="mui-content">
            <div class="page2">
                <div class="playdata">
                    <div class="fl">
                        <img class="photo" v-if="user" :src="user.avatar">
                        <img class="photo" v-else="user" src="/assets/activity/trash-classify/img/touxinag.png">
                    </div>
                    <div class="fr clock">
		    	<p class="frc1">
                            本轮得分
                            <span class="pd5" v-text="current">0</span>
                        </p>
                        <p class="frc1">
                            剩余时间:
                            <span class="pd5 frc2" v-text="remainder">0</span>
                            秒
                        </p>
                    </div>
                    <div class="txt">
                        <p class="frc1 mui-ellipsis" v-if="user" v-text="user.nickname"></p>
                        <p class="frc1 mui-ellipsis" v-else="user">小罗号</p>
                        <p class="frc1 mui-ellipsis">
                            最高纪录
                            <span class="pd5" v-text="max? max: 0">50</span>
                        </p>
                        <p class="frc1 mui-ellipsis">
                            剩余机会
                            <span class="pd5" v-if="attendee" v-text="attendee.stock_cnt">5</span>
                            <span class="pd5" v-else="attendee">0</span>
                            次
                        </p>
                    </div>
                </div>
                <div class="mui-col-xs-12 mui-text-center magictime star" style="display: none">
                    <div class="dib mui-col-xs-2 ">
                        <img src="/assets/activity/trash-classify/img/star.png" class="mui-col-xs-12" alt="">
                    </div>
                    <div class="dib mui-col-xs-2 ">
                        <img src="/assets/activity/trash-classify/img/star.png" class="mui-col-xs-12" alt="">
                    </div>
                    <div class="dib mui-col-xs-2 ">
                        <img src="/assets/activity/trash-classify/img/star.png" class="mui-col-xs-12" alt="">
                    </div>
                </div>
                <div class="game_footer">
                    <div class="mui-col-xs-12 mui-text-left">
                        <div class="rubbish" v-if="options" style="background-image: url('/assets/activity/trash-classify/img/cloud.png');">
                            <div v-for="option in options">
                                <img class="mui-col-xs-12 waste magictime vanishIn" alt="" :src="option.cover" @tap="pickout($index, option, $event)">
                            </div>
                        </div>
                        <div class="rubbish-pickout">
                            <div>
                            </div>
                        </div>
                    </div>
                    <div class="rubbish_box">
                        <div v-if="topic">
                            <img class="mui-col-xs-12 box magictime twisterInUp" :src="topic.cover">
                        </div>
                        <div v-if="topics" v-for="trash    in topics">
                            <img class="mui-col-xs-12 box magictime twisterInUp" :src="trash.cover" :data-topic-id="trash.id">
                        </div>
                    </div>
                </div>
                <vui-game-res-list :classes="null" :trashes="null" :loading="null" :loaded="null"></vui-game-res-list>
            </div>
            <div class="toolTip-integral">
                <div class="ft ">
                    <div class="mui-col-xs-12 mui-text-right">
                        <div class="dib mui-col-xs-5">
                            <img src="/assets/activity/trash-classify/img/guidance.png" class="mui-col-xs-12">
                        </div>
                    </div>
                    <div class="mui-col-xs-12 mui-text-center">
                        <div class="dib mui-col-xs-9 mt10">
                            <img src="/assets/activity/trash-classify/img/cup.png" class="mui-col-xs-12 animated tada">
                        </div>
                        <p class="f1 mt5">得分: <span class="red f3">10</span></p>
                        <p class="f1 mt5">最高: <span class="red f3">50</span></p>
                    </div>
                    <div class="mui-col-xs-12 mt10">
                        <div class="mui-col-xs-6 fl mui-text-center">
                            <div class="dib mui-col-xs-10">
                                <img src="/assets/activity/trash-classify/img/palyagain.png">
                            </div>
                        </div>
                        <div class="mui-col-xs-6 fl mui-text-center">
                            <div class="dib mui-col-xs-10">
                                <img src="/assets/activity/trash-classify/img/palyagain.png">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	    <audio src="/assets/activity/trash-classify/music/correct.mp3" id="music-correct"  controls=""  style="display:none;"></audio>
	    <audio src="/assets/activity/trash-classify/music/mistake.mp3" id="music-mistake"  controls=""  style="display:none;"></audio>
        </div>
    </script>
    <script type="x/template" id="vui-game-res-list">
        <div style="height: 1px; width: 1px;">
            <img src="/assets/activity/trash-classify/img/cloud.png">
            <ul v-if="classes">
                <li v-for="topic in classes">
                    <img :src="topic.cover">
                </li>
            </ul>
            <ul v-if="trashes">
                <li v-for="option in trashes">
                    <img :src="option.cover">
                </li>
            </ul>
            <vui-game-res-loading v-else="classes && trashes"></vui-game-res-loading>
            {{--<vui-tooltips-game-to-start v-if="classes && trashes"></vui-tooltips-game-to-start>--}}
        </div>
    </script>
    <script type="x/template" id="vui-game-res-loading">
        <div class="weui-mask_transparent">
            <div class="weui-toast">
                <i class="weui-loading weui-icon_toast"></i>
                <p class="weui-toast__content">资源加载中</p>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-page-invite">
        <div class="mui-content">
            <div class="invite-show">
                <div class=" mui-col-xs-3 logo">
                    <div class="dib mui-col-xs-8">
                        <img src="/assets/activity/trash-classify/img/logo.png" class="mui-col-xs-12 animated rotateIn">
                    </div>
                </div>
                <vui-user-profile-inviter :inviter="inviter"></vui-user-profile-inviter>
                <div class="mui-col-xs-12 mui-text-center bg-header ">
                    <div class="mui-col-xs-9 dib animated pulse tada">
                        <img src="/assets/activity/trash-classify/img/bg-header.png" class="mui-col-xs-12" alt="垃圾分类找茬头部标题">
                    </div>
                </div>
                {{--<div class="opport-count">还有<span class="frc2">10</span>次机会</div>--}}
                <div class="foot_box">
                    <div class="btn-box">
                        <div class="dib mui-col-xs-12 mui-text-center mui-text-center">
                            <div v-if="!flag" class="dib mui-col-xs-6 animated pulse" @tap="support">
                                <img  src="/assets/activity/trash-classify/img/opportunity.png" id="msgbg" class="mui-col-xs-11">
                            </div>
                            <div v-if="flag" class="dib mui-col-xs-6 animated pulse">
                                <img  src="/assets/activity/trash-classify/img/issupport.png" class="mui-col-xs-11">
                            </div>
                        </div>
                        <div class="dib mui-col-xs-12 mui-text-center">
                            {{--<div class="dib mui-col-xs-6 animated pulse" @tap="tooltips('vui-tooltips-share', $event)">--}}
                            <div class="dib mui-col-xs-6 animated pulse" @tap="attend">
                                <img src="/assets/activity/trash-classify/img/attend.png" class="mui-col-xs-11">
                            </div>
                        </div>
                    </div>
                    <!--底部按钮-->
                    <div class="dt mui-col-xs-12">
                        <div class="dts mui-col-xs-4 mui-text-center">
                            <a class="dib mui-col-xs-7" href="#vui-page-rank">
                                <img src="/assets/activity/trash-classify/img/btn2.png" class="mui-col-xs-12 animated rotateIn">
                            </a>
                        </div>
                        <div class="dts mui-col-xs-4 mui-text-center">
                        </div>
                        <div class="dts mui-col-xs-4 mui-text-center" @tap="tooltips('vui-tooltips-rule', $event)">
                            <div class="dib mui-col-xs-7">
                                <img src="/assets/activity/trash-classify/img/btn3.png" class="mui-col-xs-12 animated rotateIn">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-rank-popular">
        <ul class="mui-table-view playdata">
            <li class="mui-table-view-cell">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3">排名</span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3">昵称</span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3">战绩</span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="populars" v-for="popular in populars">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="$index + 1"></span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3" v-text="popular.user.nickname"></span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="popular.attend_cnt"></span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="! populars">
                <div class="helpimg-non">
                    <img src="/assets/activity/trash-classify/img/nothing.png" class="mui-col-xs-9">
                </div>
            </li>
        </ul>
    </script>
    <script type="x/template" id="vui-rank-talent">
        <ul class="mui-table-view playdata">
            <li class="mui-table-view-cell">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3">排名</span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3">昵称</span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3">战绩</span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="talents" v-for="talent in talents">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="$index + 1"></span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3" v-text="talent.attendee.user.nickname"></span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="talent.credit_total"></span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="! talents">
                <div class="helpimg-non">
                    <img src="/assets/activity/trash-classify/img/nothing.png" class="mui-col-xs-9">
                </div>
				<div class="mui-text-center">
        			<h4 class="red">快召唤洪荒之力的好友来助力吧</h4>
                </div>
            </li>
        </ul>
    </script>
    <script type="x/template" id="vui-rank-mvp">
        <ul class="mui-table-view playdata">
            <li class="mui-table-view-cell">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3">排名</span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3">昵称</span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3">战绩</span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="mvps" v-for="mvp in mvps">
                <div class="fl mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="$index + 1"></span>
                </div>
                <div class="fl mui-col-xs-6">
                    <span class="mui-ellipsis frc3" v-text="mvp.user.nickname"></span>
                </div>
                <div class="fr mui-col-xs-3">
                    <span class="mui-ellipsis frc3" v-text="mvp.score"></span>
                </div>
            </li>
            <li class="mui-table-view-cell" v-if="! mvps">
                <div class="helpimg-non">
                    <img src="/assets/activity/trash-classify/img/nothing.png" class="mui-col-xs-9">
                </div>
            </li>
        </ul>
    </script>
    <script type="x/template" id="vui-user-profile-inviter">
        <div class="playdata" v-if="inviter">
            <div class="fl">
                <img class="photo" :src="inviter.user.avatar">
            </div>
            <div class="txt">
                <p class="frc1">
                    <span class="pd5 frc2 mui-ellipsis name" v-text="inviter.user.nickname" style="max-width:50%;display: block;float: left;">隔壁一枝花</span>
                    邀请您参加"垃圾分类找茬"活动，请给我一次机会吧！
                </p>
            </div>
        </div>
        <div class="playdata" v-else="inviter">
            <div class="fl">
                <img class="photo" src="/assets/activity/trash-classify/img/touxinag.png">
            </div>
            <div class="txt">
                <p class="frc1">
                    <span class="pd5 frc2 mui-ellipsis name" style="max-width:50%;display: block;float: left;">小罗号</span>
                    邀请您参加"垃圾分类找茬"活动，请给我一次机会吧！
                </p>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-share">
        <div class="share" style="display: block;">
            <div class="ft" style="padding-top: 23%;">
                <img src="/assets/activity/trash-classify/img/share.png">
            </div>
            <div class="mui-text-center">
                {{--<p>亲机会已经用完了哦，</p>--}}
                <p>点击右上角，快分享给好友参与，</p>
                <p>就可获得挑战机会！</p>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-sharepeople">
        <div class="share" style="display: none;">
            <div class="ft" style="padding-top: 23%;">
                <img src="/assets/activity/trash-classify/img/share.png">
            </div>
            <div class="mui-text-center">
            <p >点击右上角，快分享给好友参与，</p>
            <p >就可获得挑战机会！</p>
        </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-rule">
        <div class="rule-content mui-text-center" style="background-color: rgba(0, 0, 0, 0.9)";>
            {{--@{{{rule.content}}}--}}

            <img :src="rule.cover">
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-game-end">
        <div class="tooltip-box mask gameend">
            <div class="playdata" style="padding-top:10%;">
                <div class="mui-col-xs-12 mui-text-center">
                    <img src="/assets/activity/trash-classify/img/game-end.png" class="mui-col-xs-10">
                </div>
                <div class="mask_text">
                    <h3 class="frc1">活动已结束</h3>
                    <h3 class="frc1">谢谢关注</h3>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-game-to-start">
        <div class="tooltip-box mask gameend">
            <div style="padding-top:50%;">
                <div class="mui-col-xs-12 mui-text-center">
                    <div class="mui-col-xs-4 dib" >
                        <img src="/assets/activity/trash-classify/img/begin.png"  @tap="start()" class="mui-col-xs-12">
                    </div>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-not-start">
        <div class="tooltip-box mask notstarted">
            <div class="playdata" style="padding-top:10%;">
                <div class="mui-col-xs-12 mui-text-center">
                    <img src="/assets/activity/trash-classify/img/game-preview .png" class="mui-col-xs-5">
                </div>
                <div class="mask_text">
                    <h3 class="frc1">活动未开始</h3>
                    <h3 class="frc1">敬请期待</h3>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-not-focus">
        <div class="tooltip-box mask notfocus">
            <div class="playdata" style="padding-top:10%;">
                <div class="mui-col-xs-12 mui-text-center">
                    <img src="/assets/activity/trash-classify/img/code.png" class="mui-col-xs-10">
                </div>
                <div class="mask_text">
                    <h3 class="frc1">长按二维码</h3>
                    <h3 class="frc1">关注罗湖城事</h3>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-score">
        <div class="tooltip-box mask score">
            <div class="mui-col-xs-12 mui-text-right">
                <div class="dib mui-col-xs-6">
                    <img src="/assets/activity/trash-classify/img/guidance.png" class="mui-col-xs-12">
                </div>
            </div>
            <div class="mui-col-xs-12 mui-text-center mt10">
                <div class="dib mui-col-xs-8">
                    <img src="/assets/activity/trash-classify/img/cup.png" class="mui-col-xs-12">
                </div>
            </div>
            <h3 class="mui-text-center">得分：<span class="red">0</span> </h3>
            <h3 class="mui-text-center">最高：<span class="red">0</span></h3>
            <div class=" mui-text-center mui-col-xs-12 mt10">
                <div class="dib mui-col-xs-5 ">
                    <img src="/assets/activity/trash-classify/img/palyagain.png" alt="">
                </div>
                <div class="dib mui-col-xs-5  " @tap="location.href='#vui-page-home'">
                    <img src="/assets/activity/trash-classify/img/reback.png" alt="">
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-tooltips-score-single">
        <div class="toolTip-integral" style="display: block;">
            <div class="ft">
                <div class="mui-col-xs-12 mui-text-right">
                    <div class="dib mui-col-xs-5">
                        <img src="/assets/activity/trash-classify/img/guidance.png" class="mui-col-xs-12">
                    </div>
                </div>
                <div class="mui-col-xs-12 mui-text-center">
                    <div class="dib mui-col-xs-9 mt10">
                        <img src="/assets/activity/trash-classify/img/cup.png" class="mui-col-xs-12 animated tada">
                    </div>
                    <p class="f1 mt5">本轮得分:
                        <span class="red f3" v-text="current">0</span>
                    </p>
                    {{--<p class="f1 mt5">最高:--}}
                        {{--<span class="red f3" v-text="max">0</span>--}}
                    {{--</p>--}}
                </div>
                <div class="mui-col-xs-12 mt10">
                    <div class="mui-col-xs-6 fl mui-text-center" @tap="start()">
                        <div class="dib mui-col-xs-10">
                            <img src="/assets/activity/trash-classify/img/palyagain.png">
                        </div>
                    </div>
                    <div class="mui-col-xs-6 fl mui-text-center" @tap="goview('vui-page-home')">
                        <div class="dib mui-col-xs-10">
                            <img src="/assets/activity/trash-classify/img/reback.png">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-container-page">
        <div class="page js_show">
            <div class="page__bd" style="height: 100%;">
                <div class="weui-tab">
                    {{--<vui-page-navbar :currentComp="currentComp"></vui-page-navbar>--}}
                    <div class="weui-tab__panel" v-if="currentComp">
                        <component :is="currentComp"></component>
                    </div>
                    {{--<vui-page-tabbar></vui-page-tabbar>--}}
                </div>
            </div>
        </div>
    </script>
    <script type="x/template" id="vui-page-navbar">
        <div class="weui-navbar">
            <a class="weui-navbar__item" href="#vui-page-home" @tap="goview('vui-page-home')">
                首页
            </a>
            <a class="weui-navbar__item" href="#vui-page-rank" @tap="goview('vui-page-rank')">
                排行榜
            </a>
            <a class="weui-navbar__item" href="#vui-page-boddy" @tap="goview('vui-page-boddy')">
                好友
            </a>
            <a class="weui-navbar__item" href="#vui-page-game" @tap="goview('vui-page-game')">
                游戏
            </a>
            <a class="weui-navbar__item" href="#vui-page-invite" @tap="goview('vui-page-invite')">
                助力
            </a>
        </div>
    </script>
    <script type="x/template" id="vui-page-tabbar">
        <div class="weui-tabbar">
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-share', $event)">
                <p class="weui-tabbar__label">分享弹窗</p>
            </a>
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-rule', $event)">
                <p class="weui-tabbar__label">活动规则</p>
            </a>
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-game-end', $event)">
                <p class="weui-tabbar__label">活动结束</p>
            </a>
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-not-start', $event)">
                <p class="weui-tabbar__label">未开始</p>
            </a>
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-not-focus', $event)">
            <p class="weui-tabbar__label">未关注</p>
            </a>
            <a href="javascript:;" class="weui-tabbar__item" @tap="tooltips('vui-tooltips-score', $event)">
            <p class="weui-tabbar__label">分数</p>
            </a>
        </div>
    </script>
    <script type="text/javascript">
        user        =   {!! json_encode($user) !!};
        activity    =   {!! json_encode($activity) !!};
        inviter     =   {!! json_encode($inviter) !!};
        attendee    =   {!! json_encode($attendee) !!};
        defaultView =   {!! isset($default_view)? json_encode($default_view): json_encode(null) !!};
        wxjs        =   {!! json_encode($wxjsconf) !!};
        _token      =   {!! json_encode(csrf_token()) !!};
        urls    =   {
            info: "/activity/trash/pickout/info",
            user: "/activity/trash/pickout/user",
            attend: "/activity/trash/pickout/attend",
            support: "/activity/trash/pickout/support",
            attendee: "/activity/trash/pickout/attendee",
            paper: "/activity/trash/pickout/paper",
            answer: "/activity/trash/pickout/answer",
            classes: "/activity/trash/pickout/all/classes",
            trashes: "/activity/trash/pickout/all/trashes",
            jsconf: "/activity/wxjs/config",
            popular: "/activity/trash/pickout/rank/popular",
            talent: "/activity/trash/pickout/rank/talent",
            mvp: "/activity/trash/pickout/rank/mvp",
            supported: "/activity/trash/pickout/supporteds",
            supporter: "/activity/trash/pickout/supporters",
            populars: "/activity/trash/pickout/populars",
            talents: "/activity/trash/pickout/talents",
            mvps: "/activity/trash/pickout/mvps",
        };
        topics      =   null;
        options     =   null;
	personrank = 0;
	personscore = 0;
        duration    =   60000;  //60000ms, 60s
        count       =   6;
        delta       =   1;
        deltaFail   =   1;
        if (! Array.prototype.shuffle) {
            Array.prototype.shuffle = function() {
                for(var j, x, i = this.length;
                    i;
                    j = parseInt(Math.random() * i), --i, x = this[i], this[i] = this[j], this[j] = x);

                return this;
            };
        }
        Game        =   {
            count: count,
            topic: null,
            topics: [],
            trashes: [],
            topicTrashes: [],
            allTopics: [],
            allTrashes: [],
            start: function(){
                //从所有的分类中随机出一个
                this.allTopics  =   [].concat(topics);      //使用concat，避免直接修改topics
//                this.allTrashes =   [].concat(options);
                idx     =   this.rand(this.allTopics);
                this.topic     =   this.allTopics[idx];
                this.topicTrashes   =   [].concat(this.topic.options);
                this.allTopics.splice(idx, 1);  //将随机到的垃圾箱移除
                this.topics   =   [].concat(this.allTopics);

                //allTrashes修改为剩余的三个分类对应的垃圾
                this.allTrashes =   [];
                for(j in this.allTopics) {
                    if (this.allTopics[j]) {
                        this.allTrashes =   this.allTrashes.concat(this.allTopics[j].options);
                    }
                }
                this.refresh();

//                if (this.check(this.topic, this.trashes)) {
//                    this.start();
//                }
            },
            rand: function(arr){
                idx = Math.floor((Math.random() * arr.length));
                return idx;
            },
            refresh: function(){
                _trashes   =   [];
                //splice用于避免重复出现，导致vue异常
                //_tmp_arr使用concat，避免影响本轮测试中的数据被splice删除
                _tmp_arr    =   [].concat(this.topicTrashes);
                for(i = 0; i < 4; i ++) {
                    idx     =   this.rand(_tmp_arr);
                    if (! _tmp_arr[idx]) {
                        i --;
                    } else {
                        _trashes    =   _trashes.concat(_tmp_arr.splice(idx, 1));
                    }
                }
                _tmp_arr    =   [].concat(this.allTrashes);
                for(i = 0; i < 2; i ++) {
                    idx     =   this.rand(_tmp_arr);
                    if (! _tmp_arr[idx]) {
                        i --;
                    } else {
                        _trashes = _trashes.concat(_tmp_arr.splice(idx, 1));
                    }
                }
                this.trashes    =   _trashes.shuffle();
                return this.trashes;
            },
            check: function(clss, trashes){
                //检查是否所有的垃圾都是clss分类
                length  =   trashes.length;
                if (! clss || ! trashes || ! trashes.length) {
                    return false;
                }
                for(idx in trashes) {
                    if (clss.id != trashes[idx].topic_id) {
                        //只要有任意一个不是，则否
                        return false;
                    }
                }
                return true;
            },
            pickup: function(clss, trash){
                if (trash.topic_id != clss.id) {
                    return true;
                }
                return false;
            },
        };
        sharecallback   =   function(event){
            //$.ajaxSettings.context = this;
            wxjs.callback.data.event = event.errMsg;
            wxjs.callback.data._token = _token;
            $.post(wxjs.callback.url, wxjs.callback.data, function(resp){
                if (resp.errcode == "0000" && wxjs.callback.redirect) {
                    location.href=wxjs.callback.redirect;
                }
            });
        };
        wxjs.share.complete = sharecallback;
        wxjs.timeline.complete = sharecallback;
        wx.error = sharecallback;
        wx.ready(function(){
//            if (! subscribe) {
//                wx.hideAllNonBaseMenuItem();    //隐藏所有非基础按钮接口
//                wx.hideOptionMenu();        //隐藏右上角菜单接口
//            }
            wx.onMenuShareAppMessage(wxjs.share);
            wx.onMenuShareQQ(wxjs.share);
            wx.onMenuShareTimeline(wxjs.timeline);
            wx.onMenuShareWeibo(wxjs.share);
        });
        if (wxjs && wxjs.config) {
            wx.config(wxjs.config);
        } else {
            $.getJSON(urls.jsconf, {
                actid: activity.id,
            }, function(res){
                wx.config(res);
            });
        };
        attend  =   function(){
            $.getJSON(urls.attend, {
                actid: activity.id,
                invid: inviter? inviter.id: 0,
            }, function(res){
                console.log(res);
                if (res) {
                    if (res.errcode == "0000") {
                        attendee    =   res.attendee;
                        if (app) {
                            app.$set("attendee", res.attendee);
                        }
                    } else if (res.errcode == "1001") {
                        //未开始
                        vuiTtips && vuiTtips.show("vui-tooltips-not-start", evt);
                    } else if (res.errcode == "1002") {
                        //已结束
                        vuiTtips && vuiTtips.show("vui-tooltips-game-end", evt);
                    } else if (res.errcode == "1003") {
                        //未关注
                        vuiTtips && vuiTtips.show("vui-tooltips-not-focus", evt);
                    } else if (res.errcode == "1004") {
                        //没有参与次数
                        vuiTtips && vuiTtips.show("vui-tooltips-not-focus", evt);
                    }
                }
            });
        };
        support  =   function(ss){
            $.getJSON(urls.support, {
                actid: activity.id,
                invid: inviter? inviter.id: 0,
            }, function(res){
                console.log(res);
                if (res) {
		            mui.toast(res.errcode == '0000'?'助力成功':res.errmsg);
                    if (res.errcode == "0000") {

                        attendee    =   res.attendee;
                        if (app) {
                            app.$set("attendee", res.attendee);
                        }
                        $('#msgbg').attr('src','/assets/activity/trash-classify/img/issupport.png');
                        ss.$off('tap');
                    } else if (res.errcode == "1001") {
                        //未开始
                        vuiTtips && vuiTtips.show("vui-tooltips-not-start", evt);
                    } else if (res.errcode == "1002") {
                        //已结束
                        vuiTtips && vuiTtips.show("vui-tooltips-game-end", evt);
                    } else if (res.errcode == "1003") {
                        //未关注
                        vuiTtips && vuiTtips.show("vui-tooltips-not-focus", evt);
                    } else if (res.errcode == "1004") {
                        //没有参与次数
                        vuiTtips && vuiTtips.show("vui-tooltips-not-focus", evt);
                    }
                }
            });
        };
        vuiPageTabBer   =   Vue.component("vui-page-tabbar", {
            template: "#vui-page-tabbar",
            methods: {
                tooltips: function(res, evt){
                    console.log(res);
                    console.log(evt);
                    vuiTtips.show(res, evt);
                },
            }
        });
        vuiPageNavBer   =   Vue.component("vui-page-navbar", {
            template: "#vui-page-navbar",
            methods: {
                goview: function(res){
                    this.$parent.$set('currentView', res);
                },
            },
        });
        vuiGameResouceLoading     =   Vue.component("vui-game-res-loading", {
            template: "#vui-game-res-loading",
            methods: {
            },
            ready: function(){
                self    =   this;
                $.getJSON(urls.classes, {
                    actid: activity.id,
                }, function(res){
                    console.log(res);
                    if (res && res.errcode == "0000") {
                        topics     =   res.classes;
//                        Game.allTopics   =   res.classes;
                        //以便进行图片预加载
                        self.$parent.$set("classes", res.classes);
                    }
                });
                $.getJSON(urls.trashes, {
                    actid: activity.id,
                }, function(res){
                    console.log(res);
                    if (res && res.errcode == "0000") {
                        options     =   res.trashes;
//                        Game.allTrashes   =   res.trashes;
                        //以便进行图片预加载
                        self.$parent.$set("trashes", res.trashes);
                    }
                });
            },
            detached: function(){
                vuiTtips.show("vui-tooltips-game-to-start");
            },
        });
        vuiGameResouceList =   Vue.component("vui-game-res-list", {
            template: "#vui-game-res-list",
            props: [
                    "classes", "trashes", "loading", "loaded",
            ],
        });
vuiPageHome     =   Vue.component("vui-page-home", {
    template: "#vui-page-home",
      ready:function () {$("body").unbind("touchmove");},
    props: [
            "user", "attendee", "activity",
    ],
    methods: {
        tooltips: function(res, evt){
            console.log(res);
            console.log(evt);
            vuiTtips.show(res, evt);
        },
        attend: function(evt){
            console.log(this.activity.status);
            if (! this.activity || this.activity.status == 0) {
                vuiTtips.show("vui-tooltips-not-start", evt);
                return;
            }
            if (! this.activity || this.activity.status == 2) {
                vuiTtips.show("vui-tooltips-game-end", evt);
                return;
            }
            //判断用户是否关注
            if (! this.user || this.user.status != 1) {
                console.log(this.user);
                vuiTtips.show("vui-tooltips-not-focus", evt);
                return;
            }
            if (! this.attendee) {
                console.log(this.attendee);
                attend();
                return;
            }
            //判断用户是否有参与次数
            if (! this.attendee || this.attendee.stock_cnt <= 0) {
                console.log(this.attendee);
                vuiTtips.show("vui-tooltips-share", evt);
                return;
            }
            location.href="#vui-page-game";
//            goview('vui-page-game');
        },
    },
});
vuiPageRank     =   Vue.component("vui-page-rank", {
    template: "#vui-page-rank",
   ready:function () {$("body").unbind("touchmove");},
    props: [
            "rank", "attendee", "populars", "talents", "mvps", "personrank", "score", "ranks", "score", "activity", "user", "page",
    ],
    methods: {
        isActive: function(rankName){
            if (this.ranks == rankName) {
                return "mui-active";
            } else {
                return;
            }
        },
    },
});
        vuiTtipsGameToStart =   Vue.component("vui-tooltips-game-to-start", {
            template: "#vui-tooltips-game-to-start",
            ready: function(){
                this.$parent.$set("force", true);
            },
            methods: {
                start: function() {
                    if (! Panel || ! Panel.user || ! Panel.attendee) {
                        return;
                    }
                    if (Panel.isStart || Panel.toStart) {
                        return;
                    }
                    Panel.start(function(){

                    });
                },
            },
        });
vuiPageGame     =   Vue.component("vui-page-game", {
    template: "#vui-page-game",
    props: [
            "topic", "topics", "options", "paper", "papers",
        "attendee", "user", "activity",
        "max", "count", "total", "current", "timer", "isStart", "remainder", "toStart",
    ],
    ready: function(){
        console.log("Panel.ready");
        $("body").on("touchmove", function (event) {
            event.preventDefault();
        });
        if (! this.remainder) {
            this.remainder      =   0;
        }
        if (! this.isStart) {
            this.isStart      =   false;
        }
        if (! this.toStart) {
            this.toStart      =   false;
        }
        if (! this.current) {
            this.current      =   0;
        }
        if (! this.count) {
            this.count      =   0;
        }
        if (! this.total) {
            this.total      =   0;
        }
        if (! this.max) {
            this.max      =   0;
        }
        Panel   =   this;   //保存游戏页面实例
        $.getJSON(urls.mvps,{
            actid: this.activity.id ? this.activity.id : 0,
            attndid: this.attendee? this.attendee.id: 0,
        },function(res){
            if (res && res.errcode == "0000") {
                Panel.max = res.score;
            }
        });
    },
    methods: {
        resultTooltips: function(){
            clearInterval(Panel.timer);
            this.isStart        =   false;
            this.paper.count    =   this.count;
            this.paper.current  =   this.current;
                if (this.current > this.max) {
                    this.max    =   this.current;
                }
            if (! this.papers) {
                this.papers     =   [];
            }
            this.papers.push(this.paper);   //保存答卷
            vuiTtips.max        =   this.max;
            vuiTtips.current    =   this.current;
            vuiTtips.force      =   false;
            vuiTtips.show('vui-tooltips-score-single');
        },
        pickout: function(idx, option, evt) {
            if (! this.isStart) {
                //未开始或已结束
                this.resultTooltips();
                return;
            }
            self    =   this;
            option_ids     =   [];
            for(ii in this.options) {
                option_ids.push(this.options[ii].id);
            }
            $.getJSON(urls.answer, {
                actid: this.activity.id,
                paper_id: this.paper.id,
                topic_id: this.topic.id,
                option_id: option.id,
                options: option_ids,
            }, function(res){
                if (! res || res.errcode != "0000") {
                    console.log(res);
                }
            });
            this.count      +=  1;

		  var correct=document.getElementById("music-correct");
		  var mistake=document.getElementById("music-mistake");

            if (this.topic.id != option.topic_id) {
                //正确，垃圾不属于当前垃圾箱
                console.log("bingo！");
		correct.play();//音乐
                this.current    +=  delta;
//                if (this.current > this.max) {
//                    this.max    =   this.current;
//                }
                //打星动态
                $(this.$el).find(".star").addClass("vanishOut").css("display", "block");
                setTimeout(function () {
                    $(self.$el).find(".star").css("display", "none").removeClass("vanishOut");
                }, 500);
                //垃圾处理
                target  =   $(evt.target).clone();
                box     =   $(evt.target).parents(".rubbish").siblings(".rubbish-pickout");
                box.find("div").text("").append(target);
                target.removeClass("vanishIn")
                        .addClass("rotateUp");
                //随机一个新的垃圾
//                indx     =   Game.rand(Game.allTrashes);
//                trash    =   Game.allTrashes.splice(indx, 1, option);
//                self.options.splice(idx, 1, trash[0]);
                Game.trashes    =   [];
                Game.refresh();
                Panel.$set("options", Game.trashes);
                console.log(Panel.options);
                setTimeout(function () {
                    target.remove();    //似乎无效
                }, 400);
                //垃圾箱动态
                imgTopic  =   $(this.$el).find(".rubbish_box [data-topic-id=" + option.topic_id + "]");
                imgUrl      =   imgTopic.attr("src");
                imgTopic.attr("src", imgUrl.replace(/.png/ig, ".gif"));
                setTimeout(function () {
                    imgTopic.attr("src", imgUrl.replace(/.gif/ig, ".png"));
                }, 200);
            } else {
                //错误，垃圾属于当前垃圾箱
                if (! this.current) {
                    this.current    =   0;
                }
                if (this.current <= 1) {
                    this.current    =   0;
                } else {
                    this.current    -=  deltaFail;
                }
		mistake.play();//音乐
                //垃圾处理
                target  =   $(evt.target).clone();
                box     =   $(evt.target).parents(".rubbish").siblings(".rubbish-pickout");
                box.find("div").text("").append(target);
                target.removeClass("vanishIn")
                        .addClass("tada")
                        .attr("src", "/assets/activity/trash-classify/img/boom.png");
                setTimeout(function () {
                    target.remove();    //似乎无效
                }, 200);
                //随机一个新的垃圾
//                indx     =   Game.rand(Game.allTrashes);
//                trash    =   Game.allTrashes.splice(indx, 1, option);
//                self.options.splice(idx, 1, trash[0]);
                Game.trashes    =   [];
                Game.refresh();
                Panel.$set("options", Game.trashes);
                console.log(Panel.options);
            }
        },
        start: function(cblk) {
            if (! Panel || ! Panel.user || ! Panel.attendee) {
                return;
            }
            if (Panel.isStart || Panel.toStart) {
                return;
            }
            Panel.toStart   =   true;
            if (Panel.attendee.stock_cnt <= 0) {
                vuiTtips.show("vui-tooltips-share");
                return;
            }
            //创建一份答卷
            $.getJSON(urls.paper, {
                actid: activity.id,
            }, function(res){
                Panel.started(res);
                if (Panel.isStart) {
                    //是否成功？是，则回调
                    cblk(); //回调
                }
            });
        },
        started: function(res){
            if (! Panel.toStart || Panel.isStart) {
                return;
            }
            if (res && res.paper) {
                paper   =   res.paper;
                Panel.attendee.stock_cnt    =   Panel.attendee.stock_cnt - 1;
                //重新生成一下数据
                Game.start();
                if (! Panel.max) {
                    Panel.$set("max", 0);
                }
                Panel.$set("count", 0);
                Panel.$set("current", 0);
                Panel.$set("remainder", duration/1000);
                Panel.$set("isStart", true);
                Panel.$set("toStart", false);
                Panel.$set("paper", res.paper);
                Panel.$set("topic", Game.topic);
                Panel.$set("topics", Game.topics);
                Panel.$set("options", Game.trashes);
                vuiTtips.force = false;
                vuiTtips.hide();
                timer   =   setInterval(function(){
                    if (Panel.remainder > 0) {
                        Panel.remainder -=  1;
                    } else {
                        //结束
                        Panel.remainder =   0;
                        Panel.isStart   =   false;
                        Panel.resultTooltips();
                    }
                }, 1000);
                Panel.$set("timer", timer);
            }
        },
    },
});
vuiPageInvite   =   Vue.component("vui-page-invite", {
    template: "#vui-page-invite",
    ready:function () {
        $("body").unbind("touchmove");
    },
    props: [
        "user", "attendee", "activity", "inviter", "flag",
    ],
    init: function(){
        if (! inviter) {
            location.href = "#vui-page-home";
        }
        var _this = this;
        $.getJSON(urls.supported  , {
            actid: self.activity.id,
        }, function (resp) {
            _this.flag = false;
            if (resp.errcode == '0000' && resp.supporteds.length > 0) {
                for(var i=0; i<resp.supporteds.length; i++){
                    if(resp.supporteds[i].inviter.user.nickname == inviter.user.nickname){
                        _this.flag = true;
                        console.log(_this.flag);
                    }
                }
            }
        })
    },
    methods: {
        tooltips: function(res, evt){
            vuiTtips.show(res, evt);
        },
        attend:function () {
            location.href = "{{ url('activity/trash/pickout/index') }}" + "?actid=" + this.activity.id;
        },
        support: function(evt){
            console.log(evt);
            if (! this.activity || this.activity.status == 0) {
                vuiTtips.show("vui-tooltips-not-start", evt);
                return;
            }
            if (! this.activity || this.activity.status == 2) {
                vuiTtips.show("vui-tooltips-game-end", evt);
                return;
            }
            //判断用户是否关注
            if (! this.user || this.user.status != 1) {
                vuiTtips.show("vui-tooltips-not-focus", evt);
                return;
            }
            //判断用户是否有助力次数
            console.log(this.attendee);
            if (this.attendee && this.attendee.support_cnt <= 0) {
                //vuiTtips.show("vui-tooltips-share", evt);
		mui.toast("你的助力次数已经超过指定的上限啦");
                return;
            }
            support(this);
        },
    },
});
vuiPageBoddy    =   Vue.component("vui-page-boddy", {
    template: "#vui-page-boddy",
    props: [
        "supporters", "supporteds", "boddy", "attendee", "user", "activity",
    ],
    methods: {
        isActive: function(rankName){
            if (this.boddy == rankName) {
                return "mui-active";
            } else {
                return;
            }
        },
    }
});
        vuiBoddySupported    =   Vue.component("vui-boddy-supported", {
            template: "#vui-boddy-supported",
            props: [
                "supporteds", "boddy", "attendee", "user", "activity", "page",
            ],
            ready: function(){
                self    =   this;
                $.getJSON(urls.supported, {
                    actid: self.activity.id,
                    page: self.page? self.page: 0,
                }, function(res){
                    if (res && res.errcode == "0000") {
                        self.$set("supporteds", res.supporteds);
                    }
                });

            },
        });
        vuiBoddySupporter    =   Vue.component("vui-boddy-supporter", {
            template: "#vui-boddy-supporter",
            props: [
                "supporters", "boddy", "attendee", "user", "activity", "page",
            ],
            ready: function(){
                self    =   this;
                $.getJSON(urls.supporter, {
                    actid: self.activity.id,
                    page: self.page? self.page: 0,
                }, function(res){
                    if (res && res.errcode == "0000") {
                        self.$set("supporters", res.supporters);
                    }
                });
            },
        });
vuiRankPopular  =   Vue.component("vui-rank-popular", {
    template: "#vui-rank-popular",
    props: [
            "populars", "rank", "score", "attendee", "user", "activity", "page", "ranks",
    ],
    ready: function(){
        self    =   this;
        $.getJSON(urls.populars, {
            actid: self.activity.id,
            attndid: self.attendee? self.attendee.id: 0,
            page: self.page? self.page: 0,
        }, function(res){
            if (res && res.errcode == "0000") {
                self.$parent.$set("populars", res.populars);
                self.$parent.$set("rank", res.rank);
                self.$parent.$set("score", res.score);
            }
        });
    },
});
vuiRankTalent  =   Vue.component("vui-rank-talent", {
    template: "#vui-rank-talent",
    props: [
        "talents", "rank", "score", "attendee", "user", "activity", "page", "ranks",
    ],
    ready: function(){
        self    =   this;
        $.getJSON(urls.talents, {
            actid: self.activity.id,
            attndid: self.attendee? self.attendee.id: 0,
            page: self.page? self.page: 0,
        }, function(res){
            if (res && res.errcode == "0000") {
                self.$parent.$set("talents", res.talents);
                self.$parent.$set("rank", res.rank);
                self.$parent.$set("score", res.score);
            }
        });
    },
});
vuiRankMVP  =   Vue.component("vui-rank-mvp", {
    template: "#vui-rank-mvp",
    props: [
        "mvps", "rank", "score", "attendee", "user", "activity", "page", "ranks",
    ],
    ready: function(){
        self    =   this;
        $.getJSON(urls.mvps, {
            actid: self.activity.id,
            attndid: self.attendee? self.attendee.id: 0,
            page: self.page? self.page: 0,
        }, function(res){
            if (res && res.errcode == "0000") {
                self.$parent.$set("mvps", res.mvps);
                self.$parent.$set("rank", res.rank);
                self.$parent.$set("score", res.score);
            }
        });
    },
});
vuiUserProfInviter    =   Vue.component("vui-user-profile-inviter", {
    template: "#vui-user-profile-inviter",
    props: [
            "inviter",
    ],
});
vuiTtipsShare =   Vue.component("vui-tooltips-share", {
    template: "#vui-tooltips-share",
});
vuiTtipsSharepeople =   Vue.component("vui-tooltips-sharepeople", {
    template: "#vui-tooltips-sharepeople",
});
vuiTtipsRule =   Vue.component("vui-tooltips-rule", {
    template: "#vui-tooltips-rule",
    //props的属性将会将模板变更成类似<div class="rule-content" rule="activity? activity.rule: activity">...</div>
    //因此根结点一般不带数据访问
    props: [
            "rule",
    ],
    //使用函数进行返回的方法是可行的
//    data: function(){
//            console.log(activity);
//            console.log(activity.rule);
//            console.log(activity.rule.content);
//            return {
//                rule: activity.rule,
//            };
//    },
});
vuiTtipsGameEnd =   Vue.component("vui-tooltips-game-end", {
    template: "#vui-tooltips-game-end",
});
vuiTtipsNotStart =   Vue.component("vui-tooltips-not-start", {
    template: "#vui-tooltips-not-start",
});
vuiTtipsNotFocus =   Vue.component("vui-tooltips-not-focus", {
    template: "#vui-tooltips-not-focus",
});
vuiTtipsScore   =   Vue.component("vui-tooltips-score", {
    template: "#vui-tooltips-score",
    ready: function(evt){
        this.$parent.$set("force", true);
    },
});
        vuiTtipsScoreSingle   =   Vue.component("vui-tooltips-score-single", {
            template: "#vui-tooltips-score-single",
            props: [
                    "current", "max",
            ],
            ready: function(evt){
                this.$parent.$set("force", true);
            },
            methods: {
                start: function(){
                    if (! Panel || ! Panel.user || ! Panel.attendee) {
                        return;
                    }
                    if (Panel.isStart || Panel.toStart) {
                        return;
                    }
                    Panel.start(function(){
//                        vuiTtips.force  =   false;
//                        vuiTtips.hide();
                    });
                },
                goview: function(res){
                    vuiTtips.force  =   false;
                    vuiTtips.hide();
                    //app.$set('currentView', res);
		    location.href = "#"+res;
		    console.log(app.currentView);
                },
            },
        });
        vuiTtips    =   new Vue({
            el: "#vui-tooltips",
            data: {
                tooltips: "vui-tooltips-share",
                activity: activity,
                user: user,
                attendee: attendee,
                force: false,
            },
            methods: {
                show: function(res, evt){
//                    console.log(res);
//                    console.log(evt.target);
//                    console.log($(evt.target).data("href"));
                    this.$set("tooltips", res);
                    $(this.$el).removeClass("mui-hidden").addClass("mui-active");
                },
                hide: function(evt){
                    console.log(evt);
                    if (this.force) {
                        return;
                    }
                    $(this.$el).addClass("mui-hidden").removeClass("mui-active");
                    this.tooltips   =   null;
                },

            },
        });
if (defaultView) {
    anchor  =   defaultView;
} else {
    anchor          =   window.location.hash.slice(1);
    if (! anchor) {
        anchor      =   "vui-page-home";
    }
}
app   =   new Vue({
    el: '#app',
    data: {
        currentView: anchor,
        activity: activity,
        user: user,
        attendee: attendee,
        inviter: inviter,
        ranks: null,
        invitees: null,
    },
});
$(window).on("hashchange", function(evt){
    anchor  =   window.location.hash.slice(1);
    if (! anchor) {
        anchor      =   "vui-page-home";
    }
    app.$set("currentView", anchor);
});
$(function(){
    goview= function(res) {
        app.$set("currentView", res);
    };
    $.getJSON(urls.info, {
        actid: activity.id,
    }, function(res){
        console.log(res);
        if (res && res.errcode == "0000") {
            activity    =   res.activity;
            if (app) {
                app.$set("activity", activity);
            }
            if (vuiTtips) {
                vuiTtips.$set("activity", activity);
            }
        }
    });
    $.getJSON(urls.user, {
        actid: activity.id,
    }, function(res){
        console.log(res);
        if (res && res.id) {
            user    =   res;
            if (app) {
                app.$set("user", res);
            }
        }
    });
    $.getJSON(urls.attendee, {
        actid: activity.id,
    }, function(res){
        console.log(res);
        if (res || res.errcode == "0000") {
            attendee    =   res.attendee;
            if (app) {
                app.$set("attendee", res.attendee);
            }
        }
    });
});
mui.init({
    swipeBack: true //启用右滑关闭功能
});

    document.getElementById('music').play();
    var firstTouch = true;
    $('body').bind("touchstart", function (e) {
        if (firstTouch) {
            firstTouch = false;
            document.getElementById('music').play();
        } else {
            return;
        }
    });

    $('.music').click(function () {
        var Omusic = document.getElementById('music')
        if ($('.music').hasClass('play')) {
            Omusic.pause()
            $('.music').removeClass("play")
        }
        else {
            $('.music').addClass('play');
            Omusic.play()
        }
    })

    </script>
@endsection