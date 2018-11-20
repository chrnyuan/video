<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>修改主讲人</title>
</head>
<style>
label{
	color:#8066ff;
}
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
   }
   .box5{
       width: 500px;
       height: 30px;
       border-radius: 5px;
   }
   </style>
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
                      
                        <div class="col-xs-2"><h3>修改主讲人</h3></div>
   
                    </div>

     </div>  
     </div>
     
                <div class="box">
                  <form  action="${pageContext.request.contextPath }/speaker.Update.action" method="post">
       				
       				<input type="hidden" name="speakerId" value="${speaker.speakerId}">
       				 &emsp;&emsp; 姓名&emsp;<input type="text" name="speakerName" class="box5" 
                   value="${speaker.speakerName}">
                <br><br>
                   
                   &emsp;&emsp; 职位&emsp;<input type="text" name="speakerJob" class="box5" 
                   value="${speaker.speakerJob}">
                <br><br>
                	头像地址   &emsp;<input type="text" name="speakerHeadUrl" class="box5" 
                    value="${speaker.speakerHeadUrl}">
                <br><br>
                &emsp;&emsp; 简介&emsp;<input type="text" name="speakerDesc" 
                class="box5" value="${speaker.speakerDesc}">
                 <br><br>    
                 <input type="submit" value="保存" class="btn btn-default">
                  </form>
                </div>
</body>
<script type="text/javascript">
	$().ready(function(){
		$("form").validate({
		    rules:{
		    	speakerName:{
		    		required:true,
		    		minlength:2,
		    		
		    	},
		    	speakerJob:{
		            required:true,
		            maxlength:20
		        },
		        speakerHeadUrl:{
		        	required:true,
		        	url:true
		        },
		        speakerDesc:{
		        	required:true,
		        	maxlength:150
		        },
		    },
		    messages:{
		    	speakerName:{
		    		required:"请输入主讲人姓名",
		    		minlength:"用户名最少2位字符",
			      
		    	},
		    	
		    	speakerJob:{       
		            required:"请输入主讲人职位",
		            maxlength:"简介内容不能超过20个字符"
		            
		        },
		        speakerHeadUrl:{
		        	required:"请输入地址",
					url:"网址格式输入错误,请输入http://开头格式"
		        },
		        speakerDesc:{
		        	required:"请输入简介",
		        	maxlength:"简介内容不能超过150个字符"
		        }
		        
		    }
		})
	})

</script>
</html>