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
	<div class="header">
		<div class="logo">
			<img src="${pageContext.request.contextPath }/images/logo.png" />
		</div>

		<div class="header-right">
			<i class="icon-question-sign icon-white"></i> <i
				class="icon-off icon-white"></i> <a id="modal-973558"
				href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
			<i class="icon-user icon-white"></i> <i
				class="icon-envelope icon-white"></i>
			<div id="modal-container-973558" class="modal hide fade"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
				style="width: 300px; margin-left: -150px; top: 30%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">注销系统</h3>
				</div>
				<div class="modal-body">
					<p>您确定要注销退出系统吗？</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					<a class="btn btn-primary" style="line-height: 20px;"
						href="index.jsp">确定退出</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 顶部 -->

	<div id="middle">
		<div class="left">

			<script type="text/javascript">
				var myMenu;
				window.onload = function() {
					myMenu = new SDMenu("my_menu");
					myMenu.init();
				};
			</script>

			<div id="my_menu" class="sdmenu">
				<div>
					<span>物流查询</span> <a href="${pageContext.request.contextPath }/html/inputdanhao.jsp">根据单号查询</a> <a
						href="分理处发货排行榜.html">根据时间查询</a> <a href="开票界面.html">根据站点查询</a> <a
						href="客户投诉.html">根据货物名称</a> <a href="#">到货确认</a>
				</div>
				<div class="collapsed">
					<span>数据统计</span> <a href="#">每日订单汇总</a>
				</div>
				<div class="collapsed">
					<span>订单管理</span> <a href="${pageContext.request.contextPath }/html/main.jsp">下单</a> <a href="#">订单查询</a> <a
						href="${pageContext.request.contextPath }/html/chuliyundan.jsp">处理运单</a> <a href="${pageContext.request.contextPath }/html/quxiaodanhaoInput.jsp">取消订单</a><a href="#">订单状态</a>

				</div>
				<div class="collapsed">
					<span>站点管理</span> <a href="${pageContext.request.contextPath }/html/side_list.jsp">查询所有站点</a>
					<a href="#">站点名查询</a> <a href="${pageContext.request.contextPath }/html/side_add.jsp">增加站点</a>
					<a href="${pageContext.request.contextPath }/html/xiugaiside.jsp">修改站点</a>
				</div>

				<div class="collapsed">
					<span>财务管理</span> <a href="#">每日收入总计</a> <a href="#">每单收款详情</a>

				</div>
			</div>

		</div>
		<div class="Switch"></div>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".Switch").click(function() {
					$(".left").toggle();

				});
			});
		</script>

		<div class="right" id="mainFrame">

			<div class="right_cont">
				<ul class="breadcrumb">
					当前位置：
					<a href="#">首页</a>
					<span class="divider">/</span> 下单
				</ul>

				<div class="title_right">
					<strong>发货单填写</strong>
				</div>
				<div style="width: 900px; margin: auto;">
				<form action="${pageContext.request.contextPath }/orderformServlet" method="post">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">下单日期：</td>
							<td width="23%"><input type="text"
								class="laydate-icon span1-1" id="Calendar" name="riqi" value="2015-08-25" /></td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货地点：</td>
							<td width="23%"><input type="text" name="fahuodidian" id=""
								class="span1-1" /></td>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">收货地点：</td>
							<td><input type="text" name="shouhuodidian" id="" class="span1-1" /></td>
						</tr>
						<tr>
							
							<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货人：</td>
							<td><input type="text" name="fahuoren" id="" class="span1-1" /></td>
							<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">发货人电话：</td>
							<td><input type="text" name="fahuorendianhua" id="" class="span1-1" /></td>
							<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">运单类型：</td>
							<td><input type="text" name="yundanleixing" id="" class="span1-1" /></td>
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
							<td align="center" bgcolor="#f1f1f1"><strong>运单状态</strong></td>
							<td align="center" bgcolor="#f1f1f1"><strong>数量</strong></td>
							<td align="center" bgcolor="#f1f1f1"><strong>类型</strong></td>
							<td align="center" bgcolor="#f1f1f1"><strong>运费</strong></td>

						</tr>
						<tr>
							<td align="center"><input type="text" name="yundanzhuangtai"
								id="input4" class=" span2" readonly="readonly" value="未处理" /></td>
							
							<td align="center"><input type="text" name="shuliang"
								id="input5" class=" span1 text-center" value="个/吨/体积" /></td>
							<td align="center"><input type="text" name="leixing"
								id="input6" class=" span1 text-center" value="衣服/瓷器*" /></td>
							<td align="center"><input type="text" name="yunfei"
								id="input7" class=" span1 text-center"  /></td>
							
							

						</tr>
					</table>
					<table class="table table-bordered">
						
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
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer"></div>



	<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#Calendar'
			});
		}();
	</script>

</body>
</html>