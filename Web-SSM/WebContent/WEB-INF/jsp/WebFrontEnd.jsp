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
<title>课程介绍</title>
  <style>
       .container{
      width: 900;
      border: 1px;
     
  }
  .box{
      width: 100%;
      height: 200px;
  }
  .box2{
      width: 150px;
      height: 170px;
  }
  
  </style>
  <base href="http://localhost:8080/Web-SSM/">
</head>
<body>
	  <div class="containner">
                <div class="row">
                     <div class="col-md-3"></div>
            		<div class="col-md-3">欢迎来到IT培训的黄埔军校——智游教育</div>
            		<div class="col-md-2"><img src="z/phone.png"><span style="color:red;">0371-88888598 4006-371-555</span></div>
           			<div class="col-md-1"><img src="z/we.png"><a href="${pageContext.request.contextPath}/adminLogin.action">后台管理</a></div>
           			<div class="col-md-1"><img src="z/sc.png"><a href="">加入收藏</a></div>
           			<div class="col-md-1"><img src="z/we.png"><a href="${pageContext.request.contextPath }/userLogin.action">登录</a></div>
           			<div class="col-md-1"><img src="z/we.png"><a href="userRegister.action">注册</a></div>
                </div>
                <img src="z/banner-1.jpg" class="box">
                
            </div>
            <div class="containner">
            	<div class="row">
              
                    <div class="col-md-1"></div>
                    <div class="col-md-1">公开课/WEB前端</div>
                </div>
            
                <c:forEach items="${courseVideoList}" var="course">
                <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-3"><h3>${course.courseTitle}</h3></div>
                </div>
                <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-1"><b>课程介绍：</b></div>
                        <div class="col-md-8">${course.courseDesc}</div>
                </div>
                 <c:forEach items="${course.videos}" var="video">
               		<div class="col-md-1"></div> 
                        <div class="col-md-2" > 
                        	<div class="box2">
                        	<div >
                  		 <a href="${pageContext.request.contextPath}/usershowVideo.action?videoId=${video.videoId}"> <img alt="加载失败" src="${video.videoImgUrl}" style="width:150px;height:100px;"></a> 		
                        	</div>
                        		<div>${video.videoTitle}</div>
                        		<div>${video.videoPlayNum}</div>
                        		<div>${video.videoTime}</div>
                        		<br><br>
                        	</div>
                        </div>
                        </c:forEach>
                 </c:forEach>
                   
            </div>
           
        
            
</body>
</html>