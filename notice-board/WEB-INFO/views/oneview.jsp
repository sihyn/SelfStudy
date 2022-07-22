<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
textarea
{
margin-top:4px;
}
</style>
<center>
	<body>
		<h1><a href="/list">게시글</a> ${board_item.id}</h1>
		<form method="post" action="/oneview">
			<table cellspacing=1 width=600 border=1>
				<tr>
					<th align=center style="background-color: lavender">번호</th>
					<td align=center><input type="number" name="id"
						value="${board_item.id}" readonly></td>
				</tr>
				<tr>
					<th align=center style="background-color: lavender">제목</th>
					<td align=center><input type="text" name="title"
						value="${board_item.title}" maxlength="10"></td>
				</tr>
				<tr>
					<th align=center style="background-color: lavender">내용</th>
					<td align=center><textarea type="text" name="content"
							rows="10" cols="62" value="${board_item.content}">${board_item.content}</textarea></td>
				</tr>
				<tr>
					<th align=center style="background-color: lavender">작성자</th>
					<td align=center><input type="text" name="writer"
						value="${board_item.writer}" maxlength="10"></td>
				</tr>
				<tr>
					<th align=center style="background-color: lavender">작성일자</th>
					<td align=center><input type="text" name="time"
						value="${board_item.time}" readonly></td>
				</tr>
			</table>
			<p>
				<input type=submit value="수정"> &emsp; <input type=reset
					value="다시입력">
			</p>
		</form>
		<form method="post" action="/replyInsert">
				<p align = center><h3>-- 댓글 --</h3></p>
					<p align = center><input type=hidden id=BoardId name=BoardId value="${board_item.id}" readonly></p>
					<table cellspacing=1 width=600 border=1>
				<tr>
					<th align=center style="background-color: lavender">이름</th>
					<td align=center><input type="text" name="name" id="name" maxlength="10" value=""></td>
				</tr>
				<tr>
					<th align=center style="background-color: lavender">댓글</th>
					<td align=center><textarea type="text" rows="4" cols="62" name="content" id="content" rows="4" cols="22" maxlength="40" value=""></textarea></td>
				</tr>
					</table>
					<p><input type="submit" id="submit" value="댓글 추가"> &emsp; <input type=reset
					value="다시입력"></p>
		</form>
		<h3>-- 댓글 list --</h3>
		<table cellspacing=1 width=600  border=1>
			<tr style="background-color: lavender">
				<th width=80>작성자</th>
				<th width=290>내용</th>
				<th width=90>수정/삭제</th>
			</tr>
			<c:forEach var="replyitem" items="${replyItems}">
				<p align = center><input type=hidden id=BoardId name=BoardId value="${board_item.id}" readonly></p>
				<tr>
					<td align=center>${replyitem.name}</td>
					<td align=center>${replyitem.content}</td>
					<td width=50><p align=center><a href="/replyUpdate?id=${replyitem.id}">[수정]</a><a href="/replyDelete?id=${replyitem.id}">[삭제]</a></p></td>
				</tr>
			</c:forEach>
		</table>
</center>
</body>
</html>