<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Email</title>
</head>
<body>
<!-- Prompt message -->
<jsp:include page="../prompt.jsp" />

<!-- Main body -->
<h3>Update Email</h3>
<form id="updateEmailForm" class="form-horizontal" action="updateEmail.html" method="post">
	<div class="form-group">                    
        <label for="newEmail" class="col-sm-4 control-label"><font color="red">* </font>New Email Address</label>
        <div class="col-sm-6">
            <input type="email" class="form-control" id="newEmail" name="newEmail" placeholder="New Email Address">
        </div>
    </div>
    <div class="form-group">
    	<div class="col-sm-offset-4 col-sm-6">
      		<button type="reset" class="btn btn-primary">Reset</button>
      		<button type="submit" id="updateEmailBtn" class="btn btn-primary">Update</button>
    	</div>
    </div>
</form>
</body>
</html>