<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>jQuery背景切换注册登录模板</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="login/css/style.css" />

<body>

<div class="login-container">
	<h1>登录</h1>
	
	
	<form action="login" method="post" id="loginForm">
		<div>
			<input type="text" name="userName" class="username" id="userName" placeholder="用户名" />
		</div>
		<div style="background:#F00; text-align:center" id="scan"></div>
		<div>
			<input type="password" name="Password" class="password"  id="Password" placeholder="密码" />
		</div>
		<div style="background:#F00;text-align:center" id="scan2"></div>
		<button id="submit" type="submit">登 录</button>
    <c:if test="${!empty errorMsg }">
    <div style="background:#F00;height:30px">
    ${errorMsg }
    </div>
    </c:if>
    </div>
	</form>
	<a href="register.jsp">
		<button type="button" class="register-tis">还有没有账号？</button>
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
   function checkuserName()
     {
    			var userName=$("#userName").val();
    			var $msg=$('#scan').html("");
    			$('#scan').css("height","");
    			if(userName==''){
    				$('#scan').css("height","30px");
    				$msg.html('用户名不能为空');
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
   $("#userName").blur(checkuserName);
   $("#Password").blur(checkPassword);
   $("form").submit(function(){
		if(checkuserName()==false)
		{
			
			
			return false;
		}
		if(checkPassword()==false)
		{
		
			return false;
		}
		
		return true;
	    })
});
</script>
</body>
</html>
