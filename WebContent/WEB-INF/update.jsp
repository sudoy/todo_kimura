<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:include page="todo_header.jsp" />
	<div class="container">
		<b>更新フォーム</b>
		<hr>

		<div class="row">
			<form class="form-horizontal" action="#" method="post">
				<label for="title" class="col-sm-2 control-label">題名</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="title" placeholder="題名" value="">
					</div>
				</div>

				<label for="deadline" class="col-sm-2 control-label">詳細</label>
				<div class="form-group">
					<div class="col-sm-9">
						<textarea class="form-control" id="detail" placeholder="詳細" rows="3"></textarea>

					</div>
				</div>

				<label for="importance" class="col-sm-2 control-label">重要度</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="radio" name="importance" value="star" checked>★★★<br>
						<input type="radio" name="importance" value="star">★★<br>
						<input type="radio" name="importance" value="star">★
					</div>
				</div>

				<label for="deadline" class="col-sm-2 control-label">期限</label>
				<div class="form-group">
					<div class="col-sm-9">
						<input type="text" class="form-control" id="deadline" placeholder="期限" value="">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-9">
						<a href="index.html" class="btn btn-default"> キャンセル</a>
						<a href="index.html" class="btn btn-info"> 更 新</a>
						<a href="index.html" class="btn btn-danger"> 削 除</a>
					</div>
				</div>
			</form>
		</div>
	</div><!-- /container -->
<jsp:include page="todo_footter.jsp" />