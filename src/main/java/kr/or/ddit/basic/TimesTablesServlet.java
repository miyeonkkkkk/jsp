package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 생성하는 방법
// 1. HttpServlet 클래스를 상속한다.
// 2. doXXX 메서드를 구현한다.
// 3. servlet은 정적 자료와 다르게 이름이 없다.
// => localhost/ServletTest/index.html (사용가능)
// => localhost/BasicServlet.java (사용불 가능)
// => url : 서블릿 매핑하는 작업이 필요한다.
// url을 직접 이름을 생성해줘야 한다.(web.xml)
public class TimesTablesServlet extends HttpServlet {

	// 웹브라우저에서는 doGet과 doPost만 지원한다.
	// ajax에서는 다양한 메서드 사용가능
	// 톰캣에서 web.xml로 new 하여 화면에 뿌려준다.
	// 톰캣은 Servlet container에 불과하다.
	// WAS : Servlet container + EJB container
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// writer 객체를 통해 html 문서를 생성해준다.
		PrintWriter writer = resp.getWriter();
		
		// 컨텐츠를 동적으로 변경시킨다.
		writer.println("<html>");
		writer.println("	<head><style>table{border : 3px solid orange}</style></head>");
		writer.println("	<body>");
		writer.println("		<table border='1'>");
		for(int i=1; i <10; i++) {
			writer.println("			<tr>");
			for(int j=2; j < 10; j++) {
				writer.println("				<td>" + j +" * "+ i + " = "+ (j*i) +"</td>");
			}
			writer.println("			</tr>");
		}
		writer.println("		</table>");
		writer.println("	</body>");
		writer.println("</html>");
		
		// 작성이 끝났으면 닫아준다.
		writer.flush(); // flush로 자동 close됨.
		writer.close();
		
		

	}

	
}
