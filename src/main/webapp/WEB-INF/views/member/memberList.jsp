<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="resources/js/member.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>email</td>
			<td>blog</td>
			<td>reg_date</td>
			<td>status</td>
			<c:forEach var="dto" items="${list}">
				<tr>				
					<td>${dto.id}</td>
					<td>${dto.name}</td>
					<td>${dto.email}</td>
					<td>${dto.blog}</td>
					<td>
						<fmt:formatDate value="${dto.reg_date}" type="date" dateStyle="short" />
					</td>
						<td>
							<form action="/user/statusChange.me">
								<select name="status">
									<option value="0" ${dto.status == 0 ? 'selected' : ''}>탈퇴회원</option>
									<option value="1" ${dto.status == 1 ? 'selected' : ''}>일반회원</option>
									<option value="10" ${dto.status == 10 ? 'selected' : ''}>관리자</option>
								</select>
								
								<input type="hidden" name="id" value="${dto.id}" />
								<input type="submit" value="변경" />
							</form>
								<c:if test="${dto.status == 0}">탈퇴회원</c:if>
								<c:if test="${dto.status == 1}">일반회원</c:if>
								<c:if test="${dto.status == 10}">관리자</c:if>
						</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>


