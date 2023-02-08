<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>

<div class="container">
<h1>Page inscription nouveaux clients</h1>
<form action="client" method="post">
			<div class="form-group">
				<label for="civilite">civilite:</label> <select name="civilite"
					class="form-control">
					<c:forEach var="civilite" items="${civilite}">
						<option value="${civilite}">${civilite}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="id.nom">nom:</label> <input id="id.prenom" name="id.prenom"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id.prenom">prenom:</label> <input id="id.password" name="id.password"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id.mail">mail:</label> <input id="id.mail" name="id.mail"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id.password">mot de passe:</label> <input id="id.password" name="id.password"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id.password">retaper votre mot de passe:</label> <input id="id.password" name="id.password"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id.tel">téléphone:</label> <input id="id.tel" name="id.tel"
					class="form-control">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="client" class="btn btn-link">annuler</a>
			</div>
		</form>


</div>

</body>
</html>