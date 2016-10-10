<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ page session="false" %>
<form action = "LoginController" method="Post">

  <header>Login</header>
  <label>Username <span>*</span></label>
  <input type = "text" name ="username"/>
  <label>Password <span>*</span></label>
  <input type = "password" name ="password"/>
  
  <button>Login</button><br>
  
  <center><font color = "red">${requestScope.errorMessage }</font></center>
</form>
</body>
</html>