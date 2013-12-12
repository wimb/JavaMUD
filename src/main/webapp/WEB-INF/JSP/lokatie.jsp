<%-- 
    Document   : lokatie
    Created on : Sep 30, 2013, 3:29:15 PM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="nl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaMUD</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
<link rel="stylesheet" href="${contextPath}/styles/lokatie.css" />
</head>
<body>
    <c:import url="/WEB-INF/JSP/menu.jsp" />
    <h1 class="lokatieTitel">Lokatie ${lokatie.id}</h1>
    <div class="lokatieBescrijving">Omschrijving van lokatie: ${lokatie.beschrijving}</div>
    <div class="lokatieItem">
		<h2>Items</h2>
			<c:forEach var="item" items = "${items}">
				<h3 class="itemOmschrijving">${item.omschrijving}</h3>
				<c:if test="${not empty item.acties}">
				<ul>
				<c:forEach var="actie" items="${item.acties}">
					<li class="actiePerItem">${actie.omschrijving}</li>
						<c:url var="actieURL" value="/lokatie/actie">
						<c:param name="karakterid" value="${karakter.id}"/>
					  <c:param name="itemId" value="${item.id}"/>
					  <c:param name="actie" value="${actie.readableIdentifier}"/>                  
					</c:url>
					<form action="${actieURL}" method="post">
					<input class="actieButton" type="submit" value="${actie}"/>
					</form>
				</c:forEach>
				 </ul>
			</c:if>
        </c:forEach>
            
        <c:if test="${not empty lokatie.items}">
            <c:set var="items" value="${lokatie.items}"/>
            <%@include file="/WEB-INF/JSP/items/itemlijst.jsp"%>
        </c:if>
            
    </div>
	
	<div class="lokatieKarakter">
		<h2>Alle karakters op locatie</h2>
	  
		<c:if test="${not empty lokatie.karakters}">
			<c:set var="karakters" value="${lokatie.karakters}"/>
			<%@include file="/WEB-INF/JSP/karakters/karakterlijstlokatie.jsp"%>
		</c:if>
    </div>    
    <div id="acties" class="acties">
		<c:if test="${not empty lokatie.acties}">
			<c:set var="acties" value="${lokatie.acties}" />
			<%@include file="/WEB-INF/JSP/acties.jsp" %>
		</c:if>
		<c:if test="${not empty karakter.acties}">
			<c:set var="acties" value="${lokatie.acties}" />
			<%@include file="/WEB-INF/JSP/acties.jsp" %>
		</c:if>
	</div>
	
	<c:if test="${not empty actieResultaat}">
		<jsp:include page="/WEB-INF/JSP/actieResultaat.jsp" />
	</c:if>
    <div class="actieRes">
		<c:if test="${not empty message}">
			<p>Actie omschrijving: ${message}</p>
		</c:if>
	</div>
        
</body>
</html>
