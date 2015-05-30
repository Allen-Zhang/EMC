<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Page</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
<div class="container">
	
<!-- SignUp Content -->
<h3>SignUp</h3>

		<!-- User Pane -->
	<div role="tabpanel" class="tab-pane" id="userPane">
		<form id="signupForm" class="form-horizontal" action="register.html" method="post">
			<div class="form-group">                    
		        <label for="username" class="col-sm-3 control-label"><font color="red">* </font>Username</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="text" class="form-control" id="username" name="username" placeholder="Username">
		            </div>
		        </div>
		    </div>
			<div class="form-group">                    
		        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>Password</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="password" class="form-control" id="password" name="password" placeholder="Password">
		            </div>
		        </div>
		    </div>

		    <div class="form-group">                    
		        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>Confirmed Password</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
			            <input type="password" class="form-control" id="confirmedPassword" name="confirmedPassword" placeholder="Confirmed Password">
		            </div>
		        </div>
		    </div>
		    <div class="form-group">                    
		        <label for="email" class="col-sm-3 control-label"><font color="red">* </font>Email</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="email" class="form-control" id="email" name="email" placeholder="Email">
		            </div>
		        </div>
		    </div>
		    <div class="form-group">
		    	<div class="col-sm-offset-3 col-sm-9">
		      		<button type="reset" class="btn btn-primary">Reset</button>
		      		<button type="submit" id="signupBtn" class="btn btn-primary" >Submit</button>
		    	</div>
		    </div>
		</form>
	</div>
</div>

<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/validation.js"></script>
<!-- <script src="../js/angular.min.js"></script> -->
<!-- <script src="../js/myApp.js"></script> -->
<!-- <script src="../js/controller/userController.js"></script> -->
</body>
</html>