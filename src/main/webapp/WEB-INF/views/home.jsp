<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Eatclipse</title>
<link rel="stylesheet" href="/eatclipse/resources/css/HomeCss.css">
<style type="text/css">
body{
	background-image: url("./images/platter.jpg");
}
</style>

</head>
<body>
	<header><h1><a class="title" href="/eatclipse/home">{EatClipse}</a></h1></header>
	<div class="text_align_center">
		<a class="main" href="/eatclipse/commons/login.do">로그인</a> 
		<a class="main" href="/eatclipse/commons/join.do">회원가입</a>
	</div>
	
</body>
</html>
