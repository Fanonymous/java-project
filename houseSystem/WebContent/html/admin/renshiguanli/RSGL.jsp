<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<script type="text/javascript">
	function delet(id){
		if(confirm("您确认删除吗?")){
			window.location.href="${pageContext.request.contextPath}/test4?type=del&empId="+id
			return true;
		}else{
			return false;
		}		
	}
</script>
</head>

<body>
<table width="100%" height="30%" border="1" align="center">
	<tr>
		<td colspan="13">
		<div align="center">人事信息</div>
		</td>
	</tr>
	<tr>
		<td width="3%">
		<div align="center">员工工号</div>
		</td>
		<td width="9%">
		<div align="center">员工部门</div>
		</td>
		<td width="9%">
		<div align="center">员工职务</div>
		</td>
		<td width="6%">
		<div align="center">员工姓名</div>
		</td>
		<td width="13%">
		<div align="center">身份证号</div>
		</td>
		<td width="8%">
		<div align="center">联系号码</div>
		</td>
		<td width="4%">
		<div align="center">性别</div>
		</td>
		<td width="9%">
		<div align="center">出生日期</div>
		</td>
		<td width="5%">
		<div align="center">学历</div>
		</td>
		<td width="8%">
		<div align="center">入职日期</div>
		</td>
		<td width="3%">
		<div align="center">工龄</div>
		</td>
		<td width="16%">
		<div align="center">户籍所在地</div>
		</td>
		<td width="7%">
		<div align="center">合同期限</div>
		</td>

	</tr>
	<c:forEach items="${userList}" var="user" begin="0"
		end="${ userList.size()}" step="1" varStatus="empId">
		<tr>
			<td>
			<div align="center">${user.empId}</div>
			</td>
			<td>
			<div align="center">${user.empDepartment}</div>
			</td>
			<td>
			<div align="center">${user.empWork}</div>
			</td>
			<td>
			<div align="center">${user.empName}</div>
			</td>
			<td>
			<div align="center">${user.id_card}</div>
			</td>
			<td>
			<div align="center">${user.tel}</div>
			</td>
			<td>
			<div align="center">${user.empSex}</div>
			</td>
			<td>
			<div align="center">${user.bornTime}</div>
			</td>
			<td>
			<div align="center">${user.empAcademic}</div>
			</td>
			<td>
			<div align="center">${user.enterTime}</div>
			</td>
			<td>
			<div align="center">${user.workYears}</div>
			</td>
			<td>
			<div align="center">${user.bornLocal}</div>
			</td>
			<td>
			<div align="center">${user.timeLimit}</div>
			</td>
			<td>
			<div align="center"><a href="#"
				onClick=" return delet('${user.empId}');">删除</a>|<a
				href="${pageContext.request.contextPath}/test4?type=toUpdate&empId=${user.empId}"
				onClick="">修改</a></div>
			</td>
		</tr>
	</c:forEach>
	<tr align="center">
		<td colspan="4"><jsp:include
			page="/html/admin/renshiguanli/page.jsp"></jsp:include></td>
	</tr>

</table>

</body>
</html>