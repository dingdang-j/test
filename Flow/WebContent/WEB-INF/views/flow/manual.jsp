<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
	<title>项目预算申请流程图</title>
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/default.css" />
	<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jsPlumb/v1.3.15/css/custom/flow.css" />
	<script type="text/javascript" src="${ctx }/static/scripts/jQuery-UI/v1.8.18/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/jsPlumb/v1.3.15/js/jquery.jsPlumb-1.3.15-all-min.js"></script>
	<script type="text/javascript" src="${ctx }/static/scripts/utils/flowUtils.js"></script>
	<script type="text/javascript" src="${ctx }/static-content?contentPath=/flow/manual.js"></script>
</head>

<body>
	<div id="flow-panel">
		<table>
			<tr>
				<td align="center"><div class="thumbnail-window wait-window"></div></td>
				<td align="center"><div class="thumbnail-window pass-window"></div></td>
				<td align="center"><div class="thumbnail-window stop-window"></div></td>
				<td rowspan="2">
					<div class="user wait-user"><span class="panel-font">未操作者</span></div>
					<div class="user pass-user"><span class="panel-font">已操作者</span></div>
					<div class="user stop-user"><span class="panel-font">已查看者</span></div>
				</td>
			</tr><tr>
				<td align="center">未操作节点</td>
				<td align="center">已操作节点</td>
				<td align="center">当前节点</td>
			</tr>
		</table>
	</div>
</body>
</html>