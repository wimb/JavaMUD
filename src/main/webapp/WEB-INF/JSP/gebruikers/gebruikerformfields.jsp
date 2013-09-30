<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<form:label path="gebruikerNaam">gebruikerNaam:
<form:errors path="gebruikerNaam" cssClass="fout" />
</form:label>
<form:input path="gebruikerNaam" />

<form:label path="paswoord">paswoord:
<form:errors path="paswoord" cssClass="fout" />
</form:label>
<form:input path="paswoord" />

<form:label path="emailAdres">EmailAdres:
<form:errors path="emailAdres" cssClass="fout" />
</form:label>
<form:input path="emailAdres" />

<form:label path="voornaam">voornaam:
<form:errors path="voornaam" cssClass="fout" />
</form:label>
<form:input path="voornaam" />

<form:label path="familienaam">familienaam:
<form:errors path="familienaam" cssClass="fout" />
</form:label>
<form:input path="familienaam" />