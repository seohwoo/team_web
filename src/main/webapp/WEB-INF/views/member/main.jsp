<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/etc/color.jsp"%>
<html>
	<head>
		<title>메인입니다..</title>
		<link href="/resources/css/style.css" rel="stylesheet" type="text/css"> 
		<script language="javascript" src="/resources/js/member.js"></script>
	</head>


<c:if test="${sessionScope.memId == null }">
<body onLoad="focusIt();" bgcolor="${bodyback}">
  <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
      <tr>
	    <td width="300" bgcolor="${bodyback}" height="20">
	      &nbsp;
	    </td>
   
       <form name="inform" method="post" action="/user/loginPro.me"  onSubmit="return checkIt();">

        <td bgcolor="${title_c}"  width="100" align="right">아이디</td>
        <td width="100" bgcolor="${value_c}">
            <input id="aa"  class="bb"  type="text" name="id" size="15" maxlength="10"></td>
      </tr>
      <tr > 
        <td rowspan="2" bgcolor="${bodyback}" width="300" >메인입니다.</td>
        <td bgcolor="${title_c}"  width="100" align="right">패스워드</td>
        <td width="100" bgcolor="${value_c}">
           <input type="password" name="passwd" size="15" maxlength="10"></td>
       </tr>
       <tr>
        <td colspan="3" bgcolor="${title_c}"   align="center">
            <input type="submit" name="Submit" value="로그인">
            <input type="button"  value="회원가입" onclick="javascript:window.location='/user/inputForm.me'"> 
        </td></form></tr></table>

	</c:if>
	
	
	<c:if test="${sessionScope.memId != null}">

       <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" bgcolor="${bodyback}" height="20">하하하</td>

           <td rowspan="3" bgcolor="${value_c}" align="center">
             ${sessionScope.memId} 님이 <br>            
             방문하셨습니다
             <form  method="post" action="/user/logout.me">  
             <input type="submit"  value="로그아웃">
             <input type="button" value="회원정보" onclick="javascript:window.location='/user/modify.me'">
             <input type="button" value="게시판가기" onclick="javascript:window.location='/free/list'">            
             <c:if test="${sessionScope.status == 10}">
                <input type="button" value="내 회원" onclick="javascript:window.location='/user/memberviews.me'">
                <input type="button" value="쌤 회원" onclick="javascript:window.location='/user/userList.me'">
             </c:if>
             </form>
             <c:if test="${dto.status ==0 }">탈퇴회원</c:if>
             <c:if test="${dto.status ==1 }">일반회원</c:if>
             <c:if test="${dto.status ==10 }">관리자</c:if>                
         </td>
        </tr>
       <tr > 
         <td rowspan="2" bgcolor="${bodyback}" width="300" >메인입니다.</td>
      </tr>
     </table>
     <br>
</c:if>

 </body>
</html>
