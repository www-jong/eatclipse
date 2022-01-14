<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<title>EATCLIPSE</title>
</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>

<h3>${shop_name}</h3>

<table border="1" width="700px">
			
				<c:if test="${message != 'error'&&message!=null }">
					<div style="color:red">
					${message }을(를) 장바구니에 담았습니다. </div>
					 </c:if>
					 <c:if test="${message == 'error' }">
					<div style="color:red">
					다른가게의 물건을 담을 수 없습니다. </div>
					 </c:if>
   <tr>
      <th>메뉴</th>
      <th>가격</th>
      <th>사진</th>
      <th>수량</th>

   </tr>
   
    	<c:forEach var="row" items="${productList}">
			<tr>
                <td>${row.product_name}</td>
				<td>${row.price}</td>
				 <td><img src="/eatclipse/images/${row.image}" width="100px" height="100px"></td>
				<td>
				<c:if test="${row.type == 0}">
					<form name="form1" method="post" action="/eatclipse/cart/cartinsert.do">   
					<input type="hidden"name="product_no" value="${row.no}">
					<input type="hidden"name="shop_name" value="${row.shop_name}">
					<input type="hidden"  name="product_name" value="${row.product_name}">
					<input type="hidden" name="total_price" value="${row.price}"><!-- logdto에는 price가 없으므로 잠시 여기담음 -->
				    <select name="amount">
				 
                        <c:forEach begin="1" end="10" var="i">
                           <option value="${i}">${i}</option>
                        </c:forEach>
                     </select>&nbsp;개
                     <input type="submit" value="장바구니에 담기">
					</form>
					  </c:if>
					  <c:if test="${row.type == 1}">
					  품절입니다.
					    </c:if>
				</td>

				
			</tr>
		</c:forEach>



</table>



</body>
</html>