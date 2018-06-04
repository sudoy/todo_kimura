<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="todo.utils.HTMLUtils" %>

<jsp:include page="todo_header.jsp" />
	<div class="container">
		<b>更新フォーム</b>
		<hr>

		<div class="row">
			<form class="form-horizontal" action="update.html?todoId=${param.todoId != null ? param.todoId :todo.todoId}" method="post">
				<label for="title" class="col-sm-2 control-label">題名</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="title" name="title" placeholder="題名" value="${param.title != null ? param.title : todo.title}">
					</div>
				</div>

				<label for="deadline" class="col-sm-2 control-label">詳細</label>
				<div class="form-group">
					<div class="col-sm-9">
						<textarea class="form-control" id="detail" name="detail" placeholder="詳細" rows="3">${param.detail != null ? param.detail : todo.detail}</textarea>

					</div>
				</div>

				<label for="importance" class="col-sm-2 control-label">重要度</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="radio" name="importance" value="3" ${HTMLUtils.checkImportance(param.importance != null ? param.importance : todo.importance, '3')}>★★★<br>
						<input type="radio" name="importance" value="2" ${HTMLUtils.checkImportance(param.importance != null ? param.importance : todo.importance, '2')}>★★<br>
						<input type="radio" name="importance" value="1" ${HTMLUtils.checkImportance(param.importance != null ? param.importance : todo.importance, '1')}>★
					</div>
				</div>

				<label for="deadline" class="col-sm-2 control-label">期限</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="deadline" name="deadline" placeholder="期限" value="${param.deadline != null ? param.deadline : HTMLUtils.formatDeadline(todo.deadline)}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-9">
						<a href="index.html" class="btn btn-default"> キャンセル</a>
						<input type="submit" class="btn btn-info" value="更 新">
						<a href="delete.html?todoId=${todo.todoId}" class="btn btn-danger"> 削 除</a>
					</div>
				</div>
			</form>
		</div>
	</div><!-- /container -->
<jsp:include page="todo_footer.jsp" />