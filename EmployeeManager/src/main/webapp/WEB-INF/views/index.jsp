<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"
	; charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Employee Manager Home</title>
</head>
<body>

<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #ff4000">
			<div>
				<a> Employee Management  
				
				</a>
			</div>
   
		</nav>
	</header>

<p><a href="#" class="text-light bg-dark">
	Current Time:<%=java.util.Calendar.getInstance().getTime()%></a></p>
	<div align="center">
		<h1>Employee List</h1>
		<h3>
		<div class="p-3 mb-2 bg-transparent text-dark">
			<a href="new">New Employee</a>
			</div>
		</h3>
		<div class="table-responsive-sm">
		<div class="p-3 mb-2 bg-light text-dark">

			<table border="1" cellpadding="10">
				<tr>
				<th><p><a href="#" class="text-light bg-dark">No</a></p></th>
					
					<th><p><a href="#" class="text-light bg-dark">Name</a></p></th>
					<th><p><a href="#" class="text-light bg-dark">Email</a></p></th>
					<th><p><a href="#" class="text-light bg-dark">Address</a></p></th>
					<th><p><a href="#" class="text-light bg-dark">Phone</a></p></th>
					<th><p><a href="#" class="text-light bg-dark">Aciton</a></p></th>
				</tr>
				<c:forEach items="${listContact}" var="contact" varStatus="status">
					<tr>
						<td>${status.index +1}</td>
						<td>${contact.name}</td>
						<td>${contact.email}</td>
						<td>${contact.address}</td>
						<td>${contact.phone}</td>
						<td><a href="edit?id=${contact.id}" >Edit</a> &nbsp;&nbsp; <a
							href="delete?id=${contact.id}" >Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			
		</div>
	</div>
</body>
</html>