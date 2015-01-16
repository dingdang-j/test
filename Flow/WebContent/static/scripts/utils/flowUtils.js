/**
 * 基于jQuery的Flow工具JS
 * 
 * @author 潘瑞峥
 * @date 2012-10-10
 */
( function() {

	/**
	 * Tip
	 */
	function openTooltip( x, y, contents ) {
		$( '<div class="tooltip">' + contents + '</div>' ).css( {
			position: 'absolute',
			display: 'none',
			top: y + 10,
			left: x + 10,
			border: '1px solid #CC9933',
			padding: '2px',
			'background-color': '#FFFFCC',
			opacity: 0.80,
			'z-index': 999
		} ).appendTo( 'body' ).fadeIn( 200 );
	}

	function closeTooltip() {
		$( '.tooltip' ).remove();
	}

	window[ 'flowUtils' ] = {};

	window[ 'flowUtils' ][ 'openTooltip' ] = openTooltip;

	window[ 'flowUtils' ][ 'closeTooltip' ] = closeTooltip;

} )();