<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>charge.jsp</title>
<link rel="stylesheet" type="text/css"
	href="../jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery/themes/icon.css">
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script type="text/javascript" src="../jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		//查询
		$("#searchbut").click(function() {
			$("#mytable").datagrid('reload', {
				status : $("#status").val()
			});
		});
		//修改按钮
		$("#editbut").click(function(){
			if($("#mytable").datagrid('getSelections').length==0){
				alert('请选择要 修改的记录');
				
			}else if($("#mytable").datagrid('getSelections').length>1){
				alert('修改只能选择一条记录进行修改');
				$("#mytable").datagrid('unselectAll');
			}else{
				$('#editForm').form('load','../chargeServlet?m=findchargeById&fId='+$("#mytable").datagrid('getSelected').id);
				$("#editDialog").dialog({
					closed : false,
					buttons : [ {
						text : '修改',
						iconCls : 'icon-save',
						handler : function() {
							$('#editForm').form('submit', {   
							    url:'../chargeServlet?m=updatechargeInfo',   
							    onSubmit: function(){
							       return $('#editForm').form('validate');
							    },   
							    success:function(flag){   
							       if(flag=='true'){
							    	
							    	   $("#editDialog").dialog({
											closed : true
										});
							    	   $("#editForm").form('clear');
							    	   $("#mytable").datagrid('reload');
							       }else{
							    	   alert('修改失败');
							       }
							    }   
							});
						}
					}, {
						text : '关闭',
						iconCls : 'icon-cancel',
						handler : function() {
							$("#editDialog").dialog({
								closed : true
							});
							$("#editForm").form('clear');
							$("#mytable").datagrid('reload');
						}
					} ]
				});
			}
			
		
		});
		//添加按钮
		$("#addbut").click(function() {
			$("#addDialog").dialog({
				closed : false,
				buttons : [ {
					text : '添加',
					iconCls : 'icon-save',
					handler : function() {
						$('#addForm').form('submit', {
							url : '../chargeServlet?m=savechargeInfo',
							onSubmit : function() {
								return $('#addForm').form('validate');
							},
							success : function(flag) {
								if (flag == 'true') {
									$("#addDialog").dialog({
										closed : true
									});
									$("#addForm").form('clear');
									$("#mytable").datagrid('reload');
								}
							}
						});
					}
				}, {
					text : '重置',
					iconCls : 'icon-redo',
					handler : function() {
						$("#addForm").form('clear');
					}
				}, {
					text : '关闭',
					iconCls : 'icon-cancel',
					handler : function() {
						$("#addDialog").dialog({
							closed : true
						});
						$("#addForm").form('clear');
						$("#mytable").datagrid('reload');
					}
				} ]
			});
		});
	});
</script>


</head>
<body>

	<!--      修改对话框div -->
<div id="editDialog" style="width: 500px; height: 300px"
		closable="false" closed="true" class="easyui-dialog" title="修改缴费信息">
		<form action="" id="editForm" method="post">
			<table>
				<tr>

					<td>房屋编号</td>
					<td><input type="hidden" class="easyui-validatebox" name="id">
					<input id="houseid" name="houseid"
						class="easyui-validatebox" required="true" /></td>
					<td>月份</td>
					<td><input id="month" name="month" class="easyui-validatebox"
						required="true" /></td>
				</tr>
				<tr>
					<td>水费</td>
					<td><input id="water" type="text" name="water"
						class="easyui-validatebox" /></td>
					<td>电费</td>
					<td><input id="electric" name="electric"
						class="easyui-validatebox" /></td>

				</tr>
				<tr>
					<td>缴费状态</td>
					<td><select id="status" class="easyui-combobox" name="status"
						style="width: 150px;">
							<option value="未缴费">未缴费</option>
							<option value="已缴费">已缴费</option>
							<option value="欠费">欠费</option>
					</select></td>
				</tr>
				<tr>
				<td>收费人</td>
				<td>
				<input id="rname" name="rname"
						class="easyui-validatebox" />				
				</td>
				
				<td>收费日期</td>
				<td><input id="mdate" type="text"
						name="mdate" class="easyui-datebox" /></td>				
				</tr>

			</table>
		</form>
	</div>
	<!--      添加对话框div -->
	<div id="addDialog" style="width: 500px; height: 200px"
		closable="false" closed="true" class="easyui-dialog" title="添加课程">
		<form action="" id="addForm" method="post">
			<table>
				<tr>

					<td>房屋编号</td>
					<td><input id="houseid" name="houseid"
						class="easyui-validatebox" required="true" /></td>
					<td>月份</td>
					<td><input id="month" name="month" class="easyui-validatebox"
						required="true" /></td>
				</tr>
				<tr>
					<td>水费</td>
					<td><input id="water" type="text" name="water"
						class="easyui-validatebox" /></td>
					<td>电费</td>
					<td><input id="electric" name="electric"
						class="easyui-validatebox" /></td>

				</tr>
				
			</table>
		</form>
	</div>
	
	<div id="tb">
		<table>
			<tr>
				<td>缴费状态</td>
				<td><td><select name="status" id="status">
						<option value="">请选择</option>
						<option value="未缴费">未缴费</option>
						<option value="已缴费">已缴费</option>
						<option value="欠费">欠费</option>
				</select></td>

				<td><a id="searchbut" href="#" plain="true"
					class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
		<a id="addbut" href="#" plain="true" class="easyui-linkbutton"
			iconCls="icon-add">添加</a> <a id="editbut" href="#" plain="true"
			class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	</div>
	<table id="mytable" class="easyui-datagrid" rownumbers="true"
		toolbar="#tb" pagination="true" pagePosition="both" fit="true"
		fitColumns="true" url="../chargeServlet?m=findchargeWithPage">
		<thead>
			<tr>
				<th field="id" checkbox="true" width="80">课程ID</th>
				<th field="houseid" width="80">房屋编号</th>
				<th field="month" width="80">月份</th>
				<th field="water" width="80">水费</th>
				<th field="electric" width="80">电费</th>
				<th field="status" width="80">缴费状态</th>
				<th field="rname" width="80">收费人</th>
				<th field="cdate" width="80">收费日期</th>
				
			</tr>
		</thead>

	</table>
</body>
</html>