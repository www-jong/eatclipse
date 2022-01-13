<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐시 충전 페이지</title>
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="/eatclipse/resources/css/table_shop.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
	$("#btnCashCharge").click(function(){
		var cash=$("#cash").val();
		if(cash<="0"){
			alert("0원이하는 충전이 불가합니다.");
			$("#cash").focus();
			return;
		}
		document.form1.action="/eatclipse/customer/cashCharge_logic.do";
		document.form1.submit();
		});		
	$("#btnList").click(function(){
	      location.href="/eatclipse/customer/myPage.do?userid=${userid}";
	      /* location.href="/eatclipse/customer/myPage.do?userid="+${sessionScope.userid}; */
	   });
	});


</script>


</head>
<body>
<%@ include file="../include/menu_cust.jsp" %>
<div style="text-align: right;">
<button type="button" id="btnList">BACK</button>
</div>
<h2>캐시 충전 해보자!!!!</h2>
<br>
<div class="center">
<form name="form1" method="post">
	충전 금액 : <input type="text" id = "cash" name="cash">
	<button type="button" id="btnCashCharge">캐시 충전</button>
</form>
</div>
</body>
</html>