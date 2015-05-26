<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
	.alert {
		color: red;
		background: #fdf1e5;
		font-size: 10px;
		line-height: 16px;
		width: 200px;
		margin: 10;
		position: relative;
	}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
		if ("<c:out value='${param.login_error}'/>" != "") {
		  	$('#wrongCredentials').show();
		}
		$("#signin").on("click", loginValidation);	
	});

	function loginValidation() {
		$("#usernameAndPasswordReq").hide();
		$("#usernameReq").hide();
		$("#passwordReq").hide();   
		$("#wrongCredentials").hide();	
	  	if($("#j_username").val().length == 0 && $("#j_password").val().length == 0) {
	  		$("#usernameAndPasswordReq").show();
	  		return false;
	  	} else if ($("#j_username").val().length == 0) {
	  		$('#usernameReq').show();
	  		return false;
	  	} else if ($("#j_password").val().length == 0) {
	  		$("#passwordReq").show();
	  		return false;
	  	} else {
	  		return true;
	  	}
	}
</script>


<!-- <script src="js/angular.min.js"></script>
<script>
	angular.module("mainModule", []).controller("mainController", function($scope, $interval, $http) {
		// Initialization
		$scope.stocksArray = [];
		$interval(function() {
			$http({  // AJAX call
				method: "GET",
				url: "market",
			}).success(function(data) {
				$scope.stocksArray = data;
			}).error(function(data) {
				alert("AJAX Error!");
			});
		}, 2000);
	});	
</script>
 -->


</head>
<body>


<%--
<body ng-app="mainModule">
--%>


<h1><font color="blue">Login with Username and Password</font></h1>
<!-- Alerts for missing form info  --> 
<div class="alert" style="display:none;" id="usernameAndPasswordReq">
	<p>Username and password are required</p>
</div>

<div class="alert" style="display:none;" id="usernameReq">
	<p>Username is required</p>
</div>
<div class="alert" style="display:none;" id="passwordReq">
	<p>Password is required</p>
</div>
<div class="alert" id="wrongCredentials" style="display:none;">
	<p>The username or password supplied is incorrect</p>
</div>	
<!-- Login Form -->	
<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST" id="login-form">
	<table>
		<tr>
			<td>Username: </td>
			<td><input type="text" name="j_username" id="j_username"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="j_password" id="j_password"/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button type="reset">Clear</button>
				<button id="signin" type="submit">Login</button>
			</td>
		</tr>
	</table>		
</form>


<%-- 	
<h2>This demo is show real time market data using Angular JS</h2>
<div ng-controller="mainController">
	<h3>Market Data</h3>
	<table id="stockList" border="1" style="width: 500px">
		<tr>
			<th>Stock ID</th>
			<th>Price</th>
			<th>Change</th>
		</tr>
		<tr ng-repeat="stock in stocksArray">
			<td>{{stock.id}}</td>
			<td>{{stock.price}}</td>
			<td>
				<b ng-if="stock.change>0" style="color:green">{{stock.change}}</b>
				<b ng-if="stock.change<0" style="color:red">{{stock.change}}</b>
				<b ng-if="stock.change==0" style="color:black">{{stock.change}}</b>
			</td>
		</tr>
	</table>
</div> 
--%>


</body>
</html>