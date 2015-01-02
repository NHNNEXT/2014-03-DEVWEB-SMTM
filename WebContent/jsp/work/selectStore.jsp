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
			<div>
				<div>이름 : ${loginUsr.name}</div>
				<div>
					직책 :
					<c:choose>
						<c:when test="${loginUsr.type == '2001'}"> 
							알바	
						</c:when>
						<c:otherwise>
							점주
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="storeList">
				<c:forEach items="${storeList}" var="store" varStatus="status">
					<div class="store">
						<div class="block-heading-two">
							<h3>
								<span>${store.name}</span>
							</h3>
						</div>
						<div class="storeOwner">${store.usr}</div>
						<div class="storeAddr">${store.addr}</div>
						<div class="storePhone">${store.phone1}</div>
						<div class="button">
							<c:choose>
								<c:when test="${loginUsr.type == '2001'}">
									<a
										href="<c:url value="/GoToWorkServlet"><c:param name="storeSeq" value="${store.seq}" />
				</c:url>">
											<button class="btn btn-default">출근</button>
									</a>

									<a
										href="<c:url value="/LeaveWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				</c:url>">
											<button class="btn btn-default">퇴근</button>
									</a>

								</c:when>
								<c:otherwise>
									<a
										href="<c:url value="/SelectWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				<c:param name="storeName" value="${store.name}" />
				</c:url>">
											<button class="btn btn-default">선택</button>
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>