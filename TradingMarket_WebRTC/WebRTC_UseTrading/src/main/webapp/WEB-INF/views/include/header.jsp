<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="header_center">
		<img class="logo" alt="logo"
			src="${pageContext.request.contextPath}/resources/img/logo.png">
		<div class="searchbox">
			<form id="searchBoard"
				action="${pageContext.request.contextPath}/board/getlist"
				method="post">
				<input class="searchtext" type="text" style="border: 0px"
					placeholder="검색할 상품명을 입력해주세요." name="search">
			</form>
			<a href="#" onclick="searchList();"><img class="search"
				alt="search"
				src="${pageContext.request.contextPath}/resources/img/search.png">
			</a>
			<script>
				function searchList() {
					var f = document.getElementById("searchBoard");
					f.submit;
					return false;
				}
			</script>
		</div>
		<img class="goAndroid" alt="Androidbtn"
			src="${pageContext.request.contextPath}/resources/img/playstore.png">
	</div>
	<div class="header_center2">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<sec:authorize access="isAnonymous()">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/page/goLogin">로그인</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a class="navbar-brand" href="#"
					onclick="document.getElementById('logout-form').submit();">로그아웃(
					<sec:authentication property="principal.email" var="email" />
					${email})
				</a>
				<form id="logout-form" action="<c:url value='/logout'/>"
					method="post">
					<input name="${_csrf.parameterName}" type="hidden"
						value="${_csrf.token}">
				</form>
			</sec:authorize>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<sec:authorize access="isAnonymous()">
						<li class="nav-item active"><a class="nav-link"
							href="${pageContext.request.contextPath}/page/goJoin">회원가입 <span
								class="sr-only">(current)</span>
						</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item active"><a class="nav-link"
							href="${pageContext.request.contextPath}/page/goUpdate">회원수정
								<span class="sr-only">(current)</span>
						</a></li>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/page/goProductAdd">상품
							등록</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 영상통화관리 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="nav-item"><a class="nav-link disabled" href="#">관리자</a>
						</li>
					</sec:authorize>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/board/getlist">공지사항</a></li>
				</ul>

				<form id="formCreate" action="<c:url value='/create'/>"
					method="post" class="form-inline">
					<label for="formCreateText">Enter room id</label> <input
						type="text" name="roomId" id="formCreateText" class="form-control">
					<button type="submit" class="btn btn-primary">Create</button>
					<input name="${_csrf.parameterName}" type="hidden"
						value="${_csrf.token}">
				</form>

				<!-- 				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form> -->
			</div>
		</nav>
	</div>
</div>
