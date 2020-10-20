package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		// service 객체 생성
		memberService = new MemberServiceImpl();
	}
       
	// login화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("loginServlet.doGet");
		logger.debug("UNT_CD paramter : {}", request.getParameter("UNT_CD"));
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	// login화면에서 사용자가 보낸 아이디, 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
//		logger.debug("userId : " + userId + " password : " + password);
		logger.debug("userId : {} password : {} ", userId, password);
		
		// 파라미터로 온 userId가 디비상에 존재하는지 확인하고에, 해당하는 비밀번호가 데이터베이스에 저장된 비밀번호와 일치하는지 확인
		// public MemberVO getMember(String userId) : 회원 1명에 대한 정보를 조회하는 메서드
		// SELECT * FROM 회원 WHERE 회원아이디 = 파라미터로 넘어온 userId;
		
		// 일치할 경우 -> main페이지 이동 / 일치하지 않을 경우 -> login 페이지로 이동
		
		/* MemberServiceI memberService = new MemberServiceImpl(); */
		MemberVO memberVo = memberService.getMember(userId);
		
		// db에 등록된 회원이 없는 경우 또는 비밀번호가 틀린경우
		if(memberVo == null || !memberVo.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else if(memberVo.getUserid().equals(userId) && memberVo.getPass().equals(password)) { 
			// 로그인을 성공했을때 session 객체 생성
			request.getSession().setAttribute("S_MEMBER", memberVo);
			
			// 회원아이디가 존재하고, 비밀번호가 일치하는 경우(메인페이지 이동)
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}
		
		// 쿠키 정보
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			logger.debug("cookieNM : {} cookieValue : {}", cookie.getName(), cookie.getValue());
		}
		
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24); // 단위가 초
		
		response.addCookie(cookie);
		
	}

}
