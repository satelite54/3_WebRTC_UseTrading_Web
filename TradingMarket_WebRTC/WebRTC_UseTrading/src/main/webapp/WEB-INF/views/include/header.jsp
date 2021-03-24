<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="header">
	<div class="header_center">
		<img class="logo" alt="logo"
			src="${pageContext.request.contextPath}/resources/img/logo.png">
		<div class="searchbox">
			<form action="Search" method="get">
				<input class="searchtext" type="text" style="border: 0px"
					placeholder="검색할 상품명을 입력해주세요.">
			</form>
			<a href="${pageContext.request.contextPath}/search"> <img
				class="search" alt="search"
				src="${pageContext.request.contextPath}/resources/img/search.png">
			</a>
		</div>
		<img class="goAndroid" alt="Androidbtn"
			src="${pageContext.request.contextPath}/resources/img/playstore.png">
	</div>
</div>