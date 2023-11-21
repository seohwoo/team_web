<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>read</title>
    </head>
    <body>
    	<h1>this is show all board ..!!😁😁😁😁😁</h1>
    	<table>
    		<tr>
    			<td>번호</td>
    			<td>작성자</td>
    			<td>제목</td>
    			<td>내용</td>
    			<td>작성일</td>
    			<td>저장</td>
    			<td>조회수</td>
    		</tr>
    	
    	<c:forEach var="dto" items="${boardList }">
    		<tr>
    			<td>${dto.num }</td>
    			<td>${dto.writer }</td>
    			<td>${dto.title }</td>
    			<td>${dto.content }</td>
    			<td>${dto.reg }</td>
    			<td>${dto.save }</td>
    			<td>${dto.count }</td>
    		</tr>
    	</c:forEach>
    	</table>
    </body>
</html>
