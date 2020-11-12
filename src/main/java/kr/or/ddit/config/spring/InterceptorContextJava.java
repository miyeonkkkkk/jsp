package kr.or.ddit.config.spring;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor;
import kr.or.ddit.mvc.interceptor.SessionCheckInterceptor;

//@Configuration
public class InterceptorContextJava extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new SessionCheckInterceptor())
										.addPathPatterns("/**")
										.excludePathPatterns("/login/**",
															 "/js/**",
															 "/css/**",
															 "/resources/**");
	}
	
	
}
