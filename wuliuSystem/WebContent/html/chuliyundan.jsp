<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理运单</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/chuliyudanSevrlet" method="post">
<table widh="300" border="1">
<tr>
<th>运单号</th>
<td><input type="text" name="orderID"></td>
</tr>
<tr>
<th>操作</th>
<td>
<input type="radio" name="opr" value="出库">出库
<input type="radio" name="opr" value="入库">入库
<input type="radio" name="opr" value="派送">派送
<input type="radio" name="opr" value="签收">签收
</td>
</tr>
<tr>
<th>备注</th>
<td><textarea name="remarks"></textarea> </td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="处理"></td>
</tr>
</table>
</form>
</body>
</html>