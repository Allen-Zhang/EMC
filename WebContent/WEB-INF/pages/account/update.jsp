<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Update</title>
</head>
<body>
<div class="container">
	
<!-- Update Content -->
<h3>Update</h3>
		<!-- User Pane -->
	<div role="tabpanel" class="tab-pane" id="userPane">
		<form id="updateForm" class="form-horizontal" action="update.html" method="post">
			<div class="form-group">                    
		        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>Old Password</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="password" class="form-control" id="originalPassword" name="originalPassword" placeholder="Old Password">
		            </div>
		        </div>
		    </div>
			<div class="form-group">                    
		        <label for="password" class="col-sm-3 control-label"><font color="red">* </font>New Password</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="password" class="form-control" id="updatePassword" name="updatePassword" placeholder="New Password">
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
<!-- 		    <div class="form-group">                    
		        <label for="email" class="col-sm-3 control-label"><font color="red">* </font>Email</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="email" class="form-control" id="email" name="email" placeholder="Email">
		            </div>
		        </div>
		    </div> -->
		    <div class="form-group">
		    	<div class="col-sm-offset-3 col-sm-9">
		      		<button type="reset" class="btn btn-primary">Reset</button>
		      		<button type="submit" id="updateBtn" class="btn btn-primary" >Update</button>
		    	</div>
		    </div>
		</form>
	</div>
</div>

<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/updatePwdValidation.js"></script>
<!-- <script src="../js/angular.min.js"></script> -->
<!-- <script src="../js/myApp.js"></script> -->
<!-- <script src="../js/controller/userController.js"></script> -->
</body>
</html>