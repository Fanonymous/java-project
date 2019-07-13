<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
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
	function userSearch() {
		$('#dg').datagrid('load', {
			name : $("#s_name").val(), //用户姓名
			userName : $("#s_userName").val(), //用户账号
			sex : $("#s_sex").combobox("getValue"),//性别
		});
	}
	//删除的javascript方法
	function userDelDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		//判断是否选择了要删除的数据
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择您要删除的数据！", "warning");
			return;
		}
		//获取选择的所有id
		var strIds = [];
		for (var i = 0; i < selectedRows.length; i++) {
			strIds.push(selectedRows[i].id);
		}
		var ids = strIds.join(",");
		$.messager.confirm("温馨提示", "您确定要删除这<font color=red size=4>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
				$.post("userDel", {
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
	function userAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "添加用户");
		url = "userSave";
	}
	//修改按钮事件，打开修改数据对话框
	function userUpdateDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择要修改的数据！", "warning");
			return;
		}
		if (selectedRows.length > 1) {
			$.messager.alert("温馨提示", "请选择一条数据进行修改！", "warning");
			return;
		}
		var row = selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle", "用户信息修改");
		$("#form").form("load", row);
		url = "userSave?id=" + row.id;
	}

	//关闭对话框后要清除文本框里面的数据
	function resetDialogValue() {
		$("#form").form('clear');
		$("#userName").val("");
		$("#password").val("");
		$("#name").val("");
		$("#address").val("");
		$("#major").val("");
		$("#grade").val("");
		$("#phone").val("");
		$("#birthday").datebox("")//这个不知应该用说明方法，这样不能清除
	}

	//对话框上面的取消按钮
	function closeDialog() {
		$("#dlg").dialog("close")
		resetDialogValue();
	}

	//对话框上面的保存按钮事件
	function saveUser() {
		//alert($("#password").val());
		//获取输入的电话号码的值
		var phone = document.getElementById("phone").value;
		//当电话长度大于0才做正则表达式判断
		if (phone.length > 0) {
			//定义电话的正则表达式表达式,/^表示正则表达式的开始，$/表示正则表达式的结束，\d表示匹配整数字符，{n}表示匹配多少位。
			//该正则表达式可匹配000-12345678,0000-1234567,12346678,1234567和12345678901电话号码格式。
			//但一般只用到0000-1234567,1234567和12345678901
			//var objExp = /^(\d{3})-(\d{8})|(\d{4})-(\d{7})|\d{7}|\d{8}|\d{11}$/;
			var obj = /^\d{4}-\d{7}|\d{7}|\d{11}&/;

			if (obj.test(phone) == false) {
				alert("电话格式不正确");
				return;
			}
		}

		//获取输入的日期
		//var date = document.getElementById("birthday").value;
		var date = $("#birthday").datetimebox("getValue")
		//同理，先判断生日是否为空，为空就不经行正则表达式判断
		if (date.length > 0) {
			//日期1993-02-22 ([\s\S]*)表示匹配任意字符
			//var obj = /^(\d{4}|\d{2})-((0?([1-9]))|(1[0|1|2]))-((0?[1-9])|([12]([1-9]))|(3[0|1]))$/;
			var obj1 = /^(\d{4}|\d{2})-((0?([1|3-9]))|(1[0|1|2]))-((0?[1-9])|([1-2]([0-9]))|(3[0|1]))$/;//匹配除了二月的的年份格式
			var obj2 = /^(\d{4}|\d{2})-(0?2)-(0?[1-9]|[1-2][0-9])$/;//匹配2月的年份格式，就是说没有30,31号

			if ((obj1.test(date)) == false && (obj2.test(date)) == false) {
				alert("日期格式不正确");
				return;
			}
		}

		$("#form").form("submit", {
			url : url,
			success : function(result) {
				if (result.errorMsg) {
					$.messager.alert("温馨提示", result.errorMsg, "error");
					return;
				}

				else {
					$.messager.alert("温馨提示", "保存数据成功！", "info");
					$("#dlg").dialog("close");//同时关闭对话框
					$("#dg").datagrid("reload");//刷新数据
					resetDialogValue();//保存成功之后要清除对话框里面的文本框里面的数据
				}
			},
		});
	}

	//导出报修记录的js，打开一个新窗口
	function userExport() {
		window.open('exportUser');
	}
