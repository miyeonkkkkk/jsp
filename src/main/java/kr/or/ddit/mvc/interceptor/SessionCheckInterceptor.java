package kr.or.ddit.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.member.model.MemberVO;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 사용자가 정상적으로 접속 했는지 체크
		// LoginController 컨트롤러를 통해 정상적으로 접속 했을 경우
		// SESSION에 S_MEMBER 속성이 존재해야함.
		
		MemberVO memberVo = (MemberVO)request.getSession().getAttribute("S_MEMBER");
		
		// 로그인 페이지로 이동
		if(memberVo == null) {
			response.sendRedirect("/login/view");
			
			// redirect를 보냈더라도 스프링에서 새로운 응답을 보낼수도 있기때문에 아래의 처리를 해주는것이 낫다.
			return false;
		}
		
		return true;
	}

}
