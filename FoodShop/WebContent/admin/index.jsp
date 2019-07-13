<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>“一起吃”网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
body {
  	background-size:100%;
	background-image: url(pic/bg.jpg);
}
.hyz{
	border: 1px solid #d7d7d7; 
	width:500px;
	height:300px;
	margin-left:433px;
	background-color:#99cccc;
	
}
.biaoti{
	height:120px;
	padding-top:20px;
	
}
.biaoti span{
	font-size:40px;
	color:#009966;
	
}
</style>
</head>

<center><div class="biaoti"><span>欢迎进入“一起吃”特色小吃购物平台后台管理系统！</span>
</div></center>
<div class="hyz">
<form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent" name='theForm' onsubmit="return validate()">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr>
    <td style="padding-left: 50px">
      <table>
      <tr>
        <td>管理员账户：</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>管理员密码：</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr><td>&nbsp;</td><td><input type="submit" value="进入管理中心" class="button" /><input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回"/></td></tr>
      
      </table>
       
    </td>
  </tr>
 
  </table>
  <input type="hidden" name="act" value="signin" />
  
</form></div>

</body>