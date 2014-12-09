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
<tr>
	<td></td>
	<td>가게 이름 </td>
	<td>알바 이름 </td>
	<td>출근 시각 </td>
	<td>출근 승인 시각 </td>
	<td>퇴근 시각 </td>
	<td>퇴근 승인 시각 </td>
	<td>(버튼)</td>
	<td></td>
</tr>
<c:forEach items="${workList}" var="work" varStatus="status">
<tr>
    <td>${status.count}</td>
    <td>점포 이름 ㅠ: ${work.seq}</td>
  	<td><a href=
  		"<c:url value="/ConfirmWorkServlet">
		<c:param name="work" value="${work}" />
		</c:url>"> 
  	<button>승인</button></a></td> 
</tr>
</c:forEach>
</table>

</body>
</html>