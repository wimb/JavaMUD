<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="karakter" items="${karakters}">
    <li>
    <div class="karakter">
        ${karakter.naam}
    </div>
    </li>
</c:forEach>
</ul>