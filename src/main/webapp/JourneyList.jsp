<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=UTF-8">
    <title>My title</title>
</head>
<body>
<c:out value="${model.user.userName}" />
<table>
    <tr>
        <th><b>Source</b></th>
        <th></th>
        <th>Destination</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${model.journeys}" var="journey">

        <tr>
            <td><c:out value="${journey.source.placeName}" /></td>
            <td><c:out value="${journey.source.description}" /></td>
            <td><c:out value="${journey.destination.placeName}" /></td>
            <td><c:out value="${journey.destination.description}" /></td>
            <td><a href="<c:url value="/searchJourney" >
                        <c:param name="elementid" value="${journey.journeyId}" />
                        </c:url>">Click
            </a></td>
        </tr>

    </c:forEach>
</table>
<h4>return <a href="<c:url value="/home" ></c:url>">Home</a> </h4>

</body>
</html>
