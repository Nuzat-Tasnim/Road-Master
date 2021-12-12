<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Faster+One&display=swap" rel="stylesheet">
    <link type="text/css" href='<c:url value="styles/home.css" />' rel="stylesheet">
    <title>My title</title>
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <span>ROAD</span>
            <span class="small">MASTER</span>
        </div>
        <div class="user-options">
            <span class="material-icons-outlined icon">account_circle</span>
            <span class="name"><c:out value="${model.user.userName}" /></span>
            <a href='<c:url value="/editProfilePage" ></c:url>'>
                <span class="material-icons-outlined icon icon-link">manage_accounts</span>
            </a>
            <a href="logout">
                <span class="material-icons-outlined icon icon-link">power_settings_new</span>
            </a>
        </div>
    </div>
    <div class="dashboard">
        <c:if test="${model.user.admin}">
            <a href='<c:url value="/addPlaceForm" ></c:url>'>
                <div class="card">
                    <span class="big">Update</span>
                    <span class="small">Place</span>
                    <span class="material-icons-outlined icon">map</span>
                </div>
            </a>
            <a href='<c:url value="/addJourneyForm" ></c:url>'>
                <div class="card">
                    <span class="big">Update</span>
                    <span class="small">Journey</span>
                    <span class="material-icons-outlined icon">edit_road</span>
                </div>
            </a>
        </c:if>
        <a href='<c:url value="/searchform" ></c:url>'>
            <div class="card">
                <span class="big">Search</span>
                <span class="material-icons-outlined icon">search</span>
            </div>
        </a>
        <a href='<c:url value="/bookmarkedPlaces" ></c:url>'>
            <div class="card">
                <span class="big">Bookmarked</span>
                <span class="small">Places</span>
                <span class="material-icons-outlined icon">location_on</span>
            </div>
        </a>
        <a href='<c:url value="/bookmarkedJourneys" ></c:url>'>
            <div class="card">
                <span class="big">Bookmarked</span>
                <span class="small">Journeys</span>
                <span class="material-icons-outlined icon">directions_car</span>
            </div>
        </a>
    </div>

    <style type="text/css">
        body{
            background-image: url("index.jpg");
        }
    </style>

</body>
</html>
