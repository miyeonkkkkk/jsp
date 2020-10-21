package kr.or.ddit.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
//		세션에 저장된 속성 제거 : session.invalidate();
		session.invalidate();
		
//		session.removeAttribute("S_MEMBER"); => 지정된 속성 1개만 삭제됨.
//		session.setMaxInactiveInterval(0); => listener 적용 안됨 , 속성 삭제 안됨
		
//		응답 화면 : login.jsp
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
