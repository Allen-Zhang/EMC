$(document).ready(function() {
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
});
