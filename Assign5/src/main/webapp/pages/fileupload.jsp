<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
    <h1 style="color: #333;">Upload a File</h1>
    <form action="UploadFile" method="post" enctype="multipart/form-data">
      <label for="filename" style="display: block; margin-bottom: 10px;">Filename:</label>
      <input type="text" id="key" name="key" style="display: block; width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-sizing: border-box; margin-bottom: 20px;">
      <label for="file" style="display: block; margin-bottom: 10px;">Select a file:</label>
      <input type="file" id="file" name="file" style="display: block; margin-bottom: 20px;">
      <input type="submit" value="Upload" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; text-decoration: none; cursor: pointer;">
    </form>
    <p style="margin-top: 30px;"><a href="Landing" style="text-decoration: none; color: #333;">Back to Homepage</a></p>
  </body>
</html>