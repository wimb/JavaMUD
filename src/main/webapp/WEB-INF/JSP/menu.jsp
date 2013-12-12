<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="menu">
		<nav>
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="logo">
			<ul class="hoofdmenu">
				<c:url value="/hoofdmenu" var="hoofdmenuURL" />
				<li><a href="${hoofdmenuURL}">Hoofdmenu</a></li>
			</ul>
		</nav>
	</div>
</header>
