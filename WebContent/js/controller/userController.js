/* 
 * Mortgage Calculator Controller
 * @Framework: AngularJS 
 */ 
angular.module("myApp")
	.controller("userCtrl", ['$scope','$http',function($scope,$http){
		// Making the fields empty
		$scope.username='';
		$scope.password='';
		$scope.email='';

		$scope.user = [];
		$scope.register = function(){	
			$scope.user.push({'username' : $scope.username, 'password' : $scope.password, 
				'email' : $scope.email});
			// Writing it to the server
			var dataObj = {
					username : $scope.username,
					password : $scope.password,
					email : $scope.email
//					username : 'Di',
//					password : 'diaoyakun',
//					email : 'diaoyakun@gmail.com'
			};	
			$http.post('register.html', dataObj)
			.success(function(data, status, headers, config) {
				$scope.userInfo = data;
			})
			.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data : data}));  // JSON.stringify() converts a JavaScript value to a JSON string
			});		
		
		};
	}]);