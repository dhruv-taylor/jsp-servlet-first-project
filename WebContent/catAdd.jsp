<%@page import="javax.servlet.http.*"%>
<%@page import="com.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Panel</title>

<jsp:include page="externalLinks.html" />

</head>
<body>
	<jsp:include page="genericNavbar.jsp"></jsp:include>

	<div class="container">
		<h1>Category Crud</h1>
			
			
			<%
			
			Message mss = (Message) session.getAttribute("msg");
			if(mss != null)
			{
				%>
				<%= mss.getData() %>
				<%
			}
			
			
			%>


		<form action="saveCategory" method="POST">

			<div class="form-group">
				<label for="name">Name</label> <input type="text" name="name"
					id="name" class="form-control">
			</div>

			<div class="form-group">
				<label for="name">Description</label> <input type="text"
					name="description" id="description" class="form-control">
			</div>

			<div class="form-group">
				<button class="form-control btn btn-primary">Submit</button>
			</div>

		</form>
	</div>


</body>
</html>