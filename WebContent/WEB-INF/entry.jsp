<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:include page="todo_header.jsp" />

	<div class="container">
		<b>登録フォーム</b>
		<hr>
		<div class="row">
			<form class="form-horizontal" action="entry.html" method="post">
				<label for="title" class="col-sm-2 control-label">題名</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" name="title" placeholder="題名"  value="">
					</div>
				</div>

				<label for="detail" class="col-sm-2 control-label">詳細</label>
				<div class="form-group">
					<div class="col-sm-9">
						<textarea class="form-control" name="detail" placeholder="詳細"  rows="3"></textarea></div>
				</div>

				<label for="importance" class="col-sm-2 control-label">重要度</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="radio" name="importance" value="3" checked>★★★<br>
						<input type="radio" name="importance" value="2">★★<br>
						<input type="radio" name="importance" value="1">★
					</div>
				</div>

				<label for="deadline" class="col-sm-2 control-label">期限</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="deadline" placeholder="期限" name="deadline" value="">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-9">
						<a href="index.html" class="btn btn-default">キャンセル</a>
						<input type="submit" class="btn btn-info" value="追 加" />
					</div>
				</div>
			</form>
		</div>
	</div><!-- /container -->
<jsp:include page="todo_footer.jsp" />