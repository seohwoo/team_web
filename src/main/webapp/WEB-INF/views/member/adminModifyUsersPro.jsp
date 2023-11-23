<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>회원상태변경</title>
    </head>
    <body>
    	<h1>${id }님의 등급이 ${statusname }으로 변경되었습니다!</h1>
    	<form>
	    	<input type="button" value="메인으로" onclick="window.location='/user/main.me'">
      	</form>
    	5초후에 메인으로 이동합니다.<meta http-equiv="Refresh" content="5;url=/user/main.me" >
    </body>
</html>
