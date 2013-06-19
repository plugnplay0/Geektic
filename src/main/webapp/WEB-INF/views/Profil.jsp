<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>Geektic - Profil de <c:out value="${geek.pseudo}"/></title>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/specific.css"/>
	</head>
	
	<body>
		<div class="form-signin">
			<div class="submit" align="center"><a href="/Geektic/accueil"><input type="button" value="Nouvelle recherche"/></a></div>
			<fieldset>
				<legend>
					<c:if test="${geek.sexe eq 'h'}">
						<img class="imgSexe" src="/Geektic/images/Geek.png" alt="Geek"/>
					</c:if>
					<c:if test="${geek.sexe eq 'f'}">
						<img class="imgSexe" src="/Geektic/images/Geekette.png" alt="Geekette"/>
					</c:if>
					&nbsp;&nbsp;<c:out value="${geek.pseudo}"/>
				</legend>
				<p>
					<strong>Nom :</strong> <c:out value="${geek.nom}"/><br/>
					<strong>Prénom :</strong> <c:out value="${geek.prenom}"/><br/>
					<strong>Date de naissance :</strong> <fmt:formatDate value="${geek.dtnaiss}" type="date" dateStyle="long"/><br/>
					<strong>Age :</strong> <c:out value="${geek.age}"/> ans
				</p>
				<p>
					<strong>Adresse e-mail :</strong> <c:out value="${geek.mail}"/>
				</p>
				<p>
					<strong>Centres d'intérêt :</strong><br/>
					<ul>
						<c:forEach var="interet" items="${geek.interets}">
							<li><c:out value="${interet.libelle}"/></li>
						</c:forEach>
					</ul>
				</p>
				<p class="consult">
					${nbConsults} consultation(s)
				</p>
			</fieldset>
		</div>
	</body>
	
</html>