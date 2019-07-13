<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.wuliuSystem.entity.wuliuMessage" %>
    <%@page import="com.wuliuSystem.util.dao.wuliuMessageDao" %>
    <%@page import="com.wuliuSystem.util.dao.sideDao" %>
    <%@page import="com.wuliuSystem.entity.site" %>
    <%@page import="java.util.List" %>
    <%@page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物流记录</title>
</head>
<body>
<table>

<% 
	String orderID = request.getParameter("orderID");
    wuliuMessageDao lm = new wuliuMessageDao();
	List<Map<String,Object>> list = lm.getAllForOrder(orderID);
	for(int i=0;i<list.size();i++){
%>
<tr>
<td>时间：<%=list.get(i).get("time") %></td>
<td>地点：<%=list.get(i).get("wname") %></td>
<td>操作类型：<%=list.get(i).get("opr") %></td>
<td>操作员：<%=list.get(i).get("ename") %></td>
<td>备注：<%=list.get(i).get("msg") %></td>
</tr>

<%
		
	}
%>



</table>
</body>
</html>