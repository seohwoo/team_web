<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/etc/color.jsp"%>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">

	<c:if test="${check == 1 }">
		<tr bgcolor="${title_c}"> 
    		<td height="39"  align="center">
	  		<font size="+1" ><b>회원정보가 수정되었습니다.</b></font>
	  		</td>
 		 </tr>
  		<tr>
			<td bgcolor="${value_c}" align="center"> 
				<p>입력하신 내용대로 수정이 완료되었습니다.</p>
			</td>
		</tr>
		<tr>
			<td bgcolor="${value_c}" align="center"> 
				<form>
					<input type="button" value="수정창으로" onclick="window.location='/user/modify.me'">
				</form>
    		</td>
		</tr>
	</c:if>
	
	
	<c:if test="${check != 1 }">
		<tr bgcolor="${title_c}"> 
    		<td height="39"  align="center">
	  		<font size="+1" ><b>회원정보가 수정되지않았습니다.</b></font>
	  		</td>
 		 </tr>
  		<tr>
			<td bgcolor="${value_c}" align="center"> 
				<p>입력하신 내용대로 수정이 완료되지않았습니다.</p>
			</td>
		</tr>
		<tr>
			<td bgcolor="${value_c}" align="center"> 
				<form>
					<input type="button" value="수정창으로" onclick="window.location='/user/modify.me'">
				</form>
    		</td>
		</tr>
	</c:if>





 
</table>
</body>
</html>