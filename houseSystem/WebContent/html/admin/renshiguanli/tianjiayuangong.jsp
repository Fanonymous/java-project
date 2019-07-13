<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
 function checkvalue(){
	var _textfield =document.getElementById("textfieldId").value;
	if(_textfield==null||""==_textfield){
		alert("员工部门不能为空！");
		return false;
	}
	var _textfield2 =document.getElementById("textfield2Id").value;
	if(_textfield2==null||""==_textfield2){
		alert("员工职务不能为空 ！");
		return false;
	}
	var _textfield3 =document.getElementById("textfield3Id").value;
	if(_textfield3==null||""==_textfield3){
		alert("员工姓名不能为空 ！");
		return false;
	}
	var _textfield4 =document.getElementById("textfield4Id").value;
	if(_textfield4==null||""==_textfield4){
		alert("员工身份证号不能为空 ！");
		return false;
	}
	var _textfield5 =document.getElementById("textfield5Id").value;
	if(_textfield5==null||""==_textfield5){
		alert("员工联系号码不能为空 ！");
		return false;
	}
	var _textfield6 =document.getElementById("textfield6Id").value;
	if(_textfield6==null||""==_textfield6){
		alert("员工性别不能为空 ！");
		return false;
	}
	var _textfield7 =document.getElementById("textfield7Id").value;
	if(_textfield7==null||""==_textfield7){
		alert("员工出生日期不能为空 ！");
		return false;
	}
	var _textfield8 =document.getElementById("textfield8Id").value;
	if(_textfield8==null||""==_textfield8){
		alert("员工学历不能为空 ！");
		return false;
	}
	var _textfield9 =document.getElementById("textfield9Id").value;
	if(_textfield9==null||""==_textfield9){
		alert("员工入职日期不能为空 ！");
		return false;
	}
	var _textfield10 =document.getElementById("textfield10Id").value;
	if(_textfield10==null||""==_textfield10){
		alert("员工工龄不能为空 ！");
		return false;
	}
	var _textfield11 =document.getElementById("textfield11Id").value;
	if(_textfield11==null||""==_textfield11){
		alert("员工户籍所在地不能为空 ！");
		return false;
	}
	var _textfield12 =document.getElementById("textfield12Id").value;
	if(_textfield12==null||""==_textfield12){
		alert("员工合同期限不能为空 ！");
		return false;
	}
 }
</script>
</head>

<body>
<form id="form1" name="form1" method="post"
	action="${pageContext.request.contextPath}/test3">
<div><script type="text/javascript">
	if ('${mes}') {
		alert('${mes}');
	}
</script></div>
<table width="30%" height="80%" border="0" align="center">
	<tr>
		<td colspan="2">
		<div align="center">添加员工</div>
		</td>
	</tr>
	<tr>
		<td width="34%">
		<div align="right">员工部门</div>
		</td>
		<td width="66%"><label>

		<div align="left"><input type="text" name="textfield" id="textfieldId"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">员工职务</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield2" id="textfield2Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">员工姓名</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield3" id="textfield3Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">身份证号</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield4" id="textfield4Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">联系号码</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield5" id="textfield5Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">性别</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield6" id="textfield6Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">出生日期</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield7" id="textfield7Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">学历</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield8" id="textfield8Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">入职日期</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield9" id="textfield9Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">工龄</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield10" id="textfield10Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">户籍所在地</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield11" id="textfield11Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td>
		<div align="right">合同期限</div>
		</td>
		<td><label>

		<div align="left"><input type="text" name="textfield12" id="textfield12Id"/></div>
		</label></td>
	</tr>
	<tr>
		<td colspan="2"><label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="Submit" onclick="return checkvalue();" value="提交" /> </label> <label> <input
			type="reset" name="Submit2" value="重置" /> </label></td>
	</tr>
</table>
</form>

</body>
</html>