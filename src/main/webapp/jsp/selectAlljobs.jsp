<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
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
	<table border="1">
		<tr>
			<td>JOB_ID</td>
			<td>JOB_TITLE</td>
		</tr>

	<%
		List<JobsVO> jobsList = (List<JobsVO>)request.getAttribute("jobsList");
		if(jobsList == null || jobsList.size() == 0){
	%>
			<tr>
				<td>존재하는 데이터가 없습니다.</td>
			</tr>
	<%		
		}else{
	
			for(JobsVO jv : jobsList){
	%>			
				<tr>
					<td><%=jv.getJob_id()%></td>
					<td><%=jv.getJob_title()%></td>
				</tr>
	<%			
			}
		}
	%>
	</table>
</body>
</html>