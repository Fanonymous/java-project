<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function delet(id){
		if(confirm("您确认删除吗?")){
			window.location.href="${pageContext.request.contextPath}/test6?type=del&ggId="+id
			return true;
		}else{
			return false;
		}		
	}
</script>

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
		<td width="13%">
		<div align="center"><a
			href="${pageContext.request.contextPath}/html/admin/wuyeguanli/tianjiagonggao.jsp">添加公告</a></div>
		</td>
	</tr>
	<tr>
		<c:forEach items="${userList}" var="user" begin="0"
			end="${ userList.size()}" step="1" varStatus="ggId">
			<tr>
				<td>${user.ggId}</td>
				<td>${user.gg }</td>
				<td><div align="center"><a href="#"
					onClick=" return delet('${user.ggId}');">删除</a>|<a
					href="${pageContext.request.contextPath}/test6?type=toUpdate&ggId=${user.ggId}"
					onClick="">修改</a></div></td>
			</tr>
		</c:forEach>
	<tr align="center">
		<td colspan="4"><jsp:include
			page="/html/admin/wuyeguanli/page.jsp"></jsp:include></td>
	</tr>
	
</table>

</body>
</html>