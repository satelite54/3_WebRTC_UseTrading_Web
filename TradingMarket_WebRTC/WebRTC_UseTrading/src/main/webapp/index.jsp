<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/boardList?page=1&pageSize=5&search=">게시판</a> <br>
	<a href="${pageContext.request.contextPath}/MainAction">메인</a>
	<c:redirect url="/product/popularity">
<%--        <c:param name="NUM1" value="5"/>
       <c:param name="NUM2" value="0"/> --%>
    </c:redirect>
	
</body>
</html>
