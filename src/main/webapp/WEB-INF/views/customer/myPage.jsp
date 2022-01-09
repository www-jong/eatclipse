<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="/eatclipse/commons/update.do";  // 경로가 맞나???
		document.form1.submit();
	});
	
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="/eatclipse/commons/delete.do";  // 경로가 맞나???
			document.form1.submit();
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

<form name="form1" method="post">
	<table border="1" width="500px" align="right">
	<caption>회원 정보</caption>
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
				<input type="button" value="정보수정" id="btnUpdate">
				<input type="button" value="계정삭제" id="btnDelete">
				
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>

<form name="form2" method="post">
	<table border="1" width="700px" align="left">
	<caption>주문 내역</caption>
		<tr>
			<th>번호</th>
			<th>주문일</th>
			<th>가게</th>
			<th>메뉴</th>
			<th>결제금액</th>
			<th>상태</th>
		</tr>

		<tr>
			<td>2_모양만</td>
			<td>2022-01-08_모양만</td>
			<td>한식당1_모양만</td>
			<td>김치찌개_모양만</td>
			<td>6,000_모양만</td>
			<td>배달 중_모양만</td>
		</tr>
		
		<tr>
			<td>1_모양만</td>
			<td>2022-01-07_모양만</td>
			<td>중식당1_모양만</td>
			<td>짬뽕_모양만</td>
			<td>5,000_모양만</td>
			<td>배달 완료_모양만</td>
		</tr>
	
	</table>
</form>


</body>
</html>











