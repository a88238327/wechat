<%@page contentType="text/html;charset=UTF-8"%>
<meta name="viewport"  content="width=device-width,
minimum-scale=1.0, maximum-scale=2.0; charset=UTF-8">

<html>
<head>
	<title>createcustomer</title>
</head>
<body>
<center>
<h4>createcustomer</h4>
<hr>
	<form action="createcustomerservlet" method="post">
	<table>
		<tr>
			<td colspan="2">createcustomer</td>
		</tr>
		<tr>
			<td>cardid：</td>
			<td><input type="text" name="cardid"></td>
		</tr>
		<tr>
			<td>code：</td>
			<td><input type="text" name="code"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="创建">
			<input type="reset" value="重置">
			
			</td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>
