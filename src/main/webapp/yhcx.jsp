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
	<script type="text/javascript">
	<!-- 页面加载时-->
	
		
	
		$(function() {
			$('#dg').datagrid({
				url : 'listUser',
					queryParams: {
						"operation":"serchUser",
						"uname": $("#uname").val(),
						"permission": $("#permission").val(),
					},
				columns : [ [ {
					field : 'check',
					checkbox : true,
					width : 100
				}, {
					field : 'name',
					title : '用户名',
					width : 100
				}, {
					field : 'password',
					title : '密码',
					width : 100
				}, {
					field : 'permission',
					title : '权限',
					width : 100
				}, {
					field : 'creatTime',
					title : '创建时间',
					width : 100
				} ] ],
				fitColumns : true,
				striped : true,
				pagination : true,

			})
			$("#deleteUser").click(function() {
				var dname = $('#dg').datagrid('getSelections')
				$.ajax({
					url : "listUser",
					type : "post",
					data : {
						
						"operation" : "deleteUser",
						"dname" : JSON.stringify(dname),
					},
					success : function(ulist) {
						//获取通过resp回写的数据
						$('#dg').datagrid('reload');
					}

				})
			})
		})
		
		function post(){
			$('#dg').datagrid({
			url : 'listUser',
			queryParams: {
				"operation":"serchUser",
				"uname": $("#uname").val(),
				"permission": $("#permission").val(),
			},
			})
		}
		function updateUser(){
			var upname = $('#dg').datagrid('getSelected')
			location.href="updateUser.jsp?"+"oldName="+upname["name"]
		}
		
	</script>
	用户名：
	<input id="uname" name="uname" /> 权限：
<select id="permission" class="easyui-combobox" style="width:200px;"> 		  
    <option selected = "selected">全部</option>   
    <option>管理员</option>   
    <option>普通用户</option>    
           </select>
	<button id="serchUser" onclick="post()">查询用户</button>
	<button id="deleteUser">删除用户</button>
	<button id="serchUser" onclick="updateUser()">更新用户</button>
	<table id="dg" style="width: 85%"></table>
	<br>
	<input id="dname" name="dname" />
</body>
</html>