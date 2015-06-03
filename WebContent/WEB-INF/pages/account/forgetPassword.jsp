<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
<!-- Prompt message -->
<jsp:include page="../prompt.jsp" />

<!-- Main body -->
<h3>Forget Password</h3>
	<form id="forgetPasswordForm" class="form-horizontal" action="forgetPassword.html" method="post">
		<div class="form-group">                    
	        <label for="username" class="col-sm-4 control-label"><font color="red">* </font>Username</label>
	        <div class="col-sm-6">
	            <input type="text" class="form-control" id="username" name="username" placeholder="Username">
	        </div>
	    </div>
		<div class="form-group">                    
	        <label for="email" class="col-sm-4 control-label"><font color="red">* </font>Email Address</label>
	        <div class="col-sm-6">
	            <input type="email" class="form-control" id="email" name="email" placeholder="Email Address">
	        </div>
	    </div>
	    <div class="form-group">
	    	<div class="col-sm-offset-4 col-sm-6">
	      		<button type="reset" class="btn btn-primary">Reset</button>
	      		<button type="submit" id="submitBtn" class="btn btn-primary">Submit</button>
	    	</div>
		</div>
	</form>
</body>
</html>