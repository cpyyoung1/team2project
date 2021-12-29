<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GALLERY</title>
    <link href="<c:url value="/resources/css/gallery.css"/>" rel='stylesheet' />
</head>
<body>
   <div class="main">
       <div class="btn">
           <span>♬</span>
           <span class="none">☆</span>
           <span class="none">☆</span>
       </div>
        <div class="sidebar">
            <div id="title">Filter:</div>
            <ul>
                <li><label for="all">─ &nbsp;all</label></li>
                <li><label for="sofa">─ &nbsp;sofa</label></li>
                <li><label for="bed">─ &nbsp;bed</label></li>
                <li><label for="table">─ &nbsp;table</label></li>
                <li><label for="lighting">─ &nbsp;lighting</label></li> 
                <li><label for="drawer">─ &nbsp;drawer</label></li>
                <li><label for="acc">─ &nbsp;acc</label></li>
            </ul>
        </div>
        <input type="checkbox" name="all" id="all">
        <input type="checkbox" name="sofa" id="sofa">
        <input type="checkbox" name="bed" id="bed">
        <input type="checkbox" name="table" id="table">
        <input type="checkbox" name="lighting" id="lighting">
        <input type="checkbox" name="drawer" id="drawer">
        <input type="checkbox" name="acc" id="acc">
        <div class="galleryBox">
            <div class="gallery">
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior2.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox bed">
                    <img src="<c:url value="/resources/img/main/mainInterior3.jpg"/>">
                    <div class="innerText">bed</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior22.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox bed">
                    <img src="<c:url value="/resources/img/main/mainInterior5.jpg"/>">
                    <div class="innerText">bed</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior6.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior7.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox lighting">
                    <img src="<c:url value="/resources/img/main/mainInterior23.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior9.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior10.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior11.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox drawer">
                    <img src="<c:url value="/resources/img/main/mainInterior26.jpg"/>">
                    <div class="innerText">drawer</div>
                </div>
                <div class="innerBox lighting">
                    <img src="<c:url value="/resources/img/main/mainInterior13.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior25.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior15.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior16.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior17.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox drawer sofa lighting">
                    <img src="<c:url value="/resources/img/main/mainInterior18.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior19.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox lighting drawer">
                    <img src="<c:url value="/resources/img/main/mainInterior20.jpg"/>">
                    <div class="innerText">drawer</div>
                </div>
                <div class="innerBox table sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior21.jpg"/>">
                    <div class="innerText">table</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior53.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior54.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox table acc">
                    <img src="<c:url value="/resources/img/main/mainInterior55.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior56.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>  
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior57.jpg"/>">
                    <div class="innerText">table</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior28.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox table lighting">
                    <img src="<c:url value="/resources/img/main/mainInterior29.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior30.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox sofa drawer">
                    <img src="<c:url value="/resources/img/main/mainInterior31.jpg"/>">
                    <div class="innerText">drawer</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior32.jpg"/>">
                    <div class="innerText">table</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox lighting">
                    <img src="<c:url value="/resources/img/main/mainInterior33.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior34.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox lighting acc">
                    <img src="<c:url value="/resources/img/main/mainInterior35.jpg"/>">
                    <div class="innerText">lighting</div>
                </div>
                <div class="innerBox table sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior36.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior37.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior38.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior39.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior40.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior41.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior42.jpg"/>">
                    <div class="innerText">table</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior43.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior44.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox table">
                    <img src="<c:url value="/resources/img/main/mainInterior45.jpg"/>">
                    <div class="innerText">table</div>
                </div>
                <div class="innerBox table acc">
                    <img src="<c:url value="/resources/img/main/mainInterior46.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox sofa">
                    <img src="<c:url value="/resources/img/main/mainInterior47.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
            </div>
            <div class="gallery">
                <div class="innerBox bed">
                    <img src="<c:url value="/resources/img/main/mainInterior48.jpg"/>">
                    <div class="innerText">bed</div>
                </div>
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior49.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox sofa table">
                    <img src="<c:url value="/resources/img/main/mainInterior50.jpg"/>">
                    <div class="innerText">sofa</div>
                </div>
                <div class="innerBox acc">
                    <img src="<c:url value="/resources/img/main/mainInterior51.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
                <div class="innerBox table acc">
                    <img src="<c:url value="/resources/img/main/mainInterior52.jpg"/>">
                    <div class="innerText">acc.</div>
                </div>
            </div>
        </div>
   </div>
</body>
</html>