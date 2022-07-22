<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
textarea{
margin-top:4px;
}
</style>
<center>
	<h1>댓글 수정</h1>
	<form method = "post" action = "/replyUpdate">
		<table cellspacing=1>
			<tr>
				<td width=600 align=right><input type = "submit" id = "submit" value = "수정"> &emsp; <input type=reset
					value="다시입력"></td>
			</tr>
		</table><br>
		<table border = 1, black>
				<!-- <th width=150 style="background-color: lavender"><p align=center>순번</p></th> -->
			<tr>
				<th width=150 style="background-color: lavender"><p align=center>이름</p></th>
				<td width=450 align=center><input type = "text" id = "name" name = "name" maxlength = "10" value="${replyitem.name}"/></td>
			</tr>
		<tr>
					<th width=150 style="background-color: lavender"><p align=center>내용</p></th>
					<td align=center><textarea type="text" name="content"
							rows="10" cols="52" maxlength="40" value="${replyitem.content}">${replyitem.content}</textarea></td>
				</tr>
		</table>
		<p align = center><input type="hidden" id="BoardId" name="BoardId" value="${board_item.id}" readonly></p>
		<p width=50><p align=center><a href="/oneview?id=${board_item.id}">[댓글 list]</a>
		<input type="hidden" id="id" name="id" value="${replyitem.id}" readonly>
	</form>
</html>