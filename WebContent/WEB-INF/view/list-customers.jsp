<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<main>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<div id="content">
			<input type="button" 
				   value="Add Customer"
				   class="add-button"
				   onclick="window.location.href='showFormForAdd'; return false;"/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td> ${customer.firstName} </td>
							<td> ${customer.lastName} </td>
							<td> ${customer.email} </td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</main>
</body>
</html>