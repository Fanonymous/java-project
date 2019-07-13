<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="20%" border="1">
	<tr>
		<td height="66" colspan="3">
		<div align="center">
		<h3>小区公告</h3>
		</div>
		</td>
	</tr>
	<tr>
		<td width="9%">
		<div align="center">公告编号</div>
		</td>
		<td width="78%">
		<div align="center">公告内容</div>
		</td>
	</tr>
	<tr>
		<c:forEach items="${userList}" var="user" begin="0"
			end="${ userList.size()}" step="1" varStatus="id">
			<tr>
				<td>${user.ggId}</td>
				<td>${user.gg }</td>
		</c:forEach>
	<tr align="center">
		<td colspan="4"><jsp:include
			page="/html/yezhu/page.jsp"></jsp:include></td>
	</tr>
	
</table>
</body>
</html>