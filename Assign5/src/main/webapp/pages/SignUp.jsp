<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
	<h1 style="color: #333;">Sign Up</h1>
	<form action="AddUser" method="post" style="width: 300px; margin: auto;">
	<label for="username" style="display: block; margin-bottom: 10px;">Username:</label>
    <input type="text" id="username" name="username" style="padding: 10px; border-radius: 5px; border: none; background-color: #fff; margin-bottom: 20px; width: 100%;"><br>
    <label for="password_size" style="display: block; margin-bottom: 10px;">Password Size:</label>
      <select id="password_size" name="passwordSize" style="padding: 10px; border-radius: 5px; border: none; background-color: #fff; margin-bottom: 20px; width: 100%;">
        <option value="8">8</option>
        <option value="12">12</option>
        <option value="16">16</option>
        <option value="20">20</option>
      </select><br>
      <label for="role" style="display: block; margin-bottom: 10px;">Role:</label>
      <input type="radio" id="admin" name="role" value="admin" style="margin-right: 5px;"><label for="admin" style="margin-right: 20px;">Admin</label>
      <input type="radio" id="user" name="role" value="user" style="margin-right: 5px;"><label for="user">User</label><br><br>
      <input type="submit" value="Sign Up" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; cursor: pointer;">
   
    </form>

</body>
</html>