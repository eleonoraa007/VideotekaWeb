<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<meta charset="ISO-8859-1">
<title>Videoteka</title>
</head>
<body>
<div class="sidenav">
	<a href="/Videoteka/auth/getSvi">Lista filmova</a><br/>
	<a href="/Videoteka/filmovi/getKategorije">Kategorije</a><br>
	<a href="/Videoteka/filmovi/getZanrovi">Zanrovi</a><br>
	<a href="/Videoteka/PretragaFilma.jsp">Prikaz glumaca za izabrani film</a><br/>
	<security:authorize access = "isAuthenticated()">
		<a href="/Videoteka/filmovi/getPodaci">Unos filma</a><br/>
		<a href="/Videoteka/filmovi/getPodaci1">Unos glumca</a><br/>
		<a href="/Videoteka/auth/logout">Odjava</a>
	</security:authorize>
</div>
</body>
</html>