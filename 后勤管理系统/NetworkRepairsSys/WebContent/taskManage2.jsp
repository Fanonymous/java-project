<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务维护</title>
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
			repairer : $("#s_repairer").val(), //维护者
			state : $("#s_state").combobox("getValue"),//状态
		});
	}

	//删除的javascript方法
	function taskDelete() {
		var selectedRows = $('#dg').datagrid('getSelections');
		//判断是否选择了要删除的数据
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择您要删除的数据！", "warning");
			return;
		}
		//获取选择的所有id
		var strIds = [];
		for (var i = 0; i < selectedRows.length; i++) {
			strIds.push(selectedRows[i].taskId);
		}
		var ids = strIds.join(",");
		$.messager.confirm("温馨提示", "您确定要删除这<font color=red size=4>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
				$.post("taskDel", {
					delIds : ids
				}, function(result) {
					if (result.success) {
						$.messager.alert("温馨提示",
								"您已成功删除<font color=red size=4>"
										+ result.delNums + "</font>条数据！",
								"info");
						$("#dg").datagrid("reload");//删除成功后刷新数据
					} else {
						$.messager.alert("温馨提示", result.errorMsg, "error");
					}
				}, "json");
			}
		});
	}
	//添加按钮事件，打开添加数据对话框
	var url
	function taskAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "发布报修任务");
		url = "taskSave";
	}

	//关闭对话框后要清除文本框里面的数据
	function resetDialogValue() {
		$("#userName").val("");
		$("#userAddress").val("");
		$("#troubleDesc").val("");
		$("#phone").val("");
		$("#form").form('clear');
		$("#publishTime").datetimebox("getValue") == "";//这个不知应该用说明方法，这样不能清除
	}
	//对话框上面的保存按钮事件
	function saveTask() {
		//获取输入的电话号码的值
		var phone = document.getElementById("phone").value;

		//定义电话的正则表达式表达式,/^表示正则表达式的开始，$/表示正则表达式的结束，\d表示匹配整数字符，{n}表示匹配多少位。
		//该正则表达式可匹配000-12345678,0000-1234567,12346678,1234567和12345678901电话号码格式。
		//但一般只用到0000-1234567,1234567和12345678901
		//var objExp = /^(\d{3})-(\d{8})|(\d{4})-(\d{7})|\d{7}|\d{8}|\d{11}$/;
		var obj = /^\d{4}-\d{7}|\d{7}|\d{11} &/;

		if (obj.test(phone) == false) {
			alert("电话格式不正确");
			return;
		}

		//获取输入的日期
		//var date = document.getElementById("publishTime").value;
		var date = $("#publishTime").datetimebox("getValue")

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
					$.messager.alert("温馨提示", "发布报修任务成功！", "info");
					$("#dlg").dialog("close");//同时关闭对话框
					$("#dg").datagrid("reload");//刷新数据
					resetDialogValue();//保存成功之后要清除对话框里面的文本框里面的数据
				}
			},
		});
	}
	//对话框上面的取消按钮,即关闭对话框
	function closeDialog() {
		$("#dlg").dialog("close")
		resetDialogValue();
	}
	//导出报修记录的js，打开一个新窗口
	function taskExport() {
		window.open('exportTask');
	}
</script>
</head>
<body style="margin: 5px">
	<table id="dg" title="用户信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="task" toolbar="#tb"
		fit="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th align="center" field="taskId" width="15">任务编号</th>
				<th align="center" field="userName" width="20">用户姓名</th>
				<th align="center" field="publishTime" width="40">报修时间</th>
				<th align="center" field="userAddress" width="30">用户地址</th>
				<th align="center" field="phone" width="30">联系电话</th>
				<th align="center" field="troubleDesc" width="50">故障描述</th>
				<th align="center" field="repairer" width="20">维修者</th>
				<th align="center" field="repairTime" width="40">维修时间</th>
				<th align="center" field="finishTime" width="40">完成时间</th>
				<th align="center" field="dealWay" width="70">处理方法</th>
				<th align="center" field="state" width="20">状态</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条，基本操作 -->
		
	<div id="tb"
		style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px">
		<div title="您的位置">您的位置：>>报修申请</div>
		<hr>
		<br> <br>
		<div style="color: black">相关操作：</div>
		<div title="相关操作">
			<a title="添加" href="javascript:taskAddDialog()"
				class="easyui-linkbutton" iconCls="icon-add">我要报修</a>


		</div>
		<div title="查询条件" style="padding-top: 5px">
			用户姓名：&nbsp;<input type="text" name="s_userName" id="s_userName" />&nbsp;
			&nbsp;维修者：&nbsp;<input type="text" name="s_repairer" id="s_repairer" />&nbsp;
			&nbsp;状态：&nbsp;<select class="easyui-combobox" name="s_state"
				id="s_state" editable="false" panelHeight="auto">
				<option value="">--请选择--</option>
				<option value="待维修">待维修</option>
				<option value="维修中">维修中</option>
				<option value="已维修">已维修</option>
			</select> &nbsp; <a title="查询" href="javascript:taskSearch()"
				class="easyui-linkbutton" iconCls="icon-search" plain="">查询</a>
				<a title="评论" class="easyui-linkbutton" iconCls="icon-seach" plain="">评论</a>
		</div>
	</div>
	<!-- 对话框，添加，修改时弹出的对话框 -->
	<div id="dlg" class="easyui-dialog" style="width: 500px; height: 380px"
		buttons="#dlg-button" title="操作对话框" closed="true">
		<form method="post" id="form" name="form">
			<table align="center"
				style="padding-top: 50px; padding-bottom: 50px;">

				<tr>
					<td>您的姓名：</td>
					<td><input type="text" name="userName" id="userName" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>报修时间：</td>
					<td><input type="text" name="publishTime" id="publishTime"
						class="easyui-datetimebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>报修地址：</td>
					<td><input type="text" name="userAddress" id="userAddress"
						class="easyui-validatebox" required="true"></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" name="phone" id="phone"
						class="easyui-validatebox" required="true"></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td valign="top">故障描述：</td>
					<td><textarea name="troubleDesc" id="troubleDesc"></textarea></td>
					<td valign="top"><font color="red"></font></td>
				</tr>

			</table>
		</form>
	</div>
	<!-- 对话框的按钮，确定和取消 -->
	<div id="dlg-button">
		<a href="javascript:closeDialog()" class="easyui-linkbutton"
			iconCls="icon-cancel">取消</a> <a href="javascript:saveTask()"
			class="easyui-linkbutton" iconCls="icon-ok">确认</a>
	</div>
</body>
</html>