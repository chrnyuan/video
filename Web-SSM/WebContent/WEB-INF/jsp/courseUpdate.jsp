<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery-1.js"></script>
<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="jquery.validate.min.js"></script>
<script type="text/javascript" src="messages_th.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>修改信息</title>
</head>


<style>

label{
	color:#8066ff;
}
div.container div.row div {
	margin: 5px 0px;
}

div.container div.row div {
	border: 1px;
	color: rgb(238, 228, 228);
}

.box {
	font-size: 20px;
	font-family: 楷体； width : 400px;
	height: 500px;
	position: absolute;
	top: 150px;
	left: 300px;
}

#box2 {
	width: 100%;
	height: 40px;
	background-color: black;
}

#box3 {
	width: 100%;
	height: 80px;
	background-color: whitesmoke;
	color: black;
}

.box4 {
	width: 500px;
	height: 60px;
	border-radius: 5px;
}

.box5 {
	width: 500px;
	height: 30px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div id="box2">
		<div class="container">
			<div class="row">

				<div class="col-xs-2">视频管理系统</div>
				<div class="col-xs-1">视频管理</div>
				<div class="col-xs-2">主讲人管理</div>
				<div class="col-xs-1">课程管理</div>
				<div class="col-xs-4"></div>
				<div class="col-xs-2">
					admin<img src=""><a href="${pageContext.request.contextPath}/outAdminlogin.action">退出</a>
				</div>

			</div>

		</div>
	</div>
	<div id="box3">
		<div class="container">
			<div class="row">

				<div class="col-xs-2">
					<h3>修改课程</h3>
				</div>

			</div>

		</div>
	</div>

	<div class="box">
		<form id="courseForm"
			action="${pageContext.request.contextPath }/course.Update.action"
			method="post">
			<input type="hidden" name="courseId" value="${courseS.courseId}">
			所属学科&emsp; <select name="subjectId" class="box5">
				<option value="${courseS.subjectId}" />
				<c:forEach items="${subjectList}" var="sub">
					<option value="${sub.subjectId}">${sub.subjectName}</option>
				</c:forEach>
			</select><br><br> 
			&emsp;&emsp; 标题&emsp;<input
				type="text" name="courseTitle" class="box5"  placeholder="课程标题" value="${courseS.courseTitle}"> 
			<br> <br>
			&emsp;&emsp; 简介&emsp;<input type="text" name="courseDesc"  class="box4" value="${courseS.courseDesc}"> <br>
			<br> <input type="submit" value="保存" class="btn btn-default">
		</form>
	</div>




</body>
<!-- jquery 表单验证 -->
<script type="text/javascript">
 $().ready(function(){
		$("form").validate({
			//代表所有表单
			rules:{
				courseTitle:{
					required:true,
					minlength:4,

				},
				courseDesc:{
					required:true,
					minlength:4,
				}
			},
			messages:{
				courseTitle:{
					required:"请输入课程标题",
					minlength:"课程标题最少4个字符",
				},		
				courseDesc:{
					required:"请输入简介",
					minlength:"简介最少4个字符",
			}
		}
			
		})
	})
 </script> 


</html>