<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Fast and Furious characters</title>
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link type="text/css" rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/add-hero-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Fast and Furious</h2>
		</div>
		<div id="container">
		<h3>Add new hero</h3>
			<div id="content">
				<form:form action="" modelAttribute="hero" method="POST">
					<label>First Name:</label>
					<form:input path="firstName"/>
					<label>Last Name:</label>
					<form:input path="lastName"/>
					<label>Car:</label>
					<form:input path="car"/> 
					<br/>
					<input type="submit" value="Save" class="save" />
				</form:form>
			</div>
			<hr/>
			<a href="${pageContext.request.contextPath}/heroes/list">Back</a>
		</div>
	</div>
</body>
</html>