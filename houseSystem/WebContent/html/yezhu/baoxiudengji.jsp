<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
 function checkvalue(){
	var _textarea =document.getElementById("textareaId").value;
	if(_textarea==null||""==_textarea){
		alert("报修事件不能为空！");
		return false;
	}
	var _textfield =document.getElementById("bxId").value;
	if(_textfield==null||""==_textfield){
		alert("报修单元楼不能为空 ！");
		return false;
	}
	var _textfield2 =document.getElementById("textfield2Id").value;
	if(_textfield2==null||""==_textfield2){
		alert("报修房号不能为空 ！");
		return false;
	}
	
	
	
 }
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="/houseSystem/test5" target="_parent">

<table width="40%" height="50%" border="0" align="center">
	<tr>
		<td colspan="2">
		<div align="center">
		<h3>报修登记</h3>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">报修事件*：</div>
		</td>
		<td><label> <textarea name="textarea" id="textareaId"></textarea>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">报修单元楼*：</div>
		</td>
		<td><label> <input type="text" name="textfield" id="bxId"/> </label></td>
	</tr>
	<tr>
		<td>
		<div align="right">报修房号*：</div>
		</td>
		<td><label> <input type="text" name="textfield2" id="textfield2Id" /> </label></td>
	</tr>
	<tr>
		<td>
		<div align="right">报修备注：</div>
		</td>
		<td><label> <textarea name="textarea2" ></textarea> </label></td>
	</tr>
	<tr>
		<td colspan="2"><label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="Submit" onclick="return checkvalue();" value="提交" /> </label> <label> <input
			type="reset" name="Submit2" value="重置" /> <a
			href="${pageContext.request.contextPath}/test7" target="mainFrame">查询</a></label></td>
	</tr>
</table>
</form>

</body>
</html>