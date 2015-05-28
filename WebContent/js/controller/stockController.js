/* 
 * Stock Controller
 * @Framework: AngularJS 
 */ 
angular.module("myApp")
	.controller("stockCtrl", function($scope, $interval, $http) {
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