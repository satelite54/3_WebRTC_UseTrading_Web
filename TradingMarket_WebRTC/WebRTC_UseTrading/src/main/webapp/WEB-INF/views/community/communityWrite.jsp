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
				<h1>글쓰기</h1>
			</div>
			<div>
				<form class="form-group"
					action="${pageContext.request.contextPath}/board/setboardinsert"
					method="get">
					<table class="table table-striped row"
						style="justify-content: center;">
						<tbody class="col-md-10">
							<tr>
								<sec:authentication property="principal.email" var="email" />
								<th>작성자</th>
								<td>${email}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input class="form-control" type="text" name="BTitle"></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea class="form-control" name="BContent"
										rows="10" cols="100"></textarea></td>
							</tr>
							<tr>
								<td class="text-center" colspan="2"><input
									class="btn btn-primary" type="submit" value="확인"> <input
									name="${_csrf.parameterName}" type="hidden"
									value="${_csrf.token}"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>