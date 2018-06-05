<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="todo.utils.HTMLUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="todo_header.jsp" />

<div class="box">
	<div class="row">
		<div class="col-md-4 col-md-offset-7">
			<div class="panel panel-default">

				<div class="panel-body">
					<form class="form-horizontal" role="form" action="login.html" method="post">
						<h4><strong>ログイン</strong></h4>
						<jsp:include page="success.jsp" />
						<jsp:include page="error.jsp" />

						<div class="form-group">
							<label for="inputEmail" class="col-sm-3 control-label">メールアドレス</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="email" id="inputEmail" placeholder="メールアドレス" value="${param.email}">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">パスワード</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="password" id="inputPassword" placeholder="パスワード" value="">
							</div>
						</div>

						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> ログイン</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="todo_footer.jsp" />