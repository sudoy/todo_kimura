<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<jsp:include page="success.jsp" />
			<jsp:include page="error.jsp" />

		</div>