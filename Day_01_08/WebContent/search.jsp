<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.model.MemberDTO"%>   
<%@page import="com.model.MemberDAO"%>   
<%@page import="java.util.ArrayList"%> 
<%
MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> list = dao.memberSearchAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP06</title>
</head>
<body>
	<div align="center">
		[전체 회원 목록 조회]<br />
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>전화번호</th>
				
			<!--	<th colspan="4"></th> -->
				<!-- 삭제 방법 -->
				<!-- 1 : 앵커 -->
				<!-- 2 : 버튼 -->
				<!-- 3 : 함수 -->
				<!-- 4 : input type 버튼 + 함수 -->
			</tr>
			<%for (MemberDTO dto : list) { %>
				<tr align="center">
					<td><%=dto.getId() %></td>
					<td><%=dto.getPw() %></td>
					<td><%=dto.getTel() %></td>
				<!--	<td><input type="button" value="수정" onclick="location.href='update.jsp?id=<%=dto.getId() %>'" /></td> -->
				</tr>
			<%} %>
		</table>
	</div>
</body>
</html>