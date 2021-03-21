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
	href="${pageContext.request.contextPath}/resources/css/reset.css">

</head>
<body>
	<div class="header">
		<div class="header_center">
			<img class="logo" alt="logo"
				src="${pageContext.request.contextPath}/resources/img/logo.png">
			<div class="searchbox">
				<form action="Search" method="get">
					<input class="searchtext" type="text">
				</form>
				<img class="search" alt="search" src="${pageContext.request.contextPath}/resources/img/search.png">
			</div>
			
			<img class="goAndroid" alt="Androidbtn" src="${pageContext.request.contextPath}/resources/img/playstore.png">
		</div>
	</div>
</body>
</html>