<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费</title>
<link rel="stylesheet" type="text/css"
	href="../jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery/themes/icon.css">
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script type="text/javascript" src="../jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<br><br><br><br><br><br><br>
<div align="center">
<form action="../payCostServlet" method="post">
<table border="1">
<tr align="center"><td>缴费系统</td></tr>
<tr><td>
缴费房屋编号：<input type="text" name="houseid">
</td>
</tr>
<tr><td>
总费用：&nbsp;&nbsp;&nbsp;<input type="text" name="totalcost">
</td>
</tr>
<tr><td>
收费人：&nbsp;&nbsp;&nbsp;<input type="text" name="rname">
</td>
</tr>
<tr>
<td>
收费日期：&nbsp;&nbsp;<input id="cdate" type="text" name="cdate" class="easyui-datebox" />
</td>
</tr>

<tr>
<td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="缴费">
<input type="reset" value="重置">
</td>



</tr>

</table>

</form>

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
	

</body>
</html>