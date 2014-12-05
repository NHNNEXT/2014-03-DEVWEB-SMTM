<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.Usr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	if(session.getAttribute("loginUsr") != null)
	{
		Usr usr = (Usr)session.getAttribute("loginUsr"); 
		String usrType = usr.getType();
		pageContext.setAttribute("usrType", usrType);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/LoginServlet">로그인</a>
	<a href="/RegisterServlet">회원가입</a>
	<a href="/MakeStoreServlet">점포생성</a>
	<a href="/RetrieveStoreListServlet">근로 요청</a>
	
	<c:if test="${usrType == '2001'}">
		<a href="/WorkServlet">출퇴근요청</a>
	</c:if>
	<c:if test="${usrType == '2002'}">
		<a href="/WorkServlet">출퇴근승인</a>
	</c:if>
</body>
</html>