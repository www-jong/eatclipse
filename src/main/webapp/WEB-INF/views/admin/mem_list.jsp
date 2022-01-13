<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <%@ include file="../admin/admin_test.jsp" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    header{
      text-align: center;
      margin:10px;
      border: 1px solid black;
    }
    #container{
      overflow:auto;
      margin:10px 0px;
    }
    #nav{
      margin-right: 3%;
      width: 15%;
      float: left;
      height: 350px;
    }
    #content{
      position: relative;
      border: 1px solid black;
      float: right;
      width:1500px;
      height: 1000px;
    }
    footer{
      border: 1px solid black;
      text-align: center;
      clear: left;
    }
    #nav ul li{
      height: 60px;
      list-style-type: none;
    }
    .text-box{
      position: absolute;
      top: 50%;
      left: 50%;
    }
  </style>
</head>
<body>
  <header><%@ include file="../include/menu.jsp" %></header>
  <div id="container">
    <div id="nav">
      <ul>
      </ul>
    </div>

<div id="content">
<h2> <c:if test="${t==-1}">전체</c:if>
      <c:if test="${t==0}">고객</c:if>
      <c:if test="${t==1}">라이더</c:if>
      <c:if test="${t==2}">가게</c:if>목록</h2>
 <a href="/eatclipse/admin/main.do">[메인화면]</a>
<table border="1" width="700px">
   <tr>
      <th>no</th>
      <th>이름</th>
      <th>아이디</th>
      <th>비밀번호</th>
      <th>이메일</th>
  	  <th>돈</th>
  	  <th>주소</th>
  	  <th>가입날짜</th>
  	  <th>유형</th>
  	  <th>관리</th>	
   </tr>
   <c:forEach var="row" items="${list}">
   <tr>
      <td>${row.no}</td>
      <td>${row.name}</td>
      <td>${row.userid}</td>
      <td>${row.passwd}</td>
      <td>${row.email}</td>
      <td>${row.money}</td>
      <td>${row.location}</td>
      <td>${row.join_date}</td>
      <td>
      <c:if test="${row.type==0}">고객</c:if>
      <c:if test="${row.type==1}">라이더</c:if>
      <c:if test="${row.type>=2&&row.type<=8}">가게</c:if>
      <c:if test="${row.type==-1}">관리자</c:if>
      </td>
      <td>
      <c:if test="${row.type!=-1}"><!-- 관리자가 아닐경우 -->
      <a href="/eatclipse/admin/delete/${row.no}/${type=t}">삭제</a>
      </c:if>
  	  </td>
   </tr>
</c:forEach>   
</table>
</div>
</div>
  <footer><p>Footer Layout</p></footer>
</body>
</html>