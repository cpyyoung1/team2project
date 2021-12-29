<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼룸 위치</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/location.css"/>" rel='stylesheet' />
<script src='<c:url value="https://polyfill.io/v3/polyfill.min.js?features=default"/>'></script>
<script src='<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyClTw5T3zBHzuwSUlev7PdzuDcV0Ypo7zc&callback=initMap"/>'defer></script>
    <script>
        var map;

        function initMap() {
            map = new google.maps.Map(document.getElementById("map"), {
                center: { lat: 37.267969013881704, lng: 127.00053666253322 },
                zoom: 16,
            });
            var image =
          "https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png";
        var beachMarker = new google.maps.Marker({
          position: { lat: 37.267969013881704, lng: 127.00053666253322 },
          map,
          icon: image,
        });
      
     }
    </script>
</head>
<body>
<jsp:include page="../Header.jsp"/>
    <div class="main">
        <div class="container2">
            <div id="findShowRoom"><strong>show room</strong> location</div>
            <div id="line"></div>
            <div class="mapBox">
                <div id="map"></div>
            </div>
            <div class="content"><strong>주소</strong> : 경기도 수원시 팔달구 덕영대로 905 아이메카 빌딩 5층, 11층</div>
            <div class="content"><strong>영업시간</strong> : 09:00 - 22:00</div>
            <div class="content"><strong>연락처</strong> : 032-000-0000</div>
        </div>
    </div>

<jsp:include page="../Footer.jsp"/>
</body>
</html>