b<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>主讲人管理</title>
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
                  
                    <div class="col-xs-2"><h3>主讲人管理</h3></div>

                </div>

 </div>  
 </div>
		<div class="col-xs-2"></div>
		<div class="col-xs-1">
		<a href="${pageContext.request.contextPath }/speakerInsert.action">
		<button class="btn btn-info">添加</button></a>
   		 </div>

		<form action="${pageContext.request.contextPath}/speaker.ManyDelete.action" method="post"> 
		<input type="submit" class="btn btn-info" value="批量删除">	

		<div id="box2">
	
<table frame="border" cellpadding="15" cellspacing="0" align="center" rules="all" width="1000" >
    <tr  align="center">
       <th><input type="checkbox" name="speakerIds" value=""></th>
       
       <th>序号</th>
       <th>名称</th>
       <th>职位</th>
       <th>简介</th>
       <th>编辑</th>
       <th>删除</th>
        
    </tr>
  <c:forEach items="${speakersList}" var="speaker">
    <tr align="center">
        <td><input type="checkbox" name="speakerIds" value="${speaker.speakerId}"></td>
        <td >${speaker.speakerId}</td>
        <td>${speaker.speakerName}</td>
        <td>${speaker.speakerJob}</td>
        <td>${speaker.speakerDesc}</td>
         <td><a href="${pageContext.request.contextPath }/speaker.Update.action?speakerId=${speaker.speakerId}">编辑</a></td>
         <td><a href="${pageContext.request.contextPath }/speaker.Delete.action?speakerId=${speaker.speakerId}">删除</a></td>
    </tr>
  
    </c:forEach>
    
</table>

</div>
  </form>
  		<div >
       	<div class="col-xs-2"></div>
       	<div class="col-xs-1"> <p>一共${page.pages}页</p></div>
       	<c:if test="${!(page.isFirstPage)}">
       <a href="speaker.action?page=${page.firstPage}">第一页</a>&emsp;
        <a href="speaker.action?page=${page.prePage}">上一页</a>&emsp;
        </c:if>
        <c:if test="${!(page.isLastPage)}">
       <a href="speaker.action?page=${page.nextPage}">下一页</a>&emsp;
        <a href="speaker.action?page=${page.lastPage}">最后页</a>
        </c:if>

     	</div>
</body>
</html>