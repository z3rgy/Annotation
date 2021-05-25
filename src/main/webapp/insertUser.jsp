<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<style>
</style>
</head>
<body>
	<div id="div_box">
		<h1>회원 가입</h1>
		<form name="userForm" method="POST" action="insertUser.do">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><input type="text" name="role" /></td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="회원가입" />
					<input type="reset" value="다시쓰기" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>