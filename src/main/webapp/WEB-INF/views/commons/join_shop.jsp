<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val();
		var passwd=$("#passwd").val();
		var name=$("#name").val();
		var location=$("#location").val();
		if(userid==""){
			alert("전부 입력해주세요");
			$("#userid").focus();
			return;
			}
		if(passwd==""){
			alert("전부 입력해주세요");
			$("#passwd").focus();
			return;
			}
		if(name==""){
			alert("전부 입력해주세요");
			$("#name").focus();
			return;
			}
		if(location==""){
			alert("전부 입력해주세요");
			$("#location").focus();
			return;
			}

		
		document.form1.action="/eatclipse/commons/join_check.do"; /* 확인하는페이지로 */
		document.form1.submit();
		});
	});
</script>
</head>
<body>
	<h2>가게회원가입</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input id="userid" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="passwd" name="passwd"></td>
			</tr>
			<tr>
				<td>상호</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
				<tr>
				<td>지역</td>
				<td><input type="text" id="location" name="location"></td>
			</tr>
			<tr>
			<td>
				<select name="type">
   				 <option value="">유형선택</option>
  					   <option value="2">한식</option>
  					   <option value="3">양식</option>
  					   <option value="4">분식</option>
  					   <option value="5">중식</option>
  					   <option value="6">일식</option>
  					   <option value="7">디저트</option>
  					   <option value="8">패스트푸드</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">회원가입</button>
					<c:if test="${message == 'error' }">
					<div style="color:red">
					아이디가 중복됩니다.. </div>
					</c:if>
					<c:if test="${message == 'nameerror' }">
					<div style="color:red">
					상호명이 이미 존재합니다! </div>
					</c:if>
					<c:if test="${message == 'success' }">
					<script>
					alert('회원가입 성공!');
					</script>
					</c:if>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>