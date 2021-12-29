<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGN UP</title>
   <link href="<c:url value="/resources/css/signup.css"/>" rel='stylesheet' />
</head>
<script>
var index = 0;
    window.onload=function(){
        slideShow();
    }

    function slideShow(){
        var i;
        var x = document.getElementsByClassName("sImg");
        for(i=0;i<x.length;i++){
            x[i].style.display="none";
        }
        index++;
        if(index>x.length){
            index = 1;
        }
        x[index-1].style.display = "block";
        setTimeout(slideShow,2000);
    }
</script>

<body>
    <div id="title">SIGN UP</div>
    <div id="main">
        <form:form action="step3" commandName="formData">
            <table border="1">
                <tr class="box">
                    <td class="property"><label for="memberName">name *</label></td>
                    <td><input class="form" type="text" name="memberName" id="memberName" size="40">
                       <span class="error"><form:errors path="memberName" /></span>
                    </td>
                <tr class="box">
                    <td class="property"><label for="memberId">id *</label></td>
                    <td><input class="form" type="text" name="memberId" id="memberId" size="40"
                        placeholder="아이디는 5-15자로 입력해주세요.">
                        <span class="error"><form:errors path="memberId" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="memberPw">password *</label></td>
                    <td><input class="form" type="password" name="memberPw" id="memberPw" size="40">
                       <span class="error"><form:errors path="memberPw" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="chkPw">check password *</label></td>
                    <td><input class="form" type="password" name="confirmPassword" id="confirmPassword" size="40">
                       <span class="error"><form:errors path="confirmPassword" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="memberTel">tel *</label></td>
                    <td><input class="form" type="text" name="memberTel" id="memberTel" size="40">
                      <span class="error"><form:errors path="memberTel" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="memberAddress">address *</label></td>
                    <td><input class="form" type="text" name="memberAddress" id="memberAddress" size="40">
                       <span class="error"><form:errors path="memberAddress" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="memberNickname">nickname *</label></td>
                    <td><input class="form" type="text" name="memberNickname" id="memberNickname" size="40">
                       <span class="error"><form:errors path="memberNickname" /></span>
                    </td>
                </tr>
                <tr class="box">
                    <td class="property"><label for="memberProfile">profile</label></td>
                    <td><input class="form" type="file" name="memberProfile" id="memberProfile"></td>
                    <!-- \team2\src\main\webapp\resources\img 경로에 있는 사진 첨부하기 -->
                </tr>
                <tr>
                    <td id="star" colspan="2">*표시 된 항목은 필수입력 항목입니다.</td>
                </tr>
                <tr class="btns">
                    <td>
                        <input class="btn" type="reset" value="RESET">
                    </td>
                    <td>
                        <input class="btn" type="submit" value="SIGN UP" onclick="return check()">
                    </td>   
                </tr>
            </table>
        </form:form>
        <div id="imgBox">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior6.jpg"/>">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior2.jpg"/>">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior3.jpg"/>">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior4.jpg"/>">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior5.jpg"/>">
            <img class="sImg" src="<c:url value="/resources/img/categoryMain/interior1.jpg"/>">
        </div>
    </div>
</body>

</html>