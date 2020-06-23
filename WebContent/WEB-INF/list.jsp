<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%

	//꺼내쓸거야 전에 배운건 dao에서 꺼내쓰고 그랬는데 그럴필요가 없다
	//request.getAttribute("personList"); //꺼내줘
	//List<PersonVo> pList = 로쓸거야 쓰는건 setAttribute로 사용하느데 지금은 필요없어
	//List<PersonVo> 형변환에 형 / request.을 하면 object에서 꺼내왔다 object이기때문에 (List<PersonVo>)을 붙여줌
	//List<PersonVo> pList = //request.getAttribute("personList"); 데이터는 어트리뷰트에 넣어서 보내줌.
	//request.getAttribute(name);
	
	List<PersonVo> pList = (List<PersonVo>)request.getAttribute("personList"); //http://localhost:8088/pb3/list.jsp가 안되는 이유는 db에서 가져오는게 없다. 컨트롤러가 넣어준 후부터 실행가능
	//web-inf로 쓰면 밖으로 노출시키지 않겠다.. 보호막 생김 (링크url이없음) list일때 list.jsp에 접근해야할땐 상대경로나 절대경로로 이용하기때문에 url을 보호하는거와는  상관없다

%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
	
	<%
	 for(PersonVo vo : pList) {
	%>
	<table border = "1">
		<colgroup>
			<col style="width: 120px;">
			<col style="width: 170px;">
		</colgroup>
		<tbody>
			<tr>
				<td>이름(name)</td>
				<td><%= vo.getName() %></td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td><%= vo.getHp() %></td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td><%= vo.getCompany() %></td>
			</tr>
			<tr>
				<td>수정</td>
				<td>삭제></td>
			</tr>
		</tbody>
	</table>
	<br>

<%}%>
	
	<p>
		<a href="/pb3/pbc?action=wform">추가번호 등록</a>
	</p>
	

	

</body>
</html>