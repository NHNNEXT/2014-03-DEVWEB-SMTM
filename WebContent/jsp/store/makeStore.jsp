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
			<h1>점포 생성</h1>
			
			<form class="form-horizontal" action="/MakeStoreServlet" method="POST">
				<div class="line"></div>
				<div class="form-group">
					<label class="col-sm-2 control-label">점포이름</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
							placeholder="4~45자의 문자를 입력해 주세요" name="registerId">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">주소</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="registerAddr">
					</div>
				</div>
				<div class="form-group">
					<label class=" col-sm-2 control-label">전화 번호</label>
					<div class="col-sm-6">
						<input type="text" class="form-control phone"
							name="registerPhone1_0" value="010"> - <input type="text"
							class="form-control phone" name="registerPhone1_1"> - <input
							type="text" class="form-control phone" name="registerPhone1_2">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-default"
							name="registerSubmit">점포 만들기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>