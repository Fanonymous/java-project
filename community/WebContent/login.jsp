<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css"
	href="jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	window.history.forward(-1);
	$(function() {

		$("#mydialog").dialog({

			buttons : [ {
				text : '登录',
				handler : function() {//后台请求执行的事件

					$('#form1').form('submit', {
						url : 'adminServlet?m=login',
						onSubmit : function() {
							return $('#form1').form('validate');
						},
						success : function(flag) {
							if (flag == 'true') {
								window.location.href = "html/main.jsp";
							} else {
								alert('登录失败');
							}
						}
					});

				}
			}, {
				text : '注册',
				handler : function() {
					window.location.href = "zhuce.jsp";

				}
			} ]
		})

	});
</script>
<style type="text/css">
.all{
background:url(images/bj.jpg) no-repeat;
background-size:100% 1024px;


}

</style>
</head>
<body>
	<div class="all">

		<div style="height: 600px"></div>

		<div id="mydialog" class="easyui-dialog" closable="false"
			style="width: 400px; height: 200px" title="登录">
			<div align="center">
				<form action="" id="form1" method="post">
					<div align="center">
						<table>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<td>管理员工号:</td>
								<td><input type="text" name="username"
									class="easyui-validatebox" required="true"></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input type="password" name="password"
									class="easyui-validatebox" required="true"></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>





</body>
</html>