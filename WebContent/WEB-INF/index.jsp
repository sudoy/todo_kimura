<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:include page="todo_headder.jsp" />
	<div class="container">
		<table class="table">
			<tr>
				<th>#</th>
				<th>題名</th>
				<th>重要度</th>
				<th>期限</th>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="update.html">テストテスト</a></td>
				<td>★★★</td>
				<td>2018/05/29</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="update.html">テストテスト</a></td>
				<td>★</td>
				<td>2018/05/29</td>
			</tr>
			<tr>
				<td>3</td>
				<td><a href="update.html">テストテスト</a></td>
				<td>★★★</td>
				<td>2018/05/30</td>
			</tr>
			<tr>
				<td>4</td>
				<td><a href="update.html">テストテスト</a></td>
				<td>★★</td>
				<td></td>
			</tr>
		</table>

		<p><a href="entry.html"><button type="button" class="btn btn-info">追加</button></a></p>

	</div><!-- /container -->
<jsp:include page="todo_footter.jsp" />