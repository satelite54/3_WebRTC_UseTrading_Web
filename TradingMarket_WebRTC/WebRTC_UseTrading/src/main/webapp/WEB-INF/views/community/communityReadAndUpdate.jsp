<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form class="form-group" action="updateProcess.do" method="post">
					<table class="table table-striped row" style="justify-content: center;">
						<tbody class="col-md-10">
							<tr>
								<th>작성자</th>
								<td>${boardDTO.id}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><c:choose>
										<c:when test="${boardRead eq true}">
											<input class="form-control" type="text" name="BTitle"
												value="${boardDTO.BTitle}">
										</c:when>
										<c:otherwise>
											<input class="form-control" type="text" name="BTitle" disabled
												value="${boardDTO.BTitle}">
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><c:choose>
										<c:when test="${boardRead eq true}">
											<textarea class="form-control" name="BContent" rows="10"
												cols="100"> ${boardDTO.BContent} </textarea>
										</c:when>
										<c:otherwise>
											<textarea class="form-control" name="BContent" rows="10" disabled
												cols="100"> ${boardDTO.BContent} </textarea>
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td class="text-center" colspan="2"><input
									class="btn btn-primary" type="submit" value="수정"></td>
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