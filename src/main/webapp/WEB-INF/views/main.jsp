<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>TEAM TWO</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/main.css"/>" rel='stylesheet' />
</head>
<script>
function confirm(){
	if(${authInfo==null}){
		alert('1:1 문의는 회원만 할 수 있습니다.');
	}else{
		location.href='<c:url value='/support/Counsel'/>';
	}
}
</script>

<body>
	<div class="main">
		<div
			style="background-position: center; padding-top: 0px; padding-right: 30px; padding-bottom: 10px; padding-left: 30px;">
			<div id="top-header">
				<div id="title">team two</div>
				<div class="sub-navi">
					<ul>
						<c:if test="${empty authInfo}">
							<li class="login-main"><a href="<c:url value='/login'/>">LOGIN</a>
							</li>
						</c:if>
						<c:if test="${authInfo.memberGrade==1}">
							<li class="login-main"><a
								href="<c:url value="/mypage/MypageMain"/>">MY PAGE &nbsp;</a> <a
								href="<c:url value='/logout'/>">LOGOUT</a></li>
						</c:if>
						<c:if test="${authInfo.memberGrade==0}">
							<li class="login-main"><a
								href="<c:url value="/admin/adminpageMain"/>">ADMIN PAGE
									&nbsp;</a> <a href="<c:url value='/logout'/>">LOGOUT</a></li>
						</c:if>
					</ul>
				</div>
				<div class="main-navi">
					<ul>
						<li><a href="<c:url value='/product/productMain'/>">SHOPPING</a>
							<ul class="main-navi-sub">
								<li>
									<div class="inner-menu">
										<a href="<c:url value='/product/1'/>">sofa</a> <a
											href="<c:url value='/product/2'/>">bed</a> <a
											href="<c:url value='/product/3'/>">table</a> <a
											href="<c:url value='/product/4'/>">lighting</a> <a
											href="<c:url value='/product/5'/>">drawer</a> <a
											href="<c:url value='/product/6'/>">acc</a>
									</div>
								</li>
							</ul></li>
						<li><a href="<c:url value='/community/CommunityList'/>">BOARD</a>
							<!-- <ul class="main-navi-sub">
                     <li>
                        <div class="inner-menu">
                           <a href="#">BBB</a>
                        </div>
                     < --></li>
						<li><a href="<c:url value='/product/gallery'/>">GALLERY</a></li>
						<li><a href="<c:url value='/support/SupportMain'/>">SUPPORT</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--------------------------------------------------헤더-------------------------->
	</div>

	<div class="container2">
		<div class="youtube">
			<div id="yText">
				<div id="topText">
					가구는 공간입니다.<br>공간의 예술 TEAM TWO
				</div>
				<div id="subText">
					문을 열었을때 당신을 맞이하는 공간이 더욱 빛날 수 있도록 그리고 삶을 바꿀 수 있도록 <br>
					<span id=""></span>팀투는 '머무는 즐거움에 대한 가치' 를 소중히 생각합니다.<br>
					<br> 당신만의 스타일로 나만의 공간을 채워보세요.
				</div>
			</div>
			<div id="yVideo">
				<iframe width="630" height="340"
					src="https://www.youtube.com/embed/PY6V-CnvJfw" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>
	
	</div>
	<div class="best_item">
       <div class="best_item_title">
          <span>BEST ITEM</span>
       </div>
       <div class="best_item_list">
          <div class="best_item_cell">
             <div class="best_item_content">
                   <a class="best_item_img" href="#">
                      <img src="<c:url value="/resources/img/categoryMain/acc7.jpg"/>">
                   </a>
                <div class="best_item_text">
                   <div class="item_title">WHITE CHAIR</div>
                   <div class="item_price">20,000원</div>
                </div>
                </div>
          </div>
          
          <div class="best_item_cell">
             <div class="best_item_content">
                   <a class="best_item_img" href="#">
                      <img src="<c:url value="/resources/img/categoryMain/bed2.jpg"/>">
                   </a>
                <div class="best_item_text">
                   <div class="item_title">SIMPLE BED</div>
                   <div class="item_price">150,000원</div>
                </div>
                </div>
          </div>
          
          <div class="best_item_cell">
             <div class="best_item_content">
                   <a class="best_item_img" href="#">
                      <img src="<c:url value="/resources/img/categoryMain/drawer5.jpg"/>">
                   </a>
                <div class="best_item_text">
                   <div class="item_title">DRAWER</div>
                   <div class="item_price">60,000원</div>
                </div>
                </div>
          </div>
          
          <div class="best_item_cell">
             <div class="best_item_content">
                   <a class="best_item_img" href="#">
                      <img src="<c:url value="/resources/img/categoryMain/acc9.jpg"/>">
                   </a>
                <div class="best_item_text">
                   <div class="item_title">GREY SOPA</div>
                   <div class="item_price">70,000원</div>
                </div>
                </div>
          </div>
          
          <div class="best_item_cell">
             <div class="best_item_content">
                   <a class="best_item_img" href="#">
                      <img src="<c:url value="/resources/img/categoryMain/bed9.jpg"/>">
                   </a>
                <div class="best_item_text">
                   <div class="item_title">QUEEN BED</div>
                   <div class="item_price">320,000원</div>
                </div>
                </div>
          </div>
       </div>
    </div>
	<div class="container3">
	<div class="fixed_background" style="background-image: url(<c:url value="/resources/img/main/mainInterior16.jpg"/>)">
       <a class="fixed_background_title" href="<c:url value='/product/gallery'/>">
          <p>BEST INTERIOR</p>
          <span>GALLERY</span>
       </a>
    </div>
	</div>
	<div class="container4">
			<div class="instagram">
        <div id="instaTitle">INSTAGRAM</div>
        <div id="subTitle">@teamtwo_official</div>
        <div class="slide_wrapper">
            <ul class="slides">
                <li class="instaImg"><a href="https://www.instagram.com/p/CH-C2mhDhtv/">
                    <img src="<c:url value="/resources/img/instagram/instagram1.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CH4p8ikjE4W/">
                    <img src="<c:url value="/resources/img/instagram/instagram2.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHxK5gPD4rn/">
                    <img src="<c:url value="/resources/img/instagram/instagram3.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHpcXcDDdVr/">
                    <img src="<c:url value="/resources/img/instagram/instagram4.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHkErhiDFDj/">
                    <img src="<c:url value="/resources/img/instagram/instagram5.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHw1Q9fruFv/">
                    <img src="<c:url value="/resources/img/instagram/instagram6.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHugIWXrKrA/">
                    <img src="<c:url value="/resources/img/instagram/instagram7.png"/>"></a>
                </li>
                <li class="instaImg"><a href="https://www.instagram.com/p/CHW_SyWFDWK/">
                    <img src="<c:url value="/resources/img/instagram/instagram8.png"/>"></a>
                </li>
            </ul>
            
        </div>
            <p class="controls">
                <span class="prev">
                	<img src="<c:url value="/resources/img/left.png"/>" width="20" height="30">
                </span>
                <span class="next">
              	  <img src="<c:url value="/resources/img/right.png"/>" width="20" height="30">
                </span>
            </p>
    </div>
	</div>

    
    <div class="info_container clear">
       <div class="info_container_box fl">
          <a href="<c:url value='/support/SupportMain'/>">
             <div class="info_container_text">
             <p class="info_container_title">SUPPORT</p>
                <h3>1557-1557</h3>
                <span>평일: AM 09:00 ~ PM 07:00</span><br>
                <span>점심시간: PM 12:00 ~ PM 13:00</span><br>
                <span>휴무: 토, 일, 공휴일 휴무</span>
             </div>
          </a>
       </div>
       <div class="info_container_box fl">
          <a href="<c:url value="/support/location"/>">
             <div class="info_container_text">
             <p class="info_container_title">SHOW ROOM</p>
                <h3>위치안내</h3>
                <span>주소: 경기도 수원시 팔달구</span><br>
                <span>매산로1가 11-12</span><br>
                <span>아이메카빌딩 5층, 11층</span>
             </div>
          </a>
       </div>
    </div>
	<!-- ------------------------------------------------------------------------->
	<div class="footer">
		<div class="footer-navi">
			<ul>
				<li><a href="<c:url value="/support/SupportMain"/>">공지사항</a></li>
				<li><a href="<c:url value="/support/Privacy"/>">개인정보처리방침</a></li>
				<li><a href="#" onclick="return confirm()">1:1문의</a></li>
				<li><a href="<c:url value="/support/SupportMain"/>">고객센터</a></li>
			</ul>
		</div>
		      <div class="copyright">
         <strong>TEAM TWO</strong>
         <h2>Copyright © TEAM TWO Corp. All rights reserved.</h2>
      </div>

	</div>
</body>
<script>
var slides = document.querySelector('.slides');
var slide = document.querySelectorAll('.slides li');
var currentIdx = 0;
var slideCount = slide.length;
var prevBtn = document.querySelector('.prev');
var slideWidth = 300;
var slideMargin = 5;
var nextBtn = document.querySelector('.next');

slides.style.width = (slideWidth + slideMargin)*slideCount - slideMargin + 'px';

function moveSlide(num){
slides.style.left = (-num * 305) + 'px';
currentIdx = num;
}

nextBtn.addEventListener('click',function(){
if(currentIdx < slideCount - 4){
    moveSlide(currentIdx + 1);
}else{
    moveSlide(0);
}
});

prevBtn.addEventListener('click',function(){
if(currentIdx > 0){
    moveSlide(currentIdx - 1);
}else{
    moveSlide(slideCount - 4);
}
});
</script>
</html>