$(document).ready(function() {
	
	/********************** Calculator Section **********************/
	// Initialize the tooltip on calculator page
	$('[data-toggle="tooltip"]').tooltip();

	// Click function for Calculate button on calculator page
	$("#calculatorBtn").click(function() {
		if ($("#calculateForm").valid()) {  // form validation
			$("#calculatorNav a[href='#resultPane']").trigger("click");
		}
	});
	
	// Auto fade out alert block
	window.setTimeout(function() {
	    $(".alert-short").fadeTo(1500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 2000);  // stay for 2 seconds
	window.setTimeout(function() {
	    $(".alert-long").fadeTo(1500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 20000);  // stay for 20 seconds
});
