<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추천!</title>
<script>
function a(num){
			document.form2.action="/eatclipse/customer/worldcup.do?num="+num;
		   document.form2.submit();			
	}
function b(){
	document.form1.action="/eatclipse/customer/worldcup.do";
   document.form1.submit();			
}
function gogo(){
	document.form1.action="/eatclipse/customer/worldcup.do";
   document.form1.submit();			
}
function out(){
	window.close();			
}

</script>
</head>
<body>
<h2>음식월드컵!</h2>
	<form name="form1" method="post">
	<table border="1" width="700px" align="right">
	<c:if test="${count==0}">
	<p>오늘의 배달메뉴를 월드컵으로 정해보세요! </p>
	<div>
    <button onclick="gogo()" id="count" name="count" value="1">시작</button>
  </div> 
	</c:if>
	 <c:if test="${count==1}">
     <p>둘중 더 좋아하는거를 고르세요!</p>
  <div>
  <a style="cursor:pointer;" onclick="a(1)" ><img src="../images/${first_image}"  alt="${first_product_name}"/></a>
    <a style="cursor:pointer;" onclick="a(2)" ><img src="../images/${second_image}" alt="${second_product_name}"/></a>
  <input type="hidden" name="count" id="count" value="1">
  </div>
     </c:if>
      <c:if test="${count==2}">
     <p>당신의 음식은! </p>
  <div>
  <a style="cursor:pointer;"><img src="../images/${first_image}.png"  alt="${first_product_name}"/></a>
  </div>
  <div>
    <button onclick="out()" id="count" name="count" value="3">종료</button>
  </div> 
	 </c:if>
	</table>
	</form>
</body>
</html>