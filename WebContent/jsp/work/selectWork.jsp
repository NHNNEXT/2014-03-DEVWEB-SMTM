<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			점포 : ${storeName}
			<c:choose>
				<c:when test="${empty workList}">
					<p>모든 출퇴근 요청을 승인 하셨습니다!</p>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th>이름</th>
								<th>날짜</th>
								<th>출근시간</th>
								<th>퇴근시간</th>
								<th>출근승인</th>
								<th>퇴근승인</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${workList}" var="work" varStatus="status">
								<tr>
									<th>${work.name}</th>
									<fmt:parseDate value="${work.start}" var="start" pattern="yyyy-MM-dd HH:mm:ss" />
									<th><fmt:formatDate value="${start}" pattern="yyyy-MM-dd" /></th>
									<th><fmt:formatDate value="${start}" pattern="HH:mm" /></th>
									<c:choose>
										<c:when test="${not empty work.finish}">
											<fmt:parseDate value="${work.finish}" var="finish" pattern="yyyy-MM-dd HH:mm:ss" />
											<th><fmt:formatDate value="${finish}" pattern="HH:mm" /></th>
										</c:when>
										<c:otherwise>
											<th></th>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${not empty work.startConfirm}">
											<fmt:parseDate var="startConfirm" value="${work.startConfirm}" pattern="yyyy-MM-dd HH:mm:ss" />
											<th><fmt:formatDate value="${startConfirm}" pattern="yy-MM-dd HH:mm" /></th>
										</c:when>
										<c:otherwise>
											<th></th>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${not empty work.finishConfirm}">
											<fmt:parseDate var="finishConfirm" value="${work.finishConfirm}" pattern="yyyy-MM-dd HH:mm:ss" />
											<th><fmt:formatDate value="${finishConfirm}" pattern="yy-MM-dd HH:mm" /></th>
										</c:when>
										<c:otherwise>
											<th></th>
										</c:otherwise>
									</c:choose>
									<th><a
										href="<c:url value="/ConfirmWorkServlet">
		  								<c:param name="workIdx" value="${status.index}"/>
										</c:url>">
											<button class="btn btn-default">승인</button>
									</a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>