<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人力资源管理系统</title>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<%
	if (session.getAttribute("login") == null) {
%>
<script type="text/javascript" language="javascript">
	alert("您还没有登录，请登录...");
	window.location.href = "login.jsp";
</script>
<%
	}
%>
<script type="text/javascript">
	function isNull() {
		var name = $("#uname").val()
		var password = $("#password").val()
		if (name == null || name == "" || password == null || password == ""){
			alert("用户名或者密码不能为空")
			return false;
		}else{
			return true;
		}
	}
</script>
<body>
	<form action="listUser" method="post" onsubmit="return isNull()">
		名字：<input id="uname" type="text" name="name"> 密码：<input
			id="password" type="password" name="password"> <input
			type="hidden" name="operation" value="creatUser">
		<button type="submit" >添加</button>
	</form>
</body>
</html>