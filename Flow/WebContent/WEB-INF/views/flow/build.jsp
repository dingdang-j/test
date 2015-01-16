<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
	<title>异动申请流程图</title>
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/default.css" />
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/custom/flow.css" />
	<script type="text/javascript" src="${ctx }/static/scripts/jQuery-UI/v1.8.18/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/jsPlumb/v1.3.15/js/jquery.jsPlumb-1.3.15-all-min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/utils/flowUtils.js"></script>
	<script type="text/javascript" src="${ctx }/static-content?contentPath=/flow/build.js"></script>
</head>

<body>
	<div id="flow-panel"></div>
</body>
</html>