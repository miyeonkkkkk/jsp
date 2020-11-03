package kr.or.ddit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 기존 @WebServlet 혹은 web.xml url-mapping을 통해 url등록 => 스프링 @RequestMapping("/login")

@RequestMapping("/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	// view name => Controller는 문자열을 반환한다.
	
	// 클래스에 등록된 url이 나오고 메소드에 등록된 url이 나온다.
	// localhost/login(클래스 url)/view(메소드 url) => 요청 => 해당 메소드가 실행
	
	@RequestMapping("/view.do")
	public String getView(){
		logger.debug("LoginController.getView()");
		
		return "login/view";
	}

}
