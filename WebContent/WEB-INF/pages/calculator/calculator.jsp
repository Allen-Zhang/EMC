<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mortgage Calculator</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/justified-nav.css">
<link rel="stylesheet" href="../css/bootstrap-formhelpers.min.css">
</head>
<body ng-controller="calculatorCtrl">
<div class="container">
	<!-- Application Header -->
	<div>
		<h1><font color="blue">Enhanced Mortgage Calculator</font></h1>
	</div>
	<hr/>
	
	<!-- Mortgage Calculator Content -->
	<h3>Mortgage Calculator</h3>
	<div role="tabpanel">
		<!-- Nav Tabs -->
		<ul class="nav nav-justified" role="tablist" id="calculatorNav">
			<li role="presentation" class="active">
				<a href="#calculatorPane" aria-controls="calculatorPane" role="tab" data-toggle="tab">Calculator</a>
			</li>
			<li role="presentation">
				<a href="#resultPane" aria-controls="resultPane" role="tab" data-toggle="tab">Result</a>
			</li>
			<li role="presentation">
				<a href="#chartPane" aria-controls="chartPane" role="tab" data-toggle="tab">Chart</a>
			</li>
		</ul>
		<br/>
		
		<!-- Tab Panes -->
		<div class="tab-content">
			<!-- Calculator Pane -->
			<div role="tabpanel" class="tab-pane active" id="calculatorPane">
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
				    <div class="form-group">                    
				        <label for="state" class="col-sm-3 control-label"><font color="red">* </font>State</label>
				        <div class="col-sm-9">
				            <input type="text" class="form-control" id="state" name="state" placeholder="State" ng-model="state">
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
				      		<button type="submit" id="calculatorBtn" class="btn btn-primary" >Calculate</button>
				    	</div>
				  	</div>       
				</form>
			</div>
			
			<!-- Result Pane -->
			<div role="tabpanel" class="tab-pane" id="resultPane">
				<h2>Monthly payment is: {{monthlyPayment}}</h2>
			</div>
			
			<!-- Chart Pane -->
			<div role="tabpanel" class="tab-pane" id="chartPane">
				Chart
			</div>
		</div>
	</div>
	
	<!-- Application Footer -->
	<div>
		<h1><font color="blue">Footer Here...</font></h1>
	</div>
</div>
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/angular.min.js"></script>
<script src="../js/myApp.js"></script>
<script src="../js/controller/calculatorController.js"></script>
</body>
</html>