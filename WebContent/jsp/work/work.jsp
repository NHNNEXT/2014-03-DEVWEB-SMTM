<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "entity.Store" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Store> storeList = (ArrayList<Store>)request.getAttribute("storeList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<c:forEach items="${storeList}" var="store" varStatus="status">
<tr>
    <td>${status.count}</td>
    <td>${store.name}</td>
    <!-- 추후 store 객체에 해당 store를 넣어서 출근, 퇴근 처리요청(request)에 함께 보낸다
    보낼 때는 forward하면 될 듯 -->
   	<td><a href="/GoToWorkServlet"><button>출근</button></a></td>
	<td><a href="/LeaveWorkServlet"><button>퇴근</button></a></td>
</tr>
</c:forEach>
</table> 

</body>
</html>