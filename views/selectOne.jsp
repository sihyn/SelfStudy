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
		<h1>${scorevo.id}번${scorevo.stu_name} 학생 성적 조회</h1>
		<table cellspacing=1 width=600 border=1>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
			<tr>
				<td align=center>${scorevo.id}</td>
				<td align=center>${scorevo.stu_name}</td>
				<td align=center>${scorevo.kor}</td>
				<td align=center>${scorevo.eng}</td>
				<td align=center>${scorevo.math}</td>
			</tr>
		</table>
		<br>
		<p>
			<a href="/list">점수 전체조회</a>
		</p>
	</body>
</center>
</html>