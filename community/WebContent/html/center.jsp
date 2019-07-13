<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!--
body {
	background-color: #CCCCCC;
}

-->
</style>
</head>
<body>
<div align="center">
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0"
		width="1000" height="484">
		<param name="flash_component" value="ImageViewer.swc" />
		<param name="movie"
			value="${pageContext.request.contextPath }/images/111.swf" />
		<param name="quality" value="high" />
		<param name="FlashVars"
			value="flashlet={imageLinkTarget:'_blank',captionFont:'Verdana',titleFont:'Verdana',showControls:true,frameShow:true,slideDelay:5,captionSize:10,captionColor:#333333,titleSize:10,transitionsType:'Random',titleColor:#333333,slideAutoPlay:true,imageURLs:['${pageContext.request.contextPath }/images/001.jpg','${pageContext.request.contextPath }/images/002.jpg','${pageContext.request.contextPath }/images/003.jpg','${pageContext.request.contextPath }/images/004.jpg','${pageContext.request.contextPath }/images/005.jpg'],slideLoop:false,frameThickness:2,imageLinks:['http://macromedia.com/','http://macromedia.com/','http://macromedia.com/'],frameColor:#333333,bgColor:#FFFFFF,imageCaptions:[]}" />
		<embed src="${pageContext.request.contextPath }/images/111.swf"
			quality="high"
			flashvars="flashlet={imageLinkTarget:'_blank',captionFont:'Verdana',titleFont:'Verdana',showControls:true,frameShow:true,slideDelay:5,captionSize:10,captionColor:#333333,titleSize:10,transitionsType:'Random',titleColor:#333333,slideAutoPlay:true,imageURLs:['${pageContext.request.contextPath }/images/001.jpg','${pageContext.request.contextPath }/images/002.jpg','${pageContext.request.contextPath }/images/003.jpg','${pageContext.request.contextPath }/images/004.jpg','${pageContext.request.contextPath }/images/005.jpg'],slideLoop:false,frameThickness:2,imageLinks:['http://macromedia.com/','http://macromedia.com/','http://macromedia.com/'],frameColor:#333333,bgColor:#FFFFFF,imageCaptions:[]}"
			pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
			type="application/x-shockwave-flash" width="1000" height="484">
		</embed>
	</object>

</div>

</body>
</html>