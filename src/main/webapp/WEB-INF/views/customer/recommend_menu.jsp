<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추천!</title>
<script>
function gogo(){
			document.form1.action="/eatclipse/customer/recommend.do";
		   document.form1.submit();			
	}
function out(){
	window.close();			
}

</script>
</head>
<body>
<h2>당신의 취향을 알려주세요!</h2>
	<form name="form1" method="post">
	<table border="1" width="700px" align="right">
	<c:if test="${count==0}">
	<p>점심메뉴가 고민될때는 추천메뉴! </p>
	<div>
    <button onclick="gogo()" id="count" name="count" value="1">시작</button>
  </div> 
	</c:if>
	 <c:if test="${count==1}">
     <p>나는 이정도까진 먹을수 있다.</p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">이유식</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">진라면 순한맛</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">신라면</label>
    
    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice4">불닦볶음면</label>
    
    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice5">나는 매운거 모른다.</label>
  </div>
  <div>
    <button onclick="gogo" id="count" name="count" value="2">다음</button>
  </div> 
     </c:if>
      <c:if test="${count==2}">
     <p>나는 탕수육을 먹을때 </p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">부먹</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">찍먹</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">상관없다</label>
  </div>
  <div>
    <button onclick="gogo" id="count" name="count" value="3">다음</button>
  </div> 
     </c:if>
	    <c:if test="${count==3}">
     <p>나는 당연히 떡볶이는</p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">쌀떡</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">밀떡</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">상관없다</label>
  </div>
  <div>
    <button onclick="gogo" id="count" name="count" value="4">다음</button>
  </div> 
     </c:if>
         <c:if test="${count==4}">
     <p>나는 민트초코를</p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">극혐</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">주면 먹는다.</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">완전좋다.</label>
  </div>
  <div>
    <button onclick="gogo" id="count" name="count" value="5">다음</button>
  </div> 
     </c:if>
           <c:if test="${count==5}">
     <p>오늘은 국물이 별로 안땡긴다.</p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">아니다.</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">있으면 먹는다.</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">정확하다.</label>
  </div>
  <div>
    <button onclick="gogo" id="count" name="count" value="6">다음</button>
  </div> 
     </c:if>
              <c:if test="${count==6}">
     <p>맛있는 음식에는 당연히 이걸마셔야지~</p>
  <div>
    <input type="radio" id="contactChoice1"
     name="contact" value="email">
    <label for="contactChoice1">물</label>

    <input type="radio" id="contactChoice2"
     name="contact" value="phone">
    <label for="contactChoice2">탄산음료</label>

    <input type="radio" id="contactChoice3"
     name="contact" value="mail">
    <label for="contactChoice3">소주</label>
    
     <input type="radio" id="contactChoice4"
     name="contact" value="mail">
    <label for="contactChoice4">맥주</label>
    
     <input type="radio" id="contactChoice5"
     name="contact" value="mail">
    <label for="contactChoice5">와인</label>
  </div>
  <div>
   <button onclick="gogo" id="count" name="count" value="7">결과보기</button>
  </div> 
     </c:if>
       <c:if test="${count==7}">
     <p>당신에게 어울리는 추천메뉴입니다!</p>
  <div>
  	<p>가게이름 :${list.shop_name}</p>
    </div>
    <div>
    <p><img src="/eatclipse/images/${list.image}" width="100px" height="100px"></p>
     </div>
    <div>
    <p>${list.product_name}</p>
  </div>
  <div>
   <button onclick="out()" id="count" name="count" value="7">나가기</button>
  </div> 
     </c:if>
	</table>
	</form>
</body>
</html>