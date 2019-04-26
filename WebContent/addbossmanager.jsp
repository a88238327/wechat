<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" >
 function AddManager(){
	 var $managername=$("#managername").val();
	 var $managerphone=$("#managerphone").val();
	 document.getElementById("span").innerText = "";
	 $.post(
		"addbossmanager",
		{
			managername:$managername,
			managerphone:$managerphone
		},
		function(result){
			
			if(result=="true")
			{
				alert("添加成功");
			}
			else if(result=="errorname")
			{
				document.getElementById("span").innerText = "姓名不能为空";
				document.all['TipMessage'].style.color="red";
			}
			else if(result=="errormanagerphone")
			{
				document.getElementById("span").innerText = "手机号错误";
				document.all['TipMessage'].style.color="red";
			}
			else{
				document.getElementById("span").innerText = "手机号已存在";
				document.all['TipMessage'].style.color="red";
			}
		}
	 );	
 }
 </script>
<title>添加大区级</title>
</head>
<body>
<center>
<h1>添加业务经理</h1>
    <hr> 
		<table>
		<tr>
			<td>姓      名：</td>
			<td><input type="text" id="managername"><span id="span"></span></td>
		</tr>
		<tr>
			<td>手 机  号：</td>
			<td><input type="text" id="managerphone"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="提交" onclick="AddManager()">
			</td>
		</tr>
	</table>
</center>
</body>
</html>