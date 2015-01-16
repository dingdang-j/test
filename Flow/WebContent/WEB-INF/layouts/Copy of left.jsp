<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<div id="leftbar" class="span2">
	<h1>Flow演示</h1>
	<div class="submenu">
		<a href="${ctx }/flow/hello-flow-world.action">顺序流程</a>
	</div>
	<h1>模拟演示</h1>
	<div class="submenu">
		<a href="${ctx }/flow/build.action">自动构建流程</a>
		<a href="${ctx }/flow/manual.action">手工构建流程</a>
	</div>
	<h1>测试</h1>
	<div class="submenu">
		<a href="${ctx }/flow/test.action">test</a>
	</div>
</div>