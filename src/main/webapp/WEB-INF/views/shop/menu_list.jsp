<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <!-- 가게 메뉴 -->
   <h4>가게 메뉴</h4>
   <a href="/eatclipse/shop/menu_register.do">메뉴 등록</a>
   <table>
      <tr>
         <th>이미지</th>
         <th>메뉴</th>
         <th>가격</th>
         <th>상태</th>
         <th>수정</th>
      </tr>
      <c:forEach var="row" items="${menulist}">
         <tr>
            <td><img src="/eatclipse/images/${row.image}" width="100px" height="100px"></td>
            <td>${row.product_name}</td>
            <td>${row.price}</td>
            <td>
               <c:if test="${row.type == 0}">
             	  판매중
             	  <input type="button" value="판매중지" onclick="location.href='/eatclipse/shop/typeto1/${row.no}'">
               </c:if>
               
               <c:if test="${row.type == 1}">
            	   품절
            	   <input type="button" value="판매재개" onclick="location.href='/eatclipse/shop/typeto0/${row.no}'">
               </c:if>
            </td>
            <td>
            	<button onclick="location.href='/eatclipse/shop/menu_edit.do'">수정</button>
            	<button onclick="menu_delete()">삭제</button>
            	<script>
					function menu_delete(){
					alert("삭제하시겠습니까?");
					location.href="/eatclipse/shop/delete/${row.no}";
					}
				</script>
            </td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>