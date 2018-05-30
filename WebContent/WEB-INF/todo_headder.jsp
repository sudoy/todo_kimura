<%@ page pageEncoding="UTF-8" %>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Todoリスト</title>

		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- 独自css -->
		<link href="css/body.css" rel="stylesheet">

		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<nav class="navbar">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.html">Todoリスト</a>
				</div>
			</div>
		</nav>

		<div class="container">
			<div id="alert" class="alert alert-success fade in">
				<a href="#" class="close" data-dismiss="alert"
					aria-label="close">×</a>
				<b class="text-success">完了しました！</b>
				<ul>
					<li class="text-success">No.27のTodoを更新しました。</li>
				</ul>
			</div>

			<div id="alert" class="alert alert-danger fade in">
				<a href="#" class="close" data-dismiss="alert"
					aria-label="close">×</a>
				<b class="text-danger">エラーが発生しました！</b>
				<ul>
					<li class="text-danger">題名は必須入力です。</li>
					<li class="text-danger">題名は100文字以内にしてください。</li>
					<li class="text-danger">期限は「YYYY/MM/DD」形式で入力してください。</li>
				</ul>
			</div>
		</div>