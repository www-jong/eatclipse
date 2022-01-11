<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
   $("#btnList").click(function(){
      location.href="/eatclipse/customer/shopInfo.do";
   });
   $("#btnDelete").click(function(){
      if(confirm("장바구니를 비우시겠습니까?")){
         location.href="/eatclipse/cart/deleteAll.do";
      }
   });
});
</script>


</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>

<h2>장바구니 페이지</h2>

<c:choose>
   <c:when test="${map.count == 0 }">
      장바구니가 비었습니다.
   </c:when>
   <c:otherwise>
      <form id="form1" name="form1" method="post" 
         action="/eatclipse/cart/update.do">
      <table border="1" width="800px">
         <tr>
            <th>상품명</th>
            <th>단가</th>
            <th>수량</th>
            <th>금액</th>
            <th>&nbsp;</th>
         </tr>
         <c:forEach var="row" items="${map.list}">
         <tr>
            <td>${row.product_name}</td>
            <td>가격은 프로덕트 테이블에서... 일단 pass</td>  <%-- ${row.price} --%>  
            <td>
               <input type="number" style="width:30px;" min="0" max="100" name="amount" value="${row.amount}">
               <input type="hidden" name="product_no" value="${row.product_no}">
            </td>
            <td>${row.total_price}</td>
            <td><a href="/eatclipse/cart/delete.do?product_no=${row.product_no}">삭제</a></td>
         </tr>
         </c:forEach>
         <tr>
            <td colspan="5" align="center">
               장바구니 금액 합계 : 
               <fmt:formatNumber value="${map.sumMoney}" pattern="#,###,###" /><br>
               배달료: ${map.fee}<br>
               최종 결제 금액: <fmt:formatNumber value="${map.sum}" pattern="#,###,###" />
            </td>
         </tr>
      </table>
      <button id="btnUpdate">수정</button>
      <button type="button" id="btnDelete">장바구니 비우기</button>
      </form>
   </c:otherwise>
</c:choose>
<button type="button" id="btnList">식당 메뉴 돌아가기</button>


</body>
</html>