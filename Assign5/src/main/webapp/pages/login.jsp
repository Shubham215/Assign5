<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
	<h1 style="color: #333;">Login</h1>
	<form action="Auth" method="post" style="width: 300px; margin: auto;">
	<label for="username" style="display: block; margin-bottom: 10px;">Username:</label>
      <input type="text" id="username" name="username" style="padding: 10px; border-radius: 5px; border: none; background-color: #fff; margin-bottom: 20px; width: 100%;"><br>
      <label for="password" style="display: block; margin-bottom: 10px;">Password:</label>
      <input type="password" id="password" name="password" style="padding: 10px; border-radius: 5px; border: none; background-color: #fff; margin-bottom: 20px; width: 100%;"><br>
      <input type="submit" value="Login" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; cursor: pointer;"><br>
	  <p style="margin-top: 20px;">Don't have an account? <a href="SignUp">Sign up</a></p>
	</form>
</body>
</html>