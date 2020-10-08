<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB"); // 서버마다 설정 방법이 다르다.

		// 걸리는 시간 체크
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 20; i++) {
		// Connection타입의 객체를 리턴, / getConnection() : static 메서드
		// appliction에서 관리 -> connection(pool)을 통해 connection을 맺고 끊은 과정의 부화를 효율적으로 관리가능하다.
		// web appliction에서 관리 -> connection(jndi) 서버에 올라가있는 모든 어플리케이션에서 공유할 수 있게 한다.
			Connection conn = ds.getConnection();
			conn.close();
		}
		long endTime = System.currentTimeMillis();
		out.println("<h3>endTime - startTime : " + (endTime - startTime) + "ms</h3>");
	%>

</body>
</html>