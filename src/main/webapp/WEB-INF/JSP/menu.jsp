<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="menu">
		<nav>
		<img
		src="${pageContext.servletContext.contextPath}/images/logo.png"alt="logo" 
		/>
			<ul class="hoofdmenu">
				<c:url value="/" var="rootURL" />
				<li><a href="${rootURL}">Hoofdmenu</a></li>
			</ul>
		</nav>
	</div>
</header>
