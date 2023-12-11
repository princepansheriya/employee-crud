<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.male {
	display: inline-block;
}

.container {
	width: 30%;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin: 10px 0 5px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="radio"] {
	margin-right: 5px;
	margin-bottom: 5px; 

input[type="submit"], input[type="reset"] {
	width: 48%;
	background-color: #4caf50;
	color: #fff;
	padding: 10px;
	border: none;
	cursor: pointer;
	display: inline-block;
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<div class="container">
		<form
			action="<%=request.getContextPath()%>/register" 
			method="post">
			<input type="hidden" name="id"
				value="<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		? ((com.ignek.model.Employee) request.getAttribute("employee")).getId()
		: "")%>">

			<label for="firstName">First Name:</label> <input type="text"
				id="firstName" name="firstName"
				value="<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		? ((com.ignek.model.Employee) request.getAttribute("employee")).getFirstName()
		: "")%>"
				required> <label for="lastName">Last Name:</label> <input
				type="text" id="lastName" name="lastName"
				value="<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		? ((com.ignek.model.Employee) request.getAttribute("employee")).getLastName()
		: "")%>"
				required> <label for="email">Email:</label> <input
				type="email" id="email" name="email"
				value="<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		? ((com.ignek.model.Employee) request.getAttribute("employee")).getEmail()
		: "")%>"
				required> <label for="mobileNumber">Mobile Number:</label> <input
				type="text" id="mobileNumber" name="mobileNumber"
				value="<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		? ((com.ignek.model.Employee) request.getAttribute("employee")).getMobileNumber()
		: "")%>"
				required> <label>Gender:</label> <label for="male" id="male">Male</label>
			<input type="radio" id="male" name="gender" value="male" required
				<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		&& ((com.ignek.model.Employee) request.getAttribute("employee")).getGender().equals("male") ? "checked" : "")%>>

			<label for="female">Female</label> <input type="radio" id="female"
				name="gender" value="female" required
				<%=((com.ignek.model.Employee) request.getAttribute("employee") != null
		&& ((com.ignek.model.Employee) request.getAttribute("employee")).getGender().equals("female") ? "checked"
				: "")%>>

			<div>
				<input type="reset" value="Reset"> <input type="submit"
					value="Submit">
			</div>
		</form>
	</div>

	
	
	<jsp:include page="displayData.jsp" />
</body>
</html>
