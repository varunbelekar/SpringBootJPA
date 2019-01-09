<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="border">
	<tr>
		<th>Student ID</th>
		<th>Name</th>
		<th>Technology</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="i" items="${studentList}">
		<tr>
			<td>${i.id}</td>
			<td>${i.name}</td>
			<td>${i.tech}</td>
			<td><a href="update/${i.id}">Update</a></td>
			<td><a href="delete/${i.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>