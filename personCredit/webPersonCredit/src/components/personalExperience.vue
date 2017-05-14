<template>
                  <div class="personal-form">
                    <p class="topHint">简历录入提交后不可再修改，只可新增加某些功能！</p>
                      <div class="list-box"> 
                        <div class="list-input">
                           <p class="">  <span class=" iconHint iconfont icon-iconfont"> </span> <span class="fcRed f15 ">个人信息</span> </p> 
                        </div>
                        </div>
                       <div>
                      <div class="list-box">
                        <div class="list-input">
                            <p class=" "> <span class="fcRed f14">* &nbsp;  &nbsp;</span>姓名</p>
                            <input    placeholder="请填写" v-model="personalExperience.name">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.name">
                            姓名不能为空
                          </div>
                      </div>
                        <div class="list-box">
                        <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>性别</p>
                             <div class="gender" >  
                               <p @click="gender" :class="selectNan? 'grey' : 'blue'"> <span :class="selectNan? 'grey' : 'blue'" class="iconfont icon-nan"></span>男</p>
                               <p @click="gender" :class="selectNv? 'grey' : 'red'"> <span :class="selectNv? 'grey' : 'red'" class="iconfont icon-nv" > </span>女</p>
                             </div>
                            <!--<input  v-model="personalExperience.gender"  placeholder="姓名">-->
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.gender">
                            专业不能为空
                          </div>
                        </div>
<!--                        
                        <div class="list-box">
                          <div class="list-input" @click="selectbornyear">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>出生日期</p>
                            <input  disabled   v-model="personalExperience.bornyear" placeholder="请选择 >">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.bornyear">
                            出生日期不能为空
                          </div>
                        </div>-->
                        <div class="list-box">
                          <div class="list-input" @click="open('picker4')">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>出生日期</p>
                            <input  disabled   v-model="personalExperience.bornDate" placeholder="请选择 >">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.bornDate">
                            出生日期不能为空
                          </div>
                        </div>
                        <div class="list-box">
                          <div class="list-input">
                              <p class=" "><span class="fcRed f14">* &nbsp; </span>手机号码</p>
                              <input class="verification"  disabled  :placeholder="this.phoneNumber">
                              <button   class="verificationCode f14" @click='gotoPage("page7")'> 修改</button>
                          </div>
                          <!--<div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personal.seccode">
                            验证码不能为空
                          </div>-->
                        </div>
                      <div class="list-box">
  <div class="list-input" @click="selectworkyear">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>开始工作年份</p>
                            <input  disabled  v-model="personalExperience.workYear"  placeholder="请选择 >">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14"   v-if="!personalExperience.workYear">
                             开始工作年份不能为空
                          </div>
                        </div>

                      <div class="list-box">
                         <div class="list-input" @click="selectaddress">
                            <p class="" ><span class="fcRed f14">* &nbsp; </span>目前居住地</p>
                         <input  disabled  v-model="personalExperience.address" placeholder="请选择 > ">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.address">
                            目前居住地不能为空
                          </div>
                        </div>

                      <div class="list-box">
                         <div class="list-input">
                            <p class=" "><span class="fcRed f14">* &nbsp; </span>邮箱</p>
                            <input  v-model="personalExperience.email"  placeholder="请填写">
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.email">
                            邮箱不能为空
                          </div>
                        </div>


                      <div class="list-box">
                        <div class="list-input">
                            <p class=""><span class="fcRed f14">* &nbsp; </span>目前年收入</p>
                         <input class="verification" v-model="income" v-on:blur="Blurincome" placeholder="请填写">
                          <button   class="verificationCode f14"> 万元</button>
                        </div>
                          <div class="texthint mui-text-right mui-col-xs-12 f14" v-if="!personalExperience.income">
                            目前年收入不能为空
                          </div>
                        </div>


                    </div>
                        
                        <div class="mui-text-center mui-col-xs-12 mgt20 mgb20">
                          <div @click="nextList" class="bgc btn-next">下一步</div>
                        </div>
                        <!--address弹出框组件-->
 <mt-popup v-model="popupAddressVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='canceladdress' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determineaddress' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker  :slots="addressSlots" @change="onChangeaddress" :visible-item-count="5"></mt-picker>
</div>
</mt-popup>
<!--workyear弹出框组件-->
 <mt-popup v-model="popupWorkyearVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancel' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determine' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker :slots="yearSlot" @change="onChangeworkyear" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>

