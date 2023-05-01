<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Upload</title>
</head>
<body style="background-color: #f2f2f2; text-align: center;">
    <h1 style="color: #333;">Decrypt a File using AES</h1>
	<form action="DecFile" method="post" enctype="multipart/form-data">
	<label for="key" style="display: block; margin-bottom: 10px;">Key:</label>
    <input type="text" id="key" name="key" style="display: block; width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-sizing: border-box; margin-bottom: 20px;">
    <label for="filename" style="display: block; margin-bottom: 10px;">FileName:</label>
    <input type="text" id="file" name="file" style="display: block; width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ccc; box-sizing: border-box; margin-bottom: 20px;">
    <label for="Mode" style="display: block; margin-bottom: 10px;">Mode:</label>
      <input type="radio" id="CFB" name="mode" value="CFB" style="margin-right: 5px;"><label for="CFB" style="margin-right: 20px;">CFB</label>
      <input type="radio" id="CBC" name="mode" value="CBC" style="margin-right: 5px;"><label for="CBC">CBC</label><br><br>
    <input type="submit" value="Upload" style="padding: 10px 20px; border-radius: 5px; border: none; background-color: #333; color: #fff; font-size: 16px; text-decoration: none; cursor: pointer;">
    </form>
    <p style="margin-top: 30px;"><a href="Landing" style="text-decoration: none; color: #333;">Back to Homepage</a></p>
  </body>
</html>