<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">

<link rel="shortcut icon" href="resources/images/favicon.ico" />
<link href="resources/style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery.i18n.properties-1.0.9.js" ></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/md5.js"></script>
<script type="text/javascript" src="resources/js/page_regist.js?lang=zh"></script>

</head>
<body class="loginbody">
	<div class="dataEye">
		<div class="loginbox registbox">

			<div class="login-content reg-content">
				<div class="loginbox-title">
					<h3>注册</h3>
				</div>
				<form id="signupForm" action="${pageContext.request.contextPath }/zhuceServlet" method="post">
					<div class="login-error"></div>
					<div class="row">
						<label class="field" for="password">密码</label> <input
							type="password" value=""
							class="input-text-password noPic input-click" name="password"
							id="password">
					</div>
					<div class="row">
						<label class="field" for="passwordAgain">确认密码</label> <input
							type="password" value=""
							class="input-text-password noPic input-click"
							name="passwordAgain" id="passwordAgain">
					</div>
					<div class="row">
						<label class="field" for="contact">姓名</label> <input type="text"
							value="" class="input-text-user noPic input-click" name="contact"
							id="contact">
					</div>
					
					<div class="row">
						<label class="field" for="tel">电话</label> <input type="text"
							value="" class="input-text-user noPic input-click" name="tel"
							id="tel">
					</div>
					

					<div class="row btnArea">
						<a class="login-btn" ><input type="submit" value="注册"></a>
					</div>
				</form>
			</div>
			<div class="go-regist">
				已有帐号,请<a href="login.jsp" class="link">登录</a>
			</div>
		</div>

		<div id="footer">
			<div class="dblock">
				<div class="inline-block"></div>
				<div class="inline-block copyright">
					<p>
						<a href="#">关于我们</a> | <a href="#">微博</a> | <a href="#">隐私政策</a> |
						<a href="#">人员招聘</a>
					</p>

				</div>
			</div>
		</div>
	</div>
	<div class="loading">
		<div class="mask">
			<div class="loading-img">
				<img src="resources/images/loading.gif" width="31" height="31">
			</div>
		</div>
	</div>
	
	
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
	
</body>
</html>