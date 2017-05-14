<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<body>

    <input name="passwd" id="passwd"><br>
    <input name="email" id="email"><br>

 <button id="submit" type="button" value="提交">提交</button>
<script>
	$(function(){
		$("#submit").click(function(){
		var	passwd = $('#passwd').val();
		var	email = $('#email').val();
			$.ajax({
				type:"post",
				url:"companyAdmin/companyRegrister.do",
		    	data:{'passwd':passwd,'email':email},
		    	dataType:'json',
				success:function(data){
		    		
		    	},
			 		error:function(){
			 			alert('系统异常');
			 	}
			});
		});
		
	});
</script>
</body>
</html>