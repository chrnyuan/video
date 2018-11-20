<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="http://localhost:8080/Web-SSM/">
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
       color: black;
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
                      
                        <div class="col-xs-2"><h3>课程管理</h3></div>
   
                    </div>

     </div>  
     </div>
	
 	<div class="col-xs-2"></div>
    <div class="col-xs-1"> 
    <a href="${pageContext.request.contextPath }/courseInsert.action">
    <button class="btn btn-info">添加</button></a>	
    </div>
       <form action="${pageContext.request.contextPath }/courseDeleteAll.action" method="post">
    	<input type="submit" class="btn btn-info" value="批量删除">	

    <div id="box2">
 
    <table frame="border" cellpadding="15" cellspacing="0" align="center" rules="all" width="1000" >
        <tr  class="td">
           <th class="td"><input type="checkbox" name="courseIds" value=""></th>
           <th class="td">序号</th>
           <th class="td">标题</th>
           <th class="td" >简介</th>
           <th class="td">编辑</th>
           <th class="td">删除</th>
            
        </tr>
      <c:forEach items="${CourseList}" var="course">
        <tr class="td">
        	<td class="td"><input type="checkbox" name="courseIds" value="${course.courseId}"></td>
            <td class="td">${course.courseId}</td>
            <td class="td">${course.courseTitle}</td>
            <td class="td">${course.courseDesc}</td>
         	<td class="td"><a href="course.Update.action?courseId=${course.courseId}">编辑</a></td>
         	<td class="td"><a href="course.Delete.action?courseId=${course.courseId}">删除</a></td>
        </tr>
        </c:forEach>
          <!--文字信息-->
        

    </table>
   <div >
        <div >
       	<div class="col-xs-2"></div>
       	<div class="col-xs-1"> <p>一共${page.pages}页</p></div>
		<c:if test="${!(page.isFirstPage)}">
       		<a href="lession.action?page=${page.firstPage}">第一页</a>&emsp;
      		<a href="lession.action?page=${page.prePage}">上一页</a>&emsp;
		</c:if>
<c:if test="${!(page.isLastPage)}">
      <a href="lession.action?page=${page.nextPage}">下一页</a>&emsp;
      <a href="lession.action?page=${page.lastPage}">最后页</a>
      	</c:if>
     	</div>
</div>




 </form>
</body>
</html>