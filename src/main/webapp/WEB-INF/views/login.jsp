<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Employee timesheet management</h1>
  <hr>

 <form action="timesheet" method="get">
  <label for="username">Username:</label><br>
  <input type="text" id="username" name="username" value=""><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" value=""><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>