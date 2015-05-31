$(document).ready(function() {
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
});
