<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>회원상태변경</title>
    </head>
    <body>
    	<h1>${id }의 정보 변경</h1>
    	<form action="/user/adminModifyUsersPro.me" method="post">
    		<input type="hidden" name="id" value="${id }"/>
    		<select name="status">
    			<c:forEach var="dto" items="${gradeList }">
    				<option value="${dto.status }">${dto.statusname }</option>
    			</c:forEach>
    		</select>
    		<input type="submit" value="전송"/>
    	</form>
    </body>
</html>
