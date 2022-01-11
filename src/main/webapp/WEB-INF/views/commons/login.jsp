<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/eatclipse/resources/css/join.css">
<link rel="stylesheet" href="/eatclipse/resources/css/main.css">
<link rel="stylesheet" href="/eatclipse/resources/css/fontawesome-all.min.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val();
		var passwd=$("#passwd").val();
		
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus();
			return;
			}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return;
			}
		
		document.form1.action="/eatclipse/commons/login_check.do";
		document.form1.submit();
		});
	});
</script>
</head>
<body>
	<header>
		<%@ include file="../include/menu.jsp" %>
	</header>
	
	
	<h2>로그인</h2>
	<br>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="passwd" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button>
					<c:if test="${message == 'error' }">
					<div style="color:red">
					아이디 또는 비밀번호가 일치하지 않습니다. </div>
					</c:if>
					 <c:if test="${message == 'update_success' }">
					<div style="color:red">
					업데이트에 성공하였습니다. 다시 로그인해주세요. </div>
					</c:if>
					<c:if test="${message == 'delete_success' }">
					<div style="color:red">
					계정삭제에 성공하였습니다. 회원가입을 해주세요. </div>
					 </c:if>
					 	<c:if test="${message == 'success' }">
					<div style="color:red">
					회원가입에 성공하였습니다. 로그인해주세요. </div>
					 </c:if>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>