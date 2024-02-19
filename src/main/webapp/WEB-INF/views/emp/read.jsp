<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>read.jsp</title>
    </head>
    <body>
    	<h1>read.jsp</h1>
    	<c:forEach var="dto" items="${list }">
    		${dto.empno } ${dto.ename } ${dto.job } <br />
    	</c:forEach>
    </body>
</html>
