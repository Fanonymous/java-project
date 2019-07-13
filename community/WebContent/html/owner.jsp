<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>owner.jsp</title>
<link rel="stylesheet" type="text/css"
	href="../jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery/themes/icon.css">
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script type="text/javascript" src="../jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery/locale/easyui-lang-zh_CN.js"></script>
<title>业主信息</title>
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
			
				$('#editForm').form('load','../ownerServlet?m=findownerById&fId='+$("#mytable").datagrid('getSelected').id);
				//加载数据到对话框控件中去
				$("#editDialog").dialog({
					closed : false,
					buttons : [ {
						text : '保存',
						iconCls : 'icon-save',
						handler : function() {
							
							$('#editForm').form('submit',{   
							    url:'../ownerServlet?m=updateownerInfo',   
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
				$.post("../ownerServlet?m=delownerInfo", {
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
							url : '../ownerServlet?m=saveownerInfo',
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

					<td>业主姓名</td>
					<td><input id="owner_name" name="owner_name"
						class="easyui-validatebox" required="true" /></td>
					<td>身份证号</td>
					<td><input id="owner_idcard" name="owner_idcard"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>

					<td>性别</td>
					<td><select id="owner_sex" editable="false" required="true"
						class="easyui-combobox" name="owner_sex" style="width: 150px;">
							<option value="女">女</option>
							<option value="男">男</option>

					</select></td>
					<td>电话号码</td>
					<td><input id="owner_phone" type="text" name="owner_phone"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>

					<td>工作单位</td>
					<td><input id="owner_workstation" type="text"
						name="owner_workstation" class="easyui-validatebox" /></td>
					<td>房屋编号</td>
					<td><input id="houseid" type="text" name="houseid"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<td>所在单元号</td>
					<td><select id="teacherId" class="easyui-combogrid"
						required="true" editable="false" name="floorid"
						style="width: 150px;"
						data-options="   
             panelWidth:450,   
            idField:'id',  
            fit:true,
           fitColumns:true,
            textField:'floorid', 
            pagination:true,  
            url:'../houseServlet?m=findhouseWithPage',   
            columns:[[   
                {field:'floorid',title:'编号',width:80} 
               
            ]]   
        "></select></td>
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

					<td>业主姓名</td>
					<td><input id="owner_name" name="owner_name"
						class="easyui-validatebox" required="true" /></td>
					<td>身份证号</td>
					<td><input id="owner_idcard" name="owner_idcard"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>

					<td>性别</td>
					<td><select id="owner_sex" editable="false" required="true"
						class="easyui-combobox" name="owner_sex" style="width: 150px;">
							<option value="女">女</option>
							<option value="男">男</option>

					</select></td>
					<td>电话号码</td>
					<td><input id="owner_phone" type="text" name="owner_phone"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>

					<td>工作单位</td>
					<td><input id="owner_workstation" type="text"
						name="owner_workstation" class="easyui-validatebox" /></td>
					<td>房屋编号</td>
					<td><input id="houseid" type="text" name="houseid"
						class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<td>所在单元号</td>
					<td><select id="teacherId" class="easyui-combogrid"
						required="true" editable="false" name="floorid"
						style="width: 150px;"
						data-options="   
             panelWidth:450,   
            idField:'id',  
            fit:true,
           fitColumns:true,
            textField:'floorid', 
            pagination:true,  
            url:'../houseServlet?m=findhouseWithPage',   
            columns:[[   
                {field:'floorid',title:'编号',width:80} 
               
            ]]   
        "></select></td>
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
		fitColumns="true" url="../ownerServlet?m=findownerWithPage">
		<thead>
			<tr>
				<th field="id" checkbox="true" width="80">业主ID</th>
				<th field="owner_name" width="80">业主姓名</th>
				<th field="owner_idcard" width="80">身份证号</th>
				<th field="owner_sex" width="80">性别</th>
				<th field="owner_phone" width="80">电话号码</th>
				<th field="owner_workstation" width="80">业主工作单位</th>
				<th field="floorid" width="80">所在单元</th>
				<th field="houseid" width="80">房屋编号</th>
			</tr>
		</thead>

	</table>

</body>
</html>