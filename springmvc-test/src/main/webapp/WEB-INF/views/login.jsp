<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录页面</title>
	<link style="" href="${ pageContext.request.contextPath }/css/login.css">
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/login.js"></script>
</head>
<body>
	<h3>登录页面</h3>
	<form action="${ pageContext.request.contextPath }/login" method="post">
		<span style="color:red;">
			${ errorMsg }
		</span>
		<br>
		用户名: <input name="username" type="text">
		<br>
		密码: <input type="password" name="password">
		<br>
		<input type="submit" value="登录">
	</form>
	
	<img alt="图片" src="${ pageContext.request.contextPath }/img/1.jpg">
</body>
</html>