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
	<div class="container">
		<div class="header">
			<%@ include file="/include/top.jspf"%>
		</div>
		<div class="section">
			<h2>회원가입</h2>

			<form class="form-horizontal" action="/RegisterServlet" method="POST">
				<div class="line"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label">아이디</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="4~45자의 문자를 입력해 주세요" name="registerId">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="registerPw">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">이름</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="4~45자의 문자를 입력해 주세요" name="registerName">
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
							name="registerPhone1_0" value="010"> - <input type="text"
							class="form-control phone" name="registerPhone1_1"> - <input
							type="text" class="form-control phone" name="registerPhone1_2">
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
						<input type="date" class="form-control" name="registerBirth">
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
	</div>
</body>
</html>