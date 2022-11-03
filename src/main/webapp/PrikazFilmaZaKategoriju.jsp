<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz filmova</title>
</head>
<body>
	Prikaz filmova iz kategorije: ${naziv}
	<table border="1">
		<tr>
			<th>Naziv filma</th>
			<th>Opis</th>
			<th>Ocena</th>
			<th>Cena</th>
		</tr>
		<c:forEach items="${filmovi}" var="f">
			<tr>
				<td>${f.film.naziv}</td>
				<td>${f.film.opis}</td>
				<td>${f.film.ocena}</td>
				<td>${f.film.cena}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>