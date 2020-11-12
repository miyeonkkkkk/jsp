package kr.or.ddit.config.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:kr/or/ddit/config/db/db.properties")
public class DataSourceContextJava {
	
	@Autowired
	private Environment env; // 사용자가 설정한 properties파일 뿐만 환경변수에 대한 부분도 같이 관리해준다.
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		
		return sqlSessionTemplate;
	}
	
	
	
	
	
	
	
	
	
	
	
}
