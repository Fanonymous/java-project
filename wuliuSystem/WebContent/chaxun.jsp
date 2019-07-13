<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/show.jsp" method="post">
<table width="300" border="1">
<tr>
<th>运单号</th>
<td><input type="text" name="orderID"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="查询"></td>
</tr>
</table>
</form>
</body>
</html>