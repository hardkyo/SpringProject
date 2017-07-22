<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="root" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>Spring & iBatis를 이용한 사이트</h3>
<c:choose>
	<c:when test="${empty user}">
		<a href="${root}/user/register.kitri">회원가입</a><br>
		<a href="${root}/user/login.kitri">로그인</a><br>
	</c:when>
	<c:otherwise>
		<a href="${root}/user/logout.kitri">로그아웃</a><br>
	</c:otherwise>
</c:choose>


<%-- <c:choose>
	<c:when test="${user.name eq '이은아'}">
		이은아입니다.
	</c:when>
	<c:when test="${user.name eq 'test'}">
		test입니다.
	</c:when>
	<c:otherwise>
		둘다 아닙니다.
	</c:otherwise>
</c:choose> --%>
</center>
</body>
</html>