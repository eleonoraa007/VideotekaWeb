<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos glumca</title>
</head>
<body>
	<form action="/Videoteka/filmovi/saveGlumac" method="post">
		<table>
			<tr><td>Ime:</td><td><input name="ime"></td></tr>
			<tr><td>Prezime:</td><td><input name="prezime"></td></tr>
			<tr><td>Filmovi:</td>
				<td>
					<select name="filmovi" multiple>
						<c:forEach items="${filmovi}" var="f">
							<option value="${f.idFilm}">${f.naziv}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td><input type="submit" value="Sacuvaj"></td></tr>
		</table>
	</form>
	${poruka }
</body>
</html>