<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
   import="com.example.eatclipse.controller.member.SessionUserCounter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EATCLIPSE | 관리자</title>
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/home_cust.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
</head>
<body>
   <%@ include file="../include/menu.jsp"%>
   <h2 style="color:gray">사용자 관리</h2>
   <div style="text-align:center; padding: 40px;">
      <a class="main" href="/eatclipse/admin/list/-1">전체사용자</a>
      <a class="main" href="/eatclipse/admin/list/0">고객</a>
      <a class="main" href="/eatclipse/admin/list/1">라이더</a>
      <a class="main" href="/eatclipse/admin/list/2">가게</a>
   </div>
   <div style="text-align:center; padding: 40px;">
      <a class="main" href="/eatclipse/admin/loglist.do">전체로그 보기</a>
      <a class="main" href="/eatclipse/admin/productlist.do">모든식당의 메뉴보기</a>
   </div>
   <div style="text-align:center; padding: 40px;">
      <a class="main" href="#">현재 접속자 수 : <%=SessionUserCounter.getCount()%></a>
   </div>
</body>
</html>