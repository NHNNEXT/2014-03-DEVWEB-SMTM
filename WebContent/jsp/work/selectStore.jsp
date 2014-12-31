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
				<div>
					이름 : ${loginUsr.name} 
				</div>
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
							<div class="storeOwner">${store.usr}</div>
							<div class="storeAddr">${store.addr}</div>
							<div class="storePhone">${store.phone1}</div>
							<hr>
						</div>
					</c:forEach>
					<input class="btn btn-default" type="submit" name="saveStoreSubmit"
						value="근로 요청">
				</c:if>
			</form>


			
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
								<td><a
									href="<c:url value="/GoToWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				</c:url>">
										<button>출근</button>
								</a></td>

								<td><a
									href="<c:url value="/LeaveWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				</c:url>">
										<button>퇴근</button>
								</a></td>

							</c:when>
							<c:otherwise>
								<td><a
									href="<c:url value="/SelectWorkServlet">
				<c:param name="storeSeq" value="${store.seq}" />
				<c:param name="storeName" value="${store.name}" />
				</c:url>">
										<button>선택</button>
								</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>