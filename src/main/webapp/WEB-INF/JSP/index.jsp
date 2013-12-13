<%-- 
    Document   : index
    Created on : Sep 30, 2013, 12:48:08 PM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="nl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multi User Dungeon Java</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>Welkom in onze Multi User Dungeon</h1>
	<c:url var="aanmeldenURL" value="/aanmelden">
	</c:url>
	<a href="${aanmeldenURL}">Aanmelden Gebruiker</a>
	
</body>
</html>





