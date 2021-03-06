<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dangCopy.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dangCopy2.css">
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<article id="content" data-id="219144460">
		<h1 class="hide">
			<c:out value="${product.PTitle}" />
		</h1>
		<div id="carouselExampleIndicators" class="carousel slide w-60"
			style="margin: 0 auto;" data-ride="carousel">
			<ol id="caroIndicators" class="carousel-indicators">
				<c:forEach var="photopath" items="${photopaths}" begin="0"
					end="${fn:length(photopaths)}" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index == 0}">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="#carouselExampleIndicators"
								data-slide-to="${vs.index}"></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div id="caroInner" class="carousel-inner">s
				<c:forEach var="photopath" items="${photopaths}" begin="0"
					end="${fn:length(photopaths)}" varStatus="vs">
					<c:choose>
						<c:when test="${vs.index == 0}">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="<spring:url value='/resources/img/${photopath}'/>"
									alt="First slide">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="<spring:url value='/resources/img/${photopath}'/>"
									alt="Second slide">
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
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


		<section id="article-profile">
			<div id="article-profile-link">
				<h3 class="hide">?????????</h3>
				<div class="space-between">
					<div>
						<div id="article-profile-image">
							<img alt="${product.PName}"
								src="https://dnvefa72aowie.cloudfront.net/origin/profile/202102/4ea5464d7d39358663778e5d68911d6cf172f567e72faf6962732c921372f2ec.webp?q=82&amp;s=80x80&amp;t=crop">
						</div>
						<div id="article-profile-left">
							<div id="nickname">${product.PName}</div>
							<div id="region-name">${product.PStreet}</div>

							<div>
								???????????? :
								<c:choose>
									<c:when test="${getConnect == 'true'}">
										??????
									</c:when>
									<c:otherwise>
										?????????
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div id="article-profile-right">
						<form action="${pageContext.request.contextPath}/create" method="post">
							<input type="hidden" name="roomId" value="${product.PNum}">
							<input name="${_csrf.parameterName}" type="hidden"
								   value="${_csrf.token}">
							<button class="btn btn-primary">????????????</button>
                        </form>
					</div>
				</div>
			</div>
		</section>
		<section id="article-description">
			<h1 property="schema:name" id="article-title"
				style="margin-top: 0px;">
				<input style="width: 100%;" type="text" name="pTitle"
					value="${product.PTitle}" disabled="disabled">
			</h1>
			<!-- 				<p id="article-category">
					?????????/?????? ???
					<time> 17?????? ??? </time>
				</p> -->
			<p property="schema:priceValidUntil" datatype="xsd:date"
				content="2023-04-10"></p>
			<p rel="schema:url" resource="https://www.daangn.com/219144460"></p>
			<p property="schema:priceCurrency" content="KRW"></p>
			<p id="article-price" property="schema:price" content="350000.0"
				style="font-size: 18px; font-weight: bold;">
				<input style="width: 100%;" type="text" value="${product.PPrice}"
					disabled="disabled">
			</p>
			<div property="schema:description" id="article-detail">
				<p>
					<textarea rows="10" cols="83" disabled="disabled"><c:out
							value="${product.PContent}" /></textarea>
				</p>
			</div>

			<button style="float: right;" type="submit" class="btn btn-dark">??????</button>
			<sec:authentication property="principal.num" var="uNum" />
			<div id="article-counts" style="display: inline;">
				??????
				<c:out value="${product.PChatNum}" />
				??? ??????
				<c:out value="${product.PView}" />
				??? ??????
				<p id="heartTotal" style="display: inline;">${product.PHeart}</p>
			</div>

			<a  href="javascript:void(0)"
				onclick="ajaxheart('${product.PNum}','${uNum}');"> <img id="heartimg" alt="??????"
				style="height: 20px;"
				src="${pageContext.request.contextPath}/resources/img/heart_black.png">
			</a>
		</section>
	</article>

	<jsp:include page="../include/footer.jsp" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script>
		$(function() {
			// ????????? ???????????? ???????????? ???????????? ???????????? carousel??? ??????????????????.
			$('#carouselExampleIndicators').carousel({
				// ???????????? ?????? ?????? ?????? ??????
				// false??? ?????? ???????????? ?????????.
				interval : false,
				// hover??? ???????????? ???????????? ???????????? ?????? ????????? ?????????.
				pause : "hover",
				// ?????? ??????, true??? 1 -> 2?????? ?????? 1??? ???????????? ??????
				wrap : true,
				// ????????? ????????? ?????? ??????(?)
				keyboard : false
			});
		});
	</script>
	<script>
		function ajaxheart(pNum, uNum) {
			$.ajax({
				type : 'POST',
				//JSON.stringify()
				data : {pNum : pNum, uNum : uNum},
				url : "../../../uestrading/product/addheart",
				//contentType : 'application/json',
				dataType : 'json',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
				},
				success : function(resp) {
					var heartimg = document.getElementById('heartimg');
					var TotalheartCnt = document.getElementById('heartTotal');
					if(resp.NBool == 1) {
						heartimg.setAttribute('src','/uestrading/resources/img/heart_red.jpg');
						TotalheartCnt.innerHTML = resp.NBool;
					} else {
						heartimg.setAttribute('src','/uestrading/resources/img/heart_black.png');
						TotalheartCnt.innerHTML = resp.NBool;
					}
				}
			});
		}
	</script>
</body>
</html>