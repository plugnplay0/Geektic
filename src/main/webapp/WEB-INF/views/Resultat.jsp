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
					<th class="cell10">ID</th>
					<th class="cell20">Pseudo</th>
					<th class="cell10">Sexe</th>
					<th class="cell10">Age </th>
					<th class="cell50">Centres d'intérêt</th>
				</tr>
				<c:forEach var="geek" items="${geeks}">
					<tr>
						<td class="cell10">${geek.geekId}</td>
						<td class="cell20">
							<a href="/Geektic/profil?geekId=${geek.geekId}"><c:out value="${geek.pseudo}"/></a>
						</td>
						<td class="cell10">
							<c:if test="${geek.sexe eq 'h'}">
								<img class="imgSexe" src="/Geektic/images/Geek.png" alt="Geek"/>
							</c:if>
							<c:if test="${geek.sexe eq 'f'}">
								<img class="imgSexe" src="/Geektic/images/Geekette.png" alt="Geekette"/>
							</c:if>
						</td>
						<td class="cell10">${geek.age}</td>
						<td class="cell50 centresInteret">
							<c:forEach var="interet" items="${geek.interets}">
								${interet.libelle}&nbsp;&nbsp;
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
	
</html>