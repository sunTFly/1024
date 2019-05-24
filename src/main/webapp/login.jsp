<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/vector.js"></script>
</head>
<body>
<div id="container">
	<div id="output">
		<div class="containerT">
			<h1>用户登录</h1>
			<form action="fromLogin" method="post" class="form" id="entry_form">
				<input type="text" name="uname" placeholder="用户名" id="entry_name">
				<input type="password" name="upwd" placeholder="密码" id="entry_password" >
				<button type="submit" id="entry_btn">登录</button>
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
    $(function(){
        Victor("container", "output");   //登陆背景函数
        $("#entry_name").focus();
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#entry_btn").click();
            }
        });
    });
</script>
</body>
</html>