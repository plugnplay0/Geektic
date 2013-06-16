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
			<div class="submit" align="center"><input type="submit" value="Lancer la recherche"/>&nbsp;&nbsp;<input type="reset" value="Réinitialiser"/></div>
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
				<select name="agemin">
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
				</select><br/>
				<select name="agemax">
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
				</select>
			</fieldset>
			<fieldset>
				<legend>Recherche par centres d'intérêt</legend>
				<select name="interet1">
					<c:forEach var="type" items="${types}">
						<optgroup label="${type.libelle}">
							<c:forEach var="interet" items="${type.interets}">
								<option value="${interet.interetId}">${interet.libelle}</option>
							</c:forEach>
						</optgroup>
					</c:forEach>
				</select><br/>
				<select name="interet2">
					<c:forEach var="type" items="${types}">
						<optgroup label="${type.libelle}">
							<c:forEach var="interet" items="${type.interets}">
								<option value="${interet.interetId}">${interet.libelle}</option>
							</c:forEach>
						</optgroup>
					</c:forEach>
				</select><br/>
				<select name="interet3">
					<c:forEach var="type" items="${types}">
						<optgroup label="${type.libelle}">
							<c:forEach var="interet" items="${type.interets}">
								<option value="${interet.interetId}">${interet.libelle}</option>
							</c:forEach>
						</optgroup>
					</c:forEach>
				</select><br/>
			</fieldset>
		</form>
	</body>
	
</html>
