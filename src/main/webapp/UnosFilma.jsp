<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos filma</title>
</head>
<body>
	<form action="/Videoteka/filmovi/saveFilm" method="post">
		<table>
			<tr><td>Naziv:</td><td><input name="naziv"></td></tr>
			<tr><td>Ocena:</td><td><input name="ocena"></td></tr>
			<tr><td>Opis:</td><td><input name="opis"></td></tr>
			<tr><td>Cena:</td><td><input name="cena"></td></tr>
			<tr><td>Zanrovi:</td>
				<td>
					<select name="zanrovi" multiple>
						<c:forEach items="${zanrovi}" var="z">
							<option value="${z.idZanr}">${z.naziv }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td>Glumci:</td>
				<td>
					<select name="glumci" multiple>
						<c:forEach items="${glumci}" var="g">
							<option value="${g.idGlumac}">${g.ime} ${g.prezime}</option>
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