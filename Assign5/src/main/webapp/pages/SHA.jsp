<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHA-256</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
    <h1 style="color: #333;">Secure Hashing</h1>
    <form action="HashCheck" method="post" enctype="multipart/form-data">
      <label for="Hash" style="display: block; margin-bottom: 10px;">Hash Algorithm:</label>
      <input type="text" id="Hash" name="Hash" value="SHA-256" placeholder="SHA-256" style="display: block; width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-sizing: border-box; margin-bottom: 20px;">
      <label for="file1" style="display: block; margin-bottom: 10px;">Select first file:</label>
      <input type="file" id="file1" name="file1" style="display: block; margin-bottom: 20px;">
      <label for="file2" style="display: block; margin-bottom: 10px;">Select second file:</label>
      <input type="file" id="file2" name="file2" style="display: block; margin-bottom: 20px;">
      
      <input type="submit" value="Upload" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; text-decoration: none; cursor: pointer;">
    </form>
    <p style="margin-top: 30px;"><a href="Landing" style="text-decoration: none; color: #333;">Back to Homepage</a></p>
  </body>
</html>