<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head ng-app="myApp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Interest</title>
</head>
<body ng-controller="adminCtrl">
<!-- Result Pane -->
	<div role="tabpanel" class="tab-pane">
	
		<table class="table table-striped" class="emc-table">
	  <thead>
	    <tr>
	      <th>State</th>
	      <th>Fixed 30 Years</th>
	      <th>Fixed 20 Years</th>
	      <th>Fixed 15 Years</th>
	      <th>ARM 5</th>
	      <th>ARM 7</th>
	      <th>ARM 10</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr ng-repeat="row in rows">
			<td>{{row.state}}</td>
			 <td>{{row.fix_30}}</td>
			 <td>{{row.fix_20}}</td>
			 <td>{{row.fix_15}}%</td>
			 <td>{{row.arm_5}}</td>
			 <td>{{row.arm_7}}</td>
			 <td>{{row.arm_10}}</td>
	    </tr> 
	  </tbody>
	</table>
	</div>
<script src="js/controller/adminController.js"></script>
</body>
</html>