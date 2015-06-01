$(document).ready(function() {
	
	$.validator.addMethod("purchase_greater_extraPayment", function(value, element, param) {
        if ($("#purchase").val()>=$("#extraPayment").val()*$("#extraMonth").val()) return true;
	}, "ExtraPayment should be less than purchase");
	
	// Validation for sign up form
	$("#signupForm").validate({
		rules : {
			password : {
				minlength : 5,
				required : true
			},
			confirmedPassword : {
				minlength : 5,
				equalTo : "#password",
			}
		}
	});

	// Validation for update password form
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
});
