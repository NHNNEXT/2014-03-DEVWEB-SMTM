<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼 입니다.</h1>
	<form action="/LoginServlet" method="POST">
	아이디 : <input type="text" name="loginId"> <br>
	패스워드 : <input type="password" name="loginPw"> <br>
	<input type="submit" name="loginSubmit" value="로그인">
	</form>
	
	<a href="/jsp/index.jsp">홈화면 으로</a>
</body>
</html>