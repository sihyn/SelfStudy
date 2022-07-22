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
		<h1>게시글 등록</h1>
		<form method="post">
			<table cellspacing=1 width=300 border=1>
				<tr>
					<td align=center style="background-color: lavender">번호</td>
					<td align=center>자동부여</td>
				</tr>
				<tr>
					<td align=center style="background-color: lavender">제목</td>
					<td align=center><input name="title" maxlength="10"></td>
				</tr>
				<tr>
					<td align=center style="background-color: lavender">작성자</td>
					<td align=center><input name="writer" maxlength="10"></td>
				</tr>
				<tr>
					<td align=center style="background-color: lavender">내용</td>
					<td align=center><textarea type="text" name="content" rows="10" cols="22"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" value="등록">
		</form>
	</center>
</body>
</html>
