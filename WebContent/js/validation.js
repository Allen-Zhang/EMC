$(document).ready(function() {
	// override jquery validate plugin defaults
	$.validator.setDefaults({
	    highlight: function(element) {
	        $(element).closest('.form-group').addClass('has-error');
	    },
	    unhighlight: function(element) {
	        $(element).closest('.form-group').removeClass('has-error');
	    },
	    errorElement: 'span',
	    errorClass: 'help-block',
	    errorPlacement: function(error, element) {
	        if(element.parent('.input-group').length) {
	            error.insertAfter(element.parent());
	        } else {
	            error.insertAfter(element);
	        }
	    }
	});
	
	$.validator.addMethod("purchase_greater_extraPayment", function(value, element, param) {
        if ($("#purchase").val() >= $("#extraPayment").val() * $("#extraMonth").val()) 
        	return true;
	}, "ExtraPayment should be less than purchase");
	
	// Validation for sign up form
	$("#signupForm").validate({
		rules : {
			username : {
				required : true
			},
			password : {
				minlength : 5,
				required : true
			},
			confirmedPassword : {
				minlength : 5,
				required : true,
				equalTo : "#password"
			},
			email : {
				required : true
			}
		}
	});

	$("#updatePassowrdForm").validate({
		rules : {
			oldPassword : {
				required : true
			},
			newPassword : {
				required : true,
				minlength : 5
			},
			confirmedPassword : {
				required : true,
				minlength : 5,
				equalTo : "#newPassword"
			}
		}
	});
	
	$("#loginForm").validate({
		rules : {
			j_username : {
				required : true					
			},
			j_password : {
				required : true
			}
		}
	});
	
	$("#calculateForm").validate({
		rules : {
			purchase : {
				required : true,
				number : true,
				min : 0,		
			},
			extraPayment : {
				number : true,
				min : 0,
				max : 5000,
				purchase_greater_extraPayment : true
			}
		}
	});
	
	$("#updateEmailForm").validate({
		rules : {
			newEmail : {
				required : true,
				email : true
			}
		}
	});
	
	$("#forgetPasswordForm").validate({
		rules : {
			username : {
				required : true		
			},
			email : {
				required : true
			}
		}
	});
	
	$("#resetPasswordForm").validate({
		rules : {
			newPassword : {
				required : true,	
				minLength : 5
			},
			confirmedPassword : {
				required : true,
				minLength : 5,
				equalTo : "#newPassword"
			}
		}
	});
	
	$("#updateInterestForm").validate({
		rules : {
			state : {
				required : true	
			},
			loanType : {
				required : true
			},
			newInterestRate : {
				required : true,
				number : true,
				min : 0,
				max : 15
			}
		}
	});
});
