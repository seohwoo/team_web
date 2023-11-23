<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/etc/color.jsp"%>
<html>
<head>
	<title>회원가입</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
	<script language="JavaScript" src="resources/js/member.js"></script>    


<body bgcolor="${bodyback_c}">

<form method="post" action="/user/inputPro.me" name="userinput" onSubmit="return inputCheckIt()">
	<table width="600" border="1" cellspacing="0" cellpadding="3" align="center" >
    	<tr> 
    		<td colspan="2" height="39" align="center" bgcolor="${value_c}" >
       			<font size="+1" ><b>회원가입</b></font></td>
    	</tr>
    
    	<tr> 
      		<td width="200" bgcolor="${value_c}"><b>아이디 입력</b></td>
     		 <td width="400" bgcolor="${value_c}">&nbsp;</td>
   	 	</tr>  	

   		 <tr> 
      		<td width="200"> 사용자 ID</td>
     		<td width="400"> 
        		<input type="text" name="id" size="10" maxlength="12">
       			<input type="button" name="confirm_id" value="ID중복확인" 
        			        OnClick="openConfirmid(this.form)">
      		</td>
    	</tr>
    <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400" > 
        <input type="password" name="passwd" size="15" maxlength="12">
      </td>
    <tr>  
      <td width="200">비밀번호 확인</td>
      <td width="400"> 
        <input type="password" name="passwd2" size="15" maxlength="12">
      </td>
    </tr>
    
    <tr> 
      <td width="200" bgcolor="${value_c}"><b>개인정보 입력</b></td>
      <td width="400" bgcolor="${value_c}">&nbsp;</td>
    <tr>  
    <tr> 
      <td width="200">사용자 이름</td>
      <td width="400"> 
        <input type="text" name="name" size="15" maxlength="10">
      </td>
    </tr>
    <tr> 
      <td width="200">주민등록번호</td>
      <td width="400"> 
        <input type="text" name="jumin1" size="7" maxlength="6">
        -<input type="text" name="jumin2" size="7" maxlength="7">
      </td>
    </tr>
    <tr> 
      <td width="200">E-Mail</td>
      <td width="400"> 
        <input type="text" name="email" size="40" maxlength="30">
      </td>
    </tr>
    <tr> 
      <td width="200"> Blog</td>
      <td width="400"> 
        <input type="text" name="blog" size="60" maxlength="50">
      </td>
    </tr>
    <tr> 
      <td colspan="2" align="center" bgcolor="${value_c}"> 
          <input type="submit" name="confirm" value="등   록" >
          <input type="reset" name="reset" value="다시입력">
          <input type="button" value="가입안함" onclick="javascript:window.location='/user/main.me'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
