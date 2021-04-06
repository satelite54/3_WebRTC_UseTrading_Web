<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- width=device-width : 페이지의 너비를 기기의 스크린 너비로 설정 -->
<!-- initial-scale=1.0 : 처음 페이지 로딩시 원래크기로 설정 -->
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
	<jsp:include page="include/header.jsp"/>

	<div id="carouselExampleIndicators" class="carousel slide w-60"
		style="margin: 0 auto;" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=777&fg=555&text=First slide"
					alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=666&fg=444&text=Second slide"
					alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=555&fg=333&text=Third slide"
					alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<div class="home-hot-content">
		<h1 class="home-main-title text-center home-hot-title">중고거래 인기매물
		</h1>
		<div class="cards-wrap">
			<c:forEach var="pPopul" items="${productPopulLists}">
				<article class="card-top ">
					<a class="card-link " data-event-label="211075940"
						href="/articles/211075940">
						<div class="card-photo ">
							<img alt="${pPopul.PTitle}"
								src="https://dnvefa72aowie.cloudfront.net/origin/article/202103/CB01AB870A661199EAD635DD26573DF129FFC263E9961453C7F6794219296F2F.jpg?q=82&amp;s=300x300&amp;t=crop">
						</div>
						<div class="card-desc">
							<h2 class="card-title"></h2>
							<div class="card-price ">${pPopul.PTitle}</div>
							<div class="card-region-name">인천 부평구 부평5동</div>
							<div class="card-counts">
								<span> 관심 ${pPopul.PHeart} </span> ∙ <span> 채팅 ${pPopul.PChatNum} </span>
							</div>
						</div>
					</a>
				</article>
			</c:forEach>
		</div>
		<div class="text-center">
			<a class="text-bold text-black text-m" href="/hot_articles"> 인기매물
				더 보기</a>
		</div>
	</div>
	
	<jsp:include page="include/footer.jsp"/>
	
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<!-- 				<ul class="footer-ul">
					<li class="footer-li">믿을 수 있는 중고거래</li>
					<li class="footer-li">자주 묻는 질문</li>
				</ul> -->