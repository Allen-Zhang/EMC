<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/justified-nav.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<!-- Application Header -->
	<jsp:include page="header.jsp" />
	<!-- Application Content -->
	<div class="content">
		<jsp:include page="${content}" />
	</div>
	<!-- Application Footer -->
	<div class="footer">
		<jsp:include page="footer.jsp" />
	</div>
	
	<!-- Introduce Javascript File -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/validation.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/angular.min.js"></script>
	<script src="js/myApp.js"></script>
</body>
</html>