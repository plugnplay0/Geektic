<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Geektic - Résultats de la recherche</title>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/specific.css"/>
	</head>
	
	<body>
		<div class="form-signin">
			<div class="submit" align="center"><a href="/Geektic/accueil"><input type="button" value="Retourner aux critères"/></a></div>
			<table>
				<tr>
					<th>ID</th>
					<th>Pseudo</th>
					<th>Sexe</th>
					<th>Age</th>
					<th>Centres d'intérêt</th>
				</tr>
				<c:forEach var="geek" items="${geeks}">
					<tr>
						<td>${geek.id}</td>
						<td><a href="/Geektic/profil?id=${geek.id}"><c:out value="${geek.pseudo}"/></a></td>
						<td>
							<c:if test="${geek.sexe eq 'h'}">
								<img class="imgSexe" src="/Geektic/images/Geek.png" alt="Geek"/>
							</c:if>
							<c:if test="${geek.sexe eq 'f'}">
								<img class="imgSexe" src="/Geektic/images/Geekette.png" alt="Geekette"/>
							</c:if>
						</td>
						<td>${geek.age}</td>
						<td>
							geek.interets
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
	
</html>