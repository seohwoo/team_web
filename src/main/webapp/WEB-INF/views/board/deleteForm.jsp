<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>

<html>
	<head>
		<title>게시판</title>
		<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="resources/js/script.js"></script>
	</head>
	<body bgcolor="${bodyback_c}">
		<center>
			<b>글삭제</b>
			<br>
			<form method="POST" name="delForm"  action="/free/deletePro" onsubmit="return deleteSave()"> 
				 <table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
					  <tr height="30">
					     <td align=center  bgcolor="${value_c}">
					     	<b>비밀번호를 입력해 주세요.</b>
					     </td>
					  </tr>
					  <tr height="30">
					     <td align=center >비밀번호 :   
					       <input type="password" name="passwd" size="8" maxlength="12">
						   <input type="hidden" name="num" value="${num}">
						   <input type="hidden" name="pageNum" value="${pageNum}">
						 </td>
					 </tr>
					<tr height="30">
						<td align=center bgcolor="${value_c}">
							<input type="submit" value="글삭제" >
					      	<input type="button" value="글목록" 
					      	 onclick="document.location.href='/free/list?pageNum=${pageNum}'">     
					   	</td>
					</tr>  
				</table> 
			</form>
		</center>
	</body>
</html> 
