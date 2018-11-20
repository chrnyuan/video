<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>添加视频信息</title>
   <style>
       div.container div.row div {
    margin:5px 0px;
   
     
}
div.container div.row div {
   
    border: 1px ;
  
   color:rgb(238, 228, 228); 
   
}
   .box{
        font-size:20px;
		font-family:楷体；
		
		width:400px;
		height:500px;
		position:absolute; top:150px; left:300px;
		
   }
   #box2{
       width: 100%;
       height: 40px;
       background-color: black;
   }
   #box3{
       width: 100%;
       height: 80px;
       background-color:whitesmoke;
       color: black;
   }
   .box4{
       width: 500px;
       height: 60px;
       border-radius: 5px;
       font-wight;
   }
   .box5{
       width: 500px;
       height: 30px;
       border-radius: 5px;
        font-wight;
   }
   
   label{
	color:#8066ff;
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
                        <div class="col-xs-2">admin<img src=""><a href="${pageContext.request.contextPath}/outAdminlogin.action">退出</a></div>
                        
                    </div>
            
                </div>
    </div>
     <div id="box3">
            <div class="container">
                    <div class="row">
                      
                        <div class="col-xs-2"><h3>添加视频信息</h3></div>
   
                    </div>

     </div>  
     </div>
     
                <div class="box">
                <form action="videoInsert.action" method="post">
                
 &emsp;&emsp;视频标题&emsp;<input type="text" name="videoTitle" class="box5" placeholder="视频名称"> <br><br>
 &emsp;&emsp;&emsp;主讲人&nbsp;&nbsp;<select name="speakerId" class="box5" placeholder="请选择讲师">
           			<c:forEach items="${speakerList}" var="speaker">
                       <option value="${speaker.speakerId}">${speaker.speakerName}</option>
                  </c:forEach>
                   </select>
                   <br><br>
 &emsp;&emsp;所属课程&emsp;<select name="courseId" class="box5" placeholder="请选择课程">
           			<c:forEach items="${courseList}" var="course">
                       <option value="${course.courseId}">${course.courseTitle}</option>
                  </c:forEach>
                   </select>
                    <br><br>
&nbsp;视频时长(秒)&emsp;<input type="text" name="videoTime" class="box5" placeholder="精确到秒(正整数)">
                <br><br>
 封面图片地址&emsp;<input type="text" name="videoImgUrl"  placeholder="具体的url"class="box5">
                 <br><br>  
  视频播放地址&nbsp;&nbsp;<input type="text" name="videoUrl" class="box5" placeholder="具体的url">
                <br><br> 
&emsp;&emsp;&emsp;&emsp;备注&nbsp;&nbsp;<input type="text" name="videoDesc" title="" class="box4">
                 <br><br>   
                 <input type="submit" value="保存">
                  </form>
                </div>
               

	
</body>
<script type="text/javascript">
$().ready(function(){
	$("form").validate({
		//代表所有表单
		rules:{
			videoTitle:{
				required:true,
				minlength:4,
				
			},
			videoTime:{
				required:true,
			},
			videoImgUrl:{
				required:true,
				url:true	
			},
			videoUrl:{
				required:true,
				url:true	
			},
			videoDesc:{
				required:true,
				minlength:4,
			}
			
		},
		messages:{
			videoTitle:{
				required:"请输入视频名称",
				minlength:"标题最少4个字符",
			
			},
			videoImgUrl:{
				required:"请输入视频照片地址",
				url:"网址格式输入错误,请输入http://开头格式"
			},
			videoTime:{
				required:"请输入视频时长"
			},
			videoUrl:{
				required:"请输入 视频播放地址",
				url:"网址格式输入错误,请输入http://开头格式"
			},
			videoDesc:{
				required:"请输入备注",
				minlength:"标题最少4个字符",
			}
	}
	});	
});


</script>

</html>