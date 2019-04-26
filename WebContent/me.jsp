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
<title><%=username%></title>

</head>
<body>
<div class="cell-box">
	<a href=<%=qr_url %>>
		<div class="cell-icon">
                <span>我的推广二维码</span>
       </div>
    </a>
</div>
<div class="cell-box">
	<a href="my_info.jsp">
		<div class="cell-icon">
                <span><%=username %>(<%=phone_number %>)</span>
       </div>
    </a>
</div>
<div class="cell-box">
	<a href="ChangePW.jsp">
		<div class="cell-icon">
                <span>修改密码</span>
       </div>
    </a>
</div>
<div class="cell-box">
	<a href="addmanager.jsp">
		<div class="cell-icon">
                <span>添加经理</span>
       </div>
    </a>
</div>
</body>
</html>