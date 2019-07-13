<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
</head>

<body>
<form id="form1" name="form1" method="post"
	action="${pageContext.request.contextPath}/test6">
<div><script type="text/javascript">
	if ('${mes}') {
		alert('${mes}');
	}
</script></div>
<p align="center">修改小区公告</p>
<p align="center">
<label>请修改公告：
<input type="hidden" name="type" value="update" />
<input type="hidden" name="ggId" value="${gonggao.ggId}" /> 
<input name="textarea" value="${gonggao.gg }"/> </label></p>
<p align="center"><label> <input type="submit" name="Submit"
	value="提交" /> </label></p>
</form>

</body>
</html>