<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<div class="col-md-3">
	<div class="col-xs-6 col-sm-2 sidebar-offcanvas affix" id="sidebar" role="navigation">
		<div class="list-group">
			<a href="${ctx }/charge/charge-tree.action" class="list-group-item">收费规则树</a>
			<a href="${ctx }/flow/build.action" class="list-group-item">build</a>
			<a href="${ctx }/flow/hello-flow-world.action" class="list-group-item">hello-flow-world</a>
			<a href="${ctx }/flow/manual.action" class="list-group-item">manual</a>
		</div>
	</div>
</div>