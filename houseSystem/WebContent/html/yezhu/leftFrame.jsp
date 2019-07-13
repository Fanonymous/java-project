<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>业主主页</title>
<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	left:13px;
	top:19px;
	width:160px;
	height:70px;
	z-index:1;
	background-color: #996633;
}
.STYLE1 {font-size: 16px}
.STYLE2 {color: #FF0000}
#Layer2 {
	position:absolute;
	left:13px;
	top:113px;
	width:160px;
	height:500px;
	z-index:2;
	background-color: #00CCCC;
}
-->
</style>
</head>

<body>
<div id="Layer1">
  <p class="STYLE1"><span class="STYLE2"> &nbsp;登录成功，欢迎您</span>！</p>
  <form action="" method="get" name="yezhu" class="STYLE1" id="yezhu">
    &nbsp;业主
    ：
    <input type="hidden" name="hiddenField" />
  </form>
  <p class="STYLE1">&nbsp;</p>
</div>
<div id="Layer2">
  <table width="98%" height="207" border="0">
    <tr>
      <td><div align="center"><strong><span class="STYLE1">系统功能</span></strong></div></td>
    </tr>
    <tr>
      <td><div align="center"><a href="xiugaimima.jsp" target="mainFrame">修改密码</a></div></td>
    </tr>
    <tr>
      <td><div align="center"><strong><span class="STYLE1"><a href="${pageContext.request.contextPath }/html/index.jsp" target="_parent">退出系统</a></span></strong></div></td>
    </tr>
  </table>
</div>
</body>
</html>