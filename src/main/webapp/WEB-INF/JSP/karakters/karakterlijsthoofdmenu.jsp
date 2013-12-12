<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test="${not empty gebruiker.karakter}">
    <c:forEach var="karakter" items="${gebruiker.karakter}">
        <c:if test="${not empty karakter.naam}">
            <ul class="zonderbolletjes">
                <li>
                    <c:url var="karakterURL" value="/lokatie">
                        <c:param name="karakterId" value="${karakter.id}"/>
                    </c:url>
                    

                    <c:url var="deleteURL" value="/karakter">
                        <c:param name="karakterId" value="${karakter.id}"/>
                    </c:url>
					<div>
						<form:form action="${deleteURL}" method="delete" >
							<a href="${karakterURL}">${karakter.naam}</a>
							<input  class="characterdelete" type="submit" value="delete"/>
						</form:form>
					</div>
                </li>
            </ul>
        </c:if>
    </c:forEach>
</c:if>