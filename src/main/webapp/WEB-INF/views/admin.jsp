<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <p> Timesheet admin to add new project </p>
 <p> Property file value ${message} </p>
 <p> Property file value ${port} </p>
 
 <form action="timesheet" method="post">
  <label for="Project name">ProjectName:</label><br>
  <input type="text" id="projectname" name="projectname" value=""><br>
  <input type="submit" value="Submit">
</form> 
 
</body>
</html>