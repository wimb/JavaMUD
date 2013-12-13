<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="heeftitem" items="${heefitems}">    
    <li>
    <div class="item">
        ${item.omschrijving}
        <c:if test="${not empty heeftitems.acties}">
            <ul>
            <c:forEach var="actie" items="${heeftitem.acties}">
                <li>${actie.omschrijving}</li>
            </c:forEach>
             </ul>
        </c:if>
    </div>
    </li>
</c:forEach>
    </ul>
