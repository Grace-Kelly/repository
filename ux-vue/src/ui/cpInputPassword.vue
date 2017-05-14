<template>
    <div>
        <ul class="cpPlane"> 
            <li >
                <a  @click="xmsOutIn('plane')">面板1</a>
                <div class="xms-close plane">
                    <p>面板1子内容</p>
                </div>
            </li>
             <li >
                <a  @click="xmsOutIn('plane')">面板1</a>
                <div class="xms-close plane">
                    <p>面板1子内容</p>
                </div>
            </li>
        </ul>
    </div>
</template>
<script>
    let cpInputPassword = {
        name: 'cpInputPassword',
        data() {
            return {
            };
        },
        computed:{

        },
        methods:{
            xmsOutIn(e){
                 var el = event.currentTarget;
                if($(el).next().hasClass("xms-close")){

                    $(el).next().removeClass("xms-close").addClass("xms-open").addClass("fadeTopIn");
                }
                else{

                    $(el).next().removeClass("xms-open").addClass("xms-close");
              
                }
            }
        },
        components: {
        },
        mounted() {
               console.log("加载完成cpInputPassword")
          
        }
    };
    export default cpInputPassword;
</script>
<style lang='scss' scoped>

.cpPlane{
    position: relative;
    list-style: none;
    background-color: #fff;
    li{
    position: relative;
    overflow: hidden;
    cursor: pointer;
    a{
        position: relative;
        display: block;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        color: inherit;
        text-decoration: none;
        color: #007aff;
    }
    a:after {
        right: 15px;
        content: '\e583';
        font-family: Muiicons;
        font-size: inherit;
        line-height: 1;
        position: absolute;
        top: 50%;
        display: inline-block;
        text-decoration: none;
        color: #bbb;
        -webkit-font-smoothing: antialiased;
    }
    .plane{
            position: relative;
            overflow: hidden;
            padding: 8px 15px;
            height: 0px;
            background: #fff;
             transition: all 0.3s cubic-bezier(0,1,.4,1);
    }
    .xms-open{
        height: auto;
// display: block;
 -webkit-transform: translate(0, 0);
        transform        : translate(0, 0);
              
    }
    .xms-close{
        // display: none;
        -webkit-transform: translate(-100%, 0);
    transform        : translate(-100%, 0);
           
    }

    }

}









</style>