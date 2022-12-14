<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prijava</title>
</head>
<body>

<c:url var="loginUrl" value="/login" />
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger">
			<p>Pogresni podaci.</p>
		</div>
	</c:if>
	<form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Korisnicko ime</td>
				<td><input type="text" name="username"
					placeholder="Unesite korisnicko ime" required></td>
			</tr>
			<tr>
				<td>Sifra</td>
				<td><input type="password" name="password"
					placeholder="Unesite sifru" required></td>
			</tr>
			 <tr>
                <td>Zapamti me:</td>
                <td><input type="checkbox" name="remember-me" /></td>
            </tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
				<td><input type="submit" value="Prijava"></td>
			</tr>
		</table><br/><br/>
		Nemate nalog? <a href="/Videoteka/auth/registerUser">Registrujte se</a>
	</form>

</body>
</html>