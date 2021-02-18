<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<jsp:include page="externalLinks.html" />

</head>
<body>
	<jsp:include page="genericNavbar.jsp" />
	<div class="container">
		
			<h2>Login</h2> 
			<hr>
		
			<form action="LoginServlet" method="POST">

				<div class="form-group">
					<lebel>Email</lebel>
					<input type="email" name="email">
				</div>

				<div class="form-group">
					<lebel>Password</lebel>
					<input type="password" name="password">
				</div>

				<div class="form-group">
					<button type="submit">Submit</button>
				</div>
			</form>

	</div>
	
</body>
</html>