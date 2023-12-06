<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h1>/JPA/form.jsp</h1>
		<form action="/jpa/insert" method="post">
			id : <input type="text" name="id" /> <br />
			pw : <input type="text" name="pw" /> <br />
			age : <input type="text" name="age" /> <br />
				  <input type="submit" value="전송" /> <br />
		</form>
		
		<hr />
		<form action="/jpa/delete" method="post">
			id : <input type="text" name="id" /> <br />
			pw : <input type="text" name="pw" /> <br />
				  <input type="submit" value="전송" /> <br />
		</form>
	</body>
</html>