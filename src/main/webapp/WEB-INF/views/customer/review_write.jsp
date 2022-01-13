<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰쓰기</title>
<script>
function review_upload(){
	
	var review = document.form1.review.value;
		   if(review==""){
		      alert("리뷰를 작성하세요.");
		      document.form1.review.focus();
		      return;
		   }
		   var msg = "리뷰를 올릴까요?";
			var flag = confirm(msg);
			if(flag==true){
			document.form1.action="/eatclipse/customer/review_set.do";
		   document.form1.submit();
		  
		 /*   window.close();
		   self.close(); */
			}
			
	}
 window.onload=function()
{
	var check = document.form1.check.value;
	if(check!=""){
  window.open('','_self').close();
	}
} 
</script>
</head>
<body>
<h2>리뷰작성</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
		<tr>
		<td><input type="hidden"name="no" id="no" value="${no}">
		<input type="hidden"name="check" id="check" value="${check}">
		<textarea rows="5" cols="60" id="review" name="review" value="${review}"></textarea></td>
		<td><button onclick="review_upload()">보내기</button></td>
		</tr>
		</table>
		</form>
</body>
</html>