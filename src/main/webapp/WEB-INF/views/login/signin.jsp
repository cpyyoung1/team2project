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
    <title>SIGN IN</title>
     <link href="<c:url value="/resources/css/signin.css"/>" rel='stylesheet' />
    <!-- <script src='<c:url value="/resources/js/signin.js"/>'></script> -->
</head>

<body>
    <div class="main">
        <form:form commandName="loginCommand">
            <table border="1">
                <tr>
                    <td colspan="2" id="title">SIGN IN</td>
                </tr>
                <tr class="box">
                    <td class="property">ID</td>
                    <td><label>
                       <!--<form:input path="memberId" /> -->
                     <input class="form" type="text" name="memberId" id="memberId">
                    </label>
                    </td>
                </tr>
                <tr>
                   <td>
                      <span class="error"><form:errors path="memberId" /></span>
                   </td>
                </tr>
                <tr class="box">
                    <td class="property">PASSWORD</td>
                    <td><label>
                       <!--<form:input path="memberPw" />-->
                     <input class="form" type="password" name="memberPw" id="memberPw">
                    </label>
                    </td>
                </tr>
                <tr>
                   <td>
                      <span class="error"><form:errors path="memberPw" /></span>
                   </td>
                </tr>
                <tr>
                    <td colspan="2">
                       <form:checkbox path="remembermemberId"/>remember ID
                        <!--  <input type="checkbox" name="remeberId" id="rememberId">-->
                    </td>
                </tr>
                <tr>
                   <td colspan="2">
                      <span class="error"><form:errors /></span>
                   </td>
                </tr>
                <tr class="tText">
                    <td colspan="2">
                        <a href="<c:url value='/login/findId'/>" class="search">Forgot Your Id?</a>
                        <a href="<c:url value='/login/findPw'/>" class="search">Or Password?</a>
                    </td>
                </tr>
                <tr class="box btnBox">
                    <td colspan="2">
                        <input class="btn" type="submit" value="SIGN IN" onclick="return checkSignin()">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="btn" type="button" value="CREATE ACCOUNT" onclick="location.href='<c:url value='/register/term'/>'">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>

</html>