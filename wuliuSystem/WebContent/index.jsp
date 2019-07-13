<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>超能物流</title>
</head>
<body>
	<link rel="stylesheet" href="/css/bootstrap.css" />
	<style type="text/css">
	body{ background:#0066A8 ;}
body 

.tit {
	margin: auto;
	margin-top: 170px;
	text-align: center;
	width: 350px;
	padding-bottom: 20px;
}

.login-wrap {
	width: 220px;
	padding: 30px 50px 0 330px;
	height: 220px;
	background: #fff
		url(${pageContext.request.contextPath }/images/20150212154319.jpg)
		no-repeat 30px 40px;
	margin: auto;
	overflow: hidden;
}

.login_input {
	display: block;
	width: 210px;
}

.login_user {
	background:
		url(${pageContext.request.contextPath }/images/input_icon_1.png)
		no-repeat 200px center;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif
}

.login_password {
	background:
		url(${pageContext.request.contextPath }/images/input_icon_2.png)
		no-repeat 200px center;
	font-family: "Courier New", Courier, monospace
}

.btn-login {
	background: #40454B;
	box-shadow: none;
	text-shadow: none;
	color: #fff;
	border: none;
	height: 35px;
	line-height: 26px;
	font-size: 14px;
	font-family: "microsoft yahei";
}

.btn-login:hover {
	background: #333;
	color: #fff;
}

.copyright {
	margin: auto;
	margin-top: 10px;
	text-align: center;
	width: 370px;
	color: #CCC
}

@media ( max-height : 700px) {
	.tit {
		margin: auto;
		margin-top: 100px;
	}
}

@media ( max-height : 500px) {
	.tit {
		margin: auto;
		margin-top: 50px;
	}
}
</style>
</head>

<body>
	<div class="tit">
		<table width="200" align="center">
			<tr>
				<th height="35" align="center" class="close"><em>超能物流管理系统</em></th>
			</tr>
		</table>
	</div>
	<div class="login-wrap">
		<form action="adminLoginServlet" method="get">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="25" valign="bottom">用户名：</td>
				</tr>
				<tr>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td height="35" valign="bottom">密 码：</td>
				</tr>
				<tr>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="登陆"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="copyright">感谢您的选择，我们以服务至上。</div>
	<div>
	<script type="text/javascript">
	  if('${mes}'){
		  alert('${mes}');
	  }
		
	</script>
	
	</div>
</body>

</html>