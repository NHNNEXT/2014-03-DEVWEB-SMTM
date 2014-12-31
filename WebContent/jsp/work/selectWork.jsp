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

			점포 : ${storeName}
			<table>

				<tr>
					<td></td>
					<td>알바 이름</td>
					<td>출근 시각</td>
					<td>퇴근 시각</td>
					<td>승인</td>
					<td></td>
				</tr>

				<c:forEach items="${workList}" var="work" varStatus="status">
					<tr>
						<td></td>
						<td>${work.usrName}</td>
						<td>${work.work.start}</td>
						<td>${work.work.finish}</td>
						<td><a
							href="<c:url value="/ConfirmWorkServlet">
  		<c:param name="workIdx" value="${status.index}"/>
		</c:url>">
								<button>승인</button>
						</a></td>
					</tr>
				</c:forEach>
			</table>


		</div>
	</div>
</body>
</html>