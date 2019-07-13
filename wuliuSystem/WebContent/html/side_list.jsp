<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.wuliuSystem.util.dao.sideDao"%>
<%@page import="com.wuliuSystem.entity.site"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站点查询</title>
</head>
<body>
<table width="300" border="1">
<tr>
<th>编号</th>
<th>名称</th>
<th>地址</th>
<th>联系方式</th>
</tr>

<% 
	sideDao wm = new sideDao();
	List<site> list = wm.getAll();
	for(int i=0;i<list.size();i++){
%>
<tr>
<td><%=list.get(i).getSiteID() %></td>
<td><%=list.get(i).getSiteName() %></td>
<td><%=list.get(i).getAddress() %></td>
<td><%=list.get(i).getPhone() %></td>
<td> <a href="${pageContext.request.contextPath}/deletsideSevrlet?id=<%=list.get(i).getSiteID() %>">删除</a> 
</td>
</tr>

<%
		
	}
%>

</table>

</body>
</html>