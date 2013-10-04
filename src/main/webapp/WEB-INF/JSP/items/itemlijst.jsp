<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="item" items="${items}">
    <div class="item">
        ${item.omschrijving}
        <c:if test="${not empty item.acties}">
            <c:forEach var="actie" items="${items.acties}">
                ${actie.omschrijving}
            </c:forEach>
        </c:if>
    </div>
</c:forEach>