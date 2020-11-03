package kr.or.ddit.login;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.service.MemberServiceImpl;

// 기존 @WebServlet 혹은 web.xml url-mapping을 통해 url등록 => 스프링 @RequestMapping("/login")

@RequestMapping("/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	// view name => Controller는 문자열을 반환한다.
	
	// 클래스에 등록된 url이 나오고 메소드에 등록된 url이 나온다.
	// localhost/login(클래스 url)/view(메소드 url) => 요청 => 해당 메소드가 실행
	
	@RequestMapping("/view.do")
	public String getView(){
		logger.debug("LoginController.getView()");
		
		return "login/view";
	}
	
	// 파라미터 이름과 동일한 이름의 메소드 인자를 선언하면
	// 스프링 프레임워크가 자동으로 바인딩 해준다.
	// 값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드며와 파라미터 명이
	// 동일하면 자동으로 바인딩 처리를 해준다.
	// 이때 값을 담는 객체를 스프링 프레임 워크에서는 command 객체라고 한다.
	@RequestMapping("/process")
	public String process(String userid, String pass, MemberVO memberVo) {
//		logger.debug("LoginController.process() {} / {} / {}", userid, pass, memberVo);
		
//		memberService = new MemberServiceImpl();
		MemberVO mv = memberService.getMember(userid);
		
		logger.debug("memberVO : {}", mv);
		
		return "login/view";
	}

}
