<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="protect" method="post">
<input type="file" name="userfileString"><br>
<h3>Enter owner password</h3>
<input type="password" name="ownerPassword" placeholder="owner password">
<h3>Enter user password</h3>
<input type="password" name="userPassword" placeholder="user Password">
<input type="submit">
</form>
</body>
</html>