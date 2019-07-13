<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收任务</title>
<!-- 判断权限，是否登陆 -->
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
	//查询的javascript方法
	function taskSearch() {
		$('#dg').datagrid('load', {
			userName : $("#s_userName").val(), //用户姓名
			publishTime : $("#s_publishTime").datebox("getValue"), //用户报修时间
			userAddress : $("#s_userAddress").val()
		//用户地址
		});
	}

	var url
	//维修任务按钮事件，打开维修任务对话框
	function taskReceiveDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择要维修的记录！", "warning");
			return;
		}
		//维修任务只能一条一条的维修，不支持多条接收任务
		if (selectedRows.length > 1) {
			$.messager.alert("温馨提示", "一次只能选择一条报修记录进行维修！", "warning");
			return;
		}
		var row = selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle", "任务维修");
		$("#form").form("load", row);
		url = "taskReceiveSave?taskId=" + row.taskId;
	}

	//对话框上面的保存按钮事件
	function saveTask() {

		//获取输入的日期
		//var date = document.getElementById("publishTime").value;
		var date = $("#repairTime").datetimebox("getValue")

		//日期1993-02-22 ([\s\S]*)表示匹配任意字符
		//var obj = /^(\d{4}|\d{2})-((0?([1-9]))|(1[0|1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))$/;
		var obj1 = /^(\d{4}|\d{2})-((0?([1|3-9]))|(1[0|1|2]))-((0?[1-9])|([1-2]([0-9]))|(3[0|1]))([\s\S]*)$/;//匹配除了二月的的年份格式
		var obj2 = /^(\d{4}|\d{2})-(0?2)-(0?[1-9]|[1-2][0-9])([\s\S]*)$/;//匹配2月的年份格式，就是说没有30,31号

		if ((obj1.test(date)) == false && (obj2.test(date)) == false) {
			alert("日期格式不正确");
			return;
		}

		$("#form").form("submit", {
			url : url,
			success : function(result) {
				if (result.errorMsg) {
					$.messager.alert("温馨提示", result.errorMsg, "error");
					return;
				} else {
					$.messager.alert("温馨提示", "任务领取成功！", "info");
					$("#dlg").dialog("close");//同时关闭对话框
					$("#dg").datagrid("reload");//刷新数据
					resetDialogValue();//保存成功之后要清除对话框里面的文本框里面的数据
				}
			},
		});
	}
	//关闭对话框后要清除文本框里面的数据
	function resetDialogValue() {
		$("#form").form('clear');
		$("#repairTime").val("");
		$("#repairer").val("");
	}
	//对话框上面的取消按钮,即关闭对话框
	function closeDialog() {
		$("#dlg").dialog("close")
		resetDialogValue();
	}
</script>
</head>
<body style="margin: 5px">
	<table id="dg" title="用户信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="taskReceive" toolbar="#tb"
		fit="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th align="center" field="taskId" width="15">任务编号</th>
				<th align="center" field="userName" width="30">用户姓名</th>
				<th align="center" field="publishTime" width="35">报修时间</th>
				<th align="center" field="userAddress" width="45">用户地址</th>
				<th align="center" field="phone" width="30">联系电话</th>
				<th align="center" field="troubleDesc" width="80">故障描述</th>
				<th align="center" field="state" width="20">状态</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条，基本操作 -->
	<div id="tb"
		style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px">
		<div title="您的位置">您的位置：导航菜单>>任务管理>>维修任务</div>
		<hr>
		<br> 说明：
		<div>
			1、当前页面是查看状态为待维修的报修记录,支持多值查询和模糊查询,没有条件则显示所有<br>
			2、报修任务时,一次只能选择一条记录
		</div>
		<br>
		<div style="color: black">相关操作：</div>
		<div title="相关操作">
			<a href="javascript:taskReceiveDialog()" class="easyui-linkbutton"
				iconCls="icon-receive" plain="">我要维修</a>
		</div>
		<div title="查询条件" style="padding-top: 5px">
			用户姓名：&nbsp;<input type="text" name="s_userName" id="s_userName" />&nbsp;
			&nbsp;用户报修时间：<input type="text" name="s_publishTime"
				id="s_publishTime" class="easyui-datebox" />&nbsp; &nbsp;用户地址：<input
				type="text" name="s_userAddress" id="s_userAddress" />&nbsp; <a
				title="维修" href="javascript:taskSearch()" class="easyui-linkbutton"
				iconCls="icon-search" plain="">查询</a>
		</div>
	</div>
	<!-- 对话框，添加，修改时弹出的对话框 -->

	<div id="dlg" class="easyui-dialog" style="width: 550px; height: 450px"
		buttons="#dlg-button" title="操作对话框" closed="true">
		<form method="post" id="form" name="form">
			<table border="0" align="center"
				style="padding-top: 50px; padding-bottom: 50px">

				<tr>
					<td>用户姓名：</td>
					<td><input type="text" name="userName" id="userName"
						disabled="disabled" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>报修时间：</td>
					<td><input type="text" name="publishTime" id="publishTime"
						disabled="disabled" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>用户地址：</td>
					<td><input type="text" name="userAddress" id="userAddress"
						disabled="disabled"></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" name="phone" id="phone"
						disabled="disabled"></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td valign="top">故障描述：</td>
					<td><textarea name="troubleDesc" id="troubleDesc"
							disabled="disabled"></textarea></td>
					<td valign="top"><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>维修时间：</td>
					<td><input type="text" name="repairTime" id="repairTime"
						class="easyui-datetimebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 对话框的按钮，确定和取消 -->
	<div id="dlg-button">
		<a href="javascript:closeDialog()" class="easyui-linkbutton"
			iconCls="icon-cancel">取消</a> <a href="javascript:saveTask()"
			class="easyui-linkbutton" iconCls="icon-ok">确定</a>
	</div>
</body>
</html>