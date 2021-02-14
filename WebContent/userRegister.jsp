<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<form action="RegisterUser" method="post">
<label>Name</label>
<input type="text" name="name"> <br>
<label>Email</label>
<input type="email" name="email"> <br>
<label>Password</label>
<input type="password" name="password"> <br>
<label>Gender</label>
<input type="checkbox" name="gender" value="male">Male
<input type="checkbox" name="gender" value="female">Female <br>
<label>about</label>
<textarea name="about"></textarea>
<br>
<input type="checkbox" name="term" value="1">Accept all term and condition<br>

<hr>
<input type="submit" value="submit">
</form>


</body>
</html>