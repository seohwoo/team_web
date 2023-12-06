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
	<body bgcolor="${bodyback_c }">  	
		<center>
			<h3>글내용 보기</h3>
			<form>
				<table width="700" border="1" cellpadding="0" cellspacing="0">  
				  <tr >
				    <td bgcolor="${value_c}">글번호</td>
				    <td>${dto.num}</td>
				  </tr>
				  <tr>
				    <td bgcolor="${value_c}">글제목</td>
				    <td>${dto.subject}</td>
				  </tr>
				  <tr>
				    <td bgcolor="${value_c}">작성자</td>
				    <td>${dto.writer}</td>
				  </tr>
				  <tr>
				    <td bgcolor="${value_c}">글내용</td>
				    <td><pre>${dto.content}</pre></td>
				  </tr>
				    <c:if test="${dto.isfile>0 }">
				  		<tr>
					    	<td bgcolor="${value_c}">첨부파일</td>
							   <td>
					    		<c:forEach var="file" items="${imgList }">
							    	<a href="/free/download?filename=${file.filename }">${file.filename}</a> <br />
					    		</c:forEach>
							  </td>
				  		</tr>
				    </c:if>
				  <tr>
				    <td bgcolor="${value_c}">조회수</td>
				    <td>${dto.readcount}</td>
				  </tr>
				  <tr>
				    <td bgcolor="${value_c}">작성일</td>
				    <td>
					     <fmt:formatDate value="${dto.reg_date}" dateStyle="short" type="date"/> 
					</td>
				  </tr>
				  <tr>      
				    <td>
						<input type="button" value="글수정" 
						onclick="document.location.href='/free/updateForm?num=${dto.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
				    </td>
				    <td>
						<input type="button" value="글삭제" 
						onclick="document.location.href='/free/deleteForm?num=${dto.num}&pageNum=${pageNum}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>	
						<input type="button" value="답글쓰기" 
						onclick="document.location.href='/free/writeForm?num=${dto.num}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${article.re_level}'">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>	
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
   
