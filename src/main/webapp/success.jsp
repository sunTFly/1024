<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%  
              if(session.getAttribute("login") == null) {    
    %>  
           <script type="text/javascript" language="javascript">      
             alert("您还没有登录，请登录..."); 
            window.location.href="login.jsp";
            </script> 
    <%  
        }  
    %> 
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#menus').tree({
			url : 'showMenus',
			onLoadSuccess : function(node, data) {
				$('#menus').tree('collapseAll')
			},
			onClick : function(node) {
				if (node.attributes) {
					var  flag = $('#menu').tabs('exists',node.text)
					if(flag){
						$('#menu').tabs('select',node.text);
					}else{
						console.log(node)
						//添加新的tab
						$('#menu').tabs('add',{
							title: node.text,
							closable:true,
							content: "<iframe src='"+node.attributes+"' frameborder='0' width='100%' height='100%' >"
						});
					}
			
					}
			}
		});
	})
</script>
<body class="easyui-layout">
	<div data-options="region:'west',title:'人力资源管理系统',collapsible:false"
		style="width: 200px;">
		<!-- 使用tree组件 -->
		<ul id="menus"></ul>
	</div>
	<div data-options="region:'center',title:'xxxxx',fit:true"
		style="padding: 5px; background: #eee;">
		<div id="menu" class="easyui-tabs" data-options="fit:true"
			style="width: 500px; height: 250px;"></div>
	</div>
</body>
</html>