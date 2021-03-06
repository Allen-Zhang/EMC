<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Interest Rate</title>
</head>
<body ng-controller="adminCtrl">
<!-- Prompt message -->
<jsp:include page="../prompt.jsp" />

<!-- Main body -->
<h3>Update Interest Rate</h3>
<form id="updateInterestForm" class="form-horizontal" action="updateInterestRate.html" method="POST">
	<div class="form-group">                    
        <label for="state" class="col-sm-4 control-label"><font color="red">* </font>State</label>
        <div class="col-sm-6">
	        <select class="form-control" name="state" id="state" ng-model="state" 
	        	ng-options="key for (key, value) in stateList"
	        	ng-change="getCurrentInterestRate()">
	      		<option value=""></option>
	    	</select>
		</div>
    </div>
    <div class="form-group">                    
        <label for="loanType" class="col-sm-4 control-label"><font color="red">* </font>Loan Type</label>
        <div class="col-sm-6">
	        <select class="form-control" name="loanType" id="loanType" ng-model="loanType" 
	        	ng-options="key for (key, value) in loanTypeList"
	        	ng-change="getCurrentInterestRate()">
	      		<option value=""></option>
	    	</select>
		</div>
    </div>
    <div class="form-group"> 
    	<label for="rate" class="col-sm-4 control-label">Yearly Interest Rate</label>
    	<div class="col-sm-6">                   
		<div class="input-group">
			<div class="input-group-addon">%</div>
			<input type="text" class="form-control" name="newInterestRate" id="newInterestRate" 
				ng-model="rate" ng-disabled="enableInterestRateInput()">
		</div>
	</div>
    </div>
    <div class="form-group">
    	<div class="col-sm-offset-4 col-sm-6">
      		<button type="reset" class="btn btn-primary">Reset</button>
      		<button type="submit" id="updateInterestBtn" class="btn btn-primary">Update</button>
    	</div>
    </div>
</form>
<script src="js/controller/adminController.js"></script>
</body>
</html>