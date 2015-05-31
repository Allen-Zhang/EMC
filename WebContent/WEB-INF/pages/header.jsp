<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<!-- Application Header -->
<div id="header" class="container">
	<nav class="navbar navbar-default" style="border:none; background-color: #FFFFFF;"> 
	<!-- EMC Logo -->
	<div class="navbar-header">
		<a href="home.html"><img src="" alt="EMC Logo"></a>
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#appNav">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span>
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
	</div>
	<!-- Navigation Tabs -->
	<div class="collapse navbar-collapse navbar-right" id="appNav">
		<ul class="nav navbar-nav">
			<li><a href="home.html">Home</a></li>
			<li><a href="calculator.html">Calculator</a></li>
			<li class="dropdown">
				<a href="" class="dropdown-toggle" data-toggle="dropdown">Sign In <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<form action="<c:url value='/j_spring_security_check'/>" method="post" class="login-form">
						<div class="form-group">
							<label for="email">Username</label> 
							<input type="text" class="form-control" name="j_username" id="j_username" placeholder="Username">
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<input type="password" class="form-control" name="j_password" id="j_password" placeholder="Password">
						</div>
						<div class="checkbox">
							<label><input type="checkbox" name="rememberMe" checked> Remember me for 90 days</label>
						</div>
						<a href="#">Forgot Password?</a>
						<button type="submit" class="btn btn-primary pull-right">Sign In</button>
					</form>
				</ul>
			</li>
			<li><a href="signup.html">Sign Up</a></li>
			<li><a href="updatePassword.html">Update P</a></li>
			<li><a href="updateEmail.html">Update E</a></li>
		</ul>
	</div>
	</nav>
	<hr/>
</div>
</body>
</html>