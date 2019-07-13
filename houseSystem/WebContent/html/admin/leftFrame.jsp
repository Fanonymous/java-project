<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {color: #00CC99}
#Layer2 {	position:absolute;
	left:10px;
	top:43px;
	width:179px;
	height:38px;
	z-index:1;
}
#Layer3 {	position:absolute;
	left:9px;
	top:180px;
	width:187px;
	height:234px;
	z-index:2;
}
body {
	background-color: #CCCCCC;
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
<div id="Layer2"><span class="STYLE1"></span>
    <table width="200" height="38" >
      <tr>
        <th bgcolor="#00CC99" scope="col">欢迎使用</th>
      </tr>
    </table>
</div>
<div id="Layer3">
  <table width="200" height="235" >
    <tr>
      <td height="77" bgcolor="#FF9933" onclick="MM_showHideLayers('Layer3','','show','feiyong?mainFrame','','show')"><div align="center"><a href="${pageContext.request.contextPath }/html/admin/xiugaimima.jsp" target="mainFrame">修改密码</a></div></td>
    </tr>
    <tr>
      <td height="73" bgcolor="#FF9933" onclick="MM_showHideLayers('Layer3','','show','xinxi?mainFrame','','show')"><div align="center"><a href="${pageContext.request.contextPath }/html/index.jsp" target="_parent">退出系统</a></div></td>
    </tr>
    <tr>
      <td height="75" bgcolor="#FF9933"><div align="center"><a href="${pageContext.request.contextPath }/html/admin/guanyuzuozhe.jsp" target="mainFrame">关于作者</a></div></td>
    </tr>
  </table>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="200" height="46" border="1">
  <tr>
    <th height="40" scope="col">
     <!-- #BeginDate format:fcCh2a -->2015年7月21日 星期二 9:23 AM<!-- #EndDate --></th>
      
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>