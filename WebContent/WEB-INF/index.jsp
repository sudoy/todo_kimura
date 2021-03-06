<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="todo.utils.HTMLUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="todo_header.jsp" />
<jsp:include page="success.jsp" />
<jsp:include page="error.jsp" />

	<div class="container">
		<table class="table">
			<tr>
				<th>#</th>
				<th>題名</th>
				<th>重要度</th>
				<th>期限</th>
			</tr>

	<c:forEach var="todo" items="${list}">
	<tr>
		<td>${todo.todoId}</td>
		<td><a href="update.html?todoId=${todo.todoId}">${todo.title}</a></td>
		<td>${HTMLUtils.formatImportance(todo)}</td>
		<td>${HTMLUtils.formatDeadline(todo.deadline)}</td>
	</tr>
	</c:forEach>

</table>

	<p><a href="entry.html"><button type="button" class="btn btn-info">追加</button></a></p>

</div><!-- /container -->

<jsp:include page="todo_footer.jsp" />