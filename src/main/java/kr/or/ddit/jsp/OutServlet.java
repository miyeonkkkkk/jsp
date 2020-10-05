package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ranger.service.RangerService;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/outServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ranger 정보 조회
		RangerService rangerService = new RangerService();
		
		// ranger 정보를 화면에 표현해줄 out.jsp 파일로 응답 생성을 위임
		// rnager 정보가 어딘가에 담겨야함
		// servlet에서는 3가지 scope가 사용가능
		// request < session < application
		// 해당 요청은 일회성으로만 처리해주면 레인저 이름 정보를 보관할 필요가 없고
		// 다른 요청과 관련이 없으므로 request가 적당하다.
		
		// servlet 상에서 작성할 코드
		// requset 객체에 rangers라는 속성이름으로 레인저 정보를 저장
		
		// 불필요한 메모리 사용
		//List<String> rangers = new ArrayList<>();
		
		List<String> rangers = rangerService.getRangers();
		request.setAttribute("rangers", rangers);
		
		// out.jsp(아직 안만듬 webapp/jsp/out.jsp에 생성)로 요청 위임(forward)
		request.getRequestDispatcher("jsp/out.jsp").forward(request, response);
		
		// out.jsp 에서는 rangers라는 속성을 꺼내서 loop를 돌며 화면에 출력
		// ***out 객체를 이용
	}

}
