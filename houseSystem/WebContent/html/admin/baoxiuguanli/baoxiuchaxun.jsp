<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="30%" border="0">
  <tr>
    <td colspan="6"><div align="center">
      <h3>报修信息</h3>
    </div></td>
  </tr>
  
  <tr>
    <td><div align="center">报修编号</div></td>
    <td><div align="center">报修事件</div></td>
    <td><div align="center">报修单元</div></td>
    <td><div align="center">报修楼层</div></td>
    <td><div align="center">报修备注</div></td>
    <td><div align="center">维修状态</div></td>
  </tr>
  <c:forEach items="${userList}" var="user" begin="0"
		end="${userList.size()}" step="1" varStatus="maintainID">
  <tr>
    <td><div align="center">${user.maintainID}</div></td>
    <td><div align="center">${user.maintain_thing}</div></td>
    <td><div align="center">${user.maintain_homesnumber}</div></td>
    <td><div align="center">${user.maintain_fh}</div></td>
    <td><div align="center">${user.maintain_smemo}</div></td>
    <td><div align="center">${user.shifouweixiu}</div></td>
  </tr>
  </c:forEach>
  <tr align="center">  
            <td colspan="4">  
                <jsp:include page="/html/admin/baoxiuguanli/page.jsp"></jsp:include>  
            </td>  
        </tr>
</table>
</body>
</html>