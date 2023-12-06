<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>게시판</title>
	</head>
	
	<body>
		<h1>글목록</h1>
		<h3>전체글 ${count }</h3>
		<a href="/jpa/form">글작성</a> 
		<br /><br />
		<c:forEach var="dto" items="${list}">
			${dto.id } ${dto.pw } ${dto.age } <fmt:formatDate value="${dto.reg }" type="date" dateStyle="short"/>  <br />
		</c:forEach>
	</body>
</html>