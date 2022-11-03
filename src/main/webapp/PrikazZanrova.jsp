<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz zanrova</title>
</head>
<body>
	<form action="/Videoteka/filmovi/getFilm1" method="get">
		Naziv zanra:
		<select name="zanr">
			<c:forEach items="${zanrovi}" var="z">
				<option value="${z.naziv}">${z.naziv}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="Prikaz">
	</form>
</body>
</html>