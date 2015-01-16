jsPlumb.bind( 'ready', function() {

	// Connections
	var connections = [];

	// wait common
	var waitPaintStyle = {
		strokeStyle: '#A7A7A7',
		lineWidth: 1
	};

	// default color
	var color = '#006400';

	// Ajax节点
	initNode();

	// init event
	initEvent();

	/* Flow Object */
	var flow = {

		init: function() {

			/*
			 * 全局设置
			 */
			jsPlumb.importDefaults( {
				Connector: [ 'Bezier', {
					curviness: 20
				} ],
				PaintStyle: {
					strokeStyle: color,
					lineWidth: 1
				},
				EndpointStyle: {
					radius: 0.1,
					// Chrome浏览器不支持负数
					// radius: -1,
					fillStyle: color
				},
				HoverPaintStyle: {
					strokeStyle: '#ec9f2e'
				},
				EndpointHoverStyle: {
					fillStyle: '#ec9f2e'
				},
				// Anchors: [ 'BottomRight', 'BottomCenter' ],
				Anchor: 'AutoDefault',
				ConnectionOverlays: [ [ 'Arrow', {
					width: 5,
					length: 15,
					// location: 0.85,
					location: 1,
					foldback: 0.8
				} ] ],
				// 拆分
				ConnectionsDetachable: false
			} );

			/*
			 * build connects
			 */
			$.each( connections, function() {
				if( '1|2' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '2|3' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'TopCenter', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '3|4' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '3|8' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'BottomCenter', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '4|5' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '5|9' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'TopCenter' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '9|10' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'BottomCenter', 'TopCenter' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '9|11' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'LeftMiddle' ],
						connector: 'Flowchart'
					} ) );
				}
				if( '10|11' == this.id ) {
					jsPlumb.connect( $.extend( this, {
						anchors: [ 'RightMiddle', 'BottomCenter' ],
						connector: 'Flowchart'
					} ) );
				} else {
					jsPlumb.connect( this );
				}
			} );

			// 是否可拖动
			// jsPlumb.draggable( jsPlumb.getSelector( '.window' ) );

		}
	};

	/**
	 * Ajax初始化节点
	 */
	function initNode() {
		var el = '';
		var url = path + '/flow!manualJson.action';
		$.getJSON( url, function( json ) {
			/* read and build flow elements */
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
				el += '<div class="window' + _el + '" id="' + this.id + '" _remark="' + this.remark + '">' + this.name
						+ '</div>';
			} );

			/* read and build connection array */
			$.each( json.flowConnections, function() {
				// 通过
				if( this.mark ) {
					connections.push( this );
				} else {
					connections.push( $.extend( this, {
						// overlays: defaultOverlays,
						paintStyle: waitPaintStyle
					} ) );
				}
			} );

			// insert node
			$( '#flow-panel' ).append( el );

			// transfer node
			transfer();

			// add user
			addUser();

			// 初始化节点
			flow.init();
		} );
	}

	/**
	 * 移动位置
	 */
	function transfer() {
		$( '.window' ).css( 'width', '5em' );
		$( '#1' ).css( {
			'top': '20em',
			'left': '0em'
		} );
		$( '#2' ).css( {
			'top': '20em',
			'left': '10em'
		} );
		$( '#3' ).css( {
			'top': '10em',
			'left': '16em'
		} );
		$( '#4' ).css( {
			'top': '10em',
			'left': '26em'
		} );
		$( '#5' ).css( {
			'top': '10em',
			'left': '36em'
		} );
		$( '#6' ).css( {
			'top': '20em',
			'left': '32em'
		} );
		$( '#7' ).css( {
			'top': '30em',
			'left': '21em'
		} );
		$( '#8' ).css( {
			'top': '40em',
			'left': '32em'
		} );
		$( '#9' ).css( {
			'top': '30em',
			'left': '43em'
		} );
		$( '#10' ).css( {
			'top': '40em',
			'left': '43em'
		} );
		$( '#11' ).css( {
			'top': '30em',
			'left': '53em'
		} );
	}

	/** add user */
	function addUser() {
		var el1 = '<div class="user pass-user"><a href="javascript: void(0);" _state="已操作">' + '王五' + '</a></div>';
		var el2 = '<div class="user wait-user"><a href="javascript: void(0);" _state="未操作">' + '张三' + '</a></div>';
		$( '#1' ).append( el1 + el2 );

		el1 = '<div class="user wait-user"><a href="javascript: void(0);" _state="未操作">' + '丁XX' + '</a></div>';
		el2 = '<div class="user wait-user"><a href="javascript: void(0);" _state="未操作">' + '周XX' + '</a></div>';
		$( '#2' ).append( el1 + el2 );

		el1 = '<div class="user stop-user"><a href="javascript: void(0);" _state="已查看">' + '张XX' + '</a></div>';
		el2 = '<div class="user wait-user"><a href="javascript: void(0);" _state="未操作">' + '王XX' + '</a></div>';
		$( '#3' ).append( el1 + el2 );
	}

	/** init event */
	function initEvent() {
		/* tip */
		// $( '.window' ).live( 'click', function( e ) {
		// flowUtils.closeTooltip();
		// flowUtils.openTooltip( e.pageX, e.pageY, $( this ).attr( '_remark' ) );
		// } ).live( 'mouseout', function() {
		// flowUtils.closeTooltip();
		// } );
		/* query userinfo */
		$( '.user a' ).live( 'click', function( e ) {
			var content = '操作者：' + $( this ).text() + '<br />' + '操作状态：' + $( this ).attr( '_state' );
			flowUtils.closeTooltip();
			flowUtils.openTooltip( e.pageX, e.pageY, content );
		} ).live( 'mouseout', function() {
			flowUtils.closeTooltip();
		} );
	}

} );