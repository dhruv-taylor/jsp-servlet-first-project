<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<jsp:include page="externalLinks.html" />
</head>
<body>

<jsp:include page="genericNavbar.jsp" />



<div class="container">
	<h2>Register</h2>
	<hr>

	<form method="post" id="registerUser">
		<div class="form-group">
			<label for="name">Name</label> <input type="text" id="name"
				name="name">
		</div>

		<div class="form-group">
			<label for="email">Email</label> <input type="email" id="email"
				name="email">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				id="password" name="password">
		</div>
		<div class="form-group">
			<label for="gender">Gender</label> <input type="checkbox"
				name="gender" value="male">Male <input type="checkbox"
				name="gender" value="female">Female
		</div>
		<div class="form-group">
			<label for="about">About</label>
			<textarea name="about" id="about"></textarea>
		</div>

		<div class="form-group">
			<input type="checkbox" name="term" value="1">Accept all term
			and condition<br>
		</div>
		<div class="form-group">
			<input type="submit" value="submit">
		</div>
	</form>
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script>
		$(document).ready(function() {
			console.log("loaded script...");

			$('#registerUser').on('submit', function(event) {
				event.preventDefault();

				let form = new FormData(this);

				$.ajax({
					url : "RegisterUser",
					method : "POST",
					data : form,
					success : function(data, textStatus, jqXHR) {
						console.log(textStatus);
						alert(textStatus);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(textStatus);
						alert(textStatus);
					},
					processData : false,
					contentType : false
				})
			})

		})
	</script>


</body>
</html>