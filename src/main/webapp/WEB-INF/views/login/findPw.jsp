<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FIND PASSWORD</title>
   <link href="<c:url value="/resources/css/findId.css"/>" rel='stylesheet' />
</head>
<body>
    <div class="main">
        <form:form action="findPw" commandName="formData">
            <table>
                <tr>
                    <td id="title" colspan="2">find password</td>
                </tr>
                <tr class="box">
                    <td><label for="memberName">id</label></td>
                    <td><input class="form" type="text" name="memberId" id="memberId">
                    <span class="error"><form:errors path="memberId" /></span></td>
                </tr>
                <tr class="box">
                    <td><label for="memberId">name</label></td>
                    <td><input class="form" type="text" name="memberName" id="memberName">
                    <span class="error"><form:errors path="memberName" /></span></td>
                </tr>
                <tr class="box">
                    <td><label for="memberTel">tel</label></td>
                    <td><input class="form" type="text" name="memberTel" id="memberTel">
                    <span class="error"><form:errors path="memberTel" /></span></td>
                </tr>
                <tr class="tText">
                    <td colspan="2">가입시 입력한 정보를 입력해주세요.
                    <span class="error"><form:errors /></span></td>
                </tr>
                <tr>
                    <td colspan="2" class="btn"><input id="btn" type="submit" value="확인" onclick="return checkFindPw()"></td>
                </tr>
            </table>
        </form:form>

    </div>
</body>
</html>