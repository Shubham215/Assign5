<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
	<h1 style="color: #333;">Welcome!</h1>
	<p>Thank you for signing up. Here is your account information:</p>
	<ul style="list-style: none; padding: 0;">
	<li><strong>Username:</strong>${User.username}</li>
      <li><strong>Password:</strong>${User.password}</li>
      <li><strong>Private Key:</strong>${User.pvtkey}</li>
    </ul>
    <p>Make sure to keep your private key safe and secure. Use it to encrypt files for AES.</p>
    <a href="/" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; text-decoration: none; cursor: pointer;">Log In</a>
</body>
</html>