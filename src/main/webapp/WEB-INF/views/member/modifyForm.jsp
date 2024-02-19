<%@ page language="java" contentType="text/html; charset=UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/etc/color.jsp"%>

<html>
<head>
<title>회원정보수정</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<script src="/resources/js/member.js" language="javascript"></script>
</head>


<body bgcolor="${bodyback_c}">
<form method="post" action="/user/modifyPro.me" name="userinput" onsubmit="return modifyCheckIt()">

  <table width="600" border="1" cellspacing="0" cellpadding="3"  align="center">
    <tr > 
      <td  colspan="2" height="39" bgcolor="${title_c}" align="center">
	     <font size="+1" ><b>회원 정보수정</b></font></td>
    </tr>
    <tr>
      <td colspan="2" class="normal" align="center">회원의 정보를 수정합니다.</td>
    </tr>
     <tr> 
      <td width="200" bgcolor="${value_c}"><b>아이디 입력</b></td>
      <td width="400" bgcolor="${value_c}">&nbsp;</td>
    <tr>  

    <tr> 
      <td  width="200"> 사용자 ID</td>
      <td  width="400">${dto.id}</td>
    </tr>
    
     <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400"> 
        <input type="password" name="passwd" size="10" maxlength="10" value="${dto.passwd}">
      </td>
    <tr>  
    <tr> 
      <td  width="200" bgcolor="${value_c}"><b>개인정보 입력</b></td>
      <td width="400" bgcolor="${value_c}">&nbsp;</td>
    <tr>  
    <tr> 
      <td   width="200">사용자 이름</td>
      <td  width="400"> 
        <input type="text" name="name" size="15" maxlength="20" value="${dto.name}">
      </td>
    </tr>
    <tr> 
      <td width="200">주민등록번호</td>
      <td width="400"> 
        ${dto.jumin1}-${dto.jumin2}
      </td>
    </tr>
   <tr> 
      <td width="200">E-Mail</td>
      <td width="400">
          <input type="text" name="email" size="40" maxlength="30" value="${dto.email}">	
      </td>
    </tr>
    <tr> 
      <td width="200">Blog</td>
      <td width="400">
          <input type="text" name="blog" size="60" maxlength="50" value="${dto.blog}">
      </td>
    </tr>      
    <tr> 
      <td colspan="2" align="center" bgcolor="${value_c}"> 
       <input type="submit" name="modify" value="수   정" >
       <input type="button" value="취  소" onclick="javascript:window.location='/user/main.me'">      
      </td>
    </tr>
  </table>
</form>
</body>
</html>