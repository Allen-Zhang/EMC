<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="calculatorModule">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mortgage Calculator</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/justified-nav.css">
<!-- <script>
	angular.module("mainModule", []).controller("mainController", function($scope, $interval, $http) {
		// Initialization
		$scope.stocksArray = [];
		$interval(function() { 
			$http({  // AJAX call
				method: "GET",
				url: "market.html",
			}).success(function(data) {
				$scope.stocksArray = data;
			}).error(function(data) {
				alert("AJAX Error!");
			});
		}, 2000);
	});	
</script> -->
<script type="text/javascript" src="js/angular.min.js"></script>
<script>
	angular.module("calculatorModule", []).controller("calculatorCtrl", ['$scope', '$http', function($scope, $http) {
		$scope.loan = [];
		//$scope.monthlyPayment = '';
		$scope.calculateMonthlyPayment = function(){		
			$scope.loan.push({'purchase' : $scope.purchase, 'termInYears' : $scope.termInYears, 
				'interestRate' : $scope.interestRate, 'downPayment' : $scope.downPayment});
			// Writing it to the server
			var dataObj = {
					purchase : $scope.purchase,
					termInYears : $scope.termInYears,
					interestRate : $scope.interestRate,
					downPayment : $scope.downPayment
			};	
			$http.post('result.html', dataObj)
			.success(function(data, status, headers, config) {
				$scope.monthlyPayment = data;
			})
			.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data : data}));  // JSON.stringify() converts a JavaScript value to a JSON string
			});		
			// Making the fields empty
			$scope.purchase='';
			$scope.termInYears='';
			$scope.interestRate='';
			$scope.downPayment='';
		};
	}]);
</script>
</head>
<body ng-controller="calculatorCtrl">
<div class="container">
	<h1>Mortgage Calculator</h1>
	<nav>
	<ul class="nav nav-justified">
		<li class="active"><a href="#">Home</a></li>
		<li><a href="#">Calculator</a></li>
		<li><a href="#">Result</a></li>
		<li><a href="#">Interest Rate</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Contact</a></li>
	</ul>
	</nav>
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
		      		<button type="submit" class="btn btn-primary">Calculate</button>
		    	</div>
		  	</div>       
		</form>
		<h2>Monthly payment is: {{monthlyPayment}}</h2>
	</div>
</div>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>  
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>