<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
<!--
body {
	background-image: url(${pageContext.request.contextPath }/html/images/1111111.jpg);
}
#Layer1 {
	position:absolute;
	left:97px;
	top:34px;
	width:1076px;
	height:44px;
	z-index:1;
}
.STYLE4 {font-size: 36px}
-->
</style>

</head>
<body>
<div id="Layer1">
  <marquee scrollamount="5" width="1000">
  <span class="STYLE4"> 超能英雄小区欢迎您的入住，为您带来最舒适的家居生活！  </span>
  </marquee>
</div>
<form id="form1" name="form1" method="post" action="/houseSystem/test">
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="25%" border="0" align="center">
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;用户登录</td>
	</tr>
	<tr>
		<td>
		<hr width="80%" />
		</td>
	</tr>
	<tr>
		<td><label>
		<div align="center"><input name="rule" type="radio"
			value="1" checked="checked" /> 管理员 &nbsp;&nbsp; <input
			type="radio" name="rule" value="2" /> 住户</div>
		</label></td>
	</tr>
	<tr>
		<td><label>
		<div align="center">账户： <input type="text" name="accout" />
		</div>
		</label></td>
	</tr>
	<tr>
		<td><label>
		<div align="center">密码： <input type="password" name="pass" />
		</div>
		</label></td>
	</tr>
	<tr>
		<td><label>
		<div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input name="login" type="submit"" id="login" value="登录" /> &nbsp;&nbsp;
		&nbsp;&nbsp; <input name="reset" type="reset" id="reset" value="重置" />
		</div>
		</label></td>
	</tr>
	<div>
	<script type="text/javascript">
	  if('${mes}'){
		  alert('${mes}');
	  }
		
	</script>
	
	</div>
</table>
<p><label></label></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>
</body>
</html>