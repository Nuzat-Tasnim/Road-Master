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
        <th>Place Name</th>
        <th></th>
        <th></th>

    </tr>

    <c:forEach items="${model.places}" var="place">

        <tr>
            <td><c:out value="${place.placeName}" /></td>
            <td><c:out value="${place.description}" /></td>
            <td><a href="<c:url value="/searchPlace" >
                        <c:param name="elementid" value="${place.placeId}" />
                        </c:url>">Click
            </a></td>

        </tr>
    </c:forEach>
    </table>
<h4>return <a href="<c:url value="/home" ></c:url>">Home
</a> </h4>

</body>
</html>
