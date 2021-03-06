<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/include/header.jspf"%>
<link rel="stylesheet" media="screen" href="/css/form.css">
</head>
<body>
	<!-- //아이디가이미 있을경우  -->
	<div class="container">
		<div class="header">
			<%@ include file="/include/top.jspf"%>
		</div>
		<div class="section">
			<%@ include file="/include/error.jspf"%>

			<form class="form-horizontal" action="/RegisterServlet" method="POST">
				<div class="line"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label">아이디</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="4~24자의 문자를 입력해 주세요" name="registerId"
							value="${inputUsr.id}">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="registerPw"
							value="${inputUsr.pw}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">이름</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="4~45자의 문자를 입력해 주세요" name="registerName"
							value="${inputUsr.name}">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">타입</label>
					<div class="col-sm-6">
						<label> <input type="radio" name="registerType"
							value="2001"> 알바생
						</label> <label> <input type="radio" name="registerType"
							value="2002"> 점주
						</label>
					</div>
				</div>
				<div class="line"></div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">핸드폰 번호</label>
					<div class="col-sm-6">
						<input type="text" class="form-control phone"
							name="registerPhone0" value="010"> - <input type="text"
							class="form-control phone" name="registerPhone1"> - <input
							type="text" class="form-control phone" name="registerPhone2">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">성별</label>
					<div class="col-sm-6">
						<label> <input type="radio" name="registerGender"
							value="female"> 여자
						</label> <label> <input type="radio" name="registerGender"
							value="male"> 남자
						</label>
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">생일</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" name="registerBirth"
							value="${inputUsr.birth}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-default"
							name="registerSubmit">Sign in</button>
					</div>
				</div>
			</form>
		</div>
		<div class="footer">
			<%@ include file="/include/footer.jspf"%>
		</div>
	</div>
</body>
</html>