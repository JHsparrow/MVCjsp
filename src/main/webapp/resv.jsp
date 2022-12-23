<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%@include file="topmenu.jsp" %>
	<section>
		<form name="frm" action="result">
			<table>
				<tr>
					<td>학번</td>
					<td><input type="text" name="stid" /></td>
				</tr>
				<tr>
					<td>과목코드 예)S001</td>
					<td><input type="text" name="scode"  /></td>
				</tr>
				<tr>
					<td>중간(30%)(0~100) 점</td>
					<td><input type="text" name="mid" /></td>
				</tr>
				<tr>
					<td>기말(30%)(0~100) 점</td>
					<td><input type="text" name="fin" /></td>
				</tr>
				<tr>
					<td>출석(20%)(0~100) 점</td>
					<td><input type="text" name="att" /></td>
				</tr>
				<tr>
					<td>레포트(10%)(0~100) 점</td>
					<td><input type="text" name="rep" /></td>
				</tr>
				<tr>
					<td>기타(10%)(0~100) 점</td>
					<td><input type="text" name="etc" /></td>
				</tr>
				<tr class="votebtn">
					<td colspan="2">
						<input type="button" onclick="fn_submit()">
						<input type="reset" onclick="alert('정보를 지우고 처음부터 다시 입력합니다!')">
					</td>
				</tr>
			</table>
		</form>
	</section>
<%@include file="footer.jsp" %>
</body>
</html>