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
    <h1>Add New Place Information</h1>
    <h4>Nearby Hospital Contacts</h4>
    <c:forEach items="${model.place.hospcontacts}" var="hospital">

        <tr>
            <td><br><c:out value="${hospital.name}" /><br>
                <c:out value="${hospital.address}" /><br>
                <c:out value="${hospital.contact}" /><br>

            </td>
            <td>
                <a href="<c:url value="/deleteHospital" >
                <c:param name="elementid" value="${model.place.placeId}" />
                 <c:param name="contactid" value="${hospital.id}" />
                 </c:url>">Delete
                </a>
            </td>
        </tr>

    </c:forEach>
    <form action="addhospitalContact" method="post">
        <input type="hidden" name="elementid" value="${model.place.placeId}">
        <caption>Hospital Name</caption>
        <input type="text" name="hospName">
        <caption>Address</caption>
        <input type="text" name="hospAddress">
        <caption>Contact Number</caption>
        <input type="text" name="hospContact">
        <input type="submit">
    </form>

    <h4>Nearby Police Station Contacts</h4>
    <c:forEach items="${model.place.policecontacts}" var="police">

        <tr>
            <td><br><c:out value="${police.name}" /><br>
                    <c:out value="${police.address}" /><br>
                    <c:out value="${police.contact}" /><br>
            </td>
            <td>
                <a href="<c:url value="/deletePolice" >
                <c:param name="elementid" value="${model.place.placeId}" />
                 <c:param name="contactid" value="${police.id}" />
                 </c:url>">Delete
                </a>
            </td>
        </tr>

    </c:forEach>
    <form action="addpolicecontact" method="post">
        <input type="hidden" name="elementid" value="${model.place.placeId}">
        <caption>Police Station</caption>
        <input type="text" name="stationName">
        <caption>Address</caption>
        <input type="text" name="stationAddress">
        <caption>Contact Number</caption>
        <input type="text" name="stationContact">
        <input type="submit">
    </form>

    <p>Available Transports Information</p>
    <c:forEach items="${model.place.transportList}" var="transport">

        <tr>
            <td><br><c:out value="${transport.name}" /><br>
                <c:if test = "${not transport.availability}">
                    Not
                </c:if>Available<br>
            </td>
            <td>
                <a href="<c:url value="/deleteTransportPlace" >
                <c:param name="elementid" value="${model.place.placeId}" />
                 <c:param name="transportid" value="${transport.id}" />
                 </c:url>">Delete
                </a>
            </td>
        </tr>

    </c:forEach>
    <form action="addtransportplace" method="post">
        <input type="hidden" name="elementid" value="${model.place.placeId}">
        <caption>Transport name</caption>
        <input type="text" name="transportname">
        <caption>Availablity</caption>
        <input type="checkbox" name="availability">
        <input type="submit">
    </form>

    <a href="<c:url value="/backtoplace" >
            <c:param name="elementid" value="${model.place.placeId}" />
             </c:url>">Go back</a>

    <h4>return <a href="<c:url value="/home" ></c:url>">Home</a> </h4>
</body>
</html>
