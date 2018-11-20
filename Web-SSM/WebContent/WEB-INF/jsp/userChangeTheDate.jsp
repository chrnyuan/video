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
<title>个人中心</title>
  <style>
label{
	color:#8066ff;
}
div.container div.row div {
    margin:5px 0px;
    text-align: center;
   
    font-size: 20px;
   
}
.con{
    width: 70%;
    height: 350px;
  
    border:solid 2px silver;
    position: relative;
    left: 15%;

}
#box{
    width: 100%;
    height: 40px;
    background-color:rgb(17, 7, 75);
    position: absolute;
    left: 0px;
    top: 55px;
}
.con1{
    width: 200px;
    height: 150px;
    font-size: 20px;
    border-right:solid 2px silver;
    border-left-color: silver;
   
   position: relative;
   top: 20px;
}
.con2{
    width: 100px;
    height: 30px;
    margin: auto; 
   
    position: relative;
    top: 50px;
}
.big{
    width: 700px;
    height: 300px;
    font-size: 20px;
    position: absolute;
    left: 250px;
    top: 70px;
  
} 
.bottom{
    width: 100%;
    height: 130px;
    font-size: 10px;
    color: silver;
    background-color:rgb(82, 74, 74);
    position: fixed;
    left:0px;
    top:635px;
}
.bottom1{
    width: 200px;
    height: 40px;
   
    position: absolute;
    left: 15%;
    top: 40px;
    
}
.bottom2{
    width: 150px;
    height: 30px;
    position: absolute;
    font-size: 14px;
    color: silver;
    left: 40%;
    top: 50px;
}
.bottom3{
    width: 150px;
    height: 30px;
    position: absolute;
    font-size: 10px;
    color: silver;
    left: 55%;
    top: 50px;
  
}
.bottom4{
    width: 100px;
    height: 120px;
    position: absolute;
    font-size: 10px;
    color: silver;
    left: 80%;
    top: 20px;
  
}
  </style>
</head>
<body>
	     <div id="box"></div>
    <div class="container">
        <div class="row">
            
            <div class="col-xs-2"><img src="z/logo.png" style="widows: 100px;height:40px;"></div>  
            <div class="col-xs-6"></div>
            <div class="col-xs-2">4006-371-555</div>
            <div class="col-xs-2">0371-88888598</div>
            
        </div>
           
        <div class="row">
            <div style="color:lightyellow">
                <div class="col-xs-2"><a href="${pageContext.request.contextPath}/welcmoe.jsp">首页</a></div>  
                <div class="col-xs-2">个人中心</div>
                <div class="col-xs-6"></div>
                <div class="col-xs-2"><img src="${user.userImgurl}" style="width: 20px;height:20px;"><a href="${pageContext.request.contextPath}/outUserlogin.action">退出</a></div>
            </div>
        <div class="row">
            <div class="col-xs-2"><h3><b>我的资料</b></h3></div>
        </div>
    </div>
    
    <div class="row">
      
        <div style="font: size 10px;color:silver;text-align: left;">
             <div class="col-xs-2"><a href="${pageContext.request.contextPath}/user.UpdateDate.action?userId=${user.userId}">更改资料</a> </div>
            <div class="col-xs-2"><a href="${pageContext.request.contextPath}/user.Updatehead.action?userId=${user.userId}">更改头像</a></div>
            <div class="col-xs-2"><a href="${pageContext.request.contextPath}/user.UpdatePassword.action?userId=${user.userId}">更改密码</a></div>
       
    </div>
    </div>

    
</div>

<div class="con">
    <div class="con1">
       <div class="con2"><img src="${user.userImgurl}" style="width:140px;height:100px;">欢迎回来！</div>
    </div>
    <div class="big">
    <form action="user.updateDate.action" method="post">
    	<input type="hidden" name="userId" value="${user.userId}">
      	<p>昵&emsp;&nbsp; 称：<input type="text" value="${user.userNickname}" name="userNickname"></p>
       	<p>性&emsp;&nbsp; 别：<input type="radio" name="userSex" value="男" checked="checked">男 &emsp;&emsp;&emsp;   <input type="radio" name="userSex" value="女">女  </p>
        <p>生&emsp;&nbsp; 日：<input type="text" value="${user.userBithday}" name="userBithday"></p>
       	<p>邮&emsp;&nbsp; 箱：<input name="userEmail" type="text" value="${user.userEmail}"></p>
        <p>所&nbsp;在&nbsp;地：
        <select name="userAddress">
        	<option>河南</option>
        	<option>江西</option>
        	
        </select>
         <select>
        	<option>郑州</option>
        	<option>南昌</option>
        	
        </select>
        </p>
		<input type="submit" value="保存"> &emsp;&emsp;&emsp;&emsp;
		<input type="reset" value="重置">
	</form>
    </div>
</div>


        <div class="bottom">
            <div class="bottom1"><img src="z/footer_logo.png" style="widows: 100px;height:40px;"></div>  
           
            <div class="bottom2">版权所有：智游3G教育</div>
            <div class="bottom3">@www.zhiyou100.com</div>
            <div class="bottom4"><img src="z/微博公众号.png" style="width: 100px;height:100px;"></div>
        </div>
      
</body>
<script type="text/javascript">
	$().ready(function(){
		$("form").validate({
		    rules:{
		    	userNickname:{
		    		required:true,
		    		minlength:2,
		    		
		    	},
		    	userBithday:{
		            required:true,
		            dateISO:true
		        },
		       
		    },
		    messages:{
		    	userNickname:{
		    		required:"请输入昵称",
		    		minlength:"昵称2位字符",
		
		    	},
		    	
		    	userBithday:{       
		            required:"请输入主讲人职位",
		            dateISO:"请输入正确的时间格式：(YYYY-MM-DD)"
		            
		        },
		       
		        
		    }
		})
	})
</script>
</html>