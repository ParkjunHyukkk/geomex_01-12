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
		[��ü ȸ�� ��� ��ȸ]<br />
		<table border="1">
			<tr>
				<th>���̵�</th>
				<th>��й�ȣ</th>
				<th>��ȭ��ȣ</th>
				
			<!--	<th colspan="4"></th> -->
				<!-- ���� ��� -->
				<!-- 1 : ��Ŀ -->
				<!-- 2 : ��ư -->
				<!-- 3 : �Լ� -->
				<!-- 4 : input type ��ư + �Լ� -->
			</tr>
			<%for (MemberDTO dto : list) { %>
				<tr align="center">
					<td><%=dto.getId() %></td>
					<td><%=dto.getPw() %></td>
					<td><%=dto.getTel() %></td>
				<!--	<td><input type="button" value="����" onclick="location.href='update.jsp?id=<%=dto.getId() %>'" /></td> -->
				</tr>
			<%} %>
		</table>
	</div>
</body>
</html>