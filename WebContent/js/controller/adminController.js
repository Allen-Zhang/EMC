/* 
 * Mortgage Calculator Controller
 * @Framework: AngularJS 
 */
angular.module("myApp")
	.controller("adminCtrl", ['$scope','$http',function($scope,$http){
		// Making the fields empty
		$scope.state='';
		$scope.loanType='';
		$scope.interestRate = [];
		$scope.stateList = {
				'Alabama' : 'AL', 'Alaska' : 'AK', 'Arizona' : 'AZ', 'Arkansas' : 'AR', 'California' : 'CA', 
				'Colorado' : 'CO', 'Connecticut' : 'CT', 'Delaware' : 'DE', 'District Of Columbia' : 'DC', 
				'Florida' : 'FL', 'Georgia' : 'GA', 'Hawaii' : 'HI', 'Idaho' : 'ID', 'Illinois' : 'IL', 
				'Indiana' : 'IN', 'Iowa' : 'IA', 'Kansas' : 'KS', 'Kentucky' : 'KY', 'Louisiana' : 'LA', 
				'Maine' : 'ME', 'Maryland' : 'MD', 'Massachusetts' : 'MA', 'Michigan' : 'MI', 'Minnesota' : 'MN', 
				'Mississippi' : 'MS', 'Missouri' : 'MO', 'Montana' : 'MT', 'Nebraska' : 'NE', 'Nevada' : 'NV', 
				'New Hampshire' : 'NH', 'New Jersey' : 'NJ', 'New Mexico' : 'NM', 'New York' : 'NY', 
				'North Carolina' : 'NC', 'North Dakota' : 'ND', 'Ohio' : 'OH', 'Oklahoma' : 'OK', 'Oregon' : 'OR', 
				'Pennsylvania' : 'PA', 'Rhode Island' : 'RI', 'South Carolina' : 'SC', 'South Dakota' : 'SD', 
				'Tennessee' : 'TN', 'Texas' : 'TX', 'Utah' : 'UT', 'Vermont' : 'VT', 'Virginia' : 'VA', 
				'Washington' : 'WA', 'West Virginia' : 'WV', 'Wisconsin' : 'WI', 'Wyoming' : 'WY'
	  		};
		$scope.loanTypeList = {'15_fix' : 'fix_15', '20_fix' : 'fix_20', '30_fix' : 'fix_30',
			'30_arm_5' : 'arm_5', '30_arm_7' : 'arm_7', '30_arm_10' : 'arm_10'};
		$scope.updateInterest = function(){	
			$scope.interestRate.push({'state' : $scope.state, 'loanType' : $scope.loanType});
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