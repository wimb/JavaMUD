<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="item" items="${items}">    
    <li>
    <div class="item">
        ${item.omschrijving}
        <c:if test="${not empty item.acties}">
            <ul>
            <c:forEach var="actie" items="${item.acties}">
                <li>${actie.omschrijving}</li>
            </c:forEach>
             </ul>
        </c:if>
    </div>
    </li>
</c:forEach>
    </ul>