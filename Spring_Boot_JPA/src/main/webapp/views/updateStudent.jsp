<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Student</h2>
<form action="updateStud">
	<input type="hidden" name="id" value="${udpateId}"><br>
	Enter name:<br>
	<input type="text" name="name"><br>
	Enter technology:<br>
	<input type="text" name="tech"><br>
	<input type="submit" value="submit"><br>
</form>
</body>
</html>