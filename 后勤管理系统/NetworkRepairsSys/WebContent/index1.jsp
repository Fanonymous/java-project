<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宝鸡文理学院&nbsp;-&nbsp;后勤报修系统</title>
<!-- 判断权限，是否登陆 -->
<%@ include file="WEB-INF/right.jsp"%>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.2/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.2/js_css/default.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.2/themes/default/easyui.css" />
<script type="text/javascript" src="jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.2/js_css/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.2/js_css/jquery.easyui.min.js"></script>
<script type="text/javascript" src='jquery-easyui-1.4.2/js_css/menu.js'> </script>

<script type="text/javascript">
    
    javascript:window.history.forward(1);//浏览器的回退键只能回退到上一个页面，在上一个页面再回退就不可以了
    var _menus = {		
    		//任务管理模块
    		menus: [{
    			menuid: 1,
    			icon: "tu2004",
    			menuname: "任务管理",
    			menus: [{
    				menuid: "12",
    				menuname: "接收任务",
    				icon: "tu0923",
    			    url: "taskReceive.jsp",
    			},
    			{
    				menuid: "13",
    				menuname: "上交任务",
    				icon: "tu1301",
    				url: "taskHandIn.jsp",
    			},
    			{
    				menuid: "14",
    				menuname: "任务浏览",
    				icon: "tu0117",
    				url: "taskBrowser.jsp",
    			}]
    		},
    		
    
    		//系统管理模块
    		{
    			menuid: "3",
    			icon: "tu0206",
    			menuname: "系统管理",
    			menus: [{
    				menuid: "32",
    				menuname: "个人信息维护",
    				icon: "tu0925",
    				url: "personInfoModify.jsp",
    			},
    			{
    				menuid: "32",
    				menuname: "登录密码维护",
    				icon: "tu2012",
    				url: "personPWDModify.jsp",
    			
    			}]
    		},
    		
  ]
    	};
      
    //退出系统
    function logout(){
    	 $.messager.confirm("温馨提示", "您确定要退出本次登录吗？", function (r) {
             if (r) {
            	 location.href = 'logout';
             }
         });
    }
</script>

<!-- js动态生成时间 -->
<script type="text/javascript">
	var t=null;
	t=setTimeout(time, 1000);//开始执行
	function time(){
		clearTimeout(t);//清除计时器
		d = new Date();//newdate对象
		var year=d.getFullYear();//获取年份
		var mon=d.getMonth()+1;//获取月份
		var date=d.getDate();//获取日
		
		var hour=d.getHours();//获取当前小时
		var min=d.getMinutes();//获取当前分钟
		var sec=d .getSeconds();//获取当前秒钟
		
		var day=d.getDay();//获取星期天
		document.getElementById("showTime").innerHTML=
		"当前时间："+year+"年"+mon+"月"+date+"日&nbsp;&nbsp;&nbsp;&nbsp;"+hour+":"+min+":"+sec/*+"'"+"&nbsp;&nbsp;&nbsp;&nbsp;星期 "+day*/;
		t=setTimeout(time, 1000);//设定计数器，循环执行
	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" fit="true"
	scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>

	<div id="loading-mask"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #D2E0F2; z-index: 20000">
		<div id="pageloading"
			style="position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #8DB2E3; width: 200px; height: 40px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #15428B;">
			<img src="images/loading.gif" align="middle" /> 正在加载中,请稍候...
		</div>
	</div>

	<!-- 布局	，北面 -->
	<div region="north"
		style="height: 60px; background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;"
		class="header">
		<div align="left" style="width: 85%; float: left">
			<div align="left"
				style="font-size: 30px; width: 50%; float: left; padding-left: 15px; padding-top: 6px; color: white">宝文理后勤报修系统</div>
			<!-- js生成动态时间 -->
			<div align="right" style="float: right; padding-top: 35px">
				<font color="white"><label id="showTime"></label></font>
			</div>
		</div>
		<div style="width: 12%; float: right;">
			<div style="padding-top: 10px; padding-left: 10px;">
				<label class="icon-man1">&nbsp;&nbsp;&nbsp;&nbsp;</label> <font
					size="15" color="white" face="黑体">您好:${currentUser.userName}[${currentUser.level}]</font>
			</div>

			<div style="padding-top: 5px; padding-left: 10px" align="left">
				<label class="icon-no">&nbsp;&nbsp;&nbsp;&nbsp;</label> <a
					onclick="logout()"><font color="red">安全退出</font></a>
			</div>
		</div>
	</div>

	<!-- 布局	，南面 -->
	<div region="south" split="" style="height: 50px; background: #535A6C;">
		<div class="footer" align="center">
			<font color="white"> copyright©2016宝鸡文理学院后勤服务小分队<br>
				地址：宝鸡市宝光路44号&nbsp;&nbsp;
			</font>
		</div>
	</div>

	<!-- 布局	，西面 -->
	<div region="west" split="true" title="导航菜单" style="width: 180px;"
		id="west">
		<div id="nav" style=""></div>
	</div>

	<!-- 布局	，中央 -->
	<div id="mainPanle" region="center"
		style="background-color: #F7F7F7; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="true">
			<div title="首页" style="padding-bottom: 15px; overflow: hidden;">
				<div style="width: 100%; height: 84.5%; background-color: #FDFDFD">
					<div align="center"
						style="padding-top: 14%; font-size: 50px; color: green; font-family: 华文行楷">
						<img alt="" src="images/bjwl.jpg">欢迎使用后勤报修系统
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>