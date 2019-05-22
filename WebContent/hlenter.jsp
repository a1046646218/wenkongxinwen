<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="foruserByUserid?id=${userother.userId}" method="post">
<ur>
<li>用户名：<div id="myusernickName" ">${userother.nickName}</div></li>
<li>用户介绍<div id="myuserintroduction">${userother.introduction}</div></li>
</ur>
<input type="submit" value="chakan"/>
</form>
</body>
</html>
