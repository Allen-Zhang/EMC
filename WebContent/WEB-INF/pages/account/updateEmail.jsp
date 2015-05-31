<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Update Email</title>
</head>
<body>
<div class="container">
	
<!-- Update Content -->
<h3>Update</h3>
		<!-- User Pane -->
	<div role="tabpanel" class="tab-pane" id="userPane">
		<form id="updateForm" class="form-horizontal" action="updateEmail.html" method="post">
			<div class="form-group">                    
		        <label for="email" class="col-sm-3 control-label"><font color="red">* </font>New Email</label>
		        <div class="col-sm-9">
		        	<div class="input-group">
		            	<input type="email" class="form-control" id="updateEmail" name="updateEmail" placeholder="New Email">
		            </div>
		        </div>
		    </div>
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