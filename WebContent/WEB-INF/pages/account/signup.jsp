<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Page</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body ng-controller="userCtrl">
<div class="container">
	
	<!-- SignUp Content -->
	<h3>SignUp</h3>

			<!-- User Pane -->
			<div role="tabpanel" class="tab-pane" id="userPane">
				<form class="form-horizontal" ng-submit="register()">
					<div class="form-group">                    
				        <label for="username" class="col-sm-3 control-label"><font color="red">* </font>Username</label>
				        <div class="col-sm-9">
				        	<div class="input-group">
				            	<input type="text" class="form-control" id="username" name="username" placeholder="Username" ng-model="username">
				            </div>
				        </div>
				    </div>
					<div class="form-group">                    
				        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>Password</label>
				        <div class="col-sm-9">
				        	<div class="input-group">
				            	<input type="password" class="form-control" id="password" name="password" placeholder="Password" ng-model="password">
				            </div>
				        </div>
				    </div>

				    <div class="form-group">                    
				        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>Confirm Password</label>
				        <div class="col-sm-9">
				        	<div class="input-group">
					            <input type="password" class="form-control" id="password" name="password" placeholder="Confirm Password">
				            </div>
				        </div>
				    </div>
				    <div class="form-group">                    
				        <label for="email" class="col-sm-3 control-label"><font color="red">* </font>Email</label>
				        <div class="col-sm-9">
				        	<div class="input-group">
				            	<input type="email" class="form-control" id="email" name="email" placeholder="Email" ng-model="email">
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
	</div>
</div>
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/angular.min.js"></script>
<script src="../js/myApp.js"></script>
<script src="../js/controller/userController.js"></script>
</body>
</html>