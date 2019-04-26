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
<title>Insert title here</title>
</head>
<body>
<p><span>姓   名:<%=username %></span></p>
<p><span>手机号:<%=phone_number %></span></p>
<p><span>上   级：<%=leader %></span></p>
</body>
</html>