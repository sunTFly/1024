<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
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

	<form action="listUser" method="post">
		您需要更新的用户名为：<%=request.getParameter("oldName")%><br> 新名字：<input
			type="text" name="newName"> 新密码：<input type="password"
			name="password"> <input type="hidden" name="oldName"
			value="<%=request.getParameter("oldName")%>"> <input
			type="hidden" name="operation" value="updateUser">
		<button type="submit">更新</button>
	</form>
</body>
</html>