<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!-- 날짜수정용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="/eatclipse/commons/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
		document.form1.action="/eatclipse/commons/delete.do";
		document.form1.submit();
		}
	});
});
</script>
</head>
<body>
 <%@ include file="../include/menu_rider.jsp" %> 
<h2>상세 회원정보</h2>
<form name="form1" method="post">
	<table border="1" width="700px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${sessionScope.userid}" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" value="${sessionScope.passwd}"></td>
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
			<td>잔액</td>
			<td><input type="text" name="money" value="${sessionScope.money}" readonly></td>
		</tr>
		<tr>
			<td>지역</td>
			<td><input type="text" name="location" value="${sessionScope.location}"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td>
				<fmt:formatDate value="${sessionScope.join_date}" pattern="yyyy-MM-dd HH:mm:s"/>
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