<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

</head>
<body>
	<div class="header">
		<div class="header_center">
			<img class="logo" alt="logo"
				src="${pageContext.request.contextPath}/resources/img/logo.png">
			<div class="searchbox">
				<form action="Search" method="get">
					<input class="searchtext" type="text" style="border: 0px" placeholder="검색할 상품명을 입력해주세요.">
				</form>
				<a href="${pageContext.request.contextPath}/search">
					<img class="search" alt="search"
					src="${pageContext.request.contextPath}/resources/img/search.png">
				</a>
			</div>

			<img class="goAndroid" alt="Androidbtn"
				src="${pageContext.request.contextPath}/resources/img/playstore.png">
		</div>
	</div>

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

	<div class="footer">
		<div class="footer-center-box w-60 h-50 footer-center">
			<div class="footer-navbar">
				<img class="footer-logo footer-top-left" src="${pageContext.request.contextPath}/resources/img/footerlogo.png">
			</div>
			<div class="footer-navbar">
			
			</div>
			<div class="footer-navbar">
			
			</div>
			<div class="footer-navbar">
			
			</div>
		</div>
		<div class="w-60 footer-center">
			<p class="footer-font footer-padding">Made by 김태헌</p>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>