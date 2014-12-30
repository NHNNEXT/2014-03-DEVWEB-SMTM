<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/include/header.jspf"%>
	<link rel="stylesheet" media="screen"  href="/css/form.css">
</head>
<body>


	<div class="header">
		<%@ include file="/include/top.jspf" %>
	</div>
	<div class="section">
		<h2> 로그인 </h2>
			<form class="form-horizontal" action="/LoginServlet" method="POST">
			  <div class="line"></div>
			  <div class="form-group">
			  	<label class="col-sm-2 control-label">아이디</label>
			    <div class="col-sm-6">
					<input type="text" class="form-control" placeholder="4~45자의 문자를 입력해 주세요" name="loginId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class=" col-sm-2 control-label">비밀번호</label>
			    <div class="col-sm-6">
					<input type="password" class="form-control" name="loginPw">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-8">
			      <button type="submit" class="btn btn-default"> 로그인 </button>
			    </div>
			  </div>
			</form>
	</div>
</body>
</html>