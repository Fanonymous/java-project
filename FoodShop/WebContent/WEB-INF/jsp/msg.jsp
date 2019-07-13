<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>“一起吃”在线购物平台</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
body {
  	background-size:100%;
	background-image: url(image/bg.jpg);
}

a button{
padding: 0px;
	margin: 0px;
	border: 0px;
	outline: 0px;
width:150px;
	height:50px;
	color:white;
	text-decoration:none;
	background-image:url(image/bt.jpg);
}

</style>
</head>

<body>
<div id="divcontent">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px; text-align:center"><table width="80%" border="0" cellspacing="0" style="margin-top:70px;margin-left:300px">
      <tr>
        <td style="width:98"><img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
        <td style="padding-top:30px"><font style="font-weight:bold; color:#009966">
	        <s:actionmessage/>
	        <s:actionerror/>
        </font>
        <br />
            <br />
          <a href="${ pageContext.request.contextPath }/index.action"><button>首页</button></a>
          <a href="${ pageContext.request.contextPath }/user_registPage.action"><button>注册</button></a>
         <a href="${ pageContext.request.contextPath }/user_loginPage.action"><button>登录</button></a>
         </td>
      </tr>
    </table>
    <h1>&nbsp;</h1></td>
    </tr>
</table>
</div>
</body>
</html>