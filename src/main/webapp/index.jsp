<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
	form {
		width: 250px;
		margin: 50px;
	}
	
	label {
		display: flex;
		justify-content: space-between
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<h3>To continue, you must log in to your personal account.</h3>
	
	<form action="login" method="post">
        <label>eMail: <input type="email" name="eMail"></label><br>
        <label>Password: <input type="password" name="password"></label><br>
        <input type=submit value="Sign in">   
    </form>
    <p>Not registered yet? <a href="registration.jsp">Register.</a></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>