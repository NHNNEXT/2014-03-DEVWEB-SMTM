<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.Usr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty loginUsr}"> 
		<a href="/MakeStoreServlet">점포생성</a><br/>
		<a href="/RetrieveStoreListServlet">근로 요청</a><br/>
		<br/>
		<a href="/SelectStoreServlet">출퇴근요청</a><br/>
		<a href="/SelectStoreServlet">출퇴근승인</a><br/>
		<br/>
		<a href="/ShowWorkListServlet">근무기록확인</a><br/>
		<a href="/LogoutServlet">로그아웃 하기 </a><br/>
		<br/>
	</c:when>
	<c:otherwise>
		<a href="/LoginServlet">로그인</a><br/>
		<a href="/RegisterServlet">회원가입</a><br/>
	</c:otherwise>
</c:choose>
</body>
</html>