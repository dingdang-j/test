<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
<title>Flow - <sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/bootstrap/v2.1.1/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/static/styles/default.min.css" />
<script type="text/javascript" src="${ctx }/static/scripts/jQuery/v1.7/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/static/scripts/bootstrap/v2.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
var path = '${ctx }';
</script>

<sitemesh:head />

</head>

<body>
	<div class="container">
		<div class="row">
			<%@ include file="/WEB-INF/layouts/left.jsp"%>
			<div id="main" class="span10">
				<sitemesh:body />
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>