</script>
</head>
<body style="margin: 5px">
	<table id="dg" title="用户信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="user" toolbar="#tb"
		fit="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th align="center" field="id" width="20">用户编号</th>
				<th align="center" field="name" width="50">用户姓名</th>
				<th align="center" field="userName" width="40">账号</th>
				<th align="center" field="password" width="40">密码</th>
				<th align="center" field="level" width="20">权限</th>
				<th align="center" field="sex" width="20">性别</th>
				<th align="center" field="birthday" width="50">出生日期</th>
				<th align="center" field="grade" width="30">年级</th>
				<th align="center" field="major" width="30">专业</th>
				<th align="center" field="phone" width="50">电话</th>
				<th align="center" field="address" width="30">宿舍</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条，基本操作 -->
	<div id="tb"
		style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px">
		<div title="您的位置">您的位置：导航菜单>>系统管理>>用户管理</div>
		<hr>
		<br> 说明：
		<div>
			1、当前页面是查看所有用户,支持多值查询和模糊查询,没有条件则显示所有<br> 2、删除至少选择一条记录,修改只能选择一条记录
			3、当生日为0001-01-01时，表示为空
		</div>
		<br>
		<div style="color: black">相关操作：</div>
		<div title="相关操作">
			<a title="添加" href="javascript:userAddDialog()"
				class="easyui-linkbutton" iconCls="icon-add" plain="">新增用户</a> <a
				title="删除" href="javascript:userDelDialog()"
				class="easyui-linkbutton" iconCls="icon-cancel" plain="">删除用户</a> <a
				title="修改" href="javascript:userUpdateDialog()"
				class="easyui-linkbutton" iconCls="icon-edit" plain="">修改用户信息</a> <a
				title="导出" href="javascript:userExport()" class="easyui-linkbutton"
				iconCls="icon-export" plain="">导出用户信息</a>
		</div>
		<div title="查询条件" style="padding-top: 5px">
			&nbsp;用户姓名：&nbsp;<input type="text" name="s_name" id="s_name" />&nbsp;
			&nbsp;账号：&nbsp;<input type="text" name="s_userName" id="s_userName" />&nbsp;
			&nbsp;性别：&nbsp;<select class="easyui-combobox" name="s_sex"
				id="s_sex" editable="false" panelHeight="auto">
				<option value="">---请选择---</option>
				<option value="男">男</option>
				<option value="女">女</option>
			</select> &nbsp; <a title="查询" href="javascript:userSearch()"
				class="easyui-linkbutton" iconCls="icon-search" plain="">查询</a>
		</div>
	</div>
	<!-- 对话框，添加，修改时弹出的对话框 -->
	<div id="dlg" class="easyui-dialog" style="width: 550px; height: 500px"
		buttons="#dlg-button" title="操作对话框" closed="true">
		<form method="post" id="form" name="form">
			<table align="center" style="margin-top: 48px">

				<tr>
					<td>账号：</td>
					<td><input type="text" name="userName" id="userName"
						class="easyui-validatebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password"
						class="easyui-validatebox" required="true" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>权限：</td>
					<td><select name="level" id="level" style="width: 80px"
						class="easyui-combobox" editable="false" panelHeight="auto">
						<option value="3">用户</option>
							<option value="2">维修员</option>
							<option value="1">管理员</option>
					</select></td>
					<td></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td valign="top">姓名：</td>
					<td><input type="text" name="name" id="name"
						class="easyui-validatebox" required="true"></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>性别：</td>
					<td><select name="sex" id="sex" style="width: 80px"
						class="easyui-combobox" editable="false" panelHeight="auto">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
					<td></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>生日：</td>
					<td><input type="text" name="birthday" id="birthday"
						class="easyui-datebox" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>年级：</td>
					<td><input type="text" name="grade" id="grade" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>专业：</td>
					<td><input type="text" name="major" id="major" /></td>
					<td></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="phone" id="phone" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="5px"></tr>
				<tr>
					<td>宿舍：</td>
					<td><input type="text" name="address" id="address" /></td>
					<td><font color="red"></font></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 对话框的按钮，确定和取消 -->
	<div id="dlg-button">
		<a href="javascript:closeDialog()" class="easyui-linkbutton"
			iconCls="icon-cancel">取消</a> <a href="javascript:saveUser()"
			class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	</div>
</body>
</html>