<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>readNum.jsp</title>
    </head>
    <body>
    	<h1>this is empno list..!!</h1>
    	<c:forEach var="num" items="${list }">
			empno : ${num } <br />    	
    	</c:forEach>
    </body>
</html>
