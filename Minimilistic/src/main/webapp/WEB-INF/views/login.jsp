<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/SignUp</title>
</head>
<body>
<form action="/logincheck" method="post" modelAttribute="user">
<label>UserName: </label>
<input type="text" name="username"></input>
<label>Password: </label>
<input type="text" name="password"></input>
<button type="submit">Login</button>
</form>
<form id="signUpForm" action="/signUp" method="get" >
<a href="#" onclick="submit()">New User? Sign Up</a>
</form>
<div><p style="color: red">${loginError}</p></div>
<div><p style="color: green">${success}</p></div>
</body>


<script type="text/javascript">
function submit()
{
	
	document.getElementById("signUpForm").submit();	
}

</script>
</html>