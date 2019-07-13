<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
#Layer1 {position:absolute;
	left:83px;
	top:17px;
	width:1168px;
	height:42px;
	z-index:1;
}
#renshi {
	position:absolute;
	left:139px;
	top:55px;
	width:299px;
	height:31px;
	z-index:3;
	visibility: hidden;
}
#wuyeguanli {	position:absolute;
	left:269px;
	top:56px;
	width:176px;
	height:0px;
	z-index:2;
	visibility: hidden;
}
#baoxiu {
	position:absolute;
	left:492px;
	top:56px;
	width:351px;
	height:37px;
	z-index:4;
	visibility: hidden;
}
#feiyong {
	position:absolute;
	left:784px;
	top:55px;
	width:195px;
	height:34px;
	z-index:5;
	visibility: hidden;
}
#yonghu {
	position:absolute;
	left:955px;
	top:55px;
	width:260px;
	height:29px;
	z-index:6;
	visibility: hidden;
}
#xitong {
	position:absolute;
	left:1105px;
	top:55px;
	width:282px;
	height:35px;
	z-index:7;
	visibility: hidden;
}
body {
	background-color: #CCCCCC;
}
#Layer2 {
	position:absolute;
	left:26px;
	top:14px;
	width:53px;
	height:47px;
	z-index:2;
}
-->
</style>
<script type="text/JavaScript">
<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>
</head>

<body>
<div id="Layer1">
  <table width="1300" height="40">
    <tr>
      <th bgcolor="#0099FF" scope="col"><a href="${pageContext.request.contextPath }/html/admin/indexset.jsp" target="_parent">首页</a></th>
      <th bgcolor="#0099FF" scope="col" onclick="MM_showHideLayers('Layer1','','show','renshi','','show','wuyeguanli','','hide','baoxiu','','hide','feiyong','','hide','yonghu','','hide','xitong','','hide')"><a href="${pageContext.request.contextPath }/html/admin/renshiguanli/renshiguanliset.jsp" target="_parent">人事管理</a></th>
      <th bgcolor="#0099FF" scope="col" onclick="MM_showHideLayers('Layer1','','show','renshi','','hide','wuyeguanli','','show','baoxiu','','hide','feiyong','','hide','yonghu','','hide','xitong','','hide')"><a href="${pageContext.request.contextPath }/html/admin/wuyeguanli/wuyuguanliset.jsp" target="_parent">物业管理</a></th>
      <th bgcolor="#0099FF" scope="col" onclick="MM_showHideLayers('Layer1','','show','renshi','','hide','wuyeguanli','','hide','baoxiu','','show','feiyong','','hide','yonghu','','hide','xitong','','hide')"><a href="${pageContext.request.contextPath }/html/admin/baoxiuguanli/baoxiuguanliset.jsp" target="_parent">报修管理</a></th>
      <th bgcolor="#0099FF" scope="col" onclick="MM_showHideLayers('Layer1','','show','renshi','','hide','wuyeguanli','','hide','baoxiu','','hide','feiyong','','show','yonghu','','hide','xitong','','hide')"><a href="${pageContext.request.contextPath }/html/admin/feiyongguanli/index.jsp" target="_parent">费用管理</a></th>
      <th bgcolor="#0099FF" scope="col" onclick="MM_showHideLayers('Layer1','','show','renshi','','hide','wuyeguanli','','hide','baoxiu','','hide','feiyong','','hide','yonghu','','show','xitong','','hide')"><a href="${pageContext.request.contextPath }/html/admin/yonghugongneng/yonghugongnengset.jsp" target="_parent">用户功能</a></th>
    </tr>
  </table>
</div>
<div id="Layer2"><img src="${pageContext.request.contextPath }/html/images/2014082816492001.png" width="53" height="46" /></div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<hr align="center" width="1400"  color="#333333" />
<p>&nbsp;</p>
<div></div>
</body>
</html>