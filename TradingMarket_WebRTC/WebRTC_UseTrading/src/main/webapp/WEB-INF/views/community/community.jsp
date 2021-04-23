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

		<%-- 페이지 갯수를 파라미터로 넘기기 위함  --%>
		<button onclick="Show_PageSize() " style="float: right;">페이지
			변경</button>
		<div id="pageSize" style="display: none; float: right;">
			<form action="${pageContext.request.contextPath}/board/getlist" 	method="get">
				<label>한 페이지 숫자</label> <select name="pageSize">
					<option value="10" selected="selected">10</option>
					<option value="20" selected="selected">20</option>
					<option value="50" selected="selected">50</option>
					<option value="100" selected="selected">100</option>
				</select>
				<button type="submit">적용</button>
				<input type="hidden" 	value="${pageNo}" name="page" />
			</form>
		</div>

		<div class="w-100" style="height: 50px;">
			<form class="float-right"
				action="${pageContext.request.contextPath}/board/getlist"
				method="get">
				<input type="text" name="boardsearch" placeholder="입력"
					value="${searchtext}">
				<button type="submit" class="btn btn-primary">검색</button>
			</form>

			<%-- 게시판 테이블  --%>
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
						<td><a
							href="${pageContext.request.contextPath}/board/getboardView?BNum=${BoardDTO.BNum}">${BoardDTO.BTitle}</a></td>
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
					href="${pageContext.request.contextPath}/board/getlist?page=1&boardsearch=${searchtext}&pageSize=${pageSize}"
					aria-label="goFirstPage"> <span aria-hidden="true">1</span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.prevPageNo}&boardsearch=${searchtext}&pageSize=${pageSize}"
					aria-label="Previous"> <span aria-hidden="true"> &laquo;</span>
				</a></li>
				<c:forEach var="pageNo" begin="${Page.startPageNo}"
					end="${Page.endPageNo}" varStatus="vs">
					<c:choose>
						<c:when test="${pageNo eq Page.pageNo}">
							<li class="page-item"><a class="page-link text-danger"
								href="${pageContext.request.contextPath}/board/getlist?page=${pageNo}&boardsearch=${searchtext}&pageSize=${pageSize}">${pageNo}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/board/getlist?page=${pageNo}&boardsearch=${searchtext}&pageSize=${pageSize}">${pageNo}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.nextPageNo}&boardsearch=${searchtext}&pageSize=${pageSize}"
					aria-label="Next"> <span aria-hidden="true"> &raquo; </span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/board/getlist?page=${Page.finalPageNo}&boardsearch=${searchtext}&pageSize=${pageSize}"
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

<script>
	function Show_PageSize() {
		var dpNone = document.getElementById('pageSize');
		dpNone.style.display = 'block'
	}
</script>

</html>
