<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/include/header.jspf"%>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/include/top.jspf"%>
		</div>
		<div class="section">
			<h1>점포 생성 폼 입니다</h1>

			<form action="/MakeStoreServlet" method="POST">
				점포 이름 : <input type="text" name="registerName"> <br> 점포
				주소 : <input type="text" name="registerAddr"> <br> 점포
				전화번호 :<input type="text" name="registerPhone1_0" value="010">-
				<input type="text" name="registerPhone1_1">-<input
					type="text" name="registerPhone1_2"><br> <input
					type="submit" name="registerSubmit" value="만들기">
			</form>

		</div>
	</div>
</body>
</html>