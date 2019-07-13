<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.wuliuSystem.entity.site"%>
<%@page import="com.wuliuSystem.util.dao.sideDao"%>
<% 
int id = Integer.parseInt(request.getParameter("id"));
sideDao wm = new sideDao();
site w = wm.get(id);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改站点</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/updatesideSevrlet" method="post">
<input type="hidden" name="id" value="<%=w.getSiteID() %>">
<table width="300" border="1">
<tr>
<th>名称</th>
<td><input type="text" name="name" value="<%=w.getSiteName() %>"></td>
</tr>
<tr>
<th>管理员</th>
<td><input type="text" name="admin" value="<%=w.getAdminID() %>"></td>
</tr>
<tr>
<th>地址</th>
<td><input type="text" name="add" value="<%=w.getAddress() %>"></td>
</tr>
<tr>
<th>联系方式</th>
<td><input type="text" name="contact" value="<%=w.getPhone() %>"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="确认"></td>
</tr>

</table>
</form>
</body>
</html>