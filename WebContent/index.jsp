<%@page import="blog.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page errorPage="error_page.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Blog | Homepage </title>

<!-- css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/generic.css"></link> 
<%-- <jsp:include page="externalLinks.html" /> --%> 
</head>
<body>

<!-- common navbar -->

<jsp:include page="genericNavbar.jsp" />

<div class="conteiner">

<h1>Homepage</h1>

<%--

<%
	Connection con = ConnectionProvider.getConnection();
%>

<h1>connection Verification : </h1> <%= con %>
--%>

</div>

<!-- javascript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
<script src="javascript/generic.js"></script>  
</body>
</html>