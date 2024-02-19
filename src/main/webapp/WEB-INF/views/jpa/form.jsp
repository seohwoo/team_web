<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>게시판</title>
	</head>
	
	<body>
		<h1>Insert JPA</h1>
		<a href="/jpa/list">목록으로</a>	
		<br /><br />
		<form action="/jpa/insert" method="post">
			id : <input type="text" name="id"/> 	<br />
			pw : <input type="text" name="pw"/> 	<br />
			age : <input type="number" name="age"/> <br />
			<input type="submit" value="전송"/> 		<br />
		</form>
		<br /><hr /><br />
		<form action="/jpa/delete" method="post">
			id : <input type="text" name="id"/> 	<br />
			pw : <input type="text" name="pw"/> 	<br />
			<input type="submit" value="전송"/> 		<br />
		</form>
	</body>
</html>