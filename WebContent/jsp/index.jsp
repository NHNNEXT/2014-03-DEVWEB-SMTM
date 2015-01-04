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
				<div id="bs-carousel-4" class="carousel carousel-two slide"
						data-ride="carousel" data-interval="5000" data-pause="hover"
						data-wrap="true">
						<!-- Bootstrap indicators. If you don't need indicators, remove the below section -->
						<ol class="carousel-indicators">
							<li data-target="#bs-carousel-4" data-slide-to="0" class="active"></li>
							<li data-target="#bs-carousel-4" data-slide-to="1" class=""></li>
							<li data-target="#bs-carousel-4" data-slide-to="2" class=""></li>
						</ol>
						<!-- Slides. You can also add captions -->
						<div class="carousel-inner">
							<!-- Item, First item should have extra class "active" -->
							<div class="item active">
								<!-- Image -->
								<img src="../img/s1.jpg" alt="">
								<!-- Carousel two content -->
								<div class="carousel-two-content">
									<h3>SHOW ME THE MONEY</h3>
								</div>
							</div>
							<div class="item">
								<img src="../img/s2.jpg" alt="">
								<!-- Carousel two content -->
								<div class="carousel-two-content">
									<h3>SAVE YOUR TIME</h3>
								</div>
							</div>
							<div class="item">
								<img src="../img/s3.jpg" alt="">
								<!-- Carousel two content -->
								<div class="carousel-two-content">
									<h3>Die Another Day</h3>
								</div>
							</div>
						</div>
						<!-- Carousel controls (arrows). If you don't need controls, remove the below section -->
						<a class="left carousel-control" href="#bs-carousel-4"
							role="button" data-slide="prev"> <span
							class="fa fa-chevron-left"></span>
						</a> <a class="right carousel-control" href="#bs-carousel-4"
							role="button" data-slide="next"> <span
							class="fa fa-chevron-right"></span>
						</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>