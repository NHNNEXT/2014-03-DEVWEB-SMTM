<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="entity.Store"%>
    <%@ page import ="java.util.Map"%>
    <%@ page import ="java.util.Iterator" %>
<%
	Map<String, Store> storeList = (Map<String, Store>)session.getAttribute("storeList");
	//아무것도 입력 않하고 점포 찾기 를 누르면 select all 되서 전부 나옴 ㅎㅎㅎㅎ
	//section 으로 저장 되어 있어서 새로고침 누르면 아무것도 않뜨는게 아니라 전에 입력했던 결과가 그대로 있음
	//map immutable mutable 상태 ?????? iterator 사용하면 좋다고 구글링에 나오네요
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>근로 요청</h1>
	
	<form action="/RetrieveStoreListServlet" method="POST">
	점포 찾기 <br>
	점포이름 : <input type="text" name="storeId"> <br>
	<input type="submit" name="findStoreSubmit" value="점포 찾기">
	</form>
	
	<br />
	<br />
	<% if(storeList !=null) {%>
	<form action="/SaveStoreServlet" method="POST">
		<table >
			<tr>
				<th>사업자 이름</th>
				<th>가게 이름</th>
				<th>가게 주소</th>
				<th>가게 전화번호</th>
			</tr>
			
			<% for(Store store : storeList.values()){%>
			<tr>
				<th><%=store.getUsr() %></th>
				<th><%=store.getName() %></th>
				<th><%=store.getAddr() %></th>
				<th><%=store.getPhone1() %></th>
			</tr>
			<% } %>
		</table>
		<input type="submit" name="saveStoreSubmit" value="점포 등록">
	</form>
	<% } %>
</body>
</html>