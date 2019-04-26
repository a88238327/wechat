<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<%
String username=(String)session.getAttribute("username");
String phone_number=(String)session.getAttribute("phone_number");
String lv=(String)session.getAttribute("lv");
String qr_url=(String)session.getAttribute("qr_url");
String leader=(String)session.getAttribute("leader");
String Enable=(String)session.getAttribute("Enable");
if(Enable=="0")
{
	%>alert("用户已被禁用");<%
	response.sendRedirect("Login.jsp");
}
if(phone_number==null)
{
	response.sendRedirect("Login.jsp");
}

%>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" >
 function changepassword(){
	 var $password=$("#password").val();
	 var $passwordtwo=$("#passwordtwo").val();
	 var $phone_number=<%=phone_number%>;
	 document.getElementById("span").innerText = "";
	 $.post(
		"changepasswordServlet",
		{
		password:$password,
		passwordtwo:$passwordtwo,
		phone_number:$phone_number
		},
		function(result){
			
			if(result=="true")
			{
				alert("修改成功");
				location.href='me.jsp';
			}
			else if(result=="not_enough")
			{
				document.getElementById("span").innerText = "密码不足6位数";
				document.all['TipMessage'].style.color="red";
			}
			else
			{
				document.getElementById("span").innerText = "原密码不正确";
				document.all['TipMessage'].style.color="red";
			}
		}
	 );	
 }
 </script>
<title><%=username%></title>
</head>
<body>
<center>
<h1>修改密码</h1>
    <hr> 
		<table>
		<tr>
			<td>原 密 码：</td>
			<td><input type="password" id="password"><span id="span"></span></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" id="passwordtwo"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="提交" onclick="changepassword()">
			</td>
		</tr>
	</table>
</center>
</body>
</html>