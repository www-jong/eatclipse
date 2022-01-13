<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	var price=${map.cart_total_price};
	var money=${sessionScope.money};
	
   $("#btnList").click(function(){
      location.href="/eatclipse/customer/main.do";
   });
   $("#btnDelete").click(function(){
      if(confirm("장바구니를 비우시겠습니까?")){
         location.href="/eatclipse/cart/deleteAll.do";
      }
   });
   $("#btnOrder").click(function(){
	      if(confirm("주문하시겠습니까?")){
	         location.href="/eatclipse/cart/order.do";
	      }
	   });
   
});
</script>


</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>
<div style="text-align: right;">
<button type="button" id="btnList">BACK</button>
</div>

<h2>장바구니 페이지</h2>
<br>

<div class="center">
<c:if test="${message == 'error' }">
					<div style="color:red">
					돈이 모자랍니다! </div>
					 </c:if>
<c:choose>
   <c:when test="${map.count == 0 }">
      장바구니가 비었습니다.
   </c:when>
   <c:otherwise>
      <form id="form1" name="form1" method="post" action="/eatclipse/cart/update.do">
      <table border="1" width="800px">
      <c:if test="${message == 'error' }">
					<div style="color:red">
					돈이 모자랍니다! </div>
					 </c:if>
         <tr>
            <th>상품명</th>
            <th>단가</th>
            <th>수량</th>
            <th>총금액</th>
            <th>&nbsp;</th>
         </tr>
         <c:forEach var="row" items="${list}">
         <tr>
            <td>${row.product_name}</td>
            <td>대충 단가</td>  <%-- ${row.price} --%>  
            <td>
              ${row.amount}
               <input type="hidden" name="product_no" value="${row.product_no}">
            </td>
            <td>${row.total_price}</td>
            <td><a href="/eatclipse/cart/delete.do?product_no=${row.product_no}">삭제</a></td>
         </tr>
         </c:forEach>
         <tr>
            <td colspan="5" align="center">
               최종 결제 금액: <fmt:formatNumber value="${map.cart_total_price}" pattern="#,###,###" /><br>
               배달비는 결제금액에 포함되어 있습니다.
            </td>
         </tr>
      </table>
      <button id="btnUpdate">수정</button>
      <button type="button" id="btnDelete">장바구니 비우기</button>
      <button type="button" id="btnOrder">주문하기</button>
      </form>
   </c:otherwise>
</c:choose>
	

</div>
</body>
</html>