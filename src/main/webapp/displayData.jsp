<%@ page import="java.util.List"%>
<%@ page import="com.ignek.model.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 20px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

.no-records {
	margin-top: 10px;
}
</style>
<script>
        $(document).ready(function() {
           
            var contextPath = "<%=request.getContextPath()%>";

				function loadData() {
					$.ajax({
						type : 'GET',
						url : contextPath + '/employeeList',
						dataType : 'json',
						success : function(data) {

							var employeeList = data;

							$('table tbody').empty();

							$.each(employeeList, function(index, employee) {
								var row = "<tr>" + "<td>" + employee.id
										+ "</td>" + "<td>" + employee.firstName
										+ "</td>" + "<td>" + employee.lastName
										+ "</td>" + "<td>" + employee.email
										+ "</td>" + "<td>"
										+ employee.mobileNumber + "</td>"
										+ "<td>" + employee.gender + "</td>"
										+ "<td><a href='" + contextPath
										+ "/update?id=" + employee.id
										+ "'>Edit</a></td>" + "<td><a href='"
										+ contextPath + "/deleteUser?id="
										+ employee.id + "'>Delete</a></td>"
										+ "</tr>";
								$('table tbody').append(row);
							});

							if (employeeList.length === 0) {
								$('.no-records').show();
							} else {
								$('.no-records').hide();
							}
						},
						error : function(error) {
							console.error('Error loading data: '
									+ error.responseText);
						}
					});
				}

				loadData();
			});
</script>
</head>
<body>

	<h1>Users List</h1>

	<table>
		<thead>
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
		</thead>
		<tbody>

		</tbody>
	</table>

	<div class='no-records' style='display: none;'>No records found.</div>

</body>
</html>
