<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="item" items="${items}">    
    <li>
    <div class="item">
        ${item.omschrijving}1
        <c:if test="${not empty item.acties}">2
            <ul>
            <c:forEach var="actie" items="${item.acties}">
                <li>${actie.omschrijving}</li>3
            </c:forEach>
             </ul>
        </c:if>
    </div>
    </li>
</c:forEach>
    </ul>