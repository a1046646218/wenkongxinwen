<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>jQuery背景切换注册登录模板</title>
<link rel="stylesheet" href="login/css/style.css" />
<body>

<div class="register-container">
	<h1>ShareLink</h1>
	
	<div class="connect">
		<p>Link the world. Share to world.</p>
	</div>
	
	<form action="register" method="post" id="registerForm">
		<div>
			<input type="text" name="userName" class="userName" placeholder="您的用户名" id="userName"/>
		</div>
        <div>
		<div style="background:#F00;text-align:center;" id="scan"></div>	
		<input type="text" name="nickName" class="nickName" placeholder="您的昵称" id="nickName"/>

		<div style="background:#F00; text-align:center" id="scan1"></div>
		</div>
		<div>
			<input type="password" name="Password" class="Password" placeholder="输入密码"  id="Password"/>
			<div style="background:#F00; text-align:center" id="scan2"></div>
		</div>
		<div>
			<input type="password" name="Password2" class="Password2" placeholder="再次输入密码" id="Password2" />
		<div style="background:#F00; text-align:center" id="scan3"></div>
		</div>
		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>


<script src="login/js/jquery.min.js"></script>
<!--背景图片自动更换-->
<script src="login/js/supersized.3.2.7.min.js"></script>
<script src="login/js/supersized-init.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script>
$(function(){
	var check;
	var bblur=function()
    {
		var userName=$("#userName").val();
	    var check
		$.ajax({
			type:'post',
			url:'registerAjax',
			async:false,
			data:{userName:userName},
			dataType:'text',
			success:function(e){
				if(e==1)
			    {
					check=true;
				}
				else{
					check=false;
				}
			}
		});
	    return check;
	  }
     function checkuserName()
     {
    			var userName=$("#userName").val();
    			var $msg=$('#scan').html("");
    			$('#scan').css("height","");
    			if(userName==''){
    				$('#scan').css("height","30px");
    				$msg.html('用户名不能为空');
    				return false;
    			}else if(bblur())
    			{
    				$('#scan').css("height","30px");
    				$msg.html('用户已经存在');
    				return false;
    			}
    			return true; 
     }
     function checknickName(){
    	 var nickName=$("#nickName").val();
			var $msg=$('#scan1').html("");
			$('#scan1').css("height","");
			if(nickName==''){
				$('#scan1').css("height","30px");
				$msg.html('昵称不能为空');
				return false;
			}
			return true; 
    	 
     }
     function checkPassword(){
    	 var Password=$("#Password").val();
			var $msg=$('#scan2').html("");
			$('#scan2').css("height","");
			if(Password.length<6){
				$('#scan2').css("height","30px");
				$msg.html('密码长度不能小于6');
				return false;
			}
			return true; 
     }
     function checkPassword2(){
    	 var Password=$("#Password").val();
    	 var Password2=$("#Password2").val();
		 var $msg=$('#scan3').html("");
		 $('#scan3').css("height","");
			if(Password!=Password2){
				$msg.html('密码不一致');
				$('#scan3').css("height","30px");
				return false;
			}
			return true; 
     }
     
        $("#userName").blur(checkuserName);
    	$("#nickName").blur(checknickName);
    	$("#Password").blur(checkPassword);
    	$("#Password2").blur(checkPassword2);
    		
    	$("form").submit(function(){
    		if(checkuserName()==false)
    		{
    			
    			
    			return false;
    		}
    		if(checknickName()==false)
    		{
    			
    			return false;
    		}
    		if(checkPassword()==false)
    		{
    			
    			return false;
    		}
    		if(checkPassword2==false)
    		{
    			
    			return false;
    		}
    		return true;
    	    })
    });
</script>
</body>
</html>
