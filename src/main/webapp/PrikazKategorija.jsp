<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz kategorija</title>
</head>
<body>
	<form action="/Videoteka/filmovi/getFilm" method="get">
		Naziv kategorije:
		<select name="kategorija">
			<c:forEach items="${kategorije }" var="k">
				<option value="${k.naziv}">${k.naziv}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="Prikaz">
	</form>
</body>
</html>