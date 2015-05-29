$(document).ready(function() {
$("#signupForm").validate({
            rules : {
            	password: "required",
                password : {
                    minlength : 5
                },
                confirmedPassword : {
                    minlength : 5,
                    equalTo : "#password"
                }
            }

	});
});