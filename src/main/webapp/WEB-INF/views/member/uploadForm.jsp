<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>uploadForm</title>
    </head>
    <body>
    	<form action="/user/uploadPro.me" method="post" enctype="multipart/form-data">
    		업로드 : <input type="file" name="img"/> <br />
    		<input type="submit" value="전송" />
    	</form>
    </body>
</html>
