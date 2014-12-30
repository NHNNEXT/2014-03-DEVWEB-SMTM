<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 등록 폼입니다.</h1>
	<c:if test="${not empty errorMessage}">
	<p>${errorMessage}</p>
	</c:if>

<form action="/RegisterServlet" method="POST">	
	아이디 : <input type="text" name="registerId" value="${usr.id}" /> <br>
	패스워드 : <input type="password" name="registerPw" value="${usr.pw}"> <br>
	이름 : <input type="text" name="registerName" value="${usr.name}"> <br>
	타입 : <input type="radio" name="registerType" value="2001">알바생
			<input type="radio" name="registerType" value="2002">점주<br>
	핸드폰 번호 :<input type="text" name="registerPhone1_0" value="010">-
	<input type="text" name="registerPhone1_1">-<input type="text" name="registerPhone1_2"> <br>
	성별 : <input type="radio" name="registerGender" value ="female" >여자 
			<input type="radio" name="registerGender" value ="male" >남자 
			<input type="radio" name="registerGender" value ="etc" >기타  
	 <br>
	생일 : <input type="date" name="registerBirth" value="${usr.birth}"> <br>
	<input type="submit" name="registerSubmit" value="가입">
</form>
	<a href="/jsp/index.jsp">홈화면 으로</a>
</body>
</html>