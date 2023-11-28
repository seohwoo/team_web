<%@ page contentType="text/html; charset=UTF-8"%>

  <body>
  
  	<img src="/resources/file/user/${dto.img}" width="100" /> <br />
  	<a href="/user/imgForm.me">사진변경</a> <br />     
  	id : ${sessionScope.memId}<br />
  	name : ${dto.name} <br />
  
    <p>
    <a href="/user/modifyForm.me">정보수정</a>
    <a href="/user/deleteForm.me">탈퇴</a>
    </p>
  </body>
</html>
