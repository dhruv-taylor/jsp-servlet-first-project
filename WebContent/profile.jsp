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
<meta charset="UTF-8">
<title>User Profile | xyz</title>
</head>
<body>

	<h1>Hellow User</h1>

	<div class="userDetails">
		<table>
			<tr>
				<td>Name:</td>
				<td><%=user.getName()%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><%=user.getGender()%></td>
			</tr>
			<tr>
				<td>About:</td>
				<td><%=user.getAbout()%></td>
			</tr>
		</table>


		<button class="userUpdateButton">Update</button>

	</div>

	<div class="userUpdate">
		<table>
			<form action="EditUserServlet" method="POST" enctype="multipart/form-data">
				<tr>
					<td>Image:</td>
					<td><img src="pics/<%=user.getProfile()%>"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="<%=user.getName()%>"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" value="<%=user.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><input type="text" name="gender" value="<%=user.getGender()%>" disable><%=user.getGender()%></td>
					<!-- <td><input type="radio" name="gender" value="male">male  <input type="radio" name="gender" value="female">Female</td> -->
				</tr>
				<tr>
					<td>About:</td>
					<td><textarea name="about"><%=user.getAbout()%></textarea></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><input type="file" name="image"></td>
				</tr>


				<tr>
					<td><button type="submit">Submit</button></td>
					<td></td>
				</tr>
			</form>
		</table>
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