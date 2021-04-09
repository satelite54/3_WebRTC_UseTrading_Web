<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!-- jQuery -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<!-- iamport.payment.js -->
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<div
		style="width: 60vw; height: 60vh; display: flex; justify-content: center; margin: 0 auto;">
		<form action="${pageContext.request.contextPath}/member/login"
			method="post" class="form-signin"
			style="width: 30vw; margin-top: 15vh;">
			<c:choose>
				<c:when test="${requestScope.loginFailMsg ne null}">
					<h2 class="form-signin-heading">${requestScope.loginFailMsg}</h2>
				</c:when>
				<c:otherwise>
					<h2 class="form-signin-heading">로그인 해주세요.</h2>
				</c:otherwise>
			</c:choose>

			<label for="id" class="sr-only">Email address</label> <input
				type="email" id="id" name="id" class="form-control"
				placeholder="identify" required autofocus=""> <label
				for="pw" class="sr-only">Password</label> <input type="password"
				id="pw" name="pw" class="form-control" placeholder="Password"
				required style="margin-top: 2.5vh">
			<div class="checkbox">
				<label> <input type="checkbox"
					name="_spring_security_remember_me" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>