<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 공지사항</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/community.css"/>"
	rel='stylesheet' />
<script src='<c:url value="/resources/jquery/jquery-3.5.1.js"/>'></script>
<script src='<c:url value="/resources/jquery/jquery-ui.js"/>'></script>
</head>
<body>
	<div class="container">
		<jsp:include page="../Header.jsp" />
		<div class="community-wrap">

			<div class="content-area">
				<div class="community-wrap">

					<div class="content-header">
						<span>자유게시판</span>
						<!-- 게시판 종류 -->
					</div>
					<div class="content-board">
						<div class="content-view">
							<div class="content-view-header clear">
								<div class="view-title">
									<span>게시판 관련 공지사항</span>
								</div>
								<div class="view-info">
									<span class="info-id">관리자</span>
									<div class="info-data">
										<p>조회 2313</p>
										<p>2020.10.31.</p>
									</div>
								</div>
								<!-- class="view-info" -->
							</div>
							<!-- class="content-view-header" -->
							<div class="content-view-box">
							<strong>1. 욕설 / 비방이 있는 글은 즉시 삭제 조치됩니다.<br><br></strong>
							<strong>2. 회원들끼리 자유롭게 소통할 수 있는 게시판입니다.<br><br></strong><br>
							가구 중고 상품이 아닌 판매글 작성 시,
							게시글에 대한 무통보 삭제와 활동정지 3일이 처해집니다.<br><br>
							지속적으로 판매글 작성이 적발되면 재가입이 불가능하게 강제 탈퇴까지
							처리될 수 있으므로, <br><br>판매글을 작성하시면 안됩니다.<br><br>
							구매하시려는 회원님께서도 안전거래나 본인인증이 완료된 게시글에서 중고거래를 해주시를 바라며,<br><br>
							더치트등 번호 조회로 사기피해를 막기위한 최소한의 조치를 해주시기 바랍니다.<br><br>
							사기꾼 없고, 사기피해 없는 클린한 팀투가 되기를 바라면서 공지사항 전해드렸습니다.<br><br>
							감사합니다.<br><br>
							</div>
							<div class="view-info"></div>

						</div>
						<!-- class="comment-wrap" -->

					</div>
				</div>

			</div>
			<!-- class="view-control-area" -->



		</div>

	</div>
	<jsp:include page="../Footer.jsp" />
	</div>
</body>
<script>
$('.DOC_TEXT').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 200자)");    //글자수 실시간 카운팅

    if (content.length > 200){
        alert("최대 200자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 200));
        $('#counter').html("(200 / 최대 200자)");
    }
});
</script>
</html>