<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js">
	<!-- 页面加载时-->
		$(function() {
			$("#submit").click(function() {
				var uname = $("#uname").val()
				var upws = $("upwd").val()
				$.ajax({
					url : "ajaxlogin",
					type : "post",
					data : {
						"uname" : uname,
						"upwd" : upwd
					},
					dataType : "text",
					success : function(res) {
						//获取通过resp回写的数据
						console.log(res)
						//现在要将数据写在本页面  利用js或者jquey操作页面对应的元素
						$("#uname").val(res)
						$("#upwd").val(res)

					}

				})
			})
		})
	</script>
	<input id="uname" name="uname" />
	<input id="upwd" name="upwd" />
	<button id="submit">登录</button>
</body>
</html>