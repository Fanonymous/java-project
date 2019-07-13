<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>house.jsp</title>
<link rel="stylesheet" type="text/css"
	href="../jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery/themes/icon.css">
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script type="text/javascript" src="../jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery/locale/easyui-lang-zh_CN.js"></script>
<title>房屋信息</title>
<script type="text/javascript">
$(function() {
	
	
	//修改
	$("#editbut").click(function(){
		if($("#mytable").datagrid('getSelections').length==0){
			alert('请选择要修改的数据');
		}else {
			if($("#mytable").datagrid('getSelections').length>1){
				 alert('只能修改一条记录');
				 $("#mytable").datagrid('unselectAll');
			}else{
			
				$('#editForm').form('load','../houseServlet?m=findhouseById&fId='+$("#mytable").datagrid('getSelected').id);
				//加载数据到对话框控件中去
				$("#editDialog").dialog({
					closed : false,
					buttons : [ {
						text : '保存',
						iconCls : 'icon-save',
						handler : function() {
							
							$('#editForm').form('submit',{   
							    url:'../houseServlet?m=updatehouseInfo',   
							    onSubmit: function(){   
							      return $('#editForm').form('validate');  
							    },   
							    success:function(flag){   
							      if(flag=='true'){
							    	  $("#editDialog").dialog({closed:true});//添加成功关闭对话框
							    	  $('#editForm').form('clear');//清空历史记录
							    	  $("#mytable").datagrid('reload');//重新加载记录
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
							$("#editDialog").dialog({closed:true});//添加成功关闭对话框
							 $("#mytable").datagrid('reload');//重新加载记录
						}
					} ]
					
				});
			}
		
		}
		
	});
	
		//删除按钮

		$("#removebut").click(function() {
			if ($("#mytable").datagrid('getSelections').length == 0) {
				alert('请选择要删除的数据');

			} else {
				var ids = [];//js定义空数组
				var arrayIds = $("#mytable").datagrid('getSelections');
				for ( var i in arrayIds) {
					ids.push(arrayIds[i].id);
				}
				//定义删除方法，该方法不是提交表单，而是传递参数的，使用jquery中ajax函数，进行参数传递
				$.post("../houseServlet?m=delhouseInfo", {
					"stuId[]" : ids
				}, function(flag) {
					if (flag) {

						$("#mytable").datagrid('reload');//重新加载记录
					} else {
						alert('删除失败');

					}
				});

			}
		});
		//添加按钮 

		$("#addbut").click(function() {//给按钮加事件

			$("#addDialog").dialog({
				closed : false,
				buttons : [ {
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {

						$('#addForm').form('submit', {
							url : '../houseServlet?m=savehouseInfo',
							onSubmit : function() {
								return $('#addForm').form('validate');
							},
							success : function(flag) {
								if (flag == 'true') {
									$("#addDialog").dialog({
										closed : true
									});//添加成功关闭对话框
									$('#addForm').form('clear');//清空历史记录
									$("#mytable").datagrid('reload');//重新加载记录
								} else {
									alert('添加失败');
								}
							}
						});

					}
				}, {
					text : '重置',
					iconCls : 'icon-redo',
					handler : function() {
						$('#addForm').form('clear');//清空历史记录
					}
				}, {
					text : '关闭',
					iconCls : 'icon-cancel',
					handler : function() {
						$("#addDialog").dialog({
							closed : true
						});//添加成功关闭对话框
						$("#mytable").datagrid('reload');//重新加载记录
					}
				} ]

			});
		});
	});
</script>
</head>
<body>
	<!-- 修改对话框 -->
	<div id="editDialog" style="width: 500px; height: 300px"
		closable="false" closed="true" class="easyui-dialog" title="修改业主">
		<form action="" id="editForm" method="post">
			<table>
				<tr>

					<td>房屋编号</td>
					<td><input id="houseid" name="houseid"
						class="easyui-validatebox" required="true" /></td>
					<td>单元号</td>
					<td><input id="floorid" name="floorid"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
				<td>户型</td>
					<td><input id="shape" type="text" name="shape"
						class="easyui-validatebox" /></td>

					<td>面积</td>
					<td><input id="area" type="text" name="area"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>

					<td>户主</td>
					<td><input id="ownername" type="text"
						name="ownername" class="easyui-validatebox" /></td>
					<td>常驻人口</td>
					<td><input id="people" type="text" name="people"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>
				<td>电话</td>
					<td><input id="ownerphone" type="text" name="ownerphone"
						class="easyui-validatebox" /></td>

					<td>迁入日期</td>
					<td><input id="mdate" type="text" 
						name="mdate" class="easyui-datebox"  /></td>
				</tr>
			
			</table>
		</form>
	</div>
	<!--      添加对话框div -->
	<div id="addDialog" style="width: 500px; height: 300px"
		closable="false" closed="true" class="easyui-dialog" title="添加业主">
		<form action="" id="addForm" method="post">
			<table>
				<tr>

					<td>房屋编号</td>
					<td><input id="houseid" name="houseid"
						class="easyui-validatebox" required="true" /></td>
					<td>单元号</td>
					<td><input id="floorid" name="floorid"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
				<td>户型</td>
					<td><input id="shape" type="text" name="shape"
						class="easyui-validatebox" /></td>

					<td>面积</td>
					<td><input id="area" type="text" name="area"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>

					<td>户主</td>
					<td><input id="ownername" type="text"
						name="ownername" class="easyui-validatebox" /></td>
					<td>常驻人口</td>
					<td><input id="people" type="text" name="people"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>
				<td>电话</td>
					<td><input id="ownerphone" type="text" name="ownerphone"
						class="easyui-validatebox" /></td>

					<td>迁入日期</td>
					<td><input id="mdate" type="text"
						name="mdate" class="easyui-datebox" /></td>
				</tr>
			
			</table>
		</form>
	</div>

	<!-- 条件查询div -->
	<div id="tb">

		<a id="addbut" href="#" plain="true" class="easyui-linkbutton"
			iconCls="icon-add">添加</a> <a id="editbut" href="#" plain="true"
			class="easyui-linkbutton" iconCls="icon-edit">修改</a> <a
			id="removebut" href="#" plain="true" class="easyui-linkbutton"
			iconCls="icon-remove">删除</a>
	</div>

	<!-- 表格div -->
	<table id="mytable" class="easyui-datagrid" rownumbers="true"
		toolbar="#tb" pagination="true" pagePosition="both" fit="true"
		fitColumns="true" url="../houseServlet?m=findhouseWithPage">
		<thead>
			<tr>
				<th field="id" checkbox="true" width="80">房屋ID</th>
				<th field="houseid" width="80">房屋编号</th>
				<th field="floorid" width="80">单元号</th>
				<th field="shape" width="80">户型</th>
				<th field="area" width="80">面积</th>
				<th field="ownername" width="80">户主</th>
				<th field="people" width="80">常驻人口</th>
				<th field="ownerphone" width="80">电话</th>
				<th field="mdate" width="80">迁入日期</th>
			</tr>
		</thead>

	</table>

</body>
</html>