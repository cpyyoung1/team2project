<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FIND INFO</title>
<link href="<c:url value="/resources/css/findId.css"/>" rel='stylesheet' />
</head>
<body>
    <div class="main">
            <table>
                <tr>
                    <td id="title" colspan="2">find info</td>
                </tr>
                <tr class="box">
                    <td colspan="2"><button id="btn" onclick="location.href='findId'">FIND ID</button></td>
                </tr>
                <tr class="box">
                    <td colspan="2"><button id="btn" onclick="location.href='findPw'">FIND PASSWORD</button></td>
                </tr>
                <tr class="tText">
                    <td colspan="2">찾으시려는 정보를 선택해주세요.</td>
                </tr>
                <tr>
                    <td colspan="2" class="btn"><button id="btn" onclick="location.href='SupportMain'">뒤로 가기</button></td>
                </tr>
            </table>
    </div>
</body>
</html>