<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EATCLIPSE | 관리자</title>
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/home_cust.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<script>
   $(function() {
      $("#btnBack").click(function() {
         document.form1.action="/eatclipse/admin/main.do";
      });
   });
</script>
</head>
<body>
   <%@ include file="../include/menu.jsp"%>\
   <div style="text-align: right;">
      <button type="button" id="btnBack">back</button>
   </div>
   <h2 style="color:gray">전체사용자 목록</h2>
   <div class="center">
   <table>
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
               <c:if test="${row.type==-1}">관리자</c:if></td>
            <td>
               <c:if test="${row.type!=-1}">
                     <!-- 관리자가 아닐경우 -->
                  <a href="/eatclipse/admin/delete/${row.no}">삭제</a>
               </c:if>
            </td>
         </tr>
      </c:forEach>
   </table>
   </div>
</body>
</html>