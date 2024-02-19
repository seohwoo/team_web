<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>form</title>
    </head>
    <body>
        <form action="/1120/main3.do" method="post">
            name : <input type="text" name="name" /> <br />
            number : <input type="text" name="number" /> <br />
            <input type="submit" value="전송" />
        </form>
        <hr color="red"/>
        <form action="/1120/upload.do" method="post" enctype="multipart/form-data">
            file : <input type="file" name="save" /> <br />
            <input type="submit" value="전송" />
        </form>
    </body>
</html>
