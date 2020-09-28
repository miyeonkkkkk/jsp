<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectView.jsp
	
	<table border="1">
		<tr>
			<th>이름</th>
		</tr>
		<%-- request 객체에 저장된 rangers 속성을 이용하여 tr,td 그리고 ranger 이름 출력 --%>	
		<% List<String> rangers = (List<String>)request.getAttribute("rangers"); 
			if(rangers == null || rangers.size() == 0){
		%>		
				<tr>
					<td>데이터가 없습니다.</td>
				</tr>				
		<%		
			}else{
// 				for(String ranger : rangers){ 향상된 for문 -> 가독성이 좋음
				for(int i=0; i<rangers.size(); i++){ // 성능은 좋다.
		%>
					<tr>
						<td><%=rangers.get(i)%></td>
					</tr>
		<%			
				}
			}
		%>
	</table>
</body>
</html>