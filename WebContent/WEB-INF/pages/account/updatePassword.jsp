<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
</head>
<body>
<div class="container">
	<h3>Update Password</h3>
	<form id="updatePassowrdForm" class="form-horizontal" action="changePassword.html" method="post">
		<div class="form-group">                    
	        <label for="oldPassword" class="col-sm-3 control-label"><font color="red">* </font>Old Password</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="Old Password">
	        </div>
	    </div>
		<div class="form-group">                    
	        <label for="newPassword" class="col-sm-3 control-label"><font color="red">* </font>New Password</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="New Password">
	        </div>
	    </div>
	    <div class="form-group">                    
	        <label for="confirmedPassword" class="col-sm-3 control-label"><font color="red">* </font>Confirmed Password</label>
	        <div class="col-sm-9">
				<input type="password" class="form-control" id="confirmedPassword" name="confirmedPassword" placeholder="Confirmed Password">
	        </div>
	    </div>
	    <div class="form-group">
	    	<div class="col-sm-offset-3 col-sm-9">
	      		<button type="reset" class="btn btn-primary">Reset</button>
	      		<button type="submit" id="updatePasswordBtn" class="btn btn-primary">Update</button>
	    	</div>
	    </div>
	</form>
</div>
</body>
</html>