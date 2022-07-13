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
	<h1>전체 성적 조회</h1>
	<c:forEach var="stu" items="${scorevo}">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
			<tr>
				<td align=center><a href="/selectOne?id=${stu.id}">${stu.id}</a></td>
				<td align=center>${stu.stu_name}</td>
				<td align=center>${stu.kor}</td>
				<td align=center>${stu.eng}</td>
				<td align=center>${stu.math}</td>
			</tr>
		</table>
		<a href="/delete?id=${stu.id}">[삭제]</a>&ensp;
		<a href="/update?id=${stu.id}">[수정]</a>
	</c:forEach>
	<p><a href="/write-form">성적 등록 하기</a>&ensp;
</body>
</center>
</html>