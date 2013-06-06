<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Geektic</title>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/bootstrap/css/bootstrap.css"/>
	</head>
	
	<body>
		<h1>Rechercher un geek ou une geekette</h1>
		<form id="rechercheForm" method="get" action="/rechercher">
			<fieldset>
				<legend>Recherche par identité</legend>
				<input type="text" name="pseudo" placeholder="Pseudo"/><br/>
				<input type="text" name="nom" placeholder="Nom"/><br/>
				<input type="text" name="prenom" placeholder="Prénom"/><br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par sexe</legend>
				<input type="radio" name="sexe" value="h"/>Geek<br/>
				<input type="radio" name="sexe" value="f"/>Geekette<br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par âge</legend>
				Mini :<input type="text" name="agemin"/><br/>
				Maxi :<input type="text" name="agemax"/><br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par centres d'intérêt</legend>
				...
			</fieldset>
		</form>
	</body>
	
</html>