<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<script type="text/javascript">
	function updateState(maintainID) {
		var select= document.getElementById("shifouweixiuId"+maintainID); 
		var _state;
		for(var i=0;i< select.options.length;i++){
			if(select.options[i].selected){
				_state= select.options[i].value;
			}
		}
		alert(_state);
		window.location.href="${pageContext.request.contextPath}/test9?type=update&maintainID="+maintainID+"&shifouweixiu="+_state;
	}
</script>
</head>

<body>
<table width="100%" height="30%" border="0">
	<tr>
		<td colspan="6">
		<div align="center">
		<h3>报修信息</h3>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		<div align="center">报修编号</div>
		</td>
		<td>
		<div align="center">报修事件</div>
		</td>
		<td>
		<div align="center">报修单元</div>
		</td>
		<td>
		<div align="center">报修楼层</div>
		</td>
		<td>
		<div align="center">报修备注</div>
		</td>
		<td>
		<div align="center">维修状态</div>
		</td>
	</tr>
	<c:forEach items="${userList}" var="user" begin="0"
		end="${userList.size()}" step="1" varStatus="maintainID">
		<tr>
			<td>
			<div align="center">${user.maintainID}</div>
			</td>
			<td>
			<div align="center">${user.maintain_thing}</div>
			</td>
			<td>
			<div align="center">${user.maintain_homesnumber}</div>
			</td>
			<td>
			<div align="center">${user.maintain_fh}</div>
			</td>
			<td>
			<div align="center">${user.maintain_smemo}</div>
			</td>
			<td>
			<div align="center"><label>
			<select id="shifouweixiuId${user.maintainID}"
				name="shifouweixiu" onchange="updateState('${ user.maintainID}')">
				<option value="未维修" ${user.shifouweixiu == "未维修"?"selected":""}>未维修</option>
				<option value="正在维修"${user.shifouweixiu == "正在维修"?"selected":""} >正在维修</option>
				<option value="已维修"} ${user.shifouweixiu == "已维修"?"selected":""}>已维修</option>
			</select>
			</label></div>
			</td>
		</tr>
	</c:forEach>
	<tr align="center">
		<td colspan="4"><jsp:include
			page="/html/admin/baoxiuguanli/pages.jsp"></jsp:include></td>
	</tr>
</table>
</body>
</html>