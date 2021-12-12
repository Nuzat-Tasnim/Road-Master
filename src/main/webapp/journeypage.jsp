<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
    <link type="text/css" href='<c:url value="styles/placepage.css" />' rel="stylesheet">
    <title>My title</title>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="user-name">
                <span class="material-icons-outlined icon">account_circle</span>
                <span class="name"><c:out value="${model.user.userName}" /></span>
            </div>
            <a class="home-link" href='<c:url value="/home" ></c:url>'>
                <span class="material-icons-outlined icon">home</span>
                <span class="text">Home</span>
            </a>
        </div>
        <div class="place-info">
            <div class="place-name-container">
                <span class="material-icons-outlined location-icon">location_on_outline</span>
                <span class="location-name"><c:out value="${model.journey.source.placeName}" /></span>
            </div>
            <div class="place-name-container">
                <span class="material-icons-outlined location-icon">location_on_outline</span>
                <span class="location-name"><c:out value="${model.journey.destination.placeName}" /></span>
            </div>
        </div>
        <div class="settings">
                <c:if test = "${model.user.admin}">
                    <a href='<c:url value="/editJourney" >
                            <c:param name="elementid" value="${model.journey.journeyId}" />
                            </c:url>'><span class="material-icons-outlined icon">edit</span>
                    </a>
                </c:if>
                <c:if test = "${model.user.admin}">
                    <a href='<c:url value="/addJourneyInfo" >
                            <c:param name="elementid" value="${model.journey.journeyId}" />
                            </c:url>'><span class="material-icons-outlined icon">list_alt</span>
                    </a>
                </c:if>
                <c:set var = "bookmark" scope = "session" value = ""/>
                <c:if test = "${model.bookmark}">
                    <form class="bookmark-form" action="unbookmark">
                        <input type="hidden" name="elementid" value = "${model.journey.journeyId}">
                        <input type="hidden" name="element" value = "Journey">
                        <button class="form-btn" type="submit" value = "Unbookmark">
                            <span class="material-icons-outlined icon">bookmark_added</span>
                        </button>
                    </form>
                </c:if>
                <c:if test = "${model.bookmark!=true}">
                    <form class="bookmark-form" action="bookmark">
                        <input type="hidden" name="elementid" value = "${model.journey.journeyId}">
                        <input type="hidden" name="element" value = "Journey">
                        <button class="form-btn" type="submit" value = "Bookmark">
                            <span class="material-icons-outlined icon">bookmark_border</span>
                        </button>
                    </form>
                </c:if>
            </div>
            <div class="place-description">
                <p><c:out value="${model.journey.description}"/></p>
            </div>

            <div class="tab-headers">
            <span class="tab-header-text" onclick='activateTab(event, "placeInfoTransport")'>Transports</span>
            <span class="tab-header-text active" onclick='activateTab(event, "placeInfoHospital")'></span>
            <span class="tab-header-text" onclick='activateTab(event, "placeInfoPS")'></span>
            
            <div class="tab-body" id="placeInfoTransport" style="display: none;">
            <c:forEach items="${model.journey.transportList}" var="transport">
                <div class="list-item-simple">
                    <span><c:out value="${transport.name}" /></span>
                    <span><c:out value="${transport.rent}" /></span>
                </div>
            </c:forEach>
        </div>
        </div>

        <h4 class="review-header">Reviews</h4>
        <form action="addreviewjourney" method="post" class="review-form">
            <textarea name="review" placeholder="Write here" class="review-inp"></textarea>
            <input type="hidden" name="elementid" value="${model.journey.journeyId}">
            <button type="submit" class="submit-btn">Submit</button>
        </form>
        <c:forEach items="${model.journey.reviewList}" var="review">
            <div class="review">
                <div class="name"><c:out value="${review.user.userName}" /></div>
                <p class="text"><c:out value="${review.text}" /></p>
            </div>
        </c:forEach>

    </div>



    <script>
        function activateTab(e, id) {
            let tabHeaders = document.getElementsByClassName("tab-header-text");
            let tabs = document.getElementsByClassName("tab-body");
            let active = document.getElementById(id);

            for (let i = 0; i < tabs.length; i++) {
                tabs[i].style.display = (tabs[i].id === id) ? "block" : "none";
            }

            for (let i = 0; i < tabHeaders.length; i++) {
                if(tabHeaders[i] === e.currentTarget) tabHeaders[i].classList.add("active");
                else tabHeaders[i].classList.remove("active");
            }
        }
    </script>

</body>
</html>
