<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "DTO.Allview" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<Allview> list = new ArrayList<Allview>();
list = (ArrayList<Allview>)request.getAttribute("alllist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" >
</head>
<body>
	<%@include file="topmenu.jsp" %>
	<section>
		<table border="1">
			<tr>
				<th>학번</th>
				<th>성명</th>
				<th>성별</th>
				<th>과목명</th>
				<th>전공구분</th>
				<th>담당교수</th>
				<th>중간</th>
				<th>기말</th>
				<th>출석</th>
				<th>레포트</th>
				<th>기타</th>
				<th>점수</th>
				<th>등급</th>
			</tr>
			<%for (Allview av : list){ %>
			<tr>
				<td><%=av.getId()%></td>
				<td><%=av.getName() %></td>
				<td><%=av.getSex() %></td>
				<td><%=av.getSubject() %></td>
				<td><%=av.getMajor() %></td>
				<td><%=av.getProfessor() %></td>
				<td><%=av.getMid() %></td>
				<td><%=av.getfScore() %></td>
				<td><%=av.getAttend() %></td>
				<td><%=av.getReport() %></td>
				<td><%=av.getEtc() %></td>
				<td><%=av.getScore() %></td>
				<td><%=av.getGrade() %></td>
			</tr>
			<% } %>
		</table>
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>