<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>관리자 메인페이지</h2>
<a href="/eatclipse/admin/list/-1">사용자관리</a>
<a href="/eatclipse/admin/list/0">고객관리</a>
<a href="/eatclipse/admin/list/1">라이더관리</a>
<a href="/eatclipse/admin/list/2">가게관리</a>
<a href="/eatclipse/admin/loglist.do">로그보기 </a>
<a href="/eatclipse/admin/productlist.do">모든메뉴보기 </a>
</body>
</html>