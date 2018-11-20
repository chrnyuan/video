<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>智游</title>
    <style>
  .container{
      width: 900;
      border: 1px;
      vertical-align: middle;
  }
  .text{
     
      width: 500px;
      height: 60px;
      position: absolute;
        left: 300px;
         top: 250px;
  }
  .method{
  	width:100%;
  	height:500px;
  	position: absolute;
    left: 0px;
  	background:silve;
  }
  #box{
      position: absolute;
      left: 200px;
      top: 350px;
  }
  #box2{
      position: absolute;
      left: 750px;
      top: 350px;
  }
  
  #box3{
      position: absolute;
      left: 200px;
      top: 540px;
  }
  #box4{
    position: absolute;
      left: 510px;
      top: 540px; 
  }
  #box5{
      position: absolute;
      left: 200px;
      top: 730px;
  }
  #box6{
      position: absolute;
      left: 770px;
      top: 730px;
  }
  #box7{
      position: absolute;
      left: 1060px;
      top: 350px;
  }
  #box8{
      width: 100px;
      height: 40px;
      border: 1px;
  }
  .zi{
    position:absolute;width:100px;height:100px;z-indent:2;left:30px;top:80%;color: white
  }
  .pic{
    position:absolute;width:800px;height:60px;z-indent:2;left:90%;top:70%;  
  }
    .tom{
      width: 100%;
      height: 250px;
      background-color:black;
      position: absolute;
      left: 0%;
      top: 1100px;
  }
  
.bottom2{
    width: 400px;
    height: 200px;
   
    position:absolute;
    left: 30%;
    top: 10%;
    font-size: 10px;
    color: silver;
}

.bottom3{
    width: 400px;
    height: 200px;
   
    position:absolute;
    left: 60%;
    top: 10%;
    font-size: 10px;
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
        <img src="z/banner-2.jpg" class="img-thumbnail" style="width:90%;height:200px;">
        
    </div>

    <div class="text"><h3><b>模块化课程，从入门到精通，大神并不遥远</b></h3></div>
 
   <div class="col-md-2"></div>
    <div id="box"><img src="z/html5.jpg">
    
        <div class="zi">
               Web前端教程
        </div>
        <div class="pic">
            <a href="${pageContext.request.contextPath }/A.user.action"><img src="z/arrow.png"></a> 
          </div>
           
    </div>
    
    <div id="box2"><img src="z/ui.jpg">
        <div class="zi">
               UI设计教程
        </div>
        <div style=" position:absolute;width:800px;height:60px;z-indent:2;left:80%;top:70%;  ">
            <img src="z/arrow.png">
        </div>
    </div>
    <div id="box3"><img src="z/bigdata.jpg">
        <div class="zi">
                大数据教程
         </div>
    </div>
    <div id="box4"><img src="z/python.jpg">
        <div class="zi">
                Python教程
         </div>
         <div class="pic">
                <img src="z/arrow.png">
            </div>
    </div>
    <div id="box5"><img src="z/php.jpg">
        <div class="zi">
                PHP教程
         </div>
         <div class="pic">
                <img src="z/arrow.png">
            </div>
    </div>
    <div id="box6"><img src="z/qidai.jpg">
        <div style="position:absolute;width:100px;height:100px;;left:40%;top:45%;color: white">
                更多课程,敬请期待...
         </div>
    </div>
    <div id="box7"><img src="z/java.jpg">
        <div style="position:absolute;width:100px;height:200px;z-indent:2;left:30px;top:90%;color: white">
                Java教程
         </div>
    </div>

<!--     <div id="box8">高级课程</div> -->
    
	
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