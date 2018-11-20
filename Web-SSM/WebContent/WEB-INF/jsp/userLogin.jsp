<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.js"></script>
<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="jquery.validate.min.js"></script>
<script type="text/javascript" src="messages_th.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<title>用户登录</title>
<style>
div.container div.row div {
	margin: 5px 0px;
	text-align: center;
	font-size: 20px;
}

.con {
	width: 70%;
	height: 350px;
	border: solid 2px silver;
	position: relative;
	left: 15%;
}

.tom {
	width: 100%;
	height: 250px;
	background-color: black;
	position: absolute;
	left: 0px;
	top: 550px;
}

.bottom1 {
	width: 200px;
	height: 40px;
	position: absolute;
	left: 15%;
	top: 30%;
}

.bottom2 {
	width: 400px;
	height: 200px;
	position: absolute;
	left: 30%;
	top: 10%;
	font-size: 5px;
	color: silver;
}

.bottom3 {
	width: 400px;
	height: 200px;
	position: absolute;
	left: 60%;
	top: 10%;
	font-size: 5px;
	color: silver;
}

.bottom4 {
	width: 100px;
	height: 100px;
	position: absolute;
	font-size: 5px;
	color: silver;
	left: 60%;
	top: 50%;
}

.bottom5 {
	width: 100px;
	height: 100px;
	position: absolute;
	font-size: 5px;
	color: silver;
	left: 70%;
	top: 50%;
}

#a {
	color: silver;
}

#box {
	font-size: 20px;
	font-family: 楷体； width : 400px;
	height: 500px;
	position: absolute;
	top: 25%;
	left: 50%;
	margin-left: -200px;
	margin- top: -200px;
}

.t {
	width: 300px;
	height: 30px;
}

.s {
	width: 360px;
	height: 30px;
}

label{
	color:#8066ff;
}
</style>


</head>
<body>

	<div id="box"></div>
	<div class="container">
		<div class="row">

			<div class="col-xs-2">
				<img src="z/logo.png" style="widows: 100px; height: 40px;">
			</div>
			<div class="col-xs-6"></div>
			<div class="col-xs-2">4006-371-555</div>
			<div class="col-xs-2">0371-88888598</div>

		</div>
	</div>


		<div id="box">


			<form action="userLogin.action" method="post">
				<h1 id="a">&emsp;&emsp;&emsp;用户登录</h1>
				账号：<input type="text" class="t" id="userId" name="userId"><br><i id="i"style="color:red;"></i>
				<br> 密码：<input type="password" name="userPassword" class="t"><br>
				<span style="color:red;">${error}</span>
				<br> <input type="submit" value="登录" class="s">
			</form>
			<br> <a
				href="${pageContext.request.contextPath }/userRegister.action"><button
					class="s">注册</button></a>

		</div>
		<div class="tom">
			<div class="bottom1">
				<img src="z/footer_logo.png" style="widows: 100px; height: 40px;">
			</div>
			<div class="bottom2">
				<h6>各校区地址</h6>
				<span>总部地址</span><br> <span>中国-郑州经济技术开发区河南省通信产业园六层</span><br>
				<span>郑州校区一</span><br> <span>中国-郑州经济技术开发区第一大街与京北一路</span><br>
				<span>郑州校区二</span><br> <span>中国-郑州经济技术开发区第四大街京开人才市场七楼</span><br>
				<span>郑州校区三</span><br> <span>中国-郑州经济技术开发区第八大街河南省留学生创业园九层、十层</span><br>
				<span>西安分校</span><br> <span>中国-西安莲湖区联系人：&nbsp;梁老师&nbsp;13201570801</span><br>
			</div>

			<div class="bottom3">
				<h6>联系我们</h6>
				<span>中国-郑州经济技术开发区京北三路河南省通信产业园六层</span><br> <span>e-mail:zy@zhiyou100.com</span><br>
				<span>电话：4006-371-555&nbsp;0371-88888598</span><br>

			</div>
			<div class="bottom4">
				<img src="z/微博公众号.png" style="width: 100px; height: 100px;">
			</div>
			<div class="bottom5">
				<img src="z/微信公众号.png" style="width: 100px; height: 100px;">
			</div>

		</div>
		<script type="text/javascript">
			$("#userId").blur(function() {
				
				$.ajax({
					url : "verifty.action",
					data : {
						id : $("#userId").val()
					},
					success : function(data) {
						
						if (data== "2") {
							$("#i").text("该账号不存在");
						} else {
							$("#i").text("");
						}
					}
				})
			})
		</script>
</body>
	<script type="text/javascript">
	$().ready(function(){
		$("form").validate({
			rules:{
				userId:{
					required:true,
					minlength:3
				},
				userPassword:{
					required:true,
					minlength:3
				}
			},
		message:{
			userId:{
				required:"请输入用户名",
				minlength:"用户名最少三位字符"
			},
			userPassword:{
				required:"请输入密码",
				minlength:"用户名最少3位字符"
			}
			
		}
			
		})
	})


</script>
</html>