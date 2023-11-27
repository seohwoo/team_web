<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>

<html>
<head>	
	<title>내정보</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
	<script src="/resources/js/member.js" language="javascript"></script>
</head>
 <body>
 	<center>
 		<br />
 		<h1>내정보</h1>
	 	<img src="/resources/file/user/${dto.img}" width="200px" height="200px"/> <br />
	 	<br /><a href="/user/uploadForm.me">사진변경</a><br />
	 	<br />
	 	<table border="1px" style="text-align: center;">
	 		<tr>
	 			<td>아이디</td>
	 			<td>이름</td>
	 			<td>주민번호</td>
	 			<td>이메일</td>
	 			<td>블로그</td>
	 			<td>가입일</td>
	 		</tr>
	 		<tr>
	 			<td>${sessionScope.memId }</td>
	 			<td>${dto.name }</td>
	 			<td>${dto.jumin1 }-${dto.jumin2 }</td>
	 			<td>${dto.email }</td>
	 			<td>${dto.blog }</td>
	 			<td><fmt:formatDate value="${dto.reg_date}" dateStyle="short" type="date"/></td>
	 		</tr>
	 	</table>
	    <p>
			<a href="/user/modifyForm.me">정보수정</a>
			<a href="/user/deleteForm.me">회원탈퇴</a>
			<a href="/user/main.me">메인으로</a>
	    </p>
    </center>
</body>
</html>
