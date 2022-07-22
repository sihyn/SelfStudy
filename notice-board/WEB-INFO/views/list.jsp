<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<center>
	<body>
		<h1>게시판 list</h1>
		<table cellspacing=1 width=500 border=1>
			<tr style="background-color: lavender">
				<th width=40px;>번호</th>
				<th width=140px;>제목</th>
				<th width=100px;>작성자</th>
				<th width=100px;>작성일자</th>
				<th width=70px;>삭제</th>
			</tr>
			<c:forEach var="board" items="${board_item}">
				<tr>
					<td align=center>${board.id}</td>
					<td align=center><a href="/oneview?id=${board.id}">${board.title}</a></td>
					<td align=center>${board.writer}</td>
					<td align=center>${board.time}</td>
					<td align=center><a href="/delete?id=${board.id}">[삭제]</a></td>
				</tr>
			</c:forEach>
		</table>
		 <table>
		<tr>
			<td width=50><p><a href="/list?page=${p.ppPage-1}&size=${p.pageSize}">&lt;&lt;</a></p></td>
			<td width=50><p><a href="/list?page=${p.pPage-1}&size=${p.pageSize}">&lt;</a></p></td>
			<c:forEach var="i" begin="${p.sPage}" end="${p.ePage}">
				<td width=50><p><a href="/list?page=${i-1}&size=${p.pageSize}">${i}</a></p></td>
			</c:forEach>
			<td width=50><p><a href="/list?page=${p.nPage-1}&size=${p.pageSize}">&gt;</a></p></td>
			<td width=50><p><a href="/list?page=${p.nnPage-1}&size=${p.pageSize}">&gt;&gt;</a></p></td>			
		</tr>
	</table>
		<p>
			<a href="/write-form">게시글 등록하기</a>&ensp;</p>
	</body>
</center>
</html>