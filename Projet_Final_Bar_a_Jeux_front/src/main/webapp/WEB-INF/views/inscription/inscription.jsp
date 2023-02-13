<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<base href="${pageContext.request.contextPath}/">
</head>

<body>

	<div class="container">
		<h1>Page inscription nouveaux clients</h1>

		<form:form action="client" method="post" modelAttribute="client">
			<div class="form-group">
				<form:label path="civilite">civilite</form:label>
				<form:select path="civilite" items="${civilites}"
					cssClass="form-control"></form:select>
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
			</div>
<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" cssClass="form-control" />
			</div>
<div class="form-group">
				<form:label path="mail">mail:</form:label>
				<form:input path="mail" cssClass="form-control" />
			</div>
<div class="form-group">
				<form:label path="password">mot de passe:</form:label>
				<form:input path="password" cssClass="form-control" />
			</div>
<div class="form-group">
				<form:label path="tel">téléphone:</form:label>
				<form:input path="tel" cssClass="form-control" />
			</div>


			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="formateur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>

	</div>

</body>
</html>