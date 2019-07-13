<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>取消订单</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/danhaochaxunServlet" method="post">
		请输入单号：<input type="text" name="danhao"> <br> <input
			type="submit" value="确认">
	</form>

</body>
</html>