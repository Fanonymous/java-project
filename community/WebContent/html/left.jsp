<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!--
#Layer1 {
	position: absolute;
	left: 10px;
	top: 30px;
	width: 150px;
	height: 300px;
	z-index: 1;
}
body {
	background-color: #CCCCCC;
}

.STYLE1 {
	font-size: 16px
}
-->
</style>

</head>
<body>
	
	<div id="Layer1">
		<table width="207" height="301">
			
			<tr>
				<th width="200" height="80"
					background="${pageContext.request.contextPath }/images/leftbj.png"
					scope="col"><div align="center" class="STYLE1">
						<a href="${pageContext.request.contextPath }/html/owner.jsp"
							target="showCenter">业主管理</a>
					</div></th>
			</tr>
			<tr>
				<th width="200" height="80"
					background="${pageContext.request.contextPath }/images/leftbj.png"><div
						align="center" class="STYLE1">
						<a href="${pageContext.request.contextPath}/html/house.jsp"
							target="showCenter">房屋管理</a>
					</div></th>
			</tr>
			<tr>
				<th width="200" height="80"
					background="${pageContext.request.contextPath }/images/leftbj.png"><div
						align="center" class="STYLE1">
						<a href="${pageContext.request.contextPath}/html/charge.jsp"
							target="showCenter">缴费管理</a>
					</div></th>
			</tr>
			<tr>
				<th width="200" height="80"
					background="${pageContext.request.contextPath }/images/leftbj.png"><div
						align="center" class="STYLE1">
						<a href="${pageContext.request.contextPath }/html/payCost.jsp"
							target="showCenter">缴费功能</a>
					</div></th>
					<tr>
				<th width="200" height="80"
					background="${pageContext.request.contextPath }/images/leftbj.png"
					scope="col"><div align="center" class="STYLE1">
						<a href="${pageContext.request.contextPath }/html/edit.jsp"
							target="showCenter">修改密码</a>
					</div></th>
			</tr>
			</tr>
		</table>
	</div>
</body>
</html>