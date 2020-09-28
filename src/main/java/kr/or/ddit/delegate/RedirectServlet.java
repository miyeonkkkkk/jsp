package kr.or.ddit.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// servlet은 응답을 만들어 내는 역할이 아니라 요청을 받고 로직을 처리한후 
		// jsp에게 화면 응답 생성을 위임한다.
		
		System.out.println("redirectServlet.doGet()");
		
		// 응답을 다른 jsp에게 위임 하는 첫번째 방법 : redirect
		// response 객체의 sendRedirect 메서드를 통해 
		// 클라이언트에게 재요청을 보낼 주소를 알려준다.
		
		// 클라이언트 최초 요청 : http://localhost/redirectServlet
		// 서버에서 RedirectServelt의 service 메서드 호출
		// 클라이언트가 보낸 요청이 GET 방식이기 때문에 service ==> doGet() 호출
		// response객체를 이용하여 다른 jsp파일로 클라리언트에게 재요청 보내줄 것을 안내
		// 클라이언트가 최초 요청에 대한 응답(redirect 응답)을 받고서 서버의 안내대로
		// http://localhost/delegate/redirectView.jsp로 재요청
		// 그래서 최종적으로 클라이언트 주소줄에는 jsp 요청에 대한 주소가 남는다.
		// 클라이언트 입장에서는 서버로 요청을 총 두번 보내게 된다.
		
//		response.sendRedirect("/delegate/redirectView.jsp"); // 서버의 설정과 일치해야한다.
		
		
		List<String> rangers = new ArrayList<>();
		// 아래의 데이터를 db에서 조회한 데이터라고 생각하자
		rangers.add("Brown");
		rangers.add("Sally");
		rangers.add("Cony");
		rangers.add("Gray");
		
		request.setAttribute("rangers", rangers);
		// 서버가 redirect로 응답을 할 경우 클라이언트는 해당 주소로
		// 새로운 요청을 보내기 때문에 servlet에서 request 스코프에 설정한 속성은
		// 사용할 수 없기 때문에 redirectView.jsp에서는 데이터가 없다.
		
		// contextPath : jsp ==> "jsp/delegate/redirectView.jsp"
		// contextPath : ROOT(/) ==> "/delegate/redirectView.jsp"
		response.sendRedirect(request.getContextPath() + "/delegate/redirectView.jsp");
	}

}
