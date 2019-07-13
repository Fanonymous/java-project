<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息修改</title>
<!-- 判断权限，是否登陆 -->
<%@ include file="WEB-INF/right.jsp"%>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	//修改按钮事件，打开修改数据对话框
	var url
	function personPWDModifyDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择您的信息进行修改！", "warning");
			return;
		}
		var row = selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle", "登录密码修改");
		$("#form").form("load", row);
		url = "personPWD?id=" + row.id;
	}
	//对话框上面的取消按钮
	function closeDialog() {
		//关闭对话框的同时应该清空数据

		$("#form").form('clear');
		$("#dlg").dialog("close")
	}
	//修改个人信息保存按钮事件
	function personPWDSave() {
		//判断输入的旧密码与当前密码是否相同
		if ($("#password").val() != $("#oldPassword").val()) {
			$.messager.alert("温馨提示", "您输入的密码不对！", "warning");
			return;
		}
		//判断输入的新密码与确认新密码是否相同
		if ($("#newPassword").val() != $("#passwordOK").val()) {
			$.messager.alert("温馨提示", "您输入的两次密码不一致！", "warning");
			return;
		}

		$("#form").form(
				"submit",
				{
					url : url,
					success : function(result) {
						if (result.errorMsg) {
							$.messager.alert("温馨提示", result.errorMsg, "error");
							return;
						} else {
							$("#dlg").dialog("close");//同时关闭对话框

							$.messager.alert("温馨提示", "密码修改成功！您将重新登录...",
									"info", function() {
										location.href = 'logout';
									})
						}
					},
				});
	}
</script>
</head>
<body style="margin: 5px">
	<table id="dg" title="个人登录信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="personInfoModify"
		toolbar="#tb" fit="true">
		<thead>
			<tr>
				<th align="center" field="id" width="20">用户编号</th>
				<th align="center" field="name" width="40">用户姓名</th>
				<th align="center" field="userName" width="40">账号</th>
				<th align="center" field="password" width="40">密码</th>
				<th align="center" field="level" width="30">权限</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条，基本操作 -->
	<div id="tb"
		style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px">
		<div title="您的位置">您的位置：导航菜单>>系统管理>>登录密码维护</div>
		<hr>
		<br> 说明：
		<div>
			1、默认只是查看个人登录账户,密码等信息<br> 2、请选择个人信息后在进行密码修改<br>
			3、个人密码修改时，密码是不可见的<br> 4、修改密码成功后,将关闭浏览器。请重新登录
		</div>
		<br>
		<div style="color: black">相关操作：</div>
		<div title="相关操作">
			<a title="修改" href="javascript:personPWDModifyDialog()"
				class="easyui-linkbutton" iconCls="icon-pwd" plain="">登录密码修改</a>
		</div>
	</div>
	<!-- 对话框，个人信息修改时弹出的对话框 -->
	<div id="dlg" class="easyui-dialog" style="width: 450px; height: 370px"
		closed="true" buttons="#dlg-button" title="操作对话框">
		<form method="post" id="form" name="form">
			<table align="center" style="margin-top: 50px">
				<tr>
					<td>当前账号：</td>
					<td>${currentUser.userName}</td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>旧密码：</td>
					<td><input type="password" id="password"
						value="${currentUser.password}" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>输入旧密码：</td>
					<td><input type="password" id="oldPassword"
						class="easyui-validatebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>新密码：</td>
					<td><input type="password" id="newPassword" name="newPassword"
						class="easyui-validatebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>确认新密码：</td>
					<td><input type="password" id="passwordOK" name="passwordOK"
						class="easyui-validatebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
			</table>
		</form>
	</div>

	<!-- 对话框的按钮，确定和取消 -->
	<div id="dlg-button">
		<a href="javascript:closeDialog()" class="easyui-linkbutton"
			iconCls="icon-cancel">取消</a> <a href="javascript:personPWDSave()"
			class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	</div>
</body>
</html>