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
			<h3>글내용 보기</h3>
			<form>
				<table width="500" border="1" cellspacing="0" cellpadding="0"  bgcolor="${bodyback_c }" align="center">  
				  <tr height="30">
				    <td align="center" width="125" bgcolor="${value_c}">글번호</td>
				    <td align="center" width="125" align="center">
					     ${article.num}</td>
				    <td align="center" width="125" bgcolor="${value_c}">조회수</td>
				    <td align="center" width="125" align="center">
					     ${article.readcount}</td>
				  </tr>
				  <tr height="30">
				    <td align="center" width="125" bgcolor="${value_c}">작성자</td>
				    <td align="center" width="125" align="center">
					     ${article.writer}</td>
				    <td align="center" width="125" bgcolor="${value_c}" >작성일</td>
				    <td align="center" width="125" align="center">
					     <fmt:formatDate value="${article.reg_date}" dateStyle="short" type="date"/> </td>
				  </tr>
				  <tr height="30">
				    <td align="center" width="125" bgcolor="${value_c}">글제목</td>
				    <td align="center" width="375" align="center" colspan="3">
					     ${article.subject}</td>
				  </tr>
				  <tr>
				    <td align="center" width="125" bgcolor="${value_c}">글내용</td>
				    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
				  </tr>
				  
				  
				  
				  
				  
				  
				  <tr>
				    	<td align="center" width="125" bgcolor="${value_c}">사진</td>
				    	<td align="left" width="375" colspan="3">
						    <c:forEach var="filename" items="${article2}">
						    	<img src="/resources/file/board/${filename}" width="100" height="100">
						  	</c:forEach>
				  			</td>
				  </tr>
				  
				  
				  
				  
				  
				  
				  
				  
				  <tr height="30">      
				    <td colspan="4" bgcolor="${value_c}" align="right" >
						<input type="button" value="글수정" 
						onclick="document.location.href='/free/updateForm?num=${article.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="글삭제" 
						onclick="document.location.href='/free/deleteForm?num=${article.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="답글쓰기" 
						onclick="document.location.href='/free/writeForm?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
				       <input type="button" value="글목록" 
				       onclick="document.location.href='/free/list?pageNum=${pageNum}'">
				    </td>
				  </tr>
				</table>
			</form>
			<br />
		</center>     
	</body>
</html>
   
