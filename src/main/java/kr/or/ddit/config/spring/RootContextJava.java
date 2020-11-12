package kr.or.ddit.config.spring;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// @Import({AopContextJava.class, DataSourceContextJava.class, TransactionContextJava.class})
// @ImportResource({"classpath:kr/or/ddit/config/spring/aop-context.xml"})
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
			includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Service.class, Repository.class })})
public class RootContextJava {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource =
				new ReloadableResourceBundleMessageSource();
		
		// list 처리 부분을 가변인자로 처리 하였다.
		messageSource.setBasenames("classpath:kr/or/ddit/message/error",
								   "classpath:kr/or/ddit/message/msg");
		
		return messageSource;
	}

	
}
