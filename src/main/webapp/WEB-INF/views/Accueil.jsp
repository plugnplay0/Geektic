<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Geektic</title>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/specific.css"/>
	</head>
	
	<body>
		<form class="form-signin" id="rechercheForm" method="get" action="/Geektic/accueil/rechercher">
			<div class="submit" align="center"><input type="submit" value="Lancer la recherche"/></div>
			<fieldset>
				<legend>Recherche par identité</legend>
				<input type="text" name="pseudo" placeholder="Pseudo"/><br/>
				<input type="text" name="nom" placeholder="Nom"/><br/>
				<input type="text" name="prenom" placeholder="Prénom"/><br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par sexe</legend>
				<label class="radio"><input class="radioSexe" type="radio" name="sexe" value="h"/><img class="imgSexe" src="/Geektic/images/Geek.png" alt="Geek"/></label>
				<label class="radio"><input class="radioSexe" type="radio" name="sexe" value="f"/><img class="imgSexe" src="/Geektic/images/Geekette.png"/></label>
			</fieldset>
			<fieldset>
				<legend>Recherche par âge</legend>
				Mini :&nbsp;&nbsp;<input type="text" name="agemin"/><br/>
				Maxi :&nbsp;&nbsp;<input type="text" name="agemax"/><br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par centres d'intérêt</legend>
				<c:forEach var="interet" items="${interets}">
					<label class="checkbox"><input type="checkbox" name="interet" value="${interet.id}"/><c:out value="${interet.libelle}"/></label>
				</c:forEach>
			</fieldset>
			<input type="submit" value="Rechercher"/>
		</form>
	</body>
	
</html>
