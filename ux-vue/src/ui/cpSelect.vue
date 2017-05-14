<template>
     <!--<select class="cpSelect" @click="cpSelect">
		<option value="">1</option>
		<option value="">2</option>
	</select>
        <div class="cpSelectItem">one</div>
        <div class="cpSelectItem">two</div>-->

    <select v-model="basic.bzlx" @input="updateSolutionMethod($event.target.value)">
       <option v-for="issueType in issueTypeList" :value="issueType.bh">{{issueType.lxmc}}</option>
    </select>


</template>
<script>
    let cpSelect = {
        name: 'cpSelect',
        data() {
            return {
                cpSelect:{
                    amount:'2',

                } 
            };
        },
        computed:{

        },
        methods:{
            cpSelect(){

                // optionstring = $('#levelname1').val();
                            console.log(1);
            //      var el = event.currentTarget;
            // let nub=$(el).val();
            // console.log(nub);
            // $(".cpSelectItem")[nub].style.display="block";
            //     if($(el).next().hasClass("xms-close")){

            //         $(el).next().removeClass("xms-close").addClass("xms-open").addClass("fadeTopIn");
            //     }
            //     else{

            //         $(el).next().removeClass("xms-open").addClass("xms-close");
              
            //     }
            },  
            kaishi(){

                var uxID = "static" + this.guid();
                $("#kaishi").replaceWith(
                `
                    <select class="cpSelect" id='${uxID}'>
                        <option value="">1</option>
                        <option value="">2</option>
                    </select>
                    <div class="one">one</div>
                    <div class="one">two</div>
                ` )
                    var selObj=document.getElementById('uxID');
                    for(i=0;i<this.cpSelect.amount;i++){
                        selObj.append(`<option></option>`);
                    }
               ;
            },
            S4() {
                return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
            },
            guid() {
                return (this.S4()+this.S4()+"-"+this.S4()+"-"+this.S4()+"-"+this.S4()+"-"+this.S4()+this.S4()+this.S4());
            },

        },
        components: {
        },
        mounted() {
            //    console.log("加载完成cpSelect");
                // let optionstring = $('.cpSelect').val();
                // consolel.log(optionstring)

                    $('.cpSelect').on("change",function(){
                      let num=$("option:selected",this).index();


                    $('.cpSelectItem').removeClass("xms-block");
                    $('.cpSelectItem')[num].addClass("xms-block");
               
                        //   $('.cpSelectItem')[num].style.display="block"
                    })
                


            
		// var optObj=selObj.getElementsByTagName('option');
		// var oneobj=document.getElementsByClassName('one');
		// for(var i=0;i<oneobj.length;i++)
		// {
		// 	oneobj[i].style.display="none";
		// }
		// oneobj[0].style.display="block";
		// selObj.onchange=function () {
		// 	for(var i=0;i<oneobj.length;i++)
		// 	{
		// 		oneobj[i].style.display="none";
		// 	}
		// 	oneobj[this.selectedIndex].style.display="block";
		// }

    //  $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).replaceWith(`<input objectID=${sessionStorage.objectID} style="width:${inputWidth};height:${inputHeight};left:${inputLeft};top:${inputTop};position:absolute"> `);
    //  sessionStorage.styleHeight=getStyle($(this)[0], null).height;
    // sessionStorage.styleWidth=getStyle($(this)[0], null).width;
    // sessionStorage.styleLeft=getStyle($(this)[0], null).left;
    // sessionStorage.styleTop=getStyle($(this)[0], null).top;

    



          
        }
    };
    export default cpSelect;
</script>
<style lang='scss' scoped>
.cpSelectItem{
    display: none
}
.xms-block{
    display: block;
}


</style>