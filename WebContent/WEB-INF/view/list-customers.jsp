<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<form:form action="search" method="POST">
				Search customer:
				<input type="text" name="searchName"/>
				<input type="submit" value="Search" class="add-button"/>
			</form:form>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action:</th>
					</tr>
					<c:forEach var="theCustomer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${theCustomer.id}" />
						</c:url>	
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${theCustomer.id}" />
						</c:url>
						<tr>
							<td> ${theCustomer.firstName} </td>
							<td> ${theCustomer.lastName} </td>
							<td> ${theCustomer.email} </td>
							<td>
								<a href="${updateLink}">Update</a>|
								<a href="${deleteLink}"
								   onclick="if(!(confirm('Are you want to delete?'))) return false;">
								Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</main>
</body>
</html>