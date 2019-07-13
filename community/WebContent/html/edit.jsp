<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>

	<div>
		<script type="text/javascript">
			if ('${mes}') {
				alert('${mes}');
			}
		</script>

	</div>

	<div>
		<script type="text/javascript">
			if ('${mes1}') {
				alert('${mes1}');
			}
		</script>

	</div>

	<div>
		<script type="text/javascript">
			if ('${mes2}') {
				alert('${mes2}');
			}
		</script>

	</div>

<br><br><br><br><br><br><br><br>
	<div align="center">
		<form action="${pageContext.request.contextPath }/editServlet"
			method="post">
			<table border="1" bordercolor="blue">
				<tr align="center">
					<td colspan="2">修改密码</td>
				</tr>
				<tr>
					<td>输入密码：</td>
					<td><input type="password" name="jiumima"></td>
				</tr>
				<tr>
					<td>请再次输入密码：</td>
					<td><input type="password" name="xinmima"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="确认"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>