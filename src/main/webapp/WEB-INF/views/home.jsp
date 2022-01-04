<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<h1>
	Hello world!
</h1>
<P>  The time on the server is ${serverTime}. 테스트 </P>
			<a href="/eatclipse/commons/login.do">로그인</a>  |
			<a href="/eatclipse/commons/join.do">회원가입</a>
</body>
</html>
