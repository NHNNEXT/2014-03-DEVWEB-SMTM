<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>점포 찾기</h1>
	
	<form action="/FindStoreServlet" method="POST">
	점포이름 : <input type="text" name="storeId"> <br>
	점포번호 : <input type="password" name="StorePhone1"> <br>
	<input type="submit" name="findStoreSubmit" value="점포 찾기">
	</form>
	
	<form action="/SaveStoreServlet" method="POST">
	점포이름 : <input type="text" name="loginId"> <br>
	점포번호 : <input type="password" name="loginPw"> <br>
	<input type="submit" name="saveStoreSubmit" value="점포 등록">
	</form>
</body>
</html>