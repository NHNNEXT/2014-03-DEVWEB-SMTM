<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>

<p>Error message</p>
<%
	String error = (String)request.getAttribute("error");
	out.println(error);
%>

<a href="/LoginServlet">다시 회원가입</a>

<a href="/jsp/index.jsp">돌아가기</a>

</body>
</html>