<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/sdmenu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/laydate/laydate.js"></script>
</head>
<body>
	<div class="right_cont">
		<div class="title_right">
			<strong>修改订单</strong>
		</div>
		<div style="width: 900px; margin: auto;">
			<form action="" method="get">
				<table class="table table-bordered">
					<tr>
						<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">下单日期：</td>
						<td width="23%"><input type="text" name="riqi" id=""
							class="span1-1" /></td>
						<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货地点：</td>
						<td width="23%"><input type="text" name="fahuodidian" id=""
							class="span1-1" /></td>
						<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货地点：</td>
						<td><input type="text" name="shouhuodidian" id=""
							class="span1-1" /></td>
					</tr>
					<tr>

						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货人：</td>
						<td><input type="text" name="fahuoren" id="" class="span1-1" /></td>
						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货人电话：</td>
						<td><input type="text" name="fahuorendianhua" id=""
							class="span1-1" /></td>
						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">运单类型：</td>
						<td><input type="text" name="yundanleixing" id=""
							class="span1-1" /></td>
					</tr>
					<tr>

						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货人：</td>
						<td><input type="text" name="shouhuoren" id="input2"
							class="span1-1" /></td>
						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货人电话：</td>
						<td><input type="text" name="shouhuorendianhua" id="input3"
							class="span1-1" /></td>
					</tr>
				</table>
				<table class="table table-bordered">
					<tr>
						<td align="center" bgcolor="#f1f1f1"><strong>货物名称</strong></td>
						<td align="center" bgcolor="#f1f1f1"><strong>数量</strong></td>
						<td align="center" bgcolor="#f1f1f1"><strong>类型</strong></td>
						<td align="center" bgcolor="#f1f1f1"><strong>运费</strong></td>

					</tr>
					<tr>
						<td align="center"><input type="text" name="huowumingcheng"
							id="input4" class=" span2" /></td>

						<td align="center"><input type="text" name="shuliang"
							id="input5" class=" span1 text-center" value="个/吨/体积" /></td>
						<td align="center"><input type="text" name="leixing"
							id="input6" class=" span1 text-center" value="衣服/瓷器*" /></td>
						<td align="center"><input type="text" name="yunfei"
							id="input7" class=" span1 text-center" /></td>



					</tr>
				</table>
				<table class="table table-bordered">
					<tr>
						<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">收款人：</td>
						<td width="23%"><input type="text" name="yuangonghao"
							id="input10" class="span1-1" /></td>

					</tr>

					<tr>
						<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
						<td colspan="5" nowrap="nowrap"><input type="text"
							name="beizhu" id="input9" class="span10" /></td>
					</tr>
				</table>

				<table class="margin-bottom-20  table no-border">
					<tr>
						<td class="text-center"><input type="submit" value="确定"
							class="btn btn-info  " style="width: 80px;" /></td>
					</tr>
				</table>
			</form>
			<div class="alert">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				*欢迎使用超能物流*
			</div>

		</div>

	</div>

</body>
</html>