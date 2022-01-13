<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<title>마이페이지</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	$("#btnOn").click(function(){
		document.form1.action="/eatclipse/customer/myPageon.do";  // 경로가 맞나???
		document.form1.submit();
	});
	$("#btnUpdate").click(function(){
		if(confirm("수정하시겠습니까?")){
			document.form3.action="/eatclipse/customer/update.do";  // 경로가 맞나???
			document.form3.submit();
		}
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form3.action="/eatclipse/customer/delete.do";  // 경로가 맞나???
			document.form3.submit();
		}
	});
	$("#btnCashCharge").click(function(){
		document.form1.action="/eatclipse/customer/cashCharge.do";  // 경로가 맞나???
		document.form1.submit();
	});
});
</script>
</head>

<body>
<%@ include file="../include/menu_cust.jsp" %>

<br>
	<h2>회원 정보</h2>
	<br>
<c:choose>
 <c:when test="${a==1}">
  <div class="center">
<form name="form1" method="post">
	<table border="1" width="500px" align="right">
		<tr>
			<td>아이디</td>
			<td>${dto.userid}</td>
		</tr>

		<tr>
			<td>이름</td>
			<td>${dto.name}</td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td>${dto.email}</td>
		</tr>
		
		<tr>
			<td>가입일자</td>
			<td>
				<fmt:formatDate value="${dto.join_date}" pattern="yyyy-MM-dd HH:mm:s"/>
			</td>
		</tr>
		
		<tr>
			<td>주소</td>
			<td>${dto.location}</td>
		</tr>
		
		<tr>
			<td>잔액</td>
			<td>${dto.money}원</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="캐시 충전" id="btnCashCharge">  <!-- 돈 충전 -->
				<input type="button" value="정보수정" id="btnOn">
				
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>
</div>
 </c:when>
 
 <c:otherwise>
 <div class="center">
 <form name="form3" method="post">
	<table border="1" width="500px" align="right">
		<tr>
			<td>아이디</td>
			<td>${dto.userid}</td>
			<input type="hidden" name="userid" value="${sessionScope.userid}">
		</tr>

		<tr>
			<td>이름</td>
			<td><input type="text" name="name"value="${sessionScope.name}" ></td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${sessionScope.email}"></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" value="${sessionScope.passwd}"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td>
				<fmt:formatDate value="${dto.join_date}" pattern="yyyy-MM-dd HH:mm:s"/>
			</td>
		</tr>
		
		<tr>
			<td>주소</td>
			<td><input type="text" name="location" value="${sessionScope.location}"></td>
		</tr>
		
		<tr>
			<td>잔액</td>
			<td>${dto.money}원</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="캐시 충전" id="btnCashCharge">  <!-- 돈 충전 -->
				<input type="button" value="수정하기" id="btnUpdate">
				<input type="button" value="계정삭제" id="btnDelete">
				
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>
</div>
</c:otherwise>
 </c:choose>
 
  <h2>주문 내역</h2>
 <div class="center">
<form name="form2" method="post">
	<table border="1" width="700px" align="left">
		<tr>
			<th>주문일</th>
			<th>가게</th>
			<th>메뉴</th>
			<th>결제금액</th>
			<th>상태</th>
			<th>리뷰</th>
		</tr>
 <c:forEach var="row" items="${list}"><!-- status가 2인 log들만 올라옴 -->
   <tr>
      <td>${row.start_date}</td>
      <td>${row.shop_name}</td>
       <td><input type="button"  onclick="order_detail(no=${row.no})" value="상세보기"></td>
      <td>${row.totalmoney}</td>
      <td>  <c:if test="${row.status==0}">주문</c:if>
      <c:if test="${row.status==1}">주문접수</c:if>
      <c:if test="${row.status==2}">조리완료</c:if>
      <c:if test="${row.status==3}">배달중</c:if>
      <c:if test="${row.status==4}">배달완료</td>
      <td><c:if test="${row.review==null}"><input type="button"  onclick="review_write(no=${row.no})" value="리뷰쓰기"></c:if>
      	  <c:if test="${row.review!=null}"><input type="button"  onclick="review_view(no=${row.no})" value="상세보기"></c:if></td></c:if>
      </td>
   </tr>
    <script>
function order_detail(no){
	window.open("/eatclipse/customer/detail/"+no,"_blank","toolber=yes,menubar=yes,width=500,height=400").focus();
}
function review_write(no){
	window.open("/eatclipse/customer/review_write/"+no,"_blank","toolber=yes,menubar=yes,width=500,height=400").focus();
}
function review_view(no){
	window.open("/eatclipse/customer/review_view/"+no,"_blank","toolber=yes,menubar=yes,width=500,height=400").focus();
}
</script>
</c:forEach>  	
	</table>
</form>

</div>
</body>
</html>











