<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ include file = "header.jsp" %>

<%@ include file = "footer.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>



<form method ="post"  action= "useradd">
Name : <input type = "text" name="uname"></input>
<br/>
password: <input type="password" name="pass"></input>
<br/>
<button type="submit" class="btn btn-primary">Submit</button>


</form>
</body>
</html>