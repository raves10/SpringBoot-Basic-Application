<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
         .error {
         color: red
         }
      </style>
</head>
<body>
<form action="/register" method="post" modelAttribute="user">
<label>First Name: </label>
<input type="text" name="firstName"></input>
<form:errors path="firstName" cssClass="error" /><br/>
<label>Last Name: </label>
<input type="text" name="lastName"></input>
<form:errors path="lastName" cssClass="error" /><br/>
<label>UserName: </label>
<input type="text" name="username"></input>
<form:errors path="username" cssClass="error" /><br/>
<label>Password: </label>
<input type="text" name="password"></input>
<form:errors path="password" cssClass="error" /><br/>
<label>Email: </label>
<input type="text" name="email"></input>
<form:errors path="email" cssClass="error" /><br/>
<label>Location: </label>
<input type="text" name="location"></input><br/>
<button type="submit">Register</button>
<div>
${user}
</div>
</form>
<div><p style="color: red">${error}</p></div>
</body>
</html>

