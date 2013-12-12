<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
       value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="nl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css" />
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />

        <h1>Admin</h1>
        <form method='post' action='<c:url value="adminpagina"/>'>
            <select name="items">
                <c:forEach var='item' items='${items}'>
                    <option value='${item.id}'>${item.omschrijving}</option>
                </c:forEach>            
            </select>
            <select name="lokaties">
                <c:forEach var='lokatie' items='${lokaties}'>
                    <option value='${lokatie.id}'>${lokatie.beschrijving}</option>
                </c:forEach>            
            </select>
            <input type="submit" value="Toevoegen"/>
        </form>
    </body>
</html>

