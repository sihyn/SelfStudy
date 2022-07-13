<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th{
background-color: pink;
}
</style>
</head>
<center>
	<body>
		<h1>수정 페이지</h1>
		<form method="post" action="/update">
			<h3>번호: ${scorevo.id}</h3>
			<table cellspacing=1 width=300 border=1>
				<tr>
					<th align=center>id</th>
					<td align=center><input type="number" name="id"
						value="${scorevo.id}" readonly></td>
				</tr>
				<tr>
					<th align=center>이름</th>
					<td align=center><input type="text" name="stu_name"
						value="${scorevo.stu_name}" maxlength="10"></td>
				</tr>
				<tr>
					<th align=center>국어</th>
					<td align=center><input type="number" name="kor"
						value="${scorevo.kor}" min="0" max="100"></td>
				</tr>
				<tr>
					<th align=center>영어</th>
					<td align=center><input type="number" name="eng"
						value="${scorevo.eng}" min="0" max="100"></td>
				</tr>
				<tr>
					<th align=center>수학</th>
					<td align=center><input type="number" name="math"
						value="${scorevo.math}" min="0" max="100"></td>
				</tr>
			</table>
			<p>
				<input type=submit value="수정"> &emsp; <input type=reset
					value="다시입력">
			</p>
	</body>
	</form>
</center>
</html>