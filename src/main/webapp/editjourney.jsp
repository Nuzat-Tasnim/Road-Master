<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=UTF-8">
    <title>My goddamn title</title>
</head>
<body>
<c:out value="${model.user.userName}" />
<h1>Edit Journey Information</h1>
<form action="saveEditJourney" method="post">
    <input type="hidden" name="elementid" value="${model.journey.journeyId}">
    <caption>Place ID of Source</caption><br>
    <input type="text" name="sourceid" value="${model.journey.source.placeId}"><br>
    <caption>Place ID of Destination</caption><br>
    <input type="int" name="destinationid" value="${model.journey.destination.placeId}"><br>
    <caption>Description</caption><br>
    <input type="text" name="description" value="${model.journey.description}"><br>

    <input type="submit"><br>
</form>

<h4>return <a href="<c:url value="/home" ></c:url>">Home
</a> </h4>
</body>
</html>
