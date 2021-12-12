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
    <h1>Add New Journey Information</h1>
    <h4>Available Transports</h4>
    <c:forEach items="${model.journey.transportList}" var="transport">

        <tr>
            <td><br><c:out value="${transport.name}" /><br>
                    <c:out value="${transport.rent}" /><br>
            </td>
            <td>
                <a href="<c:url value="/deleteTransportJourney" >
                <c:param name="elementid" value="${model.journey.journeyId}" />
                 <c:param name="transportid" value="${transport.id}" />
                 </c:url>">Delete
                </a>
            </td>
        </tr>

    </c:forEach>
    <form action="addtransportjourney" method="post">
        <caption>Transport name</caption>
        <input type="hidden" name="elementid" value="${model.journey.journeyId}">
        <input type="text" name="transportname">
        <caption>Rent</caption>
        <input type="text" name="rent">
        <input type="submit"><br>
    </form>

    <a href="<c:url value="/backtojourney" >
            <c:param name="elementid" value="${model.journey.journeyId}" />
             </c:url>">Go back</a>

    <h4>return <a href="<c:url value="/home" ></c:url>">Home</a> </h4>
</body>
</html>
