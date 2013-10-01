<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!doctype html>
<html lang="nl">
<head>
<title>Gebruiker toegevoegd</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
</head>
<body>
	<h1>Gebruiker toegevoegd</h1>
	Jouw Gebruiker Nummer is ${param.gebruikerNr}
	<br>
</body>