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
		<form action="${ pageContext.request.contextPath }/session/regist">
			年龄：<input type="text" name="age"><br>
			地址：<input type="text" name="address"><br>
			<input type="submit" value="注册"/>
		</form>
	
	</body>
</html>