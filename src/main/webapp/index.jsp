<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
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
<div class="main">
<div class="center" style="font-size:20px; text-align:center;">
<i>Dobrodosli na portal videoteke. <br/><br/>
	Kako biste nastavili sa radom, molimo prijavite se klikom na
	<a href="/Videoteka/auth/loginPage">Link</a>
</i>
</div>
</div>
</body>
</html>