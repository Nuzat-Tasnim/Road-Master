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
<h1>Edit Place Information</h1>
<form action="saveEditPlace" method="post">
    <input type="hidden" name="elementid" value="${model.place.placeId}">
    <caption>Place name</caption><br>
    <input type="text" name="placeName" value="${model.place.placeName}"><br>
    <caption>Description</caption><br>
    <input type="text" name="description" value="${model.place.description}"><br>

    <input type="submit"><br>
</form>

<h4>return <a href="<c:url value="/home" ></c:url>">Home</a> </h4>
</body>
</html>
