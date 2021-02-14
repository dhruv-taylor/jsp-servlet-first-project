<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<form method="post" id="registerUser">
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	console.log("loaded script...");
	
	$('#registerUser').on('submit', function(event)
	{
		event.preventDefault();
		
		let form =new FormData(this);
		
		$.ajax({
			url:"RegisterUser",
			method: "POST",
			data: form,
			success: function(data, textStatus, jqXHR) {
				console.log(textStatus);
				alert(textStatus);
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				console.log(textStatus);
				alert(textStatus);
			},
			processData:false,
			contentType:false
		})		
	})
	
})

</script>


</body>
</html>