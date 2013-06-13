<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Geektic</title>
		<link rel="stylesheet" type="text/css" href="/Geektic/css/bootstrap.css"/>
		<style type="text/css">
			body {
				background-image: url("/Geektic/images/Background-Geek-Love.png");
				background-repeat: no-repeat;
				background-position: fixed;
				background-size: cover;
			}
			.form-signin .form-signin-heading {
				margin-bottom: 10px;
			}
			.form-signin input[type="text"], .form-signin input[type="password"] {
				font-size: 16px;
				height: auto;
				margin-bottom: 15px;
				padding: 7px 9px;
			}
			div.submit {
				margin-bottom: 10px;
			}
			div.submit input {
				font-size: 14pt;
				height: 40px;
			}
			.form-signin {
				max-width: 570px;
				padding: 19px 29px 29px;
				margin: 0 auto 20px;
				background-color: orange;
				border: 1px solid #e5e5e5;
				-webkit-border-radius: 5px;
				-moz-border-radius: 5px;
				border-radius: 5px;
				-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
				-moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
				box-shadow: 0 1px 2px rgba(0,0,0,.05);
			}
			input.radioSexe {
				margin-top: 12px;
			}
			img.imgSexe {
				max-height: 40px;
			}
		</style>
	</head>
	
	<body>
		<form class="form-signin" id="rechercheForm" method="get" action="/rechercher">
			<div class="submit" align="center"><input type="submit" value="Lancer la recherche"/></div>
			<fieldset>
				<legend>Recherche par identité</legend>
				<input type="text" name="pseudo" placeholder="Pseudo"/><br/>
				<input type="text" name="nom" placeholder="Nom"/><br/>
				<input type="text" name="prenom" placeholder="Prénom"/><br/>
			</fieldset>
			<fieldset>
				<legend>Recherche par sexe</legend>
				<label class="radio"><input class="radioSexe" type="radio" name="sexe" value="h"/><img class="imgSexe" src="/Geektic/images/Geek.png"/></label>
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
