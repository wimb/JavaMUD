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

        <h1>Administratie</h1>
        <c:url var="adminpaginaURL" value="/adminpagina/itemToevoegen"/>
        <div id="itemsToevoegen" class="adminpaneel">
			<h2>Item toevoegen</h2>
            <form method='post' action='${adminpaginaURL}'>
                <select name="itemsCombo" id="itemsCombo">
                    <c:forEach var='item' items='${items}'>
                        <option value='${item}'>${item.omschrijving}</option>
                    </c:forEach>            
                </select>
                <select name="lokatiesCombo" id="itemsCombo">
                    <c:forEach var='lokatie' items='${lokaties}'>
                        <option value='${lokatie.id}'>${lokatie.beschrijving}</option>
                    </c:forEach>            
                </select>
                <input type="submit" value="Toevoegen"/>
            </form>
        </div>
                
        <c:url var="karakterVerplaatsenURL" value="/adminpagina/karakterVerplaatsen"/>
        <div id="karakterVerplaatsen" class="adminpaneel">
			<h2>Karakter verplaatsen</h2>
            <form method="post" action="${karakterVerplaatsenURL}">
				<label>van:</label>
                <select name="karakterCombo" id="karakterCombo">
                    <c:forEach var="karakter" items="${karakters}">
                        <option value="${karakter.id}">${karakter.naam}</option>
                    </c:forEach>
                </select>
				<label>naar</label>
                <select name="karLokCombo" id="karLokCombo">
                    <c:forEach var='lokatie' items='${lokaties}'>
                        <option value='${lokatie.id}'>${lokatie.beschrijving}</option>
                    </c:forEach> 
                </select>
                <input type="submit" value="Verplaatsen"/>
            </form>
        </div>
		
		<div id="afmelden">
            <a href="<c:url value='j_spring_security_logout'/>">Afmelden</a>
        </div>
    </body>
</html>
