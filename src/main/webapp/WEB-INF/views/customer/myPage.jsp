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
		document.form1.action="/eatclipse/customer/update.do";  // 경로가 맞나???
		document.form1.submit();
	});
	
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="/eatclipse/customer/delete.do";  // 경로가 맞나???
			document.form1.submit();
		}
	});
});
</script>
</head>

<body>
<%@ include file="../include/menu_cust.jsp" %>

<h2>상세 회원정보</h2>
<form name="form1" method="post">
	<table border="1" width="700px">
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
			<td colspan="2" align="center">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>


</body>
</html>











