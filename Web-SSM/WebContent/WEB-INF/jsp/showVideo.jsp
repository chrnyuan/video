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
<title>教学视频</title>
  <style>
    .tom{
      width: 100%;
      height: 250px;
      background-color:black;
      position: fixed;
      left: 0px;
      top: 900px;
  }
  .bottom1{
    width: 200px;
    height: 40px;
   
    position: absolute;
    left: 15%;
    top: 30%;
    
}
.bottom2{
    width: 400px;
    height: 200px;
   
    position:absolute;
    left: 30%;
    top: 10%;
    font-size: 5px;
    color: silver;
}

.bottom3{
    width: 400px;
    height: 200px;
   
    position:absolute;
    left: 60%;
    top: 10%;
    font-size: 5px;
    color: silver;
}
.bottom4{
    width: 100px;
    height: 100px;
    position: absolute;
    font-size: 5px;
    color: silver;
    left: 60%;
    top: 50%;
  
}
.bottom5{
    width: 100px;
    height: 100px;
    position: absolute;
    font-size: 5px;
    color: silver;
    left: 70%;
    top: 50%;
  
}
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
  .box3{
  	 width: 100%;
     height: 400px;
    
  }
   .box4{
  	width: 40%;
    height: 300px;
   
    position: absolute;
    left: 9%;
    top: 10%;
  }
   .box5{
  	width: 40%;
    height: 300px;
   
    position: absolute;
    left: 50%;
    top: 10%;
  }
  .box6{
  	width:30%;
  	height:35%;
  	
  }
  .box7{
  	width: 60%;
    height: 100px;
  
    position: absolute;
    left: 40%;
    top: 20%;
  	
  }
  .box8{
  	width: 100%;
    height: 20%;
   
    position: absolute;
    
    top: 70%;
  }
	.box9{
	width: 80%;
    height: 100px;
     border-bottom:solid 2px silver;
   
    position: absolute;
    left: 9%;
    top: 56%;
	}
.box10{
	width: 80%;
    height: 50px;
 
   
    position: absolute;
    left: 9%;
    top: 75%;
	}
	.box11{
	width: 80%;
    height: 2000px;
    
   
    position: absolute;
    left: 9%;
    top: 85%;
	}
	.box12{
	width: 70%;
    height: 100px;
   
	}
.box13{
	width:90%;
    height: 20px;
   border-bottom:solid 2px silver;
   
	}
.box14{
	width:100px;
    height: 20px;
 
    position: absolute;
   
    left: 80%;
	}
  </style>
 <base href="http://localhost:8080/Web-SSM/">
</head>
<body>
	  <div class="containner">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-3">欢迎来到IT培训的黄埔军校——智游教育</div>
                    <div class="col-md-2"><img src="z/phone.png"><span style="color:red;">0371-88888598 4006-371-555</span></div>
                   <div class="col-md-1"><img src="z/we.png">后台管理</div>
                   <div class="col-md-1"><img src="z/sc.png">加入收藏</div>                  
                   <div class="col-md-1"><a href="${pageContext.request.contextPath}/userConter.action">${user.userEmail}</a></div>
                   <div class="col-md-1"><img src="z/we.png"><a href="${pageContext.request.contextPath}/outUserlogin.action">退出</a></div>
               		<div class="col-md-1"></div>
                </div>
              
                
            </div>
            <div class="containner">
            	<div class="row">
              
                    <div class="col-md-1"></div>
                    <div class="col-md-1">公开课/${voQuery.subject.subjectName }</div>
                </div>
              </div>
              
              
 <div class="box3">
    <div class="box4">
    <video  controls="controls"src="${voQuery.video.videoUrl}" style="width:500px;height:300px;"></video>
    </div>                    
  <div class="box5">
        <h3>${voQuery.video.videoTitle}</h3>
   <div class="box6"><img src="${voQuery.speaker.speakerHeadUrl}"style="width:200px;height:100px;">
    </div>
    <div class="box7">
    <h6>讲师：${voQuery.speaker.speakerName}</h6>
      <span>${voQuery.speaker.speakerDesc}</span>
    </div>                    	
           
	<div class="box8"><span>本节内容:</span>${voQuery.video.videoDesc}</div>
  </div> 
 </div>	
                
                
                <div class="box9">
                        <h3>课程介绍</h3>
                    <div>    ${voQuery.course.courseDesc}</div>
                </div>
               
               
               <!-- 目录 -->
          <div class="box10"><h3>目录</h3></div>
          
         <div class="box11">
          	<c:forEach items="${voQuery.videos}" var="v">
          	<div class="box12">
          		<a href="${pageContext.request.contextPath }/userwatchTitle.action?videoTitle=${v.videoTitle}">${v.videoTitle}</a><br><br>
          		${v.videoDesc}
          	
          	</div>
          	<div class="box13">
              	讲师：${voQuery.speaker.speakerName}
          		<div class="box14">
          			${v.videoPlayNum}&ensp;&ensp;&ensp;&ensp;${v.videoTime}
              </div>
              </div>
          	</c:forEach>
          	</div>
         <br>
                        
                
                   
      
           
        <!-- 底部样式 -->
    	
            <div class="tom">
                    <div class="bottom1"><img src="z/footer_logo.png" style="widows: 100px;height:40px;"></div> 
                    <div class="bottom2">
                        <h6>各校区地址</h6>
                        <span>总部地址</span><br>
                        <span>中国-郑州经济技术开发区河南省通信产业园六层</span><br>
                        <span>郑州校区一</span><br>
                        <span>中国-郑州经济技术开发区第一大街与京北一路</span><br>
                        <span>郑州校区二</span><br>
                        <span>中国-郑州经济技术开发区第四大街京开人才市场七楼</span><br>
                        <span>郑州校区三</span><br>
                        <span>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层</span><br>
                        <span>西安分校</span><br>
                        <span>中国-西安莲湖区联系人：&nbsp;梁老师&nbsp;13201570801</span><br>
                    </div>

                    <div class="bottom3">
                        <h6>联系我们</h6>
                        <span>中国-郑州经济技术开发区京北三路河南省通信产业园六层</span><br>
                        <span>e-mail:zy@zhiyou100.com</span><br>
                        <span>电话：4006-371-555&nbsp;0371-88888598</span><br>

                    </div>
                    <div class="bottom4"><img src="z/微博公众号.png" style="width: 100px;height:100px;"></div>
                    <div class="bottom5"><img src="z/微信公众号.png" style="width: 100px;height:100px;"></div>
                   
                </div>
            
</body>
</html>