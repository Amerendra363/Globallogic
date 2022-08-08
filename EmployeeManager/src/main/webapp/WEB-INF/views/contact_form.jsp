<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>New/Edit Employee</title>

</head>

<body >
	<div align="center">
		<h1>New/Edit Employee</h1>
		<form:form action="save" method="post" modelAttribute="contact">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td >Name:</td>
					<td><form:input path="name" placeholder="Enter name"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" placeholder="Enter email"/></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" placeholder="Enter address"/></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><form:input path="phone" placeholder="Enter phone number"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" style="background-color:blue;color:white;"	value="Save" /></td>
				</tr>
			</table>
		</form:form>
</body>
</html>