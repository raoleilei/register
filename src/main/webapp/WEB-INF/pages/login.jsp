<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					 + request.getContextPath() + "/" ;
	String login_url = base + "loginForm.action" ;
%>
<html>
	<head>
		<base href="<%=base %>">
		<title>login</title>
		<meta charset="utf-8">
	</head>
	<body>
		${error}
		<form action="<%=login_url %>" method="post">
			用户名：<input type="text" name="id"><br>
			密&nbsp;码：<input type="password" name="password"><br>
			验证码：<input type="text" name="code" id="code"><img src="image.jsp"><br>
			<input type="checkbox" name="rememberme" value="true">下次免登陆<br>
			<input type="submit" value="登录">			
		</form>
	</body>
</html>