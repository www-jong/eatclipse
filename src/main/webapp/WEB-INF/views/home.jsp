<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Eatclipse</title>
<link rel="stylesheet" href="/eatclipse/resources/css/home.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
</head>
<body>
   <header>
      <h1>
         <a href="/eatclipse" class="eatclipse">
            <span class="title_color_white">{</span>
            <span class="title_color_yellow">Eat</span>
            <span class="title_color_blue">Clipse</span>
            <span class="title_color_white">};</span>
         </a>
      </h1>
   </header>
   <div>
      <a class="main" href="/eatclipse/commons/login.do">로그인</a> 
      <a class="main" href="/eatclipse/commons/join.do">회원가입</a>
   </div>
</body>
</html>