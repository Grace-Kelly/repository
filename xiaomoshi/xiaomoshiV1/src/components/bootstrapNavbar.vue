
<template>
    <nav class="navbar navbar-toggleable-md navbar-light" 
    :class="computeClass(Navbar)"
    :style="{
        backgroundColor:Navbar[0].backgroundColor,
    
        borderTopStyle:Navbar[0].borderTopStyle,
        borderTopColor:Navbar[0].borderTopColor,
        borderTopWidth:Navbar[0].borderTopWidth+'px',
        borderBottomStyle:Navbar[0].borderBottomStyle,
        borderBottomColor:Navbar[0].borderBottomColor,
        borderBottomWidth:Navbar[0].borderBottomWidth+'px',
        borderLeftStyle:Navbar[0].borderLeftStyle,  
        borderLeftColor:Navbar[0].borderLeftColor,
        borderLeftWidth:Navbar[0].borderLeftWidth+'px',
        borderRightStyle:Navbar[0].borderRightStyle,
        borderRightColor:Navbar[0].borderRightColor,
        borderRightWidth:Navbar[0].borderRightWidth+'px'
    }"
    >
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!--使用文字-->
        <a class="navbar-brand" v-if=ture href="#" v-on:click="cs">{{Navbar[0].borderTopStyle}}</a>
        <!--使用图片-->
        <a class="navbar-brand" href="#" v-else>
            <img src="http://static.xh.sustc.edu.cn/group1/M00/02/FF/rBIBPFjQoYuAGkbpAAl5WLU-YRY648.jpg" width="30" height="30" alt="">
        </a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>  
</template>
<script>

let bootstrapNavbar = {
    name: 'bootstrapNavbar',
    data() {
        return {
        };
    },
    methods: {
        computeClass:function(res){
         if (res.status == "未立案") {
                return "frc3"
            }
        },
        cs:function(){
            console.log(    "borderTopStyle:"+this.Navbar[0].borderTopStyle+";borderTopColor:"+this.Navbar[0].borderTopColor+";borderTopWidth:"+this.Navbar[0].borderTopWidth)
            //   console.log( Navbar[0].borderTopStyle+
            //  Navbar[0].borderTopColor+
            //  Navbar[0].borderTopWidth);
        }
    },
    props: [
      "Navbar"
    ],
    components: {
  
    },
    mounted () {
        console.log("加载完成bootstrapNavbar");
       
    }
};



export default bootstrapNavbar;
</script>
<style lang='scss' scoped>
.mui-bar-nav a , .mui-bar-nav h1{
    color: #F8884D;
}
.classA{
  color: #000!important;  
}
</style>
