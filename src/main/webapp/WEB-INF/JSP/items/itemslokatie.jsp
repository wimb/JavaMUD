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
<<<<<<< HEAD:src/main/webapp/WEB-INF/JSP/items/itemlijst.jsp
                
                <c:url var="actieURL" value="/lokatie/actie">
                  <c:param name="itemId" value="${item.id}"/>
                  <c:param name="actie" value="${actie.readableIdentifier}"/>                  
                </c:url>
                  ${item.id}
                <form action="${actieURL}" method="post">
                <input type="submit" value="${actie}"/>
                </form>
                
=======
>>>>>>> 401fba2b095623530793011ae96c0aab09e70111:src/main/webapp/WEB-INF/JSP/items/itemslokatie.jsp
            </c:forEach>
             </ul>
        </c:if>
    </div>
    </li>
</c:forEach>
    </ul>
