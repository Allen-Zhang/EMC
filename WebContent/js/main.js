$(document).ready(function() {
	// Initialize the tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Click function for Calculate button on the calculator page
	$("#calculatorBtn").click(function() {
		$("#calculatorNav a[href='#resultPane']").trigger("click");
	});
	
});
