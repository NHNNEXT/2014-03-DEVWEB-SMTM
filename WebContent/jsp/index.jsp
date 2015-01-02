<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/include/header.jspf"%>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/include/top.jspf"%>
		</div>
		<div class="section">
		<c:choose>
			<c:when test="${not empty errorMessage}">
				에러 메시지 : ${errorMessage} <br>
				자세한 사항은 010-1234-5678로 문의해주시기 바랍니다.
			</c:when>
			<c:otherwise>
				정직한 알바 시급 관리 서비스! 서비스는 로그인 후 이용 가능 합니다.
			</c:otherwise>		
		</c:choose>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>