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
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<title>JASET VAPE</title>


</head>
<body>

	<div class="container" style="padding: 10dp">
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
					href="${pageContext.request.contextPath}/boardList?page=1&search="
					aria-label="goFirstPage"> <span aria-hidden="true">1</span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/boardList?page=${Page.prevPageNo}&search="
					aria-label="Previous"> <span aria-hidden="true"> &laquo;</span>
				</a></li>
				<c:forEach var="pageNo" begin="${Page.startPageNo}" end="${Page.endPageNo}" varStatus="vs">
					<c:choose>
						<c:when test="${pageNo eq Page.pageNo}">
							<li class="page-item"><a class="page-link text-danger"
								href="${pageContext.request.contextPath}/boardList?page=${pageNo}&search=">${pageNo}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/boardList?page=${pageNo}&search=">${pageNo}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/boardList?page=${Page.nextPageNo}&search="
					aria-label="Next"> <span aria-hidden="true"> &raquo; </span>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/boardList?page=${Page.finalPageNo}&search="
					aria-label="goEndPage"> <span aria-hidden="true">${Page.finalPageNo}</span>
				</a></li>
			</ul>
		</nav>
		<a href="#" onclick="checkForm1(); return false;"
			class="btn btn-success float-right">글쓰기</a>
	</div>
	<script type="text/javascript">function checkForm1() {if (${id==null}) {alert("로그인 해주세요.");return false;}location.href = "communityWrite.do?id=${id}"}</script>
	<script src="resources/js/jquery-3.5.1.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/css/bootstrap.min.css"></script>

</body>
</html>