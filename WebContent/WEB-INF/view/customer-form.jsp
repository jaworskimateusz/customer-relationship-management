<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Add Customer</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<h3>Save customer</h3>
			<div id="content">
			<form:form action="saveCustomer" modelAttribute="customer"
						method="POST" >
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear: both">
				<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			</div>
			</div>
		</div>
	</div>
</body>
</html>