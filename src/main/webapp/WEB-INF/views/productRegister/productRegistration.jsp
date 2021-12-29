<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PRODUCT REGISTRATION</title>
    <link href="<c:url value="/resources/css/productRegistration.css"/>" rel='stylesheet' />
    <script src='<c:url value="/resources/js/productRegistration.js"/>'></script>
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="base">
    <div id="title"><strong>Product</strong> registration</div>
    <div class="container">
      <form action="step10" name="frm" class="form" method="POST">
      <input type="hidden" value="${authInfo.memberNumber}" name="memberNumber">
     <!--   <form:form commandName="registrationCommand"> --> 
           <table id="tbl">
                <tr class="box">
                    <td class="property"><label for="categoryNumber">상품 카테고리</label></td>
                    <td>
                        <select name="categoryNumber" id="categoryNumber">
                            <option value="1">소파 / 의자</option>
                            <option value="2">침대 / 매트리스</option>
                            <option value="3">테이블</option>
                            <option value="4">조명</option>
                            <option value="5">서랍 / 수납장</option>
                            <option value="6">기타</option>
                        </select>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="productTitle">상품 판매 글 제목</label></td>
                    <td><input type="text" name="productTitle" id="productTitle"></td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="productPrice">상품 가격</label></td>
                    <td><input type="text" name="productPrice" id="productPrice" placeholder="숫자만 입력해주세요."></td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="productName">상품 이름</label></td>
                    <td><input type="text" name="productName" id="productName"></td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="productText">상품 설명</label></td>
                    <td><textarea name="productText" id="productText" cols="20" rows="10"></textarea></td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="productPictureNameURL">상품 사진 첨부</label></td>
                    <td><input type="file" name="productPictureNameURL" id="productPictureNameURL"></td>
                    <!-- team2\src\main\webapp\resources\img\categoryMain 경로에 있는 사진첨부하기 -->
                </tr>
                <tr class="box">
                    <td colspan="2" class="btns">
                        <input class="btn" type="submit" value="등록" onclick="return checkForm()">
                        <input class="btn" type="reset" value="취소" onclick="window.history.back()">
                    </td>    
                </tr>
           </table>
      </form> 
   <!--      </form:form>--> 
    </div>
    </div>
     <jsp:include page="../Footer.jsp"/>
</body>
</html>