<!--bornyear弹出框组件-->
 <mt-popup v-model="popupBornyearVisible" position="bottom" class="mui-col-xs-12" >
  <div class="oh wsnrp"> <div @click='cancelbornyear' class="mui-col-xs-6 fc dib mui-text-center">取消</div><div @click='determinebornyear' class="fc mui-text-center mui-col-xs-6 dib">确定</div></div>
<div class="bgc0">
   <mt-picker  :slots="yearSlot" @change="onChangebornyear" :visible-item-count="3"></mt-picker>
</div>
</mt-popup>


 <mt-datetime-picker
      ref="picker4"
      type="date"
      v-model="value4"
      :startDate="startDate"
     :endDate="endDate"
      month-format="{value} 月"
      date-format="{value} 日"
      @confirm="handleChange">
    </mt-datetime-picker>

 

</div>








</div>
</template>
<script>
import { Popup,Picker,DatetimePicker,Toast,Indicator,MessageBox } from 'mint-ui';

var haha='{"name":"冰淇","gender":"M","bornYear":"2017/01/01","workYear":"2017","address":"address","email":"email@qq.com","marry":"100"}'

  let vm;
  const address = {
    '北京': ['北京'],
    '广东': ['广州', '深圳', '珠海', '汕头', '韶关', '佛山', '江门', '湛江', '茂名', '肇庆', '惠州', '梅州', '汕尾', '河源', '阳江', '清远', '东莞', '中山', '潮州', '揭阳', '云浮'],
    '辽宁': ['沈阳', '大连', '鞍山', '抚顺', '本溪', '丹东', '锦州', '营口', '阜新', '辽阳', '盘锦', '铁岭', '朝阳', '葫芦岛'],
    '江苏': ['南京', '苏州', '无锡', '常州', '镇江', '南通', '泰州', '扬州', '盐城', '连云港', '徐州', '淮安', '宿迁'],
    '湖北': ['武汉', '黄石', '十堰', '荆州', '宜昌', '襄樊', '鄂州', '荆门', '孝感', '黄冈', '咸宁', '随州', '恩施土家族苗族自治州', '仙桃', '天门', '潜江', '神农架林区'],
    '四川': ['成都', '自贡', '攀枝花', '泸州', '德阳', '绵阳', '广元', '遂宁', '内江', '乐山', '南充', '眉山', '宜宾', '广安', '达州', '雅安', '巴中', '资阳', '阿坝藏族羌族自治州', '甘孜藏族自治州', '凉山彝族自治州'],
    '陕西': ['西安', '铜川', '宝鸡', '咸阳', '渭南', '延安', '汉中', '榆林', '安康', '商洛'],
    '河北': ['石家庄', '唐山', '秦皇岛', '邯郸', '邢台', '保定', '张家口', '承德', '沧州', '廊坊', '衡水'],
    '山西': ['太原', '大同', '阳泉', '长治', '晋城', '朔州', '晋中', '运城', '忻州', '临汾', '吕梁'],
    '河南': ['郑州', '开封', '洛阳', '平顶山', '安阳', '鹤壁', '新乡', '焦作', '濮阳', '许昌', '漯河', '三门峡', '南阳', '商丘', '信阳', '周口', '驻马店'],
    '吉林': ['长春', '吉林', '四平', '辽源', '通化', '白山', '松原', '白城', '延边朝鲜族自治州'],
    '黑龙江': ['哈尔滨', '齐齐哈尔', '鹤岗', '双鸭山', '鸡西', '大庆', '伊春', '牡丹江', '佳木斯', '七台河', '黑河', '绥化', '大兴安岭地区'],
    '内蒙古': ['呼和浩特', '包头', '乌海', '赤峰', '通辽', '鄂尔多斯', '呼伦贝尔', '巴彦淖尔', '乌兰察布', '锡林郭勒盟', '兴安盟', '阿拉善盟'],
    '山东': ['济南', '青岛', '淄博', '枣庄', '东营', '烟台', '潍坊', '济宁', '泰安', '威海', '日照', '莱芜', '临沂', '德州', '聊城', '滨州', '菏泽'],
    '安徽': ['合肥', '芜湖', '蚌埠', '淮南', '马鞍山', '淮北', '铜陵', '安庆', '黄山', '滁州', '阜阳', '宿州', '巢湖', '六安', '亳州', '池州', '宣城'],
    '浙江': ['杭州', '宁波', '温州', '嘉兴', '湖州', '绍兴', '金华', '衢州', '舟山', '台州', '丽水'],
    '福建': ['福州', '厦门', '莆田', '三明', '泉州', '漳州', '南平', '龙岩', '宁德'],
    '湖南': ['长沙', '株洲', '湘潭', '衡阳', '邵阳', '岳阳', '常德', '张家界', '益阳', '郴州', '永州', '怀化', '娄底', '湘西土家族苗族自治州'],
    '广西': ['南宁', '柳州', '桂林', '梧州', '北海', '防城港', '钦州', '贵港', '玉林', '百色', '贺州', '河池', '来宾', '崇左'],
    '江西': ['南昌', '景德镇', '萍乡', '九江', '新余', '鹰潭', '赣州', '吉安', '宜春', '抚州', '上饶'],
    '贵州': ['贵阳', '六盘水', '遵义', '安顺', '铜仁地区', '毕节地区', '黔西南布依族苗族自治州', '黔东南苗族侗族自治州', '黔南布依族苗族自治州'],
    '云南': ['昆明', '曲靖', '玉溪', '保山', '昭通', '丽江', '普洱', '临沧', '德宏傣族景颇族自治州', '怒江傈僳族自治州', '迪庆藏族自治州', '大理白族自治州', '楚雄彝族自治州', '红河哈尼族彝族自治州', '文山壮族苗族自治州', '西双版纳傣族自治州'],
    '西藏': ['拉萨', '那曲地区', '昌都地区', '林芝地区', '山南地区', '日喀则地区', '阿里地区'],
    '海南': ['海口', '三亚', '五指山', '琼海', '儋州', '文昌', '万宁', '东方', '澄迈县', '定安县', '屯昌县', '临高县', '白沙黎族自治县', '昌江黎族自治县', '乐东黎族自治县', '陵水黎族自治县', '保亭黎族苗族自治县', '琼中黎族苗族自治县'],
    '甘肃': ['兰州', '嘉峪关', '金昌', '白银', '天水', '武威', '酒泉', '张掖', '庆阳', '平凉', '定西', '陇南', '临夏回族自治州', '甘南藏族自治州'],
    '宁夏': ['银川', '石嘴山', '吴忠', '固原', '中卫'],
    '青海': ['西宁', '海东地区', '海北藏族自治州', '海南藏族自治州', '黄南藏族自治州', '果洛藏族自治州', '玉树藏族自治州', '海西蒙古族藏族自治州'],
    '新疆': ['乌鲁木齐', '克拉玛依', '吐鲁番地区', '哈密地区', '和田地区', '阿克苏地区', '喀什地区', '克孜勒苏柯尔克孜自治州', '巴音郭楞蒙古自治州', '昌吉回族自治州', '博尔塔拉蒙古自治州', '石河子', '阿拉尔', '图木舒克', '五家渠', '伊犁哈萨克自治州'],
    '香港': ['香港'],
    '澳门': ['澳门'],
    '台湾': ['台北市', '高雄市', '台北县', '桃园县', '新竹县', '苗栗县', '台中县', '彰化县', '南投县', '云林县', '嘉义县', '台南县', '高雄县', '屏东县', '宜兰县', '花莲县', '台东县', '澎湖县', '基隆市', '新竹市', '台中市', '嘉义市', '台南市']
  };
