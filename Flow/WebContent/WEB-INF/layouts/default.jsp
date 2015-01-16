<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
<title>Flow - <sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta name="description" content="Lop">
<meta name="author" content="dingdang_j@qq.com">

<%-- <link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jQuery-Validation-Engine/2.6.4/css/validationEngine.jquery.css" /> --%>
<%-- <link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/jQuery-Validation-Engine/2.6.4/css/template.css" /> --%>

<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/bootstrap/v3.0.3/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/static/scripts/bootstrap/v3.0.3/css/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/static/styles/main.css" />

<script type="text/javascript" src="${ctx }/static/scripts/jQuery/v1.7/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/static/scripts/bootstrap/v3.0.3/js/bootstrap.min.js"></script>

<%-- <script type="text/javascript" src="${ctx }/static/scripts/jQuery-Validation-Engine/2.6.4/js/languages/jquery.validationEngine-zh_CN.js"></script> --%>
<%-- <script type="text/javascript" src="${ctx }/static/scripts/jQuery-Validation-Engine/2.6.4/js/jquery.validationEngine.js"></script> --%>

<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
var path = '${ctx }';
</script>

<sitemesh:head />

</head>

<%@ include file="/WEB-INF/layouts/header.jsp"%>

<div class="container">

	<div class="row row-offcanvas row-offcanvas-right">

		<%@ include file="/WEB-INF/layouts/left.jsp"%>

		<div class="col-xs-12 col-sm-9">
			<sitemesh:body />
		</div>
		<!--/span-->

	</div>
	<!--/row-->

	<%@ include file="/WEB-INF/layouts/footer.jsp"%>

</div>
<!--/.container-->
</body>
</html>