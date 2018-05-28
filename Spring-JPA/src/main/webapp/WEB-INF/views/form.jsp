<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
</head>
<body>
<h2>Add New User</h2>
<form method="POST" action="/spring-mvc/saveUser">
  Username:<br>
  <input type="text" name="username"><br>

  Name:<br>
  <input type="text" name="name"><br>

  Select a role:
  <select name="role">
  	<c:forEach items="${roles}" var="role">
	    <option value="${role.id}">${role.name}</option><br>
	</c:forEach>
  </select><br>	

  Enabled:
  <input type="checkbox" name="enabled" checked><br>
  <input type="submit" value="Add User">
</form>
</body>
</html>