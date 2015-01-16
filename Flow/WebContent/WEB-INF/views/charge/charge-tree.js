/**
 * 
 */
$(function() {
	// alert(1);

	$('div.panel-heading').click(function() {
		$(this).next('div.panel-body').find('div.form-group').toggle();
	})

	.css('cursor', 'pointer');

	$('#expandBtn').click(function() {
		$('div.form-group').show();
	});

	$('#shrinkBtn').click(function() {
		$('div.form-group').hide();
	});

});