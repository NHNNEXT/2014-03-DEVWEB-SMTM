<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.Usr"%>

<%
	Usr usr = (Usr)session.getAttribute("loginUsr");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
성공

<%=usr.getId()%>님 안녕하세요
 
<a href="/jsp/index.jsp">돌아가기</a>
<a href="/LogoutServlet">로그아웃 하기 </a>

</body>
</html>