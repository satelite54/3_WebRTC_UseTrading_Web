<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link rel="stylesheet" media="all"
	href="https://d1unjqcospf8gs.cloudfront.net/assets/home/search/index-c829b1465a7fdc86191738ab6d5a75935d4d5ac7806eb31485bca2402028f812.css" />
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<form action="${pageContext.request.contextPath}/product/plusView" method="get">
		<input type="hidden" id="plusView" name="pNum" value="${product.PNum}">
		<section id="result">
			<div class="result-container">
				<div id="flea-market-wrap" class="articles-wrap">
					<p class="article-kind">중고거래</p>
					<c:forEach var="product" items="${products}">
						<article class="flea-market-article flat-card">
							<a class="flea-market-article-link"
									href="${pageContext.request.contextPath}/product/getproduct/${product.PNum}">
								<div class="card-photo">
									<img alt="${product.PTitle}"
										src="<spring:url value='/resources/img/${product.PPhotoPath}'/>">
								</div>
								<div class="article-info">
									<div class="article-title-content">
										<span class="article-title">${product.PTitle}</span>
									</div>

									<p class="article-region-name">${product.PStreet}</p>
									<p class="article-price ">${product.PPrice}원</p>
									<section class="article-sub-info">
										<span class="article-watch"> <img class="watch-icon"
											alt="Watch count"
											src="https://d1unjqcospf8gs.cloudfront.net/assets/home/base/like-8111aa74d4b1045d7d5943a901896992574dd94c090cef92c26ae53e8da58260.svg" />
											${product.PView}
										</span>
									</section>
								</div>
							</a>
						</article>
					</c:forEach>
				</div>
			</div>
		</section>
	</form>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>