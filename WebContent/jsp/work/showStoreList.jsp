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
			<div class="storeList">
				<c:forEach items="${storeList}" var="store" varStatus="status">
					<div class="store">
						<div class="block-heading-two">
							<h3>
								<span>${store.name}</span>
							</h3>
						</div>
						<div class="storeOwner">${store.userName}</div>
						<div class="storeAddr">${store.addr}</div>
						<div class="storePhone">${store.phone}</div>
						<a
							href="<c:url value="/ShowWorkListServlet">
							<c:param name="storeSeq" value="${store.seq}" />
							<c:param name="storeName" value="${store.name}" />
							</c:url>">
								<button class="btn btn-default btn-right">선택</button>
						</a>
						<hr>
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