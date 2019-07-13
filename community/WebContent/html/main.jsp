<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<frameset style="background-color:gray;" rows="121,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame style="background-color:gray;" src="${pageContext.request.contextPath }/html/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset style="background-color: gray;" rows="*" cols="217,*" framespacing="0" frameborder="no" border="0">
    <frame style="background-color:gray;" src="${pageContext.request.contextPath }/html/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame style="background-color: gray;" src="${pageContext.request.contextPath }/html/center.jsp" name="showCenter" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
</html>