$(document).ready(function() {
	
	/* 
	 * Click function for Calculate button on the calculator page
	 */
	$("#calculatorBtn").click(function() {
		$("#calculatorNav a[href='#resultPane']").trigger("click");
	});
	
});
