<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form action="${pageContext.request.contextPath }/sideaddSevrlet" method="post">
<table width="300" border="1">
<tr>
<th>名称</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>管理员</th>
<td><input type="text" name="admin"></td>
</tr>
<tr>
<th>地址</th>
<td><input type="text" name="add"></td>
</tr>
<tr>
<th>联系方式</th>
<td><input type="text" name="contact"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="添加"></td>
</tr>

</table>
</form>
</body>
</html>