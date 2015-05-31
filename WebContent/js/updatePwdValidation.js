$(document).ready(function() {
	$("#updateForm").validate({
	            rules : {
	            	originalPassword : {
	            		required : true
	            	},
	            						
	            	updatePassword : {
	            		required : true,
	                    minlength : 5
	                },
	                confirmedPassword : {
	                	required : true,
	                    minlength : 5,
	                    equalTo : "#updatePassword"
	                }
	            }

	});
});