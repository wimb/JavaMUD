<%-- 
    Document   : hoofdmenu
    Created on : Oct 1, 2013, 10:30:36 AM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaMUD - Hoofdmenu</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <div id="noscript">
            Deze website gebruikt JavaScript voor een goede werking.
            Op het moment is JavaScript niet actief op uw browser.
            Dit kan problemen geven, waar wij ons voor verontschuldigen.
        </div>
        <script>
            var eNoScript = document.getElementById("noscript");
            eNoScript.style.display = "none";
        </script>
        
        <c:choose>
            <c:when test="${not empty gebruiker}">
                <c:url var="gebruikerURL" value="/gebruiker">
                </c:url>
                <a href="${gebruikerURL}">Gegevens Gebruiker</a>
                <div id="nieuwKarakter">
                    <a href="<c:url value='karakter/nieuw'/>">Nieuw karakter</a>
                
                <c:import url="/WEB-INF/JSP/fouten.jsp"/>
                <jsp:include page="karakters/karakterlijsthoofdmenu.jsp"/>               
                <div id="afmelden">
                    <a href="<c:url value='j_spring_security_logout'/>">Afmelden</a>
                </div>
            </c:when>
            <c:otherwise>
                <div id="aanmelden">
                    <a href="<c:url value='aanmelden'/>">Aanmelden</a>
                </div>
            </c:otherwise>
        </c:choose>
                <c:if test="${isAdmin}">
                    <a href="<c:url value='adminpagina'/>">Adminpagina</a>
                </c:if>
    </body>
</html>
