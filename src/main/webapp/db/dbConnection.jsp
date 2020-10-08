<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		// DB작업에 필요한 객체변수 선언
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null; // 쿼리문이 select인 경우에 사용함.

			try {
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver"); // forName() : static 메서드 / 드라이버 로딩에 문제가 생기면 ClassNotFound 예외 발생

		// 2.DB에 접속(Connection 객체 생성)
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "KMY";
		String password = "java";

		// 걸리는 시간 체크
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i < 20; i++){
			// Connection타입의 객체를 리턴, / getConnection() : static 메서드
			// appliction에서 관리 -> connection(pool)을 통해 connection을 맺고 끊은 과정의 부화를 효율적으로 관리가능하다.
			// web appliction에서 관리 -> connection(jndi) 서버에 올라가있는 모든 어플리케이션에서 공유할 수 있게 한다.
			conn = DriverManager.getConnection(url, user, password);
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		out.println("<h3>endTime - startTime : " + (endTime - startTime) + "ms</h3>");

		// 3.Statement 객체 생성 => Connection객체를 이용한다.
		// 			stmt = conn.createStatement(); // Statement객체를 통해서 쿼리문을 날린다. => Statement는 Connection을 통해서 가져오기 때문에 먼 저 생성해야한다.

		// 4.SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
		// 			String sql = "SELECT * FROM LPROD"; // 실행할 SQL문
		// 			rs = stmt.executeQuery(sql); // ResultSet을 반환한다. / executeUpdate() : insert, delete, update 에 사용, 정수값을 반환한다.

		// 5.ResultSet객체에 저장되어 있는 자료를 반복문과 next()메서드를 이용하여 차례대로 읽어와 처리한다.
		// 			System.out.println("실행한 쿼리문 : " + sql);
		// 			System.out.println("=== 쿼리문 결과 ===");

		// rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고,
		//              그 곳에 자료가 있으면 true, 없으면 false를 반환한다.
		// 			while (rs.next()) {
		// 컬럼의 자료를 가져오는 방법
		// 방법1) rs.get자료형이름("컬럼명")
		// 방법2) rs.get자료형이름(컬럼번호) => 컬럼번호는 1부터 시작
		// 		System.out.println("lprod_id : " + rs.getInt(1));
		// 		System.out.println("lprod_gu : " + rs.getString(2));
		// 		System.out.println("lprod_name : " + rs.getString(3));
		// 		System.out.println("------------------------------------------");
		// 			}

		// 			System.out.println("출력 끝...");

			} catch (SQLException e) {
		e.printStackTrace();
			} catch (ClassNotFoundException e) {
		e.printStackTrace();
			} finally {
		// 6.종료(사용했던 자원을 모두 반납한다.)
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
	%>
</body>
</html>