<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>form</h2>
    
    <form action="insert.do" method="post">
    	ID : <input type="text" name="id"><br />
    	PW : <input type="text" name="passwd"><br />
    	이름 : <input type="text" name="name"><br />
    	주민번호 : <input type="text" name="jumin1">-<input type="text" name="jumin2"><br />
    	E-Mail : <input type="text" name="email"><br />
    	Blog : <input type="text" name="blog"><br />
    			<input type="submit" value="제출">
    </form>