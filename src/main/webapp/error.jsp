<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html: charset=UTF-8">
    <title>My goddamn title</title>
</head>
<body>

<h3><c:out value="${model.msg}" /></h3>
<h4>return <a href="<c:url value="/home" ></c:url>">Home</a> </h4>


</body>
</html>