export default {
  name: 'educationExperience',
  data() {
    return {
      phoneNumber:'',
value4: null,
visible4: false,
ceshi:{},
ceshia:[],
      selectNan:false,
      selectNv:true,
      // educationExperienceNum:0,
//控制弹出层显示
 popupWorkyearVisible:false,
 popupBornyearVisible:false,
 popupAddressVisible:false,
 income:'',
//

// var haha='{"name":"冰淇","gender":"M","bornYear":"2017/01/01","workYear":"2017","address":"address","email":"email@qq.com","marry":"100"}'

      personalExperience:{
        name:'',
        gender:'男',
        bornDate:'',
        saveFlag:'local',
        workYear:'',
        address:'',
        email:'',
        income:''
      },
   values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
//时间参数
        yearSlot: [{
          flex: 1,
            values: ['1970','1971','1972','1973','1974','1975','1976','1977','1978','1979','1980','1981','1982','1983','1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992', '1993', '1994', '1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'],
          className: 'slot1'
        }],
//地址参数
        addressSlots: [
          {
            flex: 1,
            values: Object.keys(address),
            className: 'slot1',
            // defaultIndex:0,
            textAlign: 'center'
          }, {
            divider: true,
            content: '-',
         
            className: 'slot2'
          }, {
            flex: 1,
            values: ['北京'],
  
            className: 'slot3',
            textAlign: 'center'
          }
        ], 
    };
  },
  props: {
    startDate: {
        type: Date,
        default() {
          return new Date(new Date().getFullYear() -30, 0, 1);
        }
      },
      endDate: {
        type: Date,
        default() {
          return new Date(new Date().getFullYear() +1, 11, 31);
        }
      }
  },
    watch: {
            income (newval,oldval){
                if(newval!=oldval){  
                this.income = newval.replace(/[^\d]/g,'') ; 
                }
            },
  },
 components: {
    DatetimePicker,Picker,Popup,Indicator,Toast
 },
 computed: {
   genderMF(){
     if(this.personalExperience.gender=="女"){
        return "F";
     }else{
        return "M";
     }
   }
 },
  methods: {
 open(picker) {
        this.$refs[picker].open();
      },
      handleChange(value) {
        console.log(value)
this.personalExperience.bornDate=value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate()
console.log(value.getFullYear()+"/"+(value.getMonth()+1)+"/"+value.getDate());
        // Toast({
        //   message: '已选择 ' + value.toString(),
        //   position: 'bottom'
        // });
      },
    gender(){
      this.selectNan=!this.selectNan
      this.selectNv=!this.selectNv
       if(this.selectNan){
      this.personalExperience.gender="女"
       }else{
      this.personalExperience.gender="男"   
       }       
    },
      
    gotoPage(e){
this.$router.push(e)
},
    Blurincome(){
    this.personalExperience.income=this.income;
},
  determine(){
      this.popupWorkyearVisible=false
    },
    cancel(){
      this.popupWorkyearVisible=false;
      this.personalExperience.workYear='';
    },
    selectworkyear(){
      this.popupWorkyearVisible=true;
    },

    onChangeworkyear(picker, values) {
        this.personalExperience.workYear = values[0];
    },

   //出生时间时间
    determinebornyear(){
      this.popupBornyearVisible=false
    },
    cancelbornyear(){
      this.popupBornyearVisible=false;
      this.personalExperience.bornDate='';
    },
    selectbornyear(){
      this.popupBornyearVisible=true;
    },
    onChangebornyear(picker, values) {
        this.personalExperience.bornDate = values[0];
    },
   //地址
    determineaddress(){
      this.popupAddressVisible=false;
    },
    canceladdress(){
      this.popupAddressVisible=false;
      this.personalExperience.address='';
    },
    selectaddress(){
      this.popupAddressVisible=true;
    },
    onChangeaddress(picker, values) {
       picker.setSlotValues(1, address[values[0]]);
       console.log(values[0])
        this.personalExperience.address = values[0]+values[1];
    },
    nextList(){
    $(".texthint").css("display","block");

  let edu=this.personalExperience;
  let enter=8;
          for(var key in edu){
            if((edu[key])){
               enter-=1;
               console.log(enter)
            }
          }
          if(!enter){
            let isemail= /^[_a-zA-Z0-9\-\.]+@([\-_a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,3}$/;

            if (!isemail.test(this.personalExperience.email)) {
              let instance = Toast('邮箱格式不对');
              setTimeout(() => {
              instance.close();
              }, 1500);
              return false;
            }else{
              console.log("成功")

Indicator.open();
var user = JSON.parse(JSON.stringify(this.personalExperience));  
console.log(user)
user.gender=this.genderMF;
var savePersonInfo = JSON.stringify(user);

                    this.$http.post('/personCredit/person/savePersonInfo.do',savePersonInfo)
                    .then((res)=>{
                    Indicator.close()
                    if(res.body.status=='ok'){
          
                     this.$router.push('page4')
                    console.log("=================")
                    }else{
                    Indicator.close()
                    console.log(res.body.status)
                    console.log(res.body.msg)
                    MessageBox('提示', res.body.msg);
         
                    }
                    },(err)=>{
                    Indicator.close()
                    console.log("错误")
                    MessageBox('提示', '服务器繁忙');
                    })
                    // MessageBox.confirm('前往添加认证','认证提示').then(
                    // action=>{
                    // console.log('确认')
                    // this.$router.push('page9')
                    // },
                    // action=>{
                    // console.log('取消')
                    // this.$router.push('page2')
                    // }
                    // );

                    }
           
}
}
  },
   created: function () {
      vm = this;
    },
  mounted () {

this.$http.get('/personCredit/personCenter/showTel.do')
.then((res)=>{
  this.phoneNumber=res.body.result
console.log(res.body)
console.log("=================")

// commit(‘updateOrderList’,res.data.list)
},(err)=>{
console.log("--------------")
console.log(err)
MessageBox('提示', '服务器繁忙');
})

        this.personalExperience.bornDate='';
        this.personalExperience.workYear='';
        this.personalExperience.address='';
                console.log(1)
     



  },
  

};
</script>

<style lang="scss" scoped>
.mint-datetime-action {

    color: #FF6600!important;
}

.btn-next{
  width: 65%;
  border-radius: 30px;
  color: #fff;
  font-size: 1.4rem;
  display: inline-block;
  line-height: 40px;
  height: 40px;
}
.list-box{
  height: auto;
     border-bottom: 1px solid #EEEEEE;
     margin-bottom: 5px;
}
.iconHint{
  color: #979797;
  font-size: 2.1rem;
}
.texthint{
  padding: 0 15px 2px;
  font-size: 1.4rem;
  color: #FF0000;
  display: none;
}
input::-webkit-input-placeholder,
textarea::-webkit-input-placeholder {
  font-weight: 0;
  font-size: 1.4rem;
  font-weight: 300;
}

.top-form ,.personal-form  {
  .topHint{
    background: rgba(255,229,105,0.51);
  font-size: 1.4rem;
  height: 34px;
  line-height: 34px;
  padding-left: 10px;
  color: #F19F17;
  margin-bottom: 0px;
  }
  .btn-next{
    border-radius: 30px;
    font-size: 1.4rem;
    display: inline-block;
    line-height: 40px;
    height: 40px;
   
  }
    border-radius: 7px;
    background-color: #fff;
      .list-input{
      line-height: 50px;
      white-space: nowrap;
      overflow: hidden;
      width: 100%;
      height: 50px;
      padding: 0 15px;
      -webkit-user-select: text;
   
      outline: 0;
      background-color: #fff;
      -webkit-appearance: none;
        input{
            line-height: 48px;
            height: 48px;
            vertical-align: top;
            padding: 0 5px;
            -webkit-user-select: text;
            border:transparent;
            border-radius: 3px;
            outline: 0;
            width: 65%;
            overflow: hidden;
            background-color: #fff;
            -webkit-appearance: none;
            font-size: 1.4rem;
            text-align: right;
        }
        .gender{
           line-height: 48px;
            height: 48px;
            width: 65%;
            display: inline-block;
            text-align: right;
            
            p{
              span{
                margin-right: 5px;
              }
              width: 25%;
              display: inline-block;
              color: #999999;
              .grey{
                 color: #999999;
              }
              .blue{
                color: #4990E2;
              }
            }
            .grey{
                 color: #999999;
              }
              .blue{
                color: #4990E2;
              }
              .red{
                color: #E13400;
              }
        }
        .verification{
          width: 45%;
        }
        p{
            display: inline-block;
            line-height: 50px;
            height: 50px;
            color: #444444;
            margin-bottom: 0;
            width: 35%;
            overflow: hidden;
            font-size: 1.4rem;
        }
        .verificationCode{
          width: 20%;
          border: none;
          border-left: 1px solid #999999;
          border-radius: 0;
          height: 24px;
          line-height: 24px;
          padding: 0;
          text-align: center!important;
          margin-top:13px; 
          text-align: right;
          color: #4990E2;
          vertical-align: top;
        }
        .verificationInput{
          width: 25%;
          position: absolute;
          color: transparent;
          right: 0;
          opacity: 0;
          border: none;
          background-color: transparent;
        }
    }

}
.wsnrp{
  div{
    height: 40px;
    line-height: 40px;
    border-bottom: 1px solid #EEEEEE;
    font-size: 1.6rem;
    
  }
}


</style>