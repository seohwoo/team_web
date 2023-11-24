<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	<!-- fmt : fomatdate -->
<%@ include file="/resources/etc/color.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>전체회원보기</title>
        <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
		<script src="/resources/js/member.js" language="javascript"></script>
    </head>
    <body>
    	<table border="1">
    		<tr>
    			<td>아이디</td>	
    			<td>패스워드</td>	
    			<td>이름</td>	
    			<td>주민번호</td>	
    			<td>이메일</td>	
    			<td>블로그</td>	
    			<td>가입일</td>	
    			<td>등급</td>
    		</tr>
    		<c:forEach var="dto" items="${userList }">
    			<tr>
    				<td>${dto.id} </td>
    				<td>${dto.passwd} </td>
    				<td>${dto.name} </td>
    				<td>${dto.jumin1} - ${dto.jumin2} </td>
    				<td>${dto.email} </td>
    				<td>${dto.blog} </td>
    				<td><fmt:formatDate value="${dto.reg_date}" dateStyle="short" type="date"/></td>
    				<td>
 	   					<form action="/user/adminModifyUsersPro.me" method="post">
 	   						<input type="hidden" name="id" value="${dto.id }"/> 
 	   						<select name="status">
    							<c:forEach var="gradeDto" items="${gradeList }">
    								<option value="${gradeDto.status }" ${dto.status == gradeDto.status ? 'selected' : '' }>${gradeDto.statusname }</option>
    							</c:forEach>
    						</select>
 	   						<input type="submit" value="변경"/> 
 	   					</form>
 	   				</td>
    			</tr>
    		</c:forEach>
    	</table>
    </body>
</html>
