<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="actie" items="acties">
	<c:url var="actieURL" value="/actie/do">
		<c:param name="actieId" value="${actie.id}" />
	</c:url>
	<a href="actieURL">${actie.omschrijving}</a>
</c:forEach>
