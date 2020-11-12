package kr.or.ddit.config.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@Import({DataSourceContextJava.class})
public class TransactionContextJava {
	
	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		DataSourceTransactionManager transactionManager =
				new DataSourceTransactionManager(dataSource);
		
		return transactionManager;
	}
	
	

}
