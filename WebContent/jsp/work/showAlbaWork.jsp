<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
	<td> </td>
	<td>출근 시각 </td>
	<td>퇴근 시각 </td>
	<td>출근 확인 시각 </td>
	<td>퇴근 확인 시각 </td>
	<td>승인</td>
	<td> </td>
</tr>

<c:forEach items="${workList}" var="work" varStatus="status">
<tr>
	<td> </td>
	<td>${work.start} </td>
	<td>${work.finish} </td>
	<td>${work.startConfirm} </td>
	<td>${work.finishConfirm} </td>
</tr>
</c:forEach>
</table>
</body>
</html>