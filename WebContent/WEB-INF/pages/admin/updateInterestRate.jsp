<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Interest Rate</title>
</head>
<body ng-controller="adminCtrl">
<div class="container">
	<h3>Update Interest</h3>
	<form id="updateInterestForm" class="form-horizontal" ng-submit="updateInterest()">
		<div class="form-group">                    
	        <label for="state" class="col-sm-3 control-label"><font color="red">* </font>State</label>
	        <div class="col-sm-9">
		        <select class="form-control" ng-model="state" ng-options="key for (key, value) in stateList">
		      		<option value=""></option>
		    	</select>
			</div>
	    </div>
	    <div class="form-group">                    
	        <label for="loanType" class="col-sm-3 control-label"><font color="red">* </font>Loan Type</label>
	        <div class="col-sm-9">
		        <select class="form-control" ng-model="loanType" ng-options="key for (key, value) in loanTypeList">
		      		<option value=""></option>
		    	</select>
			</div>
	    </div>
	    <div class="form-group">                    
	        <label for="interestRate" class="col-sm-3 control-label"><font color="red">* </font>Interest Rate</label>
	        <div class="col-sm-9">
		        <select class="form-control" ng-model="interestRate" ng-disabled="">
		      		<option value=""></option>
		    	</select>
			</div>
	    </div>

	    <div class="form-group">
	    	<div class="col-sm-offset-3 col-sm-9">
	      		<button type="reset" class="btn btn-primary">Reset</button>
	      		<button type="submit" id="updateInterestBtn" class="btn btn-primary">Update</button>
	    	</div>
	    </div>
	</form>
</div>
</body>
</html>