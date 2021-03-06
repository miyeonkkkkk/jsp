package kr.or.ddit.mvc.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.mvc.exception.NoFileException;

@Controller
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@RequestMapping("/exception/respSt")
	public String responseStatus() throws NoFileException {
		logger.debug("ExceptionController.view()");

		try {
			// 파일을 찾는 로직이 있음.
			// 찾고자 하는 파일이 없어서 예외 발생
			throw new Exception();
		} catch (Exception e) {
			// Exception 대신 우리가 만든 NoFileException 으로 처리
			// NoFileException은 @ResponseStatus 설정에 의해
			// 404 코드로 사용자에게 응답 처리됨.
			throw new NoFileException();
		}
		
//		return "";
	}
	
	
	
//	@ExceptionHandler({ArithmeticException.class})
//	public String handler() { // 해당 Controller 안에서만 유효하다.
//		logger.debug("ExceptionController.handler()");
//		
//		//에러를 처리할 화면
//		return "exception/arithmetic";
//	}
}
