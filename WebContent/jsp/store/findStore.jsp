<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<%@ include file="/include/error.jspf"%>

			<form class="search form-inline" action="/RetrieveStoreListServlet"
				method="POST">
				<div class="input-group">
					<input class="form-control" type="text" name="storeName"
						placeholder="가게 이름"> <span class="input-group-btn">
						<input class="btn btn-default" type="submit"
						name="findStoreSubmit" value="검색">
					</span>
				</div>
			</form>

			<form class="storeList" action="/SaveStoreServlet" method="POST">
				<c:if test="${not empty storeList}">
					<c:forEach items="${storeList}" var="store">
						<div class="store">
							<div class="block-heading-two">
								<h3>
									<span>${store.name}</span> <input type="radio" name="storeSeq"
										id="inlineRadio3" value="${store.seq}">
								</h3>
							</div>
							<div class="storeOwner">${store.userName}</div>
							<div class="storeAddr">${store.addr}</div>
							<div class="storePhone">${store.phone}</div>
							<hr>
						</div>
					</c:forEach>
					<input class="btn btn-default" type="submit" name="saveStoreSubmit"
						value="근로 요청">
				</c:if>
			</form>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>