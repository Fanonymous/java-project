<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
	var _textfield3 =document.getElementById("textfield3Id").value;
	if(_textfield3==null||""==_textfield3){
		alert("巡查时间不能为空 ！");
		return false;
	}
	var _textfield4 =document.getElementById("textfield4Id").value;
	if(_textfield4==null||""==_textfield4){
		alert("巡查结果不能为空 ！");
		return false;
	}
	
 }
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/test10">
  <table width="30%" height="80%" border="0" align="center">
    <tr>
      <td colspan="2"><div align="center">新建巡查</div></td>
    </tr>
    <tr>
      <td width="34%"><div align="right">巡查人*：</div></td>
      <td width="66%"><label>
        
        <div align="left">
          <input type="text" name="textfield" id="textfieldId"/>
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查类别*：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield2" id="textfield2Id"/>
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查时间*(2015.7.25 pm10:00)：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield3" id="textfield3Id"/>
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查处理人：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield4" />
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查当事人：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield5" />
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查结果*：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield6" id="textfield4Id"/>
        </div>
      </label></td>
    </tr>
    <tr>
      <td><div align="right">巡查备注：</div></td>
      <td><label>
        
        <div align="left">
          <input type="text" name="textfield7" />
        </div>
      </label></td>
    </tr>
    <tr>
      <td colspan="2"><label>
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="Submit" onclick="return checkvalue();" value="提交" />
        </label>
        <label>
        
        <input type="reset" name="Submit2" value="重置" />
      </label></td>
    </tr>
  </table>
</form>

</body>
</html>