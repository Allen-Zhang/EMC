<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mortgage Calculator</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/justified-nav.css">
</head>
<body ng-controller="calculatorCtrl">
<div class="container">
	<h1>Mortgage Calculator</h1>
	<nav>
	<ul class="nav nav-justified">
		<li class="active"><a href="#">Home</a></li>
		<li><a href="#">Calculator</a></li>
		<li><a href="#">Result</a></li>
		<li><a href="#">Chart</a></li>
		<li><a href="#">Interest Rate</a></li>
	</ul>
	</nav>
	<br/>
	<div>
		<form class="form-horizontal" ng-submit="calculateMonthlyPayment()">
			<div class="form-group">                    
		        <label for="purchase" class="col-sm-3 control-label"><font color="red">* </font>Purchase price</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		      			<div class="input-group-addon">$</div>
		            	<input type="text" class="form-control" id="purchase" name="purchase" placeholder="Purchase price" ng-model="purchase">
		            </div>
		        </div>
		    </div>
			<div class="form-group">                    
		        <label for="termInYears" class="col-sm-3 control-label"><font color="red">* </font>Loan term</label>
		        <div class="col-sm-9">
		            <input type="text" class="form-control" id="termInYears" name="termInYears" placeholder="Term of loan in years" ng-model="termInYears">
		        </div>
		    </div>
		<!--     <div class="form-group">                    
		        <label for="state" class="col-sm-3 control-label"><font color="red">* </font>State</label>
		        <div class="col-sm-9">
		            <input type="text" class="form-control" id="state" name="state" placeholder="State">
		        </div>
		    </div> -->
		    <div class="form-group">                    
		        <label for="state" class="col-sm-3 control-label"><font color="red">* </font>Interest Rate</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
			            <input type="text" class="form-control" id="interestRate" name="interestRate" placeholder="Interest Rate" ng-model="interestRate">
			            <div class="input-group-addon">%</div>
		            </div>
		        </div>
		    </div>
		    <div class="form-group">                    
		        <label for="downPayment" class="col-sm-3 control-label"><font color="red">* </font>Down payment</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="text" class="form-control" id="downPayment" name="downPayment" placeholder="Down payment" ng-model="downPayment">
		            	<div class="input-group-addon">%</div>
		            </div>
		        </div>
		    </div>
		    <div class="form-group">
		    	<div class="col-sm-offset-3 col-sm-9">
		      		<button type="reset" class="btn btn-primary">Reset</button>
		      		<button type="submit" class="btn btn-primary" >Calculate</button>
		    	</div>
		  	</div>       
		</form>
		<h2>Monthly payment is: {{monthlyPayment}}</h2>
	</div>
</div>
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/angular.min.js"></script>
<script src="../js/myApp.js"></script>
<script src="../js/controller/calculatorController.js"></script>
</body>
</html>