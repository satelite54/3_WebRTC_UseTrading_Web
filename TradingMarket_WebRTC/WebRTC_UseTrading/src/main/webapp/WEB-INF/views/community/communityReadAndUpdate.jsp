<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
	<jsp:include page="../include/header.jsp" />

	<div class="container">
		<div class="">
			<div class="page-hearder" style="padding-bottom: 20px;">
				<h1>글쓰기 화면</h1>
			</div>
			<div>
				<c:choose>
					<c:when test="${param.boardUpdate eq null}">
						<c:set var="controot" value="/board/goBoardUpdate" />
					</c:when>
					<c:otherwise>
						<c:set var="controot" value="/board/setboardUpdate" />
					</c:otherwise>
				</c:choose>
				<form class="form-group"
					action="${pageContext.request.contextPath}${controot}"
					method="post">
					<input type="hidden" name="id" value="${boardDTO.id}">
					<table class="table table-striped row"
						style="justify-content: center;">
						<tbody class="col-md-10">
							<tr>
								<th>작성자</th>
								<c:choose>
									<c:when test="${requestScope.id ne null}">
										<td>${requestScope.id}</td>
									</c:when>
									<c:otherwise>
										<td>${boardDTO.id}</td>
									</c:otherwise>
								</c:choose>

							</tr>
							<tr>
								<th>제목</th>
								<td><c:choose>
										<c:when test="${param.boardUpdate ne null}">
											<input class="form-control" type="text" name="BTitle"
												value="${requestScope.BTitle}">
										</c:when>
										<c:otherwise>
											<input class="form-control" type="text" name="BTitle"
												readonly value="${boardDTO.BTitle}">
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><c:choose>
										<c:when test="${param.boardUpdate ne null}">
											<textarea class="form-control" name="BContent" rows="10"
												cols="100"> ${requestScope.BContent} </textarea>
										</c:when>
										<c:otherwise>
											<textarea class="form-control" name="BContent" rows="10"
												readonly cols="100"> ${boardDTO.BContent} </textarea>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<sec:authorize access="isAuthenticated()">
									<c:choose>
										<c:when test="${param.boardUpdate ne null}">
											<c:set var="confim" value="확인">
											</c:set>
											<input type="hidden" name="BNum" value="${requestScope.BNum}">
										</c:when>
										<c:otherwise>
											<c:set var="confim" value="수정" />
											<input type="hidden" name="BNum" value="${boardDTO.BNum}">
										</c:otherwise>
									</c:choose>
									<td class="text-center" colspan="2"><input
										class="btn btn-primary" type="submit" value="${confim}">
										<input name="${_csrf.parameterName}" type="hidden"
										value="${_csrf.token}"></td>
								</sec:authorize>
							</tr>
						</tbody>
					</table>

				</form>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>
