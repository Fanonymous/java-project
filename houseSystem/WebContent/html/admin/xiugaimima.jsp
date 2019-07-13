<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>无标题文档</title>
<script type="text/javascript">
 function checkvalue(){
	var _textfield =document.getElementById("textfieldId").value;
	if(_textfield==null||""==_textfield){
		alert("巡查人不能为空！");
		return false;
	}
	var _textfield2 =document.getElementById("textfield2Id").value;
	if(_textfield2==null||""==_textfield2){
		alert("巡查类别不能为空 ！");
		return false;
	}
	
 }
</script>
<style type="text/css">
<!--
.STYLE1 {	color: #CC0000;
	font-family: "宋体";
	font-size: 26px;
}
#Layer1 {
	position:absolute;
	left:128px;
	top:34px;
	width:945px;
	height:32px;
	z-index:1;
	background-color: #333333;
}
.STYLE3 {	font-family: "宋体";
	font-size: 16px;
}
#Layer2 {
	position:absolute;
	left:320px;
	top:192px;
	width:304px;
	height:138px;
	z-index:2;
}
.STYLE4 {font-size: 16px}
.STYLE5 {font-family: "宋体"}
-->
</style>
</head>

<body>
<div id="Layer1">
  <marquee scrollamount="5" width="1000">
  <span class="STYLE1">超能小区密码修改，请牢记您的密码，谢谢合作，祝您生活愉快！！！ </span>
  </marquee>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<hr align="center" width="100%" />
<div id="layer">
  <form id="form1" name="form1" method="post" action="/houseSystem/test2" target="_parent">
    <div align="center">
      <p align="left"><br />
          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div align="left" class="STYLE4">
            <div align="center">
              请输入您的账户*(int型)：
              <input type="text" name="textfield2" id="textfieldId"/>
              </div>
          </div>
          </label>
          <div align="center" class="STYLE4">
            <br />
            </div>
          <span class="STYLE3">
<label></label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
          <div align="center" class="STYLE4">            <span class="STYLE5">请输入新密码*：
            <input type="password" name="textfield" id="textfield2Id"/>
            </span></div>
      </p>
      <span class="STYLE3"><br />
&nbsp;&nbsp;
<input name="提交"  type="submit" onclick="return checkvalue();" id="提交" value="提交" />
        </span>
      
        <span class="STYLE4">
        <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="重置" type="reset" id="重置" value="重置" />
          </label>
        </span></div>
    <span class="STYLE4">
    </label>
    </span>
    <div>
<script type="text/javascript">
if('${mes}'){
	alert('${mes}');
}
		
	</script>
	</div>
	
	
<div>
	<script type="text/javascript">
	if('${mess}'){
		alert('${mess}');
	}
	</script>
	
</div>
    
    
    
  </form>
</div>
<div align="left"><div align="left"><p>&nbsp;</p>
</div></div>

</body>
</html>