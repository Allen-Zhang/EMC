<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body ng-controller="calculatorCtrl">
<div class="container">
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
				        <label for="state" class="col-sm-3 control-label"><font color="red">* </font>State</label>
				        <div class="col-sm-9">
					        <select class="form-control" ng-model="state" ng-options="key for (key, value) in stateList">
					      		<option value=""></option>
					    	</select>
						</div>
				    </div>
					<div class="form-group">                    
				        <label for="purchase" class="col-sm-3 control-label"><font color="red">* </font>
				        	Purchase price&nbsp&nbsp
				        	<img alt="Question" src="img/question-icon.png" data-toggle="tooltip" 
				        	data-placement="top" title="{{purchaseQuest}}">
				        </label>
				        <div class="col-sm-9">
				        	<div class="input-group">
				      			<div class="input-group-addon">$</div>
				            	<input type="text" class="form-control" ng-model="purchase">
				            </div>
				        </div>
				    </div>
					<div class="form-group">                    
				        <label for="termInYears" class="col-sm-3 control-label"><font color="red">* </font>
				        	Loan term&nbsp&nbsp
				        	<img alt="Question" src="img/question-icon.png" data-toggle="tooltip" 
				        	data-placement="top" title="{{termInYearsQuest}}">
				        </label>
				        <div class="col-sm-9">
				        	<label class="radio-inline">
							  	<input type="radio" ng-model="termInYears" value="30">30 years
							</label>
							<label class="radio-inline">
							  	<input type="radio" ng-model="termInYears" value="20">20 years
							</label>
							<label class="radio-inline">
							  	<input type="radio" ng-model="termInYears" value="15">15 years
							</label>
				        </div>
				    </div>
				    <div class="form-group">                    
				        <label for="loanType" class="col-sm-3 control-label"><font color="red">* </font>
				        	Loan type&nbsp&nbsp
				        	<img alt="Question" src="img/question-icon.png" data-toggle="tooltip" 
				        	data-placement="top" title="{{loanTypeQuest}}">
				        </label>
				        <div class="col-sm-9">
				        	<label class="radio-inline">
							  	<input type="radio" ng-model="loanType" value="fixed">Fixed rate
							</label>
							<label class="radio-inline">
							  	<input type="radio" ng-model="loanType" ng-disabled="isFixedSelected()" value="5_year_arm">5-year ARM
							</label>
							<label class="radio-inline">
							  	<input type="radio" ng-model="loanType" ng-disabled="isFixedSelected()" value="7_year_arm">7-year ARM
							</label>
							<label class="radio-inline">
							  	<input type="radio" ng-model="loanType" ng-disabled="isFixedSelected()" value="10_year_arm">10-year ARM
							</label>
				        </div>
				    </div>
				    <div class="form-group">                    
				        <label for="downPayment" class="col-sm-3 control-label"><font color="red">* </font>
				        	Down payments&nbsp&nbsp
				        	<img alt="Question" src="img/question-icon.png" data-toggle="tooltip" 
				        	data-placement="top" title="{{downPaymentQuest}}">
				        </label>
				        <div class="col-sm-9">
			            	<select class="form-control" ng-model="downPayment" ng-options="key for (key, value) in downPaymentList">
					      		<option value=""></option>
					    	</select>
				        </div>
				    </div>
				    <div class="form-group">
				    	<div class="col-sm-offset-3 col-sm-9">
				      		<button type="reset" class="btn btn-primary">Reset</button>
				      		<button type="submit" id="calculatorBtn" class="btn btn-primary" >Calculate</button>
				    	</div>
				  	</div>       
				</form>
				<h2>RealLoanType: {{getRealLoanType(termInYears, loanType)}}</h2>
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
</div>
<script src="js/controller/calculatorController.js"></script>
</body>
</html>