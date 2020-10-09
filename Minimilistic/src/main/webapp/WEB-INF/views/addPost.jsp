<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/add" method="POST" modelAttribute="userpost">
<div>
<label>Title: </label>
<input type="text" name="title"></input></br></br>
<label>Description: </label>
<textarea rows="5" cols="20" maxlength="200" name="description"></textarea>
</br></br>
<button type="submit">POST</button>



</div>


</form>
</body>
</html>