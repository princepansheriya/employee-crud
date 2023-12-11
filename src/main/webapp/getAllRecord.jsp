<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

h1 {
	color: #333;
}

table {
	border-collapse: collapse;
	width: 90%;
	margin: 20px auto;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #4caf50;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

a {
	text-decoration: none;
	color: #3498db;
}

a:hover {
	color: #1e87f0;
}

.no-records {
	margin: 20px auto;
	text-align: center;
	color: #555;
}
</style>
</head>
<body>
	<h1>Users List</h1>

	<%@ page import="java.util.List"%>
	<%@ page import="com.ignek.dao.EmployeeDao"%>
	<%@ page import="com.ignek.model.Employee"%>

	<%
	List<Employee> list = EmployeeDao.getAllRecords();

	if (list != null && !list.isEmpty()) {
	%>

	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile-number</th>
			<th>Gender</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
		for (Employee u : list) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getFirstName()%></td>
			<td><%=u.getLastName()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getMobileNumber()%></td>
			<td><%=u.getGender()%></td>


			<td><a
				href="<%=request.getContextPath()%>/update?id=<%=u.getId()%>">Edit</a></td>



			<td><a
				href="<%=request.getContextPath()%>/deleteUser?id=<%=u.getId()%>">Delete</a></td>

		</tr>
		<%
		}
		%>
	</table>

	<%
	} else {
	out.println("<div class='no-records'>No records found.</div>");
	}
	%>
</body>
</html>
