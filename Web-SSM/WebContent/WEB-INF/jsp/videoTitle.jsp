<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>视频在线</title>

</head>
<style>
.container{
      width: 900;
      border: 1px;
      vertical-align: middle;
  }

</style>
<body>
	<div class="containner">
<!-- 		<div class="row">	 -->
<!-- 			<div class="col-md-4"></div> -->
<%-- 			<div class="col-md-4">${video.videoTitle}</div> --%>
<!-- 			<div class="col-md-4"></div> -->
		
<!-- 		</div> -->
		
		<div class="col-md-12"><video src="${video.videoUrl}" controls="controls" style="width:100%;htight:100%;"></video></div>

	</div>
  
</body>
</html>