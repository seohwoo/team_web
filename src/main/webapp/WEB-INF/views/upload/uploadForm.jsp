<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>uploadForm</title>
    </head>
    <body>
    	<form action="/file/uploadPro" method="post" enctype="multipart/form-data">
    		작성자 : <input type="text" name="writer"/> <br />
    		업로드 : <input type="file" name="upload"/> <br />
    		<input type="submit" value="전송" />
    	</form>
    </body>
</html>
