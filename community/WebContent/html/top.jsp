<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.community.entity.admin"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
<!--
#Layer1 {position:absolute;
	left:83px;
	top:17px;
	width:1168px;
	height:42px;
	z-index:1;
}
#Layer2 {
	position:absolute;
	left:26px;
	top:14px;
	width:140px;
	height:40px;
	z-index:2;
}

#Layer3 {
	position:absolute;
	left:1200px;
	top:50px;
	width:140px;
	height:40px;
	z-index:2;
}


body {
	background-color: #CCCCCC;
}
-->
</style>
<script language="javascript">
	function realSysTime(clock) {
		var now = new Date(); //创建Date对象 
		var year = now.getFullYear(); //获取年份 
		var month = now.getMonth(); //获取月份 
		var date = now.getDate(); //获取日期 
		var day = now.getDay(); //获取星期 
		var hour = now.getHours(); //获取小时 
		var minu = now.getMinutes(); //获取分钟 
		var sec = now.getSeconds(); //获取秒钟 
		month = month + 1;
		var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六");
		var week = arr_week[day]; //获取中文的星期 
		var time = year + "年" + month + "月" + date + "日 " + week + " " + hour
				+ ":" + minu + ":" + sec; //组合系统时间 
		clock.innerHTML = time; //显示系统时间 
	}
	window.onload = function() {
		window.setInterval("realSysTime(clock)", 1000); //实时获取并显示系统时间 
	}
</script>




</head>
<body>
	<div id="Layer2">
		<h3>
			<div id="clock" align="left" style="color: blue; font: large;"></div>
		</h3>
		<hr align="center" width="1400"  color="#333333" />
	</div>
	<div id="Layer1" align="center">
		<%
			String name = (String) session.getAttribute("name");
		%>
		<div style="color: red" align="center">
			<h1>
				欢迎
				<%=name%>
				登录物业管理系统
			</h1>
		</div>

	</div>
	<div id="Layer3" align="right">
	<a href="${pageContext.request.contextPath }/login.jsp" target="parent">注销</a>
	</div>
</body>
</html>