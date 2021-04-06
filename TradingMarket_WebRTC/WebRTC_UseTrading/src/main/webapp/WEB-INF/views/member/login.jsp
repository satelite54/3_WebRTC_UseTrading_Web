<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main_header.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main_footer.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/cardview.css">
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div
		style="width: 60vw; height: 60vh; display: flex; justify-content: center; margin: 0 auto;">
		<form action="${pageContext.request.contextPath}/member/login" method="post" class="form-signin" style="width: 30vw; margin-top: 15vh;">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="id" class="sr-only">Email address</label> <input
				type="email" id="id" name="id" class="form-control"
				placeholder="identify" required autofocus=""> <label
				for="pw" class="sr-only">Password</label> <input
				type="password" id="pw" name="pw" class="form-control"
				placeholder="Password" required style="margin-top: 2.5vh">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>