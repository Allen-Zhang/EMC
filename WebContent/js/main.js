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
	
});
