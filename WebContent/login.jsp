<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>
<legend>Login</legend>

<form action="LoginServlet" method="POST">

<lebel>email</lebel>
<input type="email" name="email">

<br>

<lebel>Password</lebel>
<input type="password" name="password">

<button type="submit">Submit</button>

</form>
</fieldset>


</body>
</html>