<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@page import="com.entities.User"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Profile | xyz</title>
<jsp:include page="externalLinks.html" />
</head>
<body>
	
	<jsp:include page="genericNavbar.jsp" />

	<div class="container">
		<h1>Hellow User</h1>

		<div class="userDetails">

			<div class="row">
				<label for="#" class="col-sm-6" for="content">Name</label>
				<p class="col-sm-6"><%=user.getName()%></p>
			</div>

			<div class="row">
				<label for="#" class="col-sm-6" for="content">Email</label>
				<p class="col-sm-6"><%=user.getEmail()%></p>
			</div>

			<div class="row">
				<label for="#" class="col-sm-6" for="content">Gender</label>
				<p class="col-sm-6"><%=user.getGender()%></p>
			</div>

			<div class="row">
				<label for="#" class="col-sm-6" for="content">About</label>
				<p class="col-sm-6"><%=user.getAbout()%></p>
			</div>

			<div class="row">
				<button class="userUpdateButton col-md-auto">Update</button>
			</div>
		</div>



		<div class="userUpdate">

			<form action="EditUserServlet" method="POST"
				enctype="multipart/form-data">

				<div class="form-group">
					<label for="#">Image:</label> <img width="50"
						src="pics/<%=user.getProfile()%>">
				</div>

				<div class="form-group">
					<label for="#">Name:</label> <input type="text" name="name"
						value="<%=user.getName()%>">
				</div>

				<div class="form-group">
					<label for="#">Email:</label> <input type="email"
						name="email" value="<%=user.getEmail()%>">
				</div>

				<div class="form-group">
					<label for="#">Gender:</label> <input type="text"
						name="gender" value="<%=user.getGender()%>">
				</div>

				<div class="form-group">
					<label for="#">About:</label>
					<textarea name="about"><%=user.getAbout()%></textarea>
				</div>

				<div class="form-group">
					<label for="#">Image</label> <input type="file" name="image">
				</div>


				<div class="form-group">
					<button type="submit">Submit</button>
				</div>

			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script>
		$(document).ready(function() {
			$(".userUpdate").hide();

			$(".userUpdateButton").on('click', function() {

				$(".userDetails").hide();
				$(".userUpdate").show();

			});

		})
	</script>
</body>
</html>