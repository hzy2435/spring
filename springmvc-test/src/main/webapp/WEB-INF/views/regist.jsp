<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
	</head>
	<body>
	
		<h3>用户注册</h3>
		<form action="${ pageContext.request.contextPath }/user/regist">
			用户名：<input type="text" name="name"><br>
			密码：<input type="password" name="password"><br>
			邮箱：<input type="text" name="email"><br>
			手机号：<input type="text" name="phone"><br>
			年龄：<input type="text" name="age"><br>
			地址：<input type="text" name="address"><br>
			
			<input type="submit" value="注册"/>
		</form>
	
	</body>
</html>