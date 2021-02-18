<%@page import="com.dao.CategoryDao"%>
<%@page import="com.entities.Category"%>
<%@page import="blog.helper.ConnectionProvider"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Posts</title>
<jsp:include page="externalLinks.html" />
</head>
<body>
	
	<jsp:include page="genericNavbar.jsp" />

	<div class="container">
		<h2>Post Add</h2>
		<form action="SavePostServlet" method="POST"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>

			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" id="content"
					placeholder="Enter Content" name="content"></textarea>
			</div>

			<div class="form-group">
				<label for="code">Code</label>
				<textarea class="form-control" id="code" placeholder="Enter Code"
					name="code"></textarea>
			</div>

			<div class="form-group">
				<label for="category">Category</label> <select class="form-control"
					name="category">
					<%
					CategoryDao catDao = new CategoryDao(ConnectionProvider.getConnection());
					ArrayList<Category> list = catDao.getCategories();
					for (Category c : list) {
					%>
					<option value="<%=c.getId()%>"><%=c.getName()%></option>
					<%
					}
					%>
				</select>
			</div>
			
			<div class="form-group">
				<input type="file" name="pic">	
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>	
			</div>
			
		</form>
	</div>

</body>
</html>