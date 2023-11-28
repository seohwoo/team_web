<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/etc/color.jsp"%>

<h1> 여기는 관리자 페이지</h1>

<h1> 아래는 회원정보</h1>

<h2>회원 목록</h2>
    <table border="1">
        <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>주민번호</th>
                <th>이메일</th>
                <th>블로그</th>
                <th>가입날자</th>
                <th>회원등급</th>               
                <th>등급변환</th>
                <th>변경버튼</th>
     
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${members}">
             <form action="memberviewsPro.me" method="post">
             <input type="hidden" value="${member.id}" name="id"/>
                <tr>
                  <td>${member.id}</td>         		
                  <td>${member.passwd}</td>         		
                  <td>${member.name}</td>         		
                  <td>${member.jumin1}-${member.jumin2} </td>         		
                  <td>${member.email}</td>         		
                  <td>${member.blog}</td>         		
                  <td>${member.reg_date}</td>         		
                  <td>${member.status}</td>
                  <td valgn="top">
					<select name="status">
					    <option value="0" ${member.status == 0 ? 'selected' : ''}>탈퇴</option>
					    <option value="1" ${member.status == 1 ? 'selected' : ''}>일반</option>
					    <option value="2" ${member.status == 2 ? 'selected' : ''}>휴먼</option>
					    <option value="10" ${member.status == 10 ? 'selected' : ''}>관리자</option>
					</select>
				  </td>			    			   				        		
                 <td>  
                  <input type="submit" value="변경">
                 </td>            		
          		
                </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>