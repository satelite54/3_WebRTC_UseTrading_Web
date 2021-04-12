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
		<h1 class="hide">i7 본체 팝니다 PC [i7 3770K, 8gb ram, 256gb ssd,
			600w]</h1>

		<div id="carouselExampleIndicators" class="carousel slide w-60"
			style="margin: 0 auto;" data-ride="carousel">
			<ol id="caroIndicators" class="carousel-indicators">
<!--  				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li> -->
<!-- 				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li> -->
			</ol>
			<div id="caroInner" class="carousel-inner">
<%--  				<div class="carousel-item active">
					<img class="d-block w-100"
						src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=777&fg=555&text=First slide"
						alt="First slide">
				</div> --%>
<%-- 				<div class="carousel-item">
					<img class="d-block w-100"
						src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=666&fg=444&text=Second slide"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100"
						src="${pageContext.request.contextPath}/resources/img/caresel1.jpg??auto=yes&bg=555&fg=333&text=Third slide"
						alt="Third slide">
				</div> --%>
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

		<form action="${pageContext.request.contextPath}/product/addproduct"
			method="post" id="productAddForm" enctype="multipart/form-data">
			<section id="article-profile">
				<input type="file" id="photoInput" name="Photos" multiple="multiple" required
					accept="img/*" style="width: 100%; display: none;"> <a
					id="article-profile-link" href="/u/P2Ee0rrwz5K0RDMQ">
					<h3 class="hide">프로필</h3>
					<div class="space-between">
						<div>
							<div id="article-profile-image">
								<img alt="로빈"
									src="https://dnvefa72aowie.cloudfront.net/origin/profile/202102/4ea5464d7d39358663778e5d68911d6cf172f567e72faf6962732c921372f2ec.webp?q=82&amp;s=80x80&amp;t=crop">
							</div>
							<div id="article-profile-left">
								<div id="nickname">로빈</div>
								<div id="region-name">용산구 후암동</div>
							</div>
						</div>
						<div id="article-profile-right">
							<dl id="temperature-wrap">
								<dt>매너온도</dt>
								<dd class="text-color-05 ">
									44.6 <span>°C<span> </span></span>
								</dd>
							</dl>
							<div class="meters">
								<div class=" bar bar-color-05" style="width: 45%;"></div>
							</div>
							<div class=" face face-05"></div>
						</div>
					</div>
				</a>
				<button type="button" onclick="$('#photoInput').trigger('click');" class="btn btn-dark" style="float: right;">사진 업로드</button>
			</section>
			<section id="article-description">
				<h1 property="schema:name" id="article-title"
					style="margin-top: 0px;">
					<input style="width: 100%;" type="text" name="pTitle"
						placeholder="제목을 입력해 주세요.">
				</h1>
				<!-- 				<p id="article-category">
					디지털/가전 ∙
					<time> 17시간 전 </time>
				</p> -->
				<p property="schema:priceValidUntil" datatype="xsd:date"
					content="2023-04-10"></p>
				<p rel="schema:url" resource="https://www.daangn.com/219144460"></p>
				<p property="schema:priceCurrency" content="KRW"></p>
				<p id="article-price" property="schema:price" content="350000.0"
					style="font-size: 18px; font-weight: bold;">
					<input style="width: 100%;" type="number" name="pPrice"
						placeholder="가격을 입력해주세요.">
				</p>
				<div property="schema:description" id="article-detail">
					<p>
						<textarea rows="10" cols="83" name="pContent">내용을 입력해 주세요.</textarea>
					</p>
				</div>
				<button style="float: right;" type="submit" class="btn btn-dark">등록</button>
				<p id="article-counts">채팅 1 ∙ 관심 3 ∙ 조회 139</p>
			</section>
		</form>
	</article>

	<jsp:include page="../include/footer.jsp" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
	<script>
		$(function() {
			// 이미지 슬라이드 컨트롤를 사용하기 위해서는 carousel를 실행해야한다.
			$('#carouselExampleIndicators').carousel({
				// 슬리아딩 자동 순환 지연 시간
				// false면 자동 순환하지 않는다.
				interval : false,
				// hover를 설정하면 마우스를 가져대면 자동 순환이 멈춘다.
				pause : "hover",
				// 순환 설정, true면 1 -> 2가면 다시 1로 돌아가서 반복
				wrap : true,
				// 키보드 이벤트 설정 여부(?)
				keyboard : false
			});
		});
	</script>
<!-- 	<script>
		var photoInput = document.getElementById("photoInput");
		photoInput.addEventListener('change', function(e) {
				for(var photo in e.target.files) {	
					var div = document.createElement("div");
					div.className = "carousel-item";
					
					var img = document.createElement("img");
					img.setAttribute("src", event.target.result);
					img.className = "d-block w-100";
					div.appendChild(img);
					document.querySelector("div.carousel-inner").appendChild(div);
				};
				reader.readAsDataURL(photo);
			})
	</script> -->

	<script type="text/javascript">
        var sel_files = [];
 
        $(document).ready(function() {
            $("#photoInput").on("change", handleImgsFilesSelect);
        }); 
 
        function handleImgsFilesSelect(e) {
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);
 			var i = 0;
            filesArr.forEach(function(f) {
                if(!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다.");
                    return;
                }
 
                sel_files.push(f);
 				if(document.getElementsByClassName('carousel-item').length > 0) {
 					$("#caroIndicators").empty();
 					$("#caroInner").empty();
 				}
				var div = document.createElement("div");
				if(i == 0) {
					div.className = "carousel-item active";
				} else {
					div.className = "carousel-item";
				}
				
				var img = document.createElement("img");
				img.setAttribute("src", URL.createObjectURL(f));
				img.className = "d-block w-100";
				div.appendChild(img);
                
				var li = document.createElement("li");
				li.setAttribute("data-target", "#carouselExampleIndicators");
				li.setAttribute("data-slide-to", i.toString());
				i++;
				document.getElementById('caroIndicators').appendChild(li);
				
				
                var reader = new FileReader();
                reader.readAsDataURL(f);
                reader.onload = function(e) {/* 
                    var img_html = "<img src=\"" + e.target.result + "\" />"; */
                    $(".carousel-inner").append(div);
                }
            });
        }
 
    </script>
</body>
</html>