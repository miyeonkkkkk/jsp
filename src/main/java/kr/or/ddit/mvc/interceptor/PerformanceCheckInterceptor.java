package kr.or.ddit.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerformanceCheckInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		long start = System.currentTimeMillis(); // 1ms = 1/1000 초
//		System.nanoTime(); // 1ns = 1/1000000000 초
		
		request.setAttribute("start", start);
		// 스프링에서는 기본적으로 싱글톤이기 때문에 request객체에 담아서 보낸다.
		
		
		// true : 다음 인터셉터 호출, 인터셉터가 없을 경우 handler(controller)
		// false : 요청 처리를 멈춘다. = controller까지 가지 않는다.
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long end = System.currentTimeMillis(); // 1ms = 1/1000 초
		
		long start = (long)request.getAttribute("start");
		
		logger.debug("end - start : {}" , (end - start));
		
	}
}
