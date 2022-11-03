<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista filmova</title>
</head>
<body>
	<table border="1">
		<tr><th>Naziv filma</th><th>Ocena</th><th>Cena</th><th>Opis</th></tr>
		<c:forEach items="${film}" var="f">
			<tr>
				<td>${f.naziv}</td>
				<td>${f.ocena}</td>
				<td>${f.cena}</td>
				<td>${f.opis}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>