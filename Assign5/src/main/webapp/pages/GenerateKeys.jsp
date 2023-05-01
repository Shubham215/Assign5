<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RSA Keys</title>
</head>
<body>
    <div class="container">
      <h1>Keys</h1>
      <div class="key-container">
        <div class="key">
          <h2>Public Key</h2>
          <pre> ${Keys.publicKey}</pre>
        </div>
       <div class="key">
          <h2>Private Key</h2>
          <pre>${Keys.privateKey}</pre>
       </div>
       </div>
       </div>
      <p style="margin-top: 30px;"><a href="EncryptRSA" style="text-decoration: none; color: #333;">Continue Encryption using RSA</a></p>
</body>
</html>