<%-- 
    Document   : index
    Created on : Sep 30, 2013, 12:48:08 PM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:url var="lokatieURL" value="/lokatie">
            <c:param name="lokatieId" value="1"/>
        </c:url>
        <a href="${lokatieURL}">Lokatie</a>
    </body>
</html>
