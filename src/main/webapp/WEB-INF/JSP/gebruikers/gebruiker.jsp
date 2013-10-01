<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!doctype html>
<html lang="nl">
<head>
<title>${gebruiker.emailAdres}</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
<style>
form,form input {
	display: inline;
}

form {
	margin-right: 5px;
}
</style>
</head>
<body>
	<h1>${gebruiker.emailAdres}</h1>
	<dl>
		<dt>EmailAdres</dt>
		<dd>${gebruiker.emailAdres}</dd>
		<dt>Voornaam</dt>
		<dd>${gebruiker.voornaam}</dd>
		<dt>FamilieNaam</dt>
		<dd>${gebruiker.familienaam}</dd>
		<dt>paswoord</dt>
		<dd>${gebruiker.paswoord}</dd>
	</dl>
	<c:if test="${not empty param.fout}">
		<div class="fout">${param.fout}</div>
	</c:if>
</body>
</html>