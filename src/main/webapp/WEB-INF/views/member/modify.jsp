<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<body>
		<img src="/resources/file/user/${dto.img}" width="300" /> <br />
			<a href="/user/imgForm.me">이미지변경</a> <br />
		
		id : ${sessionScope.memId } <br />
		passwd : ${dto.passwd } <br />
		jumin : ${dto.jumin1 } - ${dto.jumin2 } <br />
		email : ${dto.email } <br />
		blog  : ${dto.blog } <br />
		reg_date : <fmt:formatDate value="${dto.reg_date}" type="date" dateStyle="short" /> <br />
		status : ${dto.status } <br />
		name : ${dto.name} <br />  
	  
		<p>
			<a href="/user/modifyForm.me">정보수정</a>
			<a href="/user/deleteForm.me">탈퇴</a>
	    </p>
	</body>
</html>
