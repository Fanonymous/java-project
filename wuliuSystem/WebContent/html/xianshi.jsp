<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" height="30%" border="1" align="center">
		<tr>
			<td colspan="13">
				<div align="center">订单</div>
			</td>
		</tr>
		<tr>
			<td width="3%">
				<div align="center">订单号</div>
			</td>
			<td width="9%">
				<div align="center">运单类型</div>
			</td>
			<td width="9%">
				<div align="center">下单时间</div>
			</td>
			<td width="6%">
				<div align="center">发货地址</div>
			</td>
			<td width="10%">
				<div align="center">收货地址</div>
			</td>
			<td width="8%">
				<div align="center">运单状态</div>
			</td>
			<td width="4%">
				<div align="center">货物类型</div>
			</td>
			<td width="4%">
				<div align="center">货物数量</div>
			</td>
			<td width="9%">
				<div align="center">发货人</div>
			</td>
			<td width="5%">
				<div align="center">发货人电话</div>
			</td>
			<td width="8%">
				<div align="center">收货人</div>
			</td>
			<td width="3%">
				<div align="center">收货人电话</div>
			</td>
			<td width="7%">
				<div align="center">费用</div>
			</td>
			<td width="7%">
				<div align="center">备注</div>
			</td>
			<td width="7%">
				<div align="center">收款人</div>
			</td>


		</tr>
		<c:forEach items="${orderform}" var="orderform" begin="0"
		end="${ orderform.size()}" step="1" varStatus="orderID">
			<tr>
				<td>
					<div align="center">${orderform.orderID}</div>
				</td>
				<td>
					<div align="center">${orderform.transportType}</div>
				</td>
				<td>
					<div align="center">${orderform.resisteredTime}</div>
				</td>
				<td>
					<div align="center">${orderform.sendplace}</div>
				</td>
				<td>
					<div align="center">${orderform.receiveplace}</div>
				</td>
				<td>
					<div align="center">${orderform.goodsName}</div>
				</td>
				<td>
					<div align="center">${orderform.goodsType}</div>
				</td>
				<td>
					<div align="center">${orderform.goodsNumber}</div>
				</td>
				<td>
					<div align="center">${orderform.outNmae}</div>
				</td>
				<td>
					<div align="center">${orderform.outPhone}</div>
				</td>
				<td>
					<div align="center">${orderform.inName}</div>
				</td>
				<td>
					<div align="center">${orderform.inPhone}</div>
				</td>
				<td>
					<div align="center">${orderform.cost}</div>
				</td>
				<td>
					<div align="center">${orderform.remarks}</div>
				</td>
				<td>
					<div align="center">${orderform.adminID}</div>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>