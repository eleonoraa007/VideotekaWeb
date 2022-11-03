<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz glumaca za film</title>
</head>
<body>
	<form action="/Videoteka/filmovi/pretraziFilmove">
		Naziv filma: <input type="text" name="naziv">
		<input type="submit" value="Pretrazi"><br>
	</form>
	
	<c:if test="${!empty glumi}">
		Prikaz glumca za film: ${film}
		<table border="1">
			<tr>
				<th>Ime glumca</th>
				<th>Prezime glumca</th>
			</tr>
			<c:forEach items="${glumi}" var="g">
				<tr>
					<td>${g.glumac.ime}</td>
					<td>${g.glumac.prezime}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>