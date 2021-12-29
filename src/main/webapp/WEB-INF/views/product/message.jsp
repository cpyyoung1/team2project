<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>쪽지보내기</title>
<link href="<c:url value="/resources/css/message.css"/>"
	rel='stylesheet' />
	
<script type="text/javascript">
	function notNull(){
		if(document.getElementById("content").value.length == 0){
			alert("보내실 내용을 입력해주세요.");
			 document.getElementById("content").focus();
		        return false;
		    }
		return true;
		}
	
</script>	
	
</head>
<body>

	<div id="title">send a message</div>
	<div class="container">
		<form action="toMember" method="post" name="sendMsgUsr" id="sendMsgUsr">
			<table>
				<tr>
					<td class="property">받는 사람 :</td>

					<td>${toMessage}</td>

				</tr>

				<tr>
					<td colspan="2"><textarea name="content" id="content"
							cols="50" rows="15" placeholder="쪽지보내실 내용을 입력하세요."></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn" type="reset" value="reset">
						 <input class="btn" type="submit" value="send" onclick="return notNull()"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="reciver" value="${toMessage}">
						<input type=hidden name="sender" value="${authInfo.memberId }"></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>