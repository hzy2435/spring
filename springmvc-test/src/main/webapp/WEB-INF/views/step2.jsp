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
		<form action="${ pageContext.request.contextPath }/session/step3">
			邮箱：<input type="text" name="email"><br>
			手机号：<input type="text" name="phone"><br>
			<input type="submit" value="下一步"/>
		</form>
	
	</body>
</html>