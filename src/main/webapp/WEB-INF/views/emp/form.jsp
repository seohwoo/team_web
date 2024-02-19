<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>form.jsp</title>
    </head>
    <body>
    	<form action="/emp/insert.do" method="post">
    		empno : 	<input type="text" name="empno" /> 	<br />
    		ename : 	<input type="text" name="ename" /> 	<br />
    		job : 		<input type="text" name="job" /> 	<br />
    		mgr : 		<input type="text" name="mgr" />	<br />
    		sal : 		<input type="text" name="sal" /> 	<br />
    		comm : 		<input type="text" name="comm" /> 	<br />
    		deptno : 	<input type="text" name="deptno" /> <br />
    		<input type="submit" value="추가" />
    	</form>
    </body>
</html>
