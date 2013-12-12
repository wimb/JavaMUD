<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="nl">
<head>
<title>Gebruiker verwijderd</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/styles/default.css" />
</head>
<body>
	<div>De gebruiker ${emailAdres} (${id}) is verwijderd.</div>
        <nav>
            <ul class="menu">
		<c:url value="/" var="rootURL" />
		<li><a href="${rootURL}">Ga terug naar beginpagina</a></li>
            </ul>
	</nav
</body>
</html>