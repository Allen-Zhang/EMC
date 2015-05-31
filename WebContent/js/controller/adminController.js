/* 
 * Mortgage Calculator Controller
 * @Framework: AngularJS 
 */
angular.module("myApp")
	.controller("adminCtrl", ['$scope','$http',function($scope,$http){
		// Making the fields empty
		$scope.state='';
		$scope.loanType='';

		$scope.loan = [];
		$scope.updateInterest = function(){	
			$scope.loan.push({'state' : $scope.state, 'loanType' : $scope.loanType});
			// Writing it to the server
			var dataObj = {
					state : $scope.state,
					loanType : $scope.loanType
			};	
			$http.post('result.html', dataObj)
			.success(function(data, status, headers, config) {
				$scope.interest = data;
			})
			.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data : data}));  // JSON.stringify() converts a JavaScript value to a JSON string
			});		
		
		};
	}]);