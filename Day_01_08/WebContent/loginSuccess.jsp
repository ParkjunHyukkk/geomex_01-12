<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript">
window.history.forward(1);
</script>
<meta charset="UTF-8">

<title>Insert title here</title>
<script type="text/javascript">

    function oneCheckbox(a){

        var obj = document.getElementsByName("food");

        for(var i=0; i<obj.length; i++){

            if(obj[i] != a){

                obj[i].checked = false;

            }

        }

    }

</script>



</head>

<body>
	<h2>설문 조사</h2>

	<form action="add" method="post">

		<table>
			<tr>

				<td>음식을 골라주세요</td>
				
				</tr>
                <tr>    
				<td><input type="checkbox" name="food" value="등심돈까스" onclick='oneCheckbox(this)'> 등심돈까스</td>
				<tr/>
				<tr>
				<td><input type="checkbox" name="food" value="육회비빔밥" onclick='oneCheckbox(this)'> 육회비빔밥</td>
			    </tr>
			    <tr>
			    <td><input type="checkbox" name="food" value="샌드위치" onclick='oneCheckbox(this)'> 샌드위치</td>
			    </tr>
			    <tr>
			    <td><input type="checkbox" name="food" value="장어덮밥" onclick='oneCheckbox(this)'> 장어덮밥</td>
			    </tr>
			</tr>

			<tr>
			<tr align="left">
                <td></td>
				<td><input type="submit" value="선택"></td>

			</tr>
			
			

		</table>
		</form>
			<div align="left">
		[table]<br />
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>전화번호</th>
				<th>음식</th>
				
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
					<td><%=dto.getTel() %></td>
					<td><%=dto.getfood() %></td>
				<!--	<td><input type="button" value="수정" onclick="location.href='update.jsp?id=<%=dto.getId() %>'" /></td> -->
				</tr>
			<%} %>
		</table>
	</div>

	</form>
<form action="loginout" method="post">
<input type="submit" value="로그아웃">
</form>
</body>
</html>