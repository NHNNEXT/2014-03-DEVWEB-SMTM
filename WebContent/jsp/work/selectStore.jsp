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

이름 : ${loginUsr.name} <br />
직책 :
<c:choose>
		<c:when test="${loginUsr.type == '2001'}"> 
			알바	
		</c:when>
		<c:otherwise>
			점주
		</c:otherwise>
</c:choose>
<table>
<tr>
	<th>가게 이름</th>
	<th>가게 주소</th>
	<th>가게 전화번호</th>
	<th>선택</th>	
</tr>

<c:forEach items="${storeList}" var="store" varStatus="status">
<tr>
    <td>${store.name}</td>
	<td>${store.addr}</td>
	<td>${store.phone1}</td>
		<c:choose>
		<c:when test="${loginUsr.type == '2001'}"> 
	  		<td><a href=
	  			"<c:url value="/GoToWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				</c:url>"> 
	  		<button>출근</button></a></td> 
	  	
			<td><a href=
				"<c:url value="/LeaveWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				</c:url>">
			<button>퇴근</button></a></td>
				
		</c:when>
		<c:otherwise>
			<td><a href=
	  			"<c:url value="/SelectWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				<c:param name="storeName" value="${store.name}" />
				</c:url>">
	  		<button>선택</button></a></td> 
		</c:otherwise>
		</c:choose>
</tr>
</c:forEach>
</table> 

<a href="/jsp/index.jsp">홈화면 으로</a>

</body>
</html>