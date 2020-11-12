package kr.or.ddit.config.spring;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

//<mvc:annotation-driven/>
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
			includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class })})
public class ApplicationContextJava extends WebMvcConfigurerAdapter{
	
	@Bean
	public ProfileImgView profileImgView() {
		
		ProfileImgView profileImgView = new ProfileImgView();
		
		return profileImgView;
	}
	
	@Bean
	public ProfileImgDownloadView profileImgDownloadView() {
		
		ProfileImgDownloadView profileImgDownloadView = new ProfileImgDownloadView();
		
		return profileImgDownloadView;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		
		MappingJackson2JsonView jackson2JsonView = new MappingJackson2JsonView();
		
		return jackson2JsonView;
	}
	
	@Bean
	public ExcelDownloadView excelView() {
		
		ExcelDownloadView excelDownloadView = new ExcelDownloadView();
		
		return excelDownloadView;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}

	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	
	// <mvc:default-servlet-handler /> => extends 구현(WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	// <mvc:resources mapping="/resources/**" location="/WEB-INF/views/" />
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
					.addResourceLocations("/WEB-INF/views/error/");
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		return multipartResolver;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		
		return new SessionLocaleResolver();
	}
	
	
	
}
