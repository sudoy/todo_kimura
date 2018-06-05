<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${successes.size() > 0}">
	<div id="alert" class="alert alert-success fade in">
		<a href="#" class="close" data-dismiss="alert"
			aria-label="close">×</a>
		<b class="text-success">完了しました！</b>
		<ul>
		<c:forEach var="success" items="${successes}">
			<li class="text-success">${success}</li>
		</c:forEach>
		</ul>
	</div>
	<%
		session.setAttribute("successes", null);
	%>
</c:if>