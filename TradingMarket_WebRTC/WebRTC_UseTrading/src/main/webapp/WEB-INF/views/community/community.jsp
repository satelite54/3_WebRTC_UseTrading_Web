<%@page import="java.awt.dnd.DropTargetListener"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JASET VAPE</title>
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
	<div class="container" style="padding: 10dp">
		<div class="w-100" style="height: 50px;">
			<form class="float-right"
				action="${pageContext.request.contextPath}/board/getlist"
				method="get">
				<input type="text" name="boardsearch" placeholder="입력"
					value="${searchtext}">
				<button type="submit" class="btn btn-primary">검색</button>
			</form>
		</div>
		<table class="table border-dark rounded">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">글 제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody class="border">
				<c:forEach var="BoardDTO" items="${BoardList}">
					<tr>
						<td>${BoardDTO.BNum}</td>
						<td>${BoardDTO.BTitle}</td>
						<td>${BoardDTO.id}</td>
						<td>${BoardDTO.BDate}</td>
						<td>${BoardDTO.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination" style="justify-content: center;">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=1&boardsearch=${searchtext}"
					aria-label="goFirstPage"> <span aria-hidden="true">1</span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.prevPageNo}&boardsearch=${searchtext}"
					aria-label="Previous"> <span aria-hidden="true"> &laquo;</span>
				</a></li>
				<c:forEach var="pageNo" begin="${Page.startPageNo}"
					end="${Page.endPageNo}" varStatus="vs">
					<c:choose>
						<c:when test="${pageNo eq Page.pageNo}">
							<li class="page-item"><a class="page-link text-danger"
								href="${pageContext.request.contextPath}/board/getlist?page=${pageNo}&boardsearch=${searchtext}">${pageNo}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/board/getlist?page=${pageNo}&boardsearch=${searchtext}">${pageNo}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.nextPageNo}&boardsearch=${searchtext}"
					aria-label="Next"> <span aria-hidden="true"> &raquo; </span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.finalPageNo}&boardsearch=${searchtext}"
					aria-label="goEndPage"> <span aria-hidden="true">${Page.finalPageNo}</span>
				</a></li>

			</ul>
		</nav>
		<div style="height: 50px">
			<a href="#" class="btn btn-success float-right">글쓰기</a> <a href="#"
				class="btn btn-success float-right">내가쓴글</a>
		</div>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>