<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
	<title>Hello Flow World</title>
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/default.css" />
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/custom/flow.css" />
	<script type="text/javascript" src="${ctx }/static/scripts/jQuery-UI/v1.8.18/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/jsPlumb/v1.3.15/js/jquery.jsPlumb-1.3.15-all-min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/utils/flowUtils.js"></script>
	<script type="text/javascript" src="${ctx }/static-content?contentPath=/flow/hello-flow-world.js"></script>
</head>

<body>
	<div id="flow-panel">
<!-- 		<div class="window pass-window" id="window1">window 1</div> -->
<!-- 		<div class="window pass-window" id="window2">window 2</div> -->
<!-- 		<div class="window pass-window" id="window3">window 3</div> -->
<!-- 		<div class="window pass-window" id="window4">window 4</div> -->
<!-- 		<div class="window pass-window" id="window5">window 5</div> -->
<!-- 		<div class="window pass-window" id="window6">window 6</div> -->
<!-- 		<div class="window pass-window" id="window7">window 7</div> -->
<!-- 		<div class="window pass-window" id="window8">window 8</div> -->
<!-- 		<div class="window pass-window" id="window9">window 9</div> -->
<!-- 		<div class="window stop-window" id="window10">window 10</div> -->
<!-- 		<div class="window" id="window11">window 11</div> -->
<!-- 		<div class="window" id="window12">window 12</div> -->
	</div>
</body>
</html>