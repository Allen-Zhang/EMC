/* 
 * Mortgage Calculator Controller
 * @Framework: AngularJS 
 */ 
angular.module('myApp')
	.controller('calculatorCtrl', ['$scope', '$http', function($scope, $http) {
		/*$scope.purchase = '';
		$scope.termInYears = '30';
		$scope.state = '';
		$scope.downPayment = '';
		$scope.loanType = 'fixed';
		$scope.extraPayment = 0;  // enhanced field
		$scope.extraMonth = 0;  // enhanced field
*/		
		
		$scope.purchase = '500000';
		$scope.termInYears = '30';
		$scope.state = 'MA';
		$scope.downPayment = 5;
		$scope.loanType = 'fixed';
		$scope.extraPayment = 2000;  // enhanced field
		$scope.extraMonth = 20;  // enhanced field
		
		
		$scope.loan = [];  // loan object for request body
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
		$scope.downPaymentList = {' 5%' : 5, '10%' : 10, '15%' : 15, '20%' : 20, '25%' : 25, '30%' : 30};
		
		/*
		 * Get months for extraMonth
		 */
		$scope.getMonths = function(termInYears) {
			var range = [];
			for (var i = 0; i <= termInYears * 12; i++) {
		        range.push(i);
		    }
			return range;
		};
		$scope.months = $scope.getMonths($scope.termInYears);
		
		// FAQ
		$scope.purchaseQuest = 'The total amount paid by a buyer to a seller for the purchase of property.';
		$scope.termInYearsQuest = 'The period of time during which a loan must be repaid. For example, a 30-year fixed loan has a term of 30 years. Also called term. See also: maturity date.';
		$scope.loanTypeQuest = 'The loan type refers to the loan product selected by the borrower at the time of application such as adjustable-rate mortgage or conventional 30-year fixed-rate mortgage.';
		$scope.downPaymentQuest = 'The amount of cash you pay toward the purchase of your home to make up the difference between the purchase price and your mortgage loan. Down payments often range between 5% and 20% of the sales price depending on many factors, including your loan, your lender, your credit history, and so forth.';
		$scope.extraPaymentQuest = 'The additional payment for each month.';
		$scope.extraMonthQuest = 'The number of months to pay the additional payment for each month.';
		
		/*
		 * Get real loan type base on termInYears, loanType
		 */
		$scope.getRealLoanType = function(termInYears, loanType) {
			if (termInYears == 15)
				return '15_fix';
			else if (termInYears == 20)
				return '20_fix';
			else if (termInYears == 30) {
				if (loanType == 'fixed')
					return '30_fix';
				else if (loanType == '5_year_arm')
					return '30_arm_5';
				else if (loanType == '7_year_arm')
					return '30_arm_7';
				else if (loanType == '10_year_arm')
					return '30_arm_10';
			} else
				return '';
		};
		
		/* 
		 * Calculate monthly payment
		 */
		$scope.calculate = function() {		
			$scope.loan.push({
				'purchase' : $scope.purchase, 
				'termInYears' : $scope.termInYears, 
				'state' : $scope.state, 
				'downPayment' : $scope.downPayment, 
				'loanType' : $scope.getRealLoanType($scope.termInYears, $scope.loanType),
				'extraPayment' : $scope.extraPayment == '' ? 0 : $scope.extraPayment,
				'extraMonth' : $scope.extraMonth == '' ? 0 : $scope.extraMonth
			});
			// Object that send to server
			var dataObj = {
					purchase : $scope.purchase,
					termInYears : $scope.termInYears,
					state : $scope.state,
					downPayment : $scope.downPayment,
					loanType : $scope.getRealLoanType($scope.termInYears, $scope.loanType),
					extraPayment : $scope.extraPayment == '' ? 0 : $scope.extraPayment,
					extraMonth : $scope.extraMonth == '' ? 0 : $scope.extraMonth
			};	
			$http.post('result.html', dataObj)
			.success(function(data, status, headers, config) {
				$scope.results = data;
			})
			.error(function(data, status, headers, config) {
				alert("failure message: " + JSON.stringify({data : data}));  // JSON.stringify() converts a JavaScript value to a JSON string
			});		
		};
		
		/*
		 * Toggle loan type radio buttons
		 */
		$scope.isFixedSelected = function() {
			return $scope.termInYears == 30 ? false : true;
		};
		
		/*
		 * Show extra payment column on result page 
		 */
		$scope.showExtraPaymentColumn = function() {
			return ($scope.extraPayment != 0 && $scope.extraMonth != 0) ? true : false; 
		};
	}]);