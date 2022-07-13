<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>시험 점수 등록</h1>
		<form method="post">
			<table cellspacing=1 width=300 border=1>
			<tr>
					<td align=center style=background-color:pink>아이디</td>
					<td align=center>자동부여</td>
				</tr>
				<tr>
					<td align=center style=background-color:pink>이름</td>
					<td align=center><input name="stu_name" maxlength="10"></td>
				</tr>
				<tr>
					<td align=center style=background-color:pink>국어</td>
					<td align=center><input name="kor" min="0" max="100"></td>
				</tr>
				<tr>
					<td align=center style=background-color:pink>영어</td>
					<td align=center><input name="eng" min="0" max="100"></td>
				</tr>
				<tr>
					<td align=center style=background-color:pink>수학</td>
					<td align=center><input name="math" min="0" max="100"></td>
				</tr>
			</table><br>
			<input type="submit" value="성적 등록">
		</form>
	</center>
</body>