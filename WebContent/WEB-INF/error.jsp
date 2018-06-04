<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<c:if test="${errors.size() > 0}">
				<div id="alert" class="alert alert-danger fade in">
					<a href="#" class="close" data-dismiss="alert"
						aria-label="close">×</a>
					<b class="text-danger">エラーが発生しました！</b>

					<ul>
						<c:forEach var="error" items="${errors}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
				<%
					session.setAttribute("errors", null);
				%>
			</c:if>