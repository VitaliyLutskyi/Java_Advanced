<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
	<h3>Enter your data</h3>
	
	<form action="registration" method="post">
        <label>Name: <input type="text" name="firstName"></label><br>
        <label>Surname: <input type="text" name="lastName"></label><br>
        <label>Age: <input type="number" name="age"></label><br>
        <label>Address: <input type="text" name="address"></label><br>
        <label>eMail: <input type="email" name="eMail"></label><br>
        <label>Password: <input type="password" name="password"></label><br>
        <label>Role: <input type="text" name="role"></label><br>
        <input type=submit value="Register">   
    </form>
    
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>