jsPlumb.bind( 'ready', function() {

	var connections = [];

	var waitPaintStyle = {
		strokeStyle: '#A7A7A7',
		lineWidth: 1
	};

	initNode();

	var options = {

		init: function() {

			var color = '#006400';

			/*
			 * 全局设置
			 */
			jsPlumb.importDefaults( {
				Connector: [ 'Flowchart' ],
				PaintStyle: {
					strokeStyle: color,
					lineWidth: 1
				},
				EndpointStyle: {
					radius: 1,
					fillStyle: color
				},
				HoverPaintStyle: {
					strokeStyle: '#ec9f2e'
				},
				EndpointHoverStyle: {
					fillStyle: '#ec9f2e'
				},
				// 拆分
				ConnectionsDetachable: false,
				ConnectionOverlays: [ [ 'Arrow', {
					width: 5,
					length: 20,
					// location: 0.85,
					location: 1,
					foldback: 0.8
				} ] ]
			} );

			/* Connect */
			$.each( connections, function() {
				jsPlumb.connect( this );
			} );

			jsPlumb.bind( 'click', function( labelOverlay, originalEvent ) {
				// showTooltip( originalEvent.pageX, originalEvent.pageY, 'test' );
				alert( 'Hello!' );
			} );
		}
	};

	/**
	 * Ajax初始化节点
	 */
	function initNode() {
		var el = '';
		var url = path + '/flow!buildJson.action';
		$.getJSON( url, function( json ) {
			/* Flows */
			$.each( json.flows, function( index ) {
				var _el = '';
				var _state = this.state;
				/* 通过 */
				if( '1' == _state ) {
					_el += ' pass-window';
				}
				/* 停止 */
				else if( '2' == _state ) {
					_el += ' stop-window';
					mark = true;
				}
				/* 等待 */
				else if( '0' == _state ) {
					_el += ' wait-window';
					mark = true;
				}
				el += '<div class="window ' + ( 'window' + ( index + 1 ) + _el ) + '" id="' + this.id + '" _remark="'
						+ this.remark + '">' + this.name + '</div>';

			} );

			/* Flow Connections */
			$.each( json.flowConnections, function() {
				// 通过
				if( this.mark ) {
					connections.push( this );
				} else {
					connections.push( $.extend( this, {
						paintStyle: waitPaintStyle
					} ) );
				}
			} );

			// insertNode
			$( '#flow-panel' ).append( el );

			// 初始化节点
			options.init();
		} );
	}

	/* tip */
	$( '.window' ).live( 'click', function( e ) {
		flowUtils.closeTooltip();
		flowUtils.openTooltip( e.pageX, e.pageY, $( this ).attr( '_remark' ) );
	} ).live( 'mouseout', function() {
		flowUtils.closeTooltip();
	} );

} );