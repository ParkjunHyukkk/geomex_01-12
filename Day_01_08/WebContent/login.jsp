<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
window.history.forward(1);
</script>
<meta charset="EUC-KR">
<link rel="stylesheet" href="logindesin.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="center">
      <input type="checkbox" id="show">
      <label for="show" class="show-btn">Login Start</label>
      <div class="container">
        <label for="show" class="close-btn fas fa-times" title="close"></label>
        <div class="text">
Login Form</div>
<form action="loginService" method="post">

		<div class = "data">
			<fieldset>
				<table>
					<tr>
						<td>아이디</td>
						<td><input placeholder="아이디 입력" type="text" name="id" alert = "일치하는 아이디가 없습니다."></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input placeholder="비밀번호 입력" type="password" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="로그인">
						<input type="reset" value="초기화">
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form>
</body>
</html>