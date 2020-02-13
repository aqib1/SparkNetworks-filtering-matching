<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spark networks</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<style>
.vr {
	border-left: 2px solid black;
	height: 100%;
	width: 2px;
	color: black;
	left: 2%;
}
</style>
</head>
<div class="container">
	<div class="jumbotron">
		<h2 class="display-4">Spark networks - Filter matching</h2>
		<hr class="my-4">
		<p>Filter matching application powered by spark networks</p>
	</div>
	<nav class="navbar navbar-light bg-light">
		<form class="form-inline">
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Photo
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Contact
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Favorite
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Compatibility
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Age
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Height
				</label>
			</div>
			<div class="navbar-brand">
				<label> <input type="checkbox" data-toggle="toggle">
					Distance
				</label>
			</div>
			<div class="navbar-brand nav navbar-nav navbar-right">
				<button class="btn btn-primary" type="submit">Search</button>
			</div>
		</form>
	</nav>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
</html>