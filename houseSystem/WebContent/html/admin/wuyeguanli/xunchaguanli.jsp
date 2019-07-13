<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function delet(id) {
		if (confirm("您确认删除吗?")) {
			window.location.href = "${pageContext.request.contextPath}/test10?type=del&xunchaID="+id
			return true;
		} else {
			return false;
		}
	}
</script>

</head>

<body>
<table width="100%" height="30%" border="1">
	<tr>
		<td colspan="9">
		<div align="center">
		<h3>巡查管理</h3>
		</div>
		</td>
	</tr>
	<tr>
		<td width="4%">
		<div align="center">巡查编号</div>
		</td>
		<td width="6%">
		<div align="center">巡查人</div>
		</td>
		<td width="7%">
		<div align="center">巡查类别</div>
		</td>
		<td width="28%">
		<div align="center">巡查时间</div>
		</td>
		<td width="6%">
		<div align="center">巡查处理人</div>
		</td>
		<td width="6%">
		<div align="center">巡查当事人</div>
		</td>
		<td width="21%">
		<div align="center">结果</div>
		</td>
		<td width="8%">
		<div align="center">备注</div>
		</td>
		<td width="14%">
		<div align="center"><a
			href="${pageContext.request.contextPath}/html/admin/wuyeguanli/tianjiaxuncha.jsp">新建巡查</a></div>
		</td>
	</tr>
	<tr>
		<c:forEach items="${userList}" var="user" begin="0"
			end="${ userList.size()}" step="1" varStatus="id">
			<td>&nbsp;${user.xunchaID}</td>
			<td>&nbsp;${user.xuncha_person}</td>
			<td>&nbsp;${user.xuncha_type}</td>
			<td>&nbsp;${user.xuncha_time}</td>
			<td>&nbsp;${user.xuncha_chuliren}</td>
			<td>&nbsp;${user.xuncha_dangshiren}</td>
			<td>&nbsp;${user.xuncha_result}</td>
			<td>&nbsp;${user.xuncha_memo}</td>
			<td><a href="#"
					onClick=" return delet('${user.xunchaID}');">删除</a>|<a
					href="${pageContext.request.contextPath}/test10?type=toUpdate&xunchaID=${user.xunchaID}"
					onClick="">修改</a></td>
	</tr>
	</c:forEach>
	<tr align="center">
		<td colspan="4"><jsp:include
			page="/html/admin/wuyeguanli/pages.jsp"></jsp:include></td>
	</tr>
</table>

</body>
</html>