<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="JoinService" method="post">
		<div>
			<fieldset>
				<legend>
					<h1>회원가입 페이지</h1>
				</legend>
				<table>
					<tr>
						<td>아이디</td>
						<td><input placeholder="아이디 입력" type="text" name="id"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input placeholder="패스워드 입력" type="password" name="pw"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input placeholder="전화번호 입력" type="text" name="tel"></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="회원가입"><input
							type="reset" value="초기화"></td>
					</tr>
				</table>

			</fieldset>
		</div>
	</form>
</body>
</html>