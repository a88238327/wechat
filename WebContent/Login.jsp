<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" >
 
 function userlogin1(){
	 var $phone=$("#phone").val();
	 var $password=$("#password").val();
	 document.getElementById("TipMessage").innerText = "";
		document.getElementById("passtip").innerText = "";
	 $.post(
		"userLogin",
		{
		phone:$phone,
		password:$password
		},
		function(result){
			
			if(result=="no_number")
				
				{
				document.getElementById("TipMessage").innerText = "请输入手机号";
				document.all['TipMessage'].style.color="red";
				}
			else if(result=="no_passwrod")
			{
			document.getElementById("passtip").innerText = "请输入密码";
			document.all['passtip'].style.color="green";
			}
			else if(result=="true")
				{
				location.href='me.jsp';
				}
			else{
				document.getElementById("TipMessage").innerText = "账号或密码错误";
				document.all['TipMessage'].style.color="red";
			}
		}
	 );	
 }
 </script>
<title>登录</title>
</head>
<body>
<center>
<h1>用户登录</h1>
    <hr> 
		<table>
		<tr>
			<td>手机号：</td>
			<td><input type="text" id="phone"><span id="TipMessage"></span></td>
		</tr>
		<tr>
			<td>密  码：</td>
			<td><input type="password" id="password"><span id="passtip"></span></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="登陆" onclick="userlogin1()">
			</td>
		</tr>
	</table>
   </center>
</body>
</html>