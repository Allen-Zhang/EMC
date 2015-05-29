/* 
 * Mortgage Calculator Controller
 * @Framework: AngularJS 
 */ 
angular.module("myApp")
	.controller("calculatorCtrl", ['$scope','$http',function($scope,$http){
		$scope.loan = [];
		$scope.purchase='';
		$scope.termInYears='';
		$scope.state='';
		$scope.downPayment='';
		
		$scope.calculateMonthlyPayment = function(){		
			$scope.loan.push({'purchase' : $scope.purchase, 'termInYears' : $scope.termInYears, 
				'state' : $scope.state, 'downPayment' : $scope.downPayment});
			// Writing it to the server
			var dataObj = {
					purchase : $scope.purchase,
					termInYears : $scope.termInYears,
					state : $scope.state,
					downPayment : $scope.downPayment
			};	
			$http.post('result.html', dataObj)
			.success(function(data, status, headers, config) {
				$scope.monthlyPayment = data;
			})
			.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data : data}));  // JSON.stringify() converts a JavaScript value to a JSON string
			});		
		};
	}]);