<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐시 충전 페이지</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
	$("#btnCashCharge").click(function(){
		
		document.form1.action="/eatclipse/customer/cashCharge_logic.do";
		document.form1.submit();
		});		
		
	});


</script>


</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>

<h3>캐시 충전 해보자!!!!</h3>

<form name="form1" method="post">
	충전 금액 <input type="text" id = "cash" name="cash">  // text가 맞냐?
	<button type="button" id="btnCashCharge">캐시 충전</button>
</form>

</body>
</html>