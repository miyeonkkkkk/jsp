package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면 요청
		request.getRequestDispatcher("/jsp/input.jsp").forward(request, response);
//		response.sendRedirect("/jsp/input.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// logger start, end 사이의 합 계산후 출력
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sumResult = 0;
		
		if(start > end) {
			for(int i=end; i <= start; i++) {
				sumResult += i;
			}
			
		}else if(start < end) {
			for(int i=start; i <= end; i++) {
				sumResult += i;
			}
			
		}
		
		logger.debug("sumResult : {} ", sumResult);
		
		// start, end 사이의 값을 더하여 session에 저장
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sumResult);
		
		// sumResult.jsp로 forward
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
		// session에 저장된 sumResult 값 출력 -> jsp에서
		
	}

}
