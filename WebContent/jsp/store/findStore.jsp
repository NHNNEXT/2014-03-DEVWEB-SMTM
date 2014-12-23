<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>근로 요청</h1>

	<form action="/RetrieveStoreListServlet" method="POST">
		점포 찾기 <br> 점포이름 : <input type="text" name="storeId"> <br>
		<input type="submit" name="findStoreSubmit" value="점포 찾기">
	</form>

	<br />
	<br />
	<form action="/SaveStoreServlet" method="POST">
		<table>
			<tr>
				<th>선택</th>
				<th>사업자 이름</th>
				<th>가게 이름</th>
				<th>가게 주소</th>
				<th>가게 전화번호</th>
			</tr>
			<c:if test="${not empty storeList}">
				<c:forEach items="${storeList.values()}" var="store">
					<tr>
						<th><input type="radio" name="storeSeq" value="${store.seq}"></th>
						<th>${store.usr}</th>
						<th>${store.name}</th>
						<th>${store.addr}</th>
						<th>${store.phone1}</th>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<input type="submit" name="saveStoreSubmit" value="근로 요청">
	</form>

	<br />
	<br />
	<br />
	<a href="/jsp/index.jsp">홈 화면으로</a>
</body>
</html>