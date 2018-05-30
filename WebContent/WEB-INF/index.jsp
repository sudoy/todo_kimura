<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*,javax.naming.*,javax.sql.*, java.text.*" %>

<jsp:include page="todo_header.jsp" />
	<div class="container">
		<table class="table">
			<tr>
				<th>#</th>
				<th>題名</th>
				<th>詳細</th>
				<th>重要度</th>
				<th>期限</th>
			</tr>

<%
ResultSet rs = (ResultSet)request.getAttribute("rs");

		while(rs.next()){
%>
	<tr>
		<td><%=rs.getString("todo_id") %></td>
		<td><a href="update.html"><%=rs.getString("title") %></a></td>
		<td><%=rs.getString("detail") %></td>
		<td><%=rs.getString("importance") %></td>
		<td><%=rs.getString("deadline") %></td>
	</tr>
<%
		}
%>

</table>

	<p><a href="entry.html"><button type="button" class="btn btn-info">追加</button></a></p>

</div><!-- /container -->

<jsp:include page="todo_footter.jsp" />