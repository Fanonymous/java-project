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
	function personInfoModifyDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("温馨提示", "请选择您的信息进行修改！", "warning");
			return;
		}

		var row = selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle", "个人信息修改");
		$("#form").form("load", row);
		url = "personInfo?id=" + row.id;
	}
	//对话框上面的取消按钮
	function closeDialog() {
		$("#dlg").dialog("close")
	}
	//修改个人信息保存按钮事件
	function personInfoSave() {

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
				} else {
					$.messager.alert("温馨提示", "保存数据成功！", "info");
					$("#dlg").dialog("close");//同时关闭对话框
					$("#dg").datagrid("reload");//刷新数据
				}
			},
		});
	}
</script>
</head>
<body style="margin: 5px">

	<table id="dg" title="个人信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="personInfoModify"
		toolbar="#tb" fit="true">
		<thead>
			<tr>
				<th align="center" field="id" width="20">用户编号</th>
				<th align="center" field="name" width="30">用户姓名</th>
				<th align="center" field="level" width="20">权限</th>
				<th align="center" field="sex" width="20">性别</th>
				<th align="center" field="birthday" width="50">出生日期</th>
				<th align="center" field="grade" width="30">年级</th>
				<th align="center" field="major" width="30">专业</th>
				<th align="center" field="phone" width="40">电话</th>
				<th align="center" field="address" width="30">宿舍</th>
			</tr>
		</thead>
	</table>
	<!-- 工具条，基本操作 -->
	<div id="tb"
		style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px">
		<div title="您的位置">您的位置：导航菜单>>系统管理>>个人信息维护</div>
		<hr>
		<br> 说明：
		<div>
			1、默认只是查看个人信息<br> 2、请选择个人信息后在进行信息修改
		</div>
		<br>
		<div style="color: black">相关操作：</div>
		<div title="相关操作">
			<a title="修改" href="javascript:personInfoModifyDialog()"
				class="easyui-linkbutton" iconCls="icon-man" plain="">个人信息修改</a>
		</div>
	</div>
	<!-- 对话框，个人信息修改时弹出的对话框 -->
	<div id="dlg" class="easyui-dialog" style="width: 450px; height: 450px"
		closed="true" buttons="#dlg-button" title="操作对话框">
		<form method="post" id="form" name="form">
			<table align="center" style="margin-top: 50px;">
				<tr>
					<td valign="top">姓名：</td>
					<td><input type="text" name="name" id="name"></td>
					<td></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>性别：</td>
					<td><select name="sex" id="sex" style="width: 80px"
						class="easyui-combobox" editable="false" panelHeight="auto">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
					<td></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>生日：</td>
					<td><input type="text" name="birthday" id="birthday"
						class="easyui-datebox" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>年级：</td>
					<td><input type="text" name="grade" id="grade" /></td>
					<td></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>专业：</td>
					<td><input type="text" name="major" id="major" /></td>
					<td></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="phone" id="phone" /></td>
					<td><font color="red"></font></td>
				</tr>
				<tr height="10px"></tr>
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
			iconCls="icon-cancel">取消</a> <a href="javascript:personInfoSave()"
			class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	</div>
</body>
</html>