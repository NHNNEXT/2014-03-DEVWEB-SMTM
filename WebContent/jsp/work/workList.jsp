<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "entity.Work" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Work> workList = (ArrayList<Work>)request.getAttribute("workList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<c:forEach items="${workList}" var="work" varStatus="status">
<tr>
    <td>${status.count}</td>
    <td>${work.seq}</td>
       
  	<td><a href=
  		"<c:url value="/ConfirmWorkServlet">
		<c:param name="workSeq" value="${work.seq}" />
		</c:url>"> 
  	<button>승인</button></a></td> 
  	
</tr>
</c:forEach>
</table>

</body>
</html>