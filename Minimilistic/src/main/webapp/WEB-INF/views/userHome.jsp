<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<body>
<div>
<form action="/addPost" method="GET"><button id="post" type="submit">Add Post</button></form>

<form action="/deletePost" method="GET"></form>
</div>
<div>
<c:choose>
<c:when test="${posts.size() >=1 }">
<c:forEach var="post" items="${posts}" >
<div>
<form  action="/editPost" method="POST">
<input  style="display: none" id="pid" name="pid" value="${post.pid }"></input> 
<p>${post.title}</p>
<p id="description" name="description" >${post.description}</p>
<p>${post.time}</p>
<button id="editPost" type="button" onclick="editDescription()">Edit Post</button>
<button id="deletePostById" type="button" onclick="deletePost(${post.pid})" >Delete Post </button>
<button id="savePost" type="submit" style="display: none" >Save</button>

</form>
</div>
                            
</c:forEach>
</c:when>
<c:otherwise>
<div><p>No Posts</p></div>
</c:otherwise>
</c:choose>

</div>
</body>
<script type="text/javascript">

function editDescription()
{
	var text= document.getElementById("description").innerHTML;
	textArea = document.createElement('textarea');
	textArea.rows=5;
	textArea.cols=20;
	textArea.maxlength=200;
	textArea.name="description";
	textArea.innerHTML=text;
	document.getElementById("description").replaceWith(textArea);
	document.getElementById("editPost").style.display='none';
	document.getElementById("savePost").style.display='block';
	console.log(text);
}

function deletePost(pid)
{
	$.ajax('/deletePost', {
	    type: 'POST',  // http method
	    data: { id: pid },  // data to submit
	    success: function (data, status, xhr) {
	    	location.reload();
	        alert("Post deleted Successfully");
	    },
	    error: function (jqXhr, textStatus, errorMessage) {
	    	 alert("Some error occured");
	    }
	});
	
	
}

</script>
</html>