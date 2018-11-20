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
<title>课程管理</title>
	    <style>
    div.container div.row div {
    margin:5px 0px;
   
     
}
div.container div.row div {
   
    border: 1px solid gray;
    
   
}
       div.container div.row div {
    margin:5px 0px;
   
     
}
div.container div.row div {
   
    border: 1px ;
  
   color:rgb(238, 228, 228); 
   
}
} 
#box2{
    width: 80%;
    height: 300px;
    position: absolute;
    left: 10%;
    top: 400px;
    background-color: antiquewhite;
}
 #box1{
       width: 100%;
       height: 40px;
       background-color: black;
   }
   #box3{
       width: 100%;
       height: 80px;
       background-color:whitesmoke;
      
   }
  #box4{
       width: 100%;
       height: 80px;
       border: 1px solid gray;
      
   }
   .like{
   		width:350px;
   		height:50px;
   		position: absolute;
    	left: 58%;
    	top: 140px;
   }
   .td{
   		text-align:center;vertical-align:middle;
   }
    </style>
</head>

<body>
  <div id="box1">
            <div class="container">
                    <div class="row">
                      
                        <div class="col-xs-2">视频管理系统</div>
                        <div class="col-xs-1"><a href="${pageContext.request.contextPath}/videoManage.action">视频管理</a></div>
                        <div class="col-xs-2"><a href="${pageContext.request.contextPath}/speaker.action">主讲人管理</a></div> 
                        <div class="col-xs-1"><a href="${pageContext.request.contextPath}/lession.action">课程管理</a></div>
                        <div class="col-xs-4"></div>
                        <div class="col-xs-2">admin<img src=""><a href="${pageContext.request.contextPath}/outAdminlogin.action">退出</a></div>
                        
                    </div>
            
                </div>
    </div>
     <div id="box3">
            <div class="container">
                    <div class="row">
                        <div class="col-xs-2"><h3>视频管理</h3></div>
                    </div>
     		</div>  
     </div>
	

	<div class="like">
		
		<form action="videoSelectLike.action" method="post"> 
		<input type="text" value="标题">
			<select name="speakerId"   class="scbtn"  title="请选择老师">
           			<c:forEach items="${speakerList}" var="speaker">
                       <option value="${speaker.speakerId}">${speaker.speakerName}</option>
                  </c:forEach>
                   </select>
			<select name="courseId"   class="scbtn"  title="请选择课程">
           			<c:forEach items="${courseList}" var="course">
                       <option value="${course.courseId}">${course.courseTitle}</option>
                  </c:forEach>
                   </select>
		<input type="submit" value="查询">
		</form>
		
	</div>
	
		
 			<div class="col-xs-2"></div>
   			 <div class="col-xs-1">
    		<a href="${pageContext.request.contextPath }/videoInsert.action">
    			<button class="btn btn-info">添加</button></a>
   			 </div>
   			
     			
    			
    

	

    		
    <form action="${pageContext.request.contextPath }/videoDeleteAll.action" method="post">
    			<input type="submit" class="btn btn-info" value="批量删除">		
    <div id="box2">
 
    <table frame="border" cellpadding="15" cellspacing="0" align="center" rules="all" width="1000" >
        <tr  class="td">
           <th><input type="checkbox" name="videoIds" value=""></th>
           <th style="text-align:center;vertical-align:middle;">序号</th>
           <th class="td">名称</th>
           <th class="td">介绍</th>
           <th class="td">讲师</th>
           <th class="td">时长</th>
           <th>播放次数</th>
           <th>编辑</th>
           <th>删除</th>    
        </tr>
      <c:forEach items="${videoList}" var="video">
        <tr align="center">
        	<td><input type="checkbox" name="videoIds" value="${video.videoId}"></td>
            <td>0</td>
            <td>${video.videoTitle}</td>
            <td>${video.videoDesc}</td>
            <td>${video.speaker.speakerName}</td>
            <td>${video.videoTime}</td>
            <td>${video.videoPlayNum}</td>
         	<td><a href="${pageContext.request.contextPath }/video.Update.action?videoId=${video.videoId}">编辑</a></td>
         	<td><a href="${pageContext.request.contextPath }/video.Delete.action?videoId=${video.videoId}">删除</a></td>
        </tr>
        </c:forEach>
        
    </table>
    <div >
        <div >
       	<div class="col-xs-2"></div>
       	<div class="col-xs-1"> <p>一共${page.pages}页</p></div>
       	<c:if test="${!(page.isFirstPage)}">
       	<a href="videoManage.action?page=${page.firstPage}">第一页</a>&emsp;
       <a href="videoManage.action?page=${page.prePage}">上一页</a>&emsp;
       </c:if>
       <c:if test="${!(page.isLastPage)}">
        <a href="videoManage.action?page=${page.nextPage}">下一页</a>&emsp;
         
        <a href="videoManage.action?page=${page.lastPage}">最后页</a>
	</c:if>
     	</div>
</div>
 </form>
 	
</body>
</html>