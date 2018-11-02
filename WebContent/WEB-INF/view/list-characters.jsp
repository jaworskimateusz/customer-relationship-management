<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Fast and Furious characters</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Fast and Furious</h2>
		</div>
		<div id="container">
			<div id="content">
			<input type="button" value="Add new" class="save" 
					onclick="window.location.href='add'; return false;"/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Car</th>
						<th>Edit</th>
					</tr>
					<c:forEach var="hero" items="${heroes}">
						<c:url var="updateLink" value="/heroes/update">
							<c:param name="heroId" value="${hero.id}"/>
						</c:url>
						<c:url var="deleteLink" value="/heroes/delete">
							<c:param name="heroId" value="${hero.id}"/>
						</c:url>
						<tr>
							<td> ${hero.firstName} </td>
							<td> ${hero.lastName} </td>
							<td> ${hero.car} </td>
							<td>
								<a href="${updateLink}"> Update</a>
								<a href="${deleteLink}"> Